/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        MemberService mbs = new MemberServiceImpl();
        Member m = mbs.login(email, pass);
//        System.out.println("Con text bach: " + request.getRequestURI());
        if (m != null) {
            HttpSession session = request.getSession();
            session.setAttribute("member", m);
            if (rememberMe != null) {
                Cookie cEmail = new Cookie("memberEmail", email);
                cEmail.setMaxAge(60*60*24*7);
                response.addCookie(cEmail);
                
                Cookie cPass = new Cookie("memberPass", pass);
                cPass.setMaxAge(60*60*24*7);
                response.addCookie(cPass);
            }
            
            request.getContextPath();
            response.sendRedirect("view");
        } else {
            request.setAttribute("erros", "Email or PassWord incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("view");
            rd.forward(request, response);
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
