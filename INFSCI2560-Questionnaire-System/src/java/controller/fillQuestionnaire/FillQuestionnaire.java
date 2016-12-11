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
import javax.servlet.http.HttpSession;
import model.showQuestionnaire.*;

/**
 *
 * @author duxia
 */
public class FillQuestionnaire extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("showFill.jsp");
        dispatcher.forward(request, response);

        Connection con;
        Statement sql;
        StringBuffer out = new StringBuffer();
        ShowFilledResult sr = new ShowFilledResult();
        request.setAttribute("filledQuestionnaire", sr);
        int i = 1;
        String questionID;
        try {
            HttpSession session = request.getSession();
            String userID = Integer.toString((int) session.getAttribute("userID"));
            String uri = "jdbc:mysql://localhost:3306/infsci2560?"
                    + "user=root&password=root&characterEncoding=gb2312";
            con = DriverManager.getConnection(uri);
            sql = con.createStatement();
//            out.append(userID);
            while ((questionID = request.getParameter("question" + i)) != null) {
//                out.append("<p>"+request.getParameter("question"+i)+":   ");
                String[] select = request.getParameterValues("questionResult" + i);
                int[] selectionArray = new int[5];

                for (int j = 0; j < select.length; j++) {
                    if (select[j] != null) {
                        selectionArray[Integer.parseInt(select[j]) - 1] = 1;
                    }
                }
                for (int j : selectionArray) {
//                    out.append(j+" ");
                }
                sql.executeUpdate("INSERT INTO answer VALUES (" + userID + "," + questionID + "," + selectionArray[0] + "," + selectionArray[1] + ","
                        + selectionArray[2] + "," + selectionArray[3] + "," + selectionArray[4] + ")");
//                out.append("</p>");
                i++;
            }
            sr.setResult(out);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("showFill.jsp");
//            dispatcher.forward(request, response);
        } catch (Exception e) {
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
