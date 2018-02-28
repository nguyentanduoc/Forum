/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.service.AnwserService;
import vn.edu.ctu.forum.models.service.AnwserServiceImpl;
import vn.edu.ctu.forum.models.pojos.Answer;

/**
 *
 * @author NTD
 */
@WebServlet(name = "AddAnwser", urlPatterns = {"/addAnwser"})
public class AddAnwser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        Member member = (Member) session.getAttribute("member");
        int memberId = member.getMemberId();

        String contentAnwser = request.getParameter("message");
        String questionId = request.getParameter("questionId");
        AnwserService anwserService = new AnwserServiceImpl();
        if (questionId != null) {
            int intQuestionId = Integer.parseInt(questionId);
            Answer anwser = new Answer(intQuestionId, memberId, contentAnwser);
            if (contentAnwser != null) {
                if (anwserService.addAnwser(anwser)) {
                    request.setAttribute("success", "Cập nhật thành công");
                }
                else{
                    request.setAttribute("errors", "Thất bại");
                }
            }
        }
        getServletContext().getRequestDispatcher("/detailQuestion?questionId=" + questionId).forward(request, response);

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
