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
public class ShowCreatedQuestionnair {
    String userID;
    StringBuffer result;
    public ShowCreatedQuestionnair(){
        result = new StringBuffer();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    
    public String getUserID(){
        return userID;
    }
    public void setUserID(String id){
        userID = id;
    }
    public StringBuffer getResult(){
        Connection con;
        Statement sql;
        ResultSet rs;
        try{
            result.append("<p>");
            result.append(userID);
            result.append("</p>");
            String uri = "jdbc:mysql://localhost:3306/infsci2560?"+
                        "user=root&password=root&characterEncoding=gb2312";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
            rs = sql.executeQuery("Select * from user_questionnaire,questionnaire "
                    + "             where user_questionnaire.QuestionnaireID=questionnaire.QuestionnaireID and UserID="+userID);
            while(rs.next()){
                result.append("<p>");
                result.append("<a href=\"showStaticQuestionnaire?questionnaireID="+rs.getString("QuestionnaireID")+"\" >"+rs.getString("QuestionnaireTitle")+"</a>");
                result.append("</p>");
            }
        }
        catch(Exception e){}
        return result;
    }
    public void setResult(StringBuffer sb){
        result = sb;
    }
}
