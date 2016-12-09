/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

import DbConnect.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author qssheep
 */
public class userDao {
      private Connection connection;
    Statement st = null;
    ResultSet rs = null;
    String sql = "";
    
     public userDao() throws SQLException {
        //connect to database and select the record
        connection = DbConnection.getConnection();
        if(connection.isClosed())
                    System.out.println("1");
        System.out.println("==userDao connection==");
    }
    
    //create account by passing variable value from user instance
    public int createAccount(String name, String sex){

        try {
                sql = "INSERT INTO INFSCI2560.userinformation(UserName, UserSex) values (?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);  
                // Parameters start with 1
                ps.setString(1, name);               
                ps.setString(2, sex);               
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) {
                    int autoKey = rs.getInt(1);
                    return autoKey;
                } else
                    return -1;
                
        } catch (SQLException e) {
                e.printStackTrace();
            return -1;            
        }         
       
    }
    public int setPassword(String name, String password){
        try {
                sql = "SELECT UserID from INFSCI2560.userinformation WHERE username = '"+ name + "'";
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);
                int userid = 0;
                while(rs.next()) {
                    userid = rs.getInt("UserID");
                }
                sql = "INSERT INTO INFSCI2560.userpassword(UserID, Password) values (?, ?)";
                PreparedStatement ps1 = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);  
                // Parameters start with 1
                ps1.setInt(1, userid);               
                ps1.setString(2, password);               
                ps1.executeUpdate();
                
                //ResultSet rs1 = ps1.getGeneratedKeys();
                //int autoKey = rs1.getInt(1);
                //System.out.println(autoKey);
                return 1;
                
                    

        } catch (SQLException e) {
                e.printStackTrace();
            System.out.println("fail");
            return -1;            
        } 
    }
    public int retrieveUser(String name, String password){
        try {
                //sql = "SELECT * from is2560.users WHERE username = ? ";               
                sql = "select Password, i.UserID from infsci2560.userinformation as i, infsci2560.userpassword as p where i.UserID = p.UserID and i.UserName = '"+ name + "'";
                System.out.println("Account " + name);
                
                PreparedStatement ps = connection.prepareStatement(sql);
                //ps.setString(1, name);     
                //System.out.println(ps);

                rs = ps.executeQuery(sql);
                String username = "";
                String pwd = "";
                int flag = 0, userid = 0;
                while(rs.next()) {
//                    Retrieve by column name                    
                    pwd = rs.getString("Password");
                    userid = rs.getInt("UserID");
                    System.out.println(pwd);
                    flag = 1;
                }
                if(flag == 1){
                    if(!password.equals(pwd))
                        flag = -1;
                }
                if(flag == -1)
                    return flag;
                else
                    return userid;
                
        } catch (SQLException e) {
                e.printStackTrace();
          return -1;
        } 
    }
}
