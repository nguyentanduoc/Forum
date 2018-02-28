/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.service.QuestionService;
import vn.edu.ctu.forum.models.service.QuestionServiceImpl;

/**
 *
 * @author feng
 */
@WebServlet(name = "AddNewQuestion", urlPatterns = {"/addNewQuestion"})
public class AddNewQuestion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //   request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            String subjectid = request.getParameter("subject");
            Integer memberid = ((Member) session.getAttribute("member")).getMemberId();
            String questionname = request.getParameter("questionname");
            String questiondecription = request.getParameter("questiondescription");
            String questioncontent = request.getParameter("questioncontent");

            QuestionService questionService = new QuestionServiceImpl();

            RequestDispatcher dispatcher = request.getRequestDispatcher("new_question.jsp");

            try {

                if ((!questionname.equals("")) && (!questiondecription.equals("")) && (!questioncontent.equals(""))) {
                    Question question = new Question(subjectid, memberid, questionname, questiondecription, questioncontent);
//                    dispatcher = request.getRequestDispatcher("my_questions.jsp");
                    if (questionService.addQuestion(question)) {

                        response.sendRedirect("my_questions.jsp?kqaction=1");
//                        request.setAttribute("success", "Has created a question");
                    } else {
                        response.sendRedirect("my_questions.jsp?kqaction=2");
//                        request.setAttribute("error", "Make question failed!");
                    }

                } else {
//                    request.setAttribute("error", "Value is null");
                    response.sendRedirect("new_question.jsp?error=0");
//                    dispatcher = request.getRequestDispatcher("new_question.jsp");

                }
            } catch (Exception ex) {
                request.setAttribute("error", "There was an error: " + ex.getMessage());
            }
            //dispatcher.forward(request, response);
        }
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
