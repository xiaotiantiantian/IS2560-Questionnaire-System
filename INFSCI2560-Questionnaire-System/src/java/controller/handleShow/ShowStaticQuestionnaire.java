/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.handleShow;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import model.showQuestionnaire.*;
/**
 *
 * @author duxia
 */
public class ShowStaticQuestionnaire extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        String questionnaireID = request.getParameter("questionnaireID");
        Connection con;
        Statement sql,sql2;
        ResultSet rs,temp;
        QuestionnaireContent qc = new QuestionnaireContent();
        request.setAttribute("questionnaireContent", qc);
        StringBuffer result = new StringBuffer();
        try{
            String uri="jdbc:mysql://localhost:3306/infsci2560?"+
                        "user=root&password=root&characterEncoding=gb2312";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM questionnaire WHERE QuestionnaireID="+questionnaireID);
            if(rs.next())
                qc.setQuestionnaireTitle(rs.getString("QuestionnaireTitle"));
            
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT DISTINCT UserID FROM question q, answer a WHERE "+
                                    "q.QuestionID=a.QuestionID and q.QuestionnaireID="+questionnaireID);
            rs.last();
            int total=rs.getRow();
            result.append("<p><font size=\"3\" color=\"blue\">"+"Total have "+total+" Participants"+"</font></p>");

            rs = sql.executeQuery("SELECT * FROM question WHERE QuestionnaireID="+questionnaireID);
            int i=1;
            while(rs.next()){
                result.append("<div class=\"page-header\">\n"
                        + "<h2>"
                        + rs.getString("QuestionContent")
                        + "</h2>\n"
                        + "</div>");
//                result.append("<h2>"+rs.getString("QuestionContent")+"</h2>");
                result.append("<p>");
                for(int j=4;j<=8;j++){
                    if(!rs.getString(j).equals("null")){
                        if(rs.getString("Type").equals("M")){
                            sql2 = con.createStatement();
                            temp = sql2.executeQuery("SELECT DISTINCT UserID FROM answer WHERE QuestionID="+rs.getString("QuestionID")+
                                    " and Selection"+(j-3)+"=1");
                            temp.last();
                            double choose=((double)temp.getRow()/total)*100.00;
                             result.append("<div class=\"checkbox\">\n"
                                    + "  <label for=\"q" + i + "\" >");
                            result.append("<input type=\"checkbox\" id=\"q"+i+"\" name=\"questionResult"+i+"\" value=\""+(j-3)+"\" disabled=\"disabled\"/>");
//                            result.append("<label for=\"q"+i+"\" >");
                            result.append(rs.getString(j)+"                   |   ");
                            result.append("<font size=\"3\" color=\"red\">");
                            result.append(choose+"%");
                            result.append("</font>");
                                  result.append("</label>"
                                    + "</div>");
                        }
                        else{
                            sql2 = con.createStatement();
                            temp = sql2.executeQuery("SELECT DISTINCT UserID FROM answer WHERE QuestionID="+rs.getString("QuestionID")+
                                    " and Selection"+(j-3)+"=1");
                            temp.last();
                            double choose=((double)temp.getRow()/total)*100.00;
                             result.append("<div class=\"radio\">\n"
                                    + "  <label for=\"q" + i + "\" >");
                            result.append("<input type=\"radio\" id=\"q"+i+"\" name=\"questionResult"+i+"\" value=\""+(j-3)+"\" disabled=\"disabled\"/>");
//                            result.append("<label for=\"q"+i+"\" >");
                            result.append(rs.getString(j)+"                   |   ");
                            result.append("<font size=\"3\" color=\"red\">");
                            result.append(choose+"%");
                            result.append("</font>");
                                  result.append("</label>"
                                    + "</div>");
                        }
                    }
                }
                result.append("</p>");
                i++;
            } 
            qc.setResult(result);
            con.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("showStatisticResult.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception e){
            out.println(e);
        }
    }
     public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
         doPost(request,response);
     }
}
