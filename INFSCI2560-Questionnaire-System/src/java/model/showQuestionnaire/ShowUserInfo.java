/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.showQuestionnaire;

import java.sql.*;

/**
 *
 * @author duxia
 */
public class ShowUserInfo {
    String userID;
    String userName;
    String gender;
    String createNumber;
    String filledNumber;
    String picture;
    public ShowUserInfo(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    public String getUserID(){
        return userID;
    }
    public void setUserID(String id){
        userID=id;
        Connection con;
        Statement sql;
        ResultSet rs;
        
        try{
            String uri="jdbc:mysql://localhost:3306/infsci2560?"+
                        "user=root&password=root&characterEncoding=gb2312";
            con=DriverManager.getConnection(uri);
            sql = con.createStatement();
            
            rs=sql.executeQuery("SELECT UserName,UserSex FROM userinformation WHERE UserID="+userID);
            rs.next();
            setUserName(rs.getString("UserName"));
            
            setGender(rs.getString("UserSex"));
            
            int total;
            rs=sql.executeQuery("SELECT QuestionnaireID FROM user_questionnaire WHERE UserID="+userID);
            rs.last();
            total=rs.getRow();
            setCreateNumber(Integer.toString(total));
 
            rs=sql.executeQuery("SELECT distinct qn.QuestionnaireID FROM questionnaire qn,question q,answer a "
                    + "WHERE q.QuestionID=a.QuestionID and qn.QuestionnaireID=q.QuestionnaireID and  a.UserID="+userID);
            rs.last();
            total=rs.getRow();
            setFilledNumber(Integer.toString(total));
            
            rs=sql.executeQuery("SELECT UserPicture FROM userinformation WHERE UserID="+userID);
            rs.next();
            setPicture(rs.getString("UserPicture"));
            
        }
        catch(Exception e){}
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        userName=name;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String sex){
        gender=sex;
    }
    public String getCreateNumber(){
        return createNumber;
    }
    public void setCreateNumber(String n){
        createNumber=n;
    }
    public String getFilledNumber(){
        return filledNumber;
    }
    public void setFilledNumber(String n){
        filledNumber=n;
    }
    public String getPicture(){
        return picture;
    }
    public void setPicture(String s){
        picture=s;
    }
}
