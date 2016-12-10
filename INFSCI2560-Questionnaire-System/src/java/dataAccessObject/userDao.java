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
                sql = "SELECT * FROM INFSCI2560.userinformation WHERE UserName = '"+ name +"'";
                PreparedStatement ps1 =  connection.prepareStatement(sql);            
                ResultSet rs1 = ps1.executeQuery(sql);
                if(rs1.next()){
                    System.out.println("1");
                    return -2;
                }else{
                    System.out.println("2");
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
                }
                
                
        } catch (SQLException e) {
                e.printStackTrace();
            return -1;            
        }         
       
    }
    public int setPassword(String name, String password){
        try {
                sql = "SELECT UserID from INFSCI2560.userinformation WHERE UserName = '"+ name + "'";
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
                int flag = -3, userid = 0;
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
                else
                    flag = -2;
                if(flag <= -1)
                    return flag;
                else
                    return userid;
                
        } catch (SQLException e) {
                e.printStackTrace();
          return -1;
        } 
    }
    
    public int changepsw(int userid, String pwd, String npwd){
        try{
            int flag = 1;
            sql = "select Password from infsci2560.userpassword where UserID = '"+ userid + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            String password = "";
            while(rs.next()) {
                password = rs.getString("Password");
            }
            //wrong password
            if(!password.equals(pwd))
                flag = -1;
            else{
                sql = "update infsci2560.userpassword set Password = '" + npwd + "' where UserID = '" + userid + "'";
                PreparedStatement ps1 = connection.prepareStatement(sql);
                ps1.executeUpdate();
                return flag;
            }
            return flag;
        }
        catch (SQLException e) {
                e.printStackTrace();
          return -1;
        } 
    }
    public int changeusername(int userid, String name) throws SQLException{
        sql = "update infsci2560.userinformation set UserName = '" + name + "' where UserID = '"+ userid + "'";
        PreparedStatement ps1 = connection.prepareStatement(sql);
        ps1.executeUpdate();
        return 0;
    }
    public int changeusersex(int userid, String sex) throws SQLException{
        sql = "update infsci2560.userinformation set UserSex = '" + sex + "' where UserID = '"+ userid + "'";
        PreparedStatement ps1 = connection.prepareStatement(sql);
        ps1.executeUpdate();
        return 0;
    }
}

