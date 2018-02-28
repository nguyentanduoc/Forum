/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.service.QuestionService;
import vn.edu.ctu.forum.models.service.QuestionServiceImpl;
import vn.edu.ctu.forum.models.service.SubjectService;
import vn.edu.ctu.forum.models.service.SubjectServiceImpl;

/**
 *
 * @author NTD
 */
@WebServlet(name = "View", urlPatterns = {"/view"}, initParams = {
    @WebInitParam(name = "limitQuesion", value = "4")})
public class View extends HttpServlet {

    int limit;
    QuestionService questionService;
    SubjectService subjectService;
    List<Subject> listSucject;
    List<Question> listQuestion;
    Integer totalPage = 0;
    int page;
    String subjectID;
    String searchString;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String limitQuesion = config.getInitParameter("limitQuesion");
        try {
            limit = Integer.parseInt(limitQuesion);
        } catch (NumberFormatException e) {
            limit = 0;
        }
        questionService = new QuestionServiceImpl();
        subjectService = new SubjectServiceImpl();
        listSucject = subjectService.findAll();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String queryString = request.getQueryString();
        searchString = request.getParameter("Search");
        if (queryString == null) {
            if (searchString != null) {
                search(request, response);
            } else {
                defaultView(request, response);
            }
        } else {
            if (queryString.contains("page")) {
                page = coverValue(request.getParameter("page"));
                pageView(request, response);
            } else if (queryString.contains("previous")) {
                if (coverValue(request.getParameter("previous")) <= 1) {
                    page = 1;
                } else {
                    page = Integer.parseInt(request.getParameter("previous")) - 1;
                }
                pageView(request, response);
            } else if (queryString.contains("next")) {
                if (coverValue(request.getParameter("next")) >= totalPage) {
                    page = totalPage;
                } else {
                    page = Integer.parseInt(request.getParameter("next")) + 1;
                }
                pageView(request, response);
            } else if (queryString.contains("subject")) {
                subjectID = request.getParameter("subject");
                viewSubjectId(request, response);
            }

        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] arrSearch = searchString.split(" ");
        listQuestion = questionService.search(arrSearch);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("totalPage", totalPage());
        request.setAttribute("listSubject", getListSubject());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private int coverValue(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private void pageView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listQuestion = questionService.find(limit, (page - 1) * limit);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("totalPage", totalPage());
        request.setAttribute("listSubject", getListSubject());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private void defaultView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listQuestion = questionService.find(limit, 0);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("totalPage", totalPage());
        request.setAttribute("listSubject", getListSubject());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    private void viewSubjectId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listQuestion = questionService.findBySubjectLimit(subjectID, limit, 0);
        request.setAttribute("listQuestion", listQuestion);
        request.setAttribute("totalPage", totalPage(questionService.totalQuestionById(subjectID)));
        request.setAttribute("listSubject", getListSubject());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    public String totalPage(int totalQuestion) {
        totalPage = totalQuestion / limit;
        if (totalQuestion % limit > 0) {
            totalPage += 1;
        }
        return totalPage.toString();
    }

    public List<Subject> getListSubject() {
        return subjectService.findAll();
    }

    private String totalPage() {
        Integer total = questionService.totalQuestion();
        totalPage = total / limit;
        if (total % limit > 0) {
            totalPage += 1;
        }
        return totalPage.toString();
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
