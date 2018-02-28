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
import vn.edu.ctu.forum.models.service.MemberService;
import vn.edu.ctu.forum.models.service.MemberServiceImpl;

/**
 *
 * @author NTD
 */
@WebServlet(name = "UpdateProfileMember", urlPatterns = {"/updateProfileMember/*"})
public class UpdateProfileMember extends HttpServlet {

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
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String strDate = request.getParameter("birthday");
        String introduce = request.getParameter("introduce");

        HttpSession httpSession = request.getSession(true);
        Member memberO = (Member) httpSession.getAttribute("member");
        int id = memberO.getMemberId();

        Member m = new Member(id, name, sex, strDate, introduce);
        MemberService mbs = new MemberServiceImpl();
        if (mbs.editMember(m)) {
            httpSession.removeAttribute("member");
            MemberService mbs1 = new MemberServiceImpl();
            httpSession.setAttribute("member", mbs1.findById(id));
            response.sendRedirect("profileMember.jsp");
        } else {
            response.sendRedirect("profileMember.jsp");
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
