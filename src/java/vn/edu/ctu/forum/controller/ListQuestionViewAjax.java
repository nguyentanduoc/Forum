/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.service.QuestionService;
import vn.edu.ctu.forum.models.service.QuestionServiceImpl;

/**
 *
 * @author PC
 */
@WebServlet(name = "ListQuestionViewAjax", urlPatterns = {"/listQuestionViewAjax"})
public class ListQuestionViewAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    QuestionService questionService;
    List<Question> listQuestion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        String rs = "";
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/plain");

            try {
                int intPage = Integer.parseInt(page);
                rs = teamplate(intPage);
                out.print(rs);
            } catch (NumberFormatException e) {
                
            }
        }
    }
//    public static void main(String[] args) {
//        ListQuestionViewAjax listQuestionViewAjax = new ListQuestionViewAjax();
//        System.out.println(listQuestionViewAjax.teamplate(1));
//        System.out.println("___________________________________");
//        System.out.println(listQuestionViewAjax.teamplate(2));
//    }
    private String teamplate(int currentPage) {
        questionService = new QuestionServiceImpl();
        listQuestion = questionService.find(4, (currentPage - 1) * 4);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String outString = "";
        if (listQuestion.size() > 0) {
            for (int i = 0; i < listQuestion.size(); i++) {
                if (i % 2 == 0) {
                    outString += "<div class=\"event-left1\">\n"
                            + "                        <div class=\"col-xs-6 event-left1-left\">\n"
                            + "                            <a href=\"detailQuestion?questionId=" + listQuestion.get(i).getQuestionId() + "\">\n"
                            + "                                <img src=\"" + listQuestion.get(i).getSubject().getImage().getImageSrc() + "\" alt=\"" + listQuestion.get(i).getSubject().getImage().getImageAlt() + "\" class=\"img-responsive\" /></a>\n"
                            + "                            <div class=\"event-left1-left-pos\">\n"
                            + "                                <ul>                           \n"
                            + "                                    <li><a href=\"#\"><span class=\"fa fa-user\" aria-hidden=\"true\"></span>" + listQuestion.get(i).getMember().getMemberName() + "</a></li>\n"
                            + "                                </ul>\n"
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"col-xs-6 event-left1-right\">\n"
                            + "                            <h4>" + dateFormat.format(listQuestion.get(i).getQuestionDate()) + "</h4>\n"
                            + "                            <h5><a href=\"detailQuestion?questionId=" + listQuestion.get(i).getQuestionId() + "\">" + listQuestion.get(i).getQuestionName() + "</a></h5>\n"
                            + "                            <p>" + listQuestion.get(i).getQuestionDecription() + "</p>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"clearfix\"> </div>\n"
                            + "                    </div>\n";
                } else {
                    outString += "   <div class=\"event-left1\">\n"
                            + "                        <div class=\"col-xs-6 event-left1-right\">\n"
                            + "                            <h4>" + dateFormat.format(listQuestion.get(i).getQuestionDate()) + "</h4>\n"
                            + "                            <h5><a href=\"detailQuestion?questionId=" + listQuestion.get(i).getQuestionId() + "\">" + listQuestion.get(i).getQuestionName() + "</a></h5>\n"
                            + "                            <p>" + listQuestion.get(i).getQuestionDecription() + "</p>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"col-xs-6 event-left1-left agileinfo-event-left1-left\">\n"
                            + "                            <a href=\"detailQuestion?questionId=" + listQuestion.get(i).getQuestionId() + "\">\n"
                            + "                                <img src=\"" + listQuestion.get(i).getSubject().getImage().getImageSrc() + "\" alt=\"" + listQuestion.get(i).getSubject().getImage().getImageAlt() + "\" class=\"img-responsive\" /></a>\n"
                            + "                            <div class=\"event-left1-left-pos\">\n"
                            + "                                <ul>                           \n"
                            + "                                    <li><a href=\"#\"><span class=\"fa fa-user\" aria-hidden=\"true\"></span>" + listQuestion.get(i).getMember().getMemberName() + "</a></li>\n"
                            + "                                </ul>\n"
                            + "                            </div>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"clearfix\"> </div>\n"
                            + "                    </div>\n";
                }                
            }
        }
        System.out.println(outString);
        return outString;
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
