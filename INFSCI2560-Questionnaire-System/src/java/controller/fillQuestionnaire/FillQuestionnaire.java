/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.fillQuestionnaire;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import model.showQuestionnaire.*;
/**
 *
 * @author duxia
 */
public class FillQuestionnaire extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        StringBuffer out = new StringBuffer();
        ShowFilledResult sr = new ShowFilledResult();
        request.setAttribute("filledQuestionnaire", sr);
        int i=1;
        while(request.getParameter("question"+i)!=null){
            out.append("<p>"+request.getParameter("question"+i)+":   ");
            String[] select = request.getParameterValues("questionResult"+i);
            int[] selectionArray = new int[5];
//            for(String j:select){
//                out.append(j+" ");
//            }
            for(int j=0;j<select.length;j++){
                if(select[j]!=null){
                    selectionArray[Integer.parseInt(select[j])-1]=1;
                }
            }for(int j:selectionArray){
                out.append(j+" ");
            }
            
            out.append("</p>");
            i++;
        }
        sr.setResult(out);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showFill.jsp");
        dispatcher.forward(request, response);
    }
}
