<%-- 
    Document   : acceptmember
    Created on : Oct 21, 2017, 1:37:39 PM
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.service.MemberServiceImpl"%>
<%@page import="vn.edu.ctu.forum.controller.AcceptMember"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Accept Member
                </div>
                <div>
                    <% 
                        MemberServiceImpl memberservice = new MemberServiceImpl();
                        List<Member> list =  memberservice.findAcceptMember();
                        
                        %>
                    <table class="table">
                        <thead>
                            
                            <tr>
                                <th data-breakpoints="xs">ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Sex</th>
                                <th>BirthDay</th>
                                <th>Admin</th>
                                <th>Date Register</th>
                                <th>Intruduce</th>
                                  
                                <th>Accepted</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(int i = 0; i < list.size() ; i++){ %>
                            <tr data-expanded="true">
                                <td><%=list.get(i).getMemberId()%></td>
                                <td><%=list.get(i).getMemberName() %></td>                                
                                <td><%=list.get(i).getMemberEmail() %></td>
                                <td><%=list.get(i).getMemberSex() %></td>
                                <td><%=list.get(i).getMemberBirthDay() %></td>

                                <td><%=list.get(i).isMemberIsAdmin() %></td>
                                <td><%=list.get(i).getMemberDateRegister() %></td>
                                <td><%=list.get(i).getMemberIntroduce()%></td>
                                <td>
                                  
                                       <a href="acceptMember?id=<%=list.get(i).getMemberId()%>" class="active" ui-toggle-class=""> 
                                           <i class="fa fa-check text-success text-active">  
                                            </i></a>
                                        <a href="delAcceptMember?id=<%=list.get(i).getMemberId()%>" class="active" ui-toggle-class=""> 
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
