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
        Statement sql;
        ResultSet rs;
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
            rs = sql.executeQuery("SELECT * FROM question WHERE QuestionnaireID="+questionnaireID);
            int i=1;
            while(rs.next()){
                result.append("<h2>"+rs.getString("QuestionContent")+"</h2>");
                result.append("<p>");
                for(int j=4;j<=8;j++){
                    if(!rs.getString(j).equals("null")){
                        if(rs.getString("Type").equals("M")){
                            result.append("<input type=\"checkbox\" id=\"q"+i+"\" name=\"questionResult"+i+"\" value=\""+(j-3)+"\" disabled=\"disabled\"/>");
                            result.append("<label for=\"q"+i+"\" >");
                            result.append(rs.getString(j)+"  ");
                            result.append("</label>");
                        }
                        else{
                            result.append("<input type=\"radio\" id=\"q"+i+"\" name=\"questionResult"+i+"\" value=\""+(j-3)+"\" disabled=\"disabled\"/>");
                            result.append("<label for=\"q"+i+"\" >");
                            result.append(rs.getString(j)+"  ");
                            result.append("</label>");
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
