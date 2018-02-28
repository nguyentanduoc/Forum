<%-- 
    Document   : del_subject
    Created on : Oct 21, 2017, 7:18:36 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="table-agile-info">
            <div class="panel panel-default">
                <div class="panel-heading">
                    List Subject
                </div>
                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th data-breakpoints="xs">ID</th>
                                <th>Subject ID</th>
                                <th>Subject Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            
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
