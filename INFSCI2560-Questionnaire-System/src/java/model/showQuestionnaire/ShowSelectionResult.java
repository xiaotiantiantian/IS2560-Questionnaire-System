/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.showQuestionnaire;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author duxia
 */
public class ShowSelectionResult {
    String userID;
    String keyword;
    StringBuffer result;
    
    public ShowSelectionResult(){
        result = new StringBuffer();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    public String getUserID(){
        return userID;
    }
    public void setUserID(String userid){
        userID = userid;
    }
    public String getKeyword(){
        return keyword;
    }
    public void setKeyword(String s){
        keyword = s;
    }
    public StringBuffer getResult(){
        Connection con;
        Statement sql;
        ResultSet rs , rs2;
        try{
            String uri = "jdbc:mysql://localhost:3306/infsci2560?"+
                        "user=root&password=root&characterEncoding=gb2312";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM questionnaire WHERE QuestionnaireTitle LIKE '%"+keyword+"%'");
            result.append(userID);
            while(rs.next()){
//                rs2=sql.executeQuery("SELECT * FROM question q, answer a where "
//                                   + "q.QuestionID=a.QuestionID and  q.QuestionnaireID="+rs.getString("QuestionnaireID")+"and a.UserID="+userID);
//                if(!rs2.first()){
                    result.append("<p>");
                    result.append("<a href=\"readQuestionnaire?questionnaireID="+rs.getString("QuestionnaireID")+"\" >"+rs.getString("QuestionnaireTitle")+"</a>");
                    result.append("</p>");
//                }
            }
        }
        catch(Exception e){}
        return result;
    }
    public void setResult(StringBuffer sb){
        result = sb;
    }
}
