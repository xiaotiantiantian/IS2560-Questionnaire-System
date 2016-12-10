/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dataAccessObject.QuestionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.QuestionnaireDao;

import model.QuestionnaireModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpSession;
import model.QuestionAndSelection;

/**
 *
 * @author Zhirun Tian
 */
public class Questionnaire extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

//    protected QuestionnaireModel hostileEntry;
//
//    protected List<QuestionnaireModel> HostileList = new ArrayList<QuestionnaireModel>();
//
//    public QuestionnaireDao hostileDao = new QuestionnaireDao();
//
//    public Questionnaire() {
//        super();
//    }
    /**
     *
     * @param @param @param
     */
//
//    public Questionnaire(int countAttempts, String IPAddress, String SYSTEM_SOURCE) {
//        super();
//
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String questionnaireTitle = (String) request.getParameter("questionnaireTitle");
        String questionTitle = "null";
        String questionSel1 = "null";
        String questionSel2 = "null";
        String questionSel3 = "null";
        String questionSel4 = "null";
        String questionSel5 = "null";
        String type = "";
        //wirte questionnaireTitle to questonnaire table
        QuestionnaireDao questionnaireDao = new QuestionnaireDao();
        int questionnaireID = questionnaireDao.WriteQuestionnaireToDB(questionnaireTitle);
        //write questionnaireID and userID to user_questionnaire table
        int userID = (int) session.getAttribute("userID");
        if (questionnaireDao.writeQuestionnaireAutherToDB(questionnaireID, userID) != 1) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Unsuccessful insert user_questionnaire</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Unsuccessful insert user_questionnaire</h1>");
                out.println("</body>");
                out.println("</html>");

            }
        }

        QuestionDao questionDao = new QuestionDao();
//        QuestionAndSelection questionAndSelection = new QuestionAndSelection();
        List<QuestionAndSelection> qsList = new ArrayList<QuestionAndSelection>();

        for (int i = 1; request.getParameter("questionnaireQ" + i) != null; i++) {
            type = (String) request.getParameter("question-type" + i);
            questionTitle = (String) request.getParameter("questionnaireQ" + i);
            if (request.getParameter("questionnaireQ" + i + "Sel1") != null) {
                questionSel1 = (String) request.getParameter("questionnaireQ" + i + "Sel1");
            }
            if (request.getParameter("questionnaireQ" + i + "Sel2") != null) {
                questionSel2 = (String) request.getParameter("questionnaireQ" + i + "Sel2");
            }
            if (request.getParameter("questionnaireQ" + i + "Sel3") != null) {
                questionSel3 = (String) request.getParameter("questionnaireQ" + i + "Sel3");
            }
            if (request.getParameter("questionnaireQ" + i + "Sel4") != null) {
                questionSel4 = (String) request.getParameter("questionnaireQ" + i + "Sel4");
            }
            if (request.getParameter("questionnaireQ" + i + "Sel5") != null) {
                questionSel5 = (String) request.getParameter("questionnaireQ" + i + "Sel5");
            }
            QuestionAndSelection qs = new QuestionAndSelection(questionnaireID, questionTitle, questionSel1, questionSel2, questionSel3, questionSel4, questionSel5, type);
            qsList.add(qs);
        }

        for (QuestionAndSelection qs : qsList) {
            questionDao.WriteQuestionAndSelectionToDB(qs);

        }

        response.sendRedirect("loginsuccess.jsp");

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void redirectQuestionnaire(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Questionnaire Redirect</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Questionnaire Redirect Example Page</h1>");
//            out.println("</body>");
//            out.println("</html>");
//
//        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
