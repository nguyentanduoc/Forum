<%-- 
    Document   : acceptquestion
    Created on : Oct 21, 2017, 1:32:33 PM
    Author     : Administrator
--%>
<%@page import="vn.edu.ctu.forum.models.service.MemberServiceImpl"%>
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
                    Accept Question
                </div>
                <div>
                    <%
                        MemberServiceImpl mbsv = new MemberServiceImpl();
                        QuestionServiceImpl qssv = new QuestionServiceImpl();
                        List<Question> list1 = qssv.findByAccect();
                        Member mb ;
                    %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th data-breakpoints="xs">ID Question</th>
                                <th>ID Supject</th>
                                <th>Member Name</th>
                                <th>Question Name</th>
                                <th>Discription</th>
                                <th>Content</th>
                                <th>Date Register</th>
                                <th>Accepted</th>
                            </tr>
                        </thead>
                        <tbody>
                             <% for(int i = 0; i < list1.size() ; i++){ %>
                            <tr data-expanded="true">
                                <td><%=list1.get(i).getQuestionId() %></td>
                                <td><%=list1.get(i).getSubjectId()  %></td>
                                <% mb = new MemberServiceImpl().findById(list1.get(i).getMemberId()); %>
                                <td><%=mb.getMemberName()  %></td>
                                <td><%=list1.get(i).getQuestionId()  %></td>
                                <td><%= list1.get(i).getQuestionDecription()  %></td>
                                <td><%= list1.get(i).getQuestionDate()  %></td>
                                <td><%= list1.get(i).getQuestionContent()  %></td>
                                
                                 <td><a href="acceptQuestion?id=<%=list1.get(i).getQuestionId() %>" class="active" ui-toggle-class=""> 
                                           <i class="fa fa-check text-success text-active">  
                                            </i></a>
                                        <a href="delAcceptQuestion?id=<%=list1.get(i).getQuestionId()  %>" class="active" ui-toggle-class=""> 
                                            <i class="fa fa-times text-danger text"></i></a>
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
                                            <a href="#myModal" data-toggle="modal" class="btn btn-success">
                                                Form in Modal
                                            </a>
                                            <a href="#myModal-1" data-toggle="modal" class="btn btn-warning">
                                                Form in Modal 2
                                            </a>
                                            <a href="#myModal-2" data-toggle="modal" class="btn btn-danger">
                                                Form in Modal 3
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