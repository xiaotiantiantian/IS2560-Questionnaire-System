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
public class ShowRecentQuestionnaire {

    StringBuffer result;
    
    public ShowRecentQuestionnaire() {
        result = new StringBuffer();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public void setResult(StringBuffer rs) {
        result = rs;
    }

    public StringBuffer getResult() {
        Connection con;
        Statement sql, sql2;
        ResultSet rs, rs2;
        try {
            String uri = "jdbc:mysql://localhost:3306/infsci2560?"
                    + "user=root&password=root&characterEncoding=gb2312";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM infsci2560.questionnaire q,infsci2560.user_questionnaire u,infsci2560.userinformation ui "
                    + "where q.QuestionnaireID=u.QuestionnaireID and u.UserID=ui.UserID "
                    + "ORDER BY q.QuestionnaireID DESC "
                    + "LIMIT 10");
            int n = 1;
            result.append("<div class=\"row\">");
            while (rs.next()) {
                result.append("<div class=\"col-sm-6 col-md-3\">\n"
                        + "                    <div class=\"thumbnail\">\n"
                        + "                        <img src=\"image/" + rs.getString("UserPicture") + ";\" width=100 height=100 alt=\"通用的占位符缩略图\">\n"
                        + "                        <div class=\"caption\"><p>");
                result.append("<a href=\"readQuestionnaire?questionnaireID=" + rs.getString("QuestionnaireID") + "\" class=\"btn btn-primary\" role=\"button\">"
                        + rs.getString("QuestionnaireTitle"));
                result.append("</a> \n"
                        + "                    \n"
                        + "                </p>\n"
                        + "            </div>\n"
                        + "         </div>\n"
                        + "    </div>");
                //                    result.append("<p>");
                        //                    result.append("<image src=\"image/"+rs.getString("UserPicture")+"\" />");
                        //                    result.append("<a href=\"readQuestionnaire?questionnaireID="+rs.getString("QuestionnaireID")+"\" >"+rs.getString("QuestionnaireTitle")+"</a>");
                        //                    result.append("</p>");
                n++;
                if(n % 4 == 1){
                    result.append("</div>");
                    result.append("<div class=\"row\">");
                }
            }
            result.append("</div>");
        } catch (Exception e) {
        }
        return result;
    }
}
