<%-- 
    Document   : my_questions
    Created on : Oct 29, 2017, 2:02:05 PM
    Author     : Feng
--%>

<%@page import="vn.edu.ctu.forum.models.untils.ConnectionPoolImpl"%>
<%@page import="vn.edu.ctu.forum.models.untils.ConnectionPool"%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.service.QuestionServiceImpl"%>
<%@page import="vn.edu.ctu.forum.controller.AcceptQuestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    My Question
                </div>

                <%

                    if (request.getParameter("kqaction") != null) {
                        Integer kqaction = Integer.parseInt(request.getParameter("kqaction"));
                        switch (kqaction) {
                            case 1: %>
                <div class="alert alert-success" role = "alert"> Has created a question
                </div> <%
                    break;
                    case 2: %>
                <div class="alert alert-success" role = "alert"> Make question failed!
                </div> <%
                    break;
                    case 3: %>
                <div class="alert alert-success" role = "alert"> Successfully deleted
                </div> <%
                    break;
                    case 4: %>
                <div class="alert alert-success" role = "alert"> Can not delete
                </div> <%
                    break;
                    default: %>
                <div class="alert alert-success" role = "alert"> Successfully deleted
                </div> <%
                        }
                    }
                %>

                <div>
                    <%
                        QuestionServiceImpl qssv = new QuestionServiceImpl();

                        Integer memberid = ((Member) session.getAttribute("member")).getMemberId();
                        List<Question> list1 = qssv.findByIdMember(memberid);
                        
                    %>
                    <table class="table">
                        <thead>
                            <tr>

                                <th>Question Name</th>
                                <th>Discription</th>

                                <th>Date Register</th>
                                <th>Status</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = 0; i < list1.size(); i++) {%>
                            <tr data-expanded="true">
                                <td><%=list1.get(i).getQuestionName()%></td>
                                <td><%= list1.get(i).getQuestionDecription()%></td>                      
                                <td><%= list1.get(i).getQuestionDate()%></td>
                                <%
                                    //Integer temp = booleanToInt(list1.get(i).isQuestionAccept());
                                    if (list1.get(i).getQuestionAccept() == 1) {
                                        out.println("<td>Approved</td>");

                                    } else {
                                        if (list1.get(i).getQuestionAccept() == 0) {
                                            out.println("<td>Pending</td>");
                                        } else {
                                            out.println("<td>Refuse</td>");
                                        }
                                    }

                                %>
                                <td>
                                    <a href="edit_question?id=<%=list1.get(i).getQuestionId()%>" class="active" ui-toggle-class=""> 
                                        <i class="fa fa-pencil-square-o"></i></a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">                                        
                                <div class="panel-body">
                                    <div class="position-center ">
                                        <div class="text-center">
                                            <a href="new_question.jsp"  class="btn btn-success">
                                                New Question
                                            </a>
                                            <a href="my_questions.jsp"  class="btn btn-warning">
                                                Refresh
                                            </a>

                                        </div>




                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>


<%@include file="//template_admin/footer.jsp" %>