<%-- 
    Document   : subject
    Created on : Oct 21, 2017, 10:19:52 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp" %>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="form-w3layouts">
            <!-- page start-->
            <!-- page start-->
            <div class="row">
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                Form Subjcet
                            </header>
                            <div class="panel-body">
                                <form action="AddSubject" class="form-horizontal bucket-form" method="POST" enctype = "multipart/form-data" acceptcharset="UTF-8">
                                    <% if (request.getAttribute("success") != null) {%>
                                    <div class="alert alert-success" role="alert">
                                        <%=request.getAttribute("success")%>
                                    </div>
                                    <%}
                                            if (request.getAttribute("error") != null) {%>
                                    <div class="alert alert-danger" role="alert">
                                        <%=request.getAttribute("error")%>
                                    </div>
                                    <%}%>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Image ID</label>
                                        <div class="col-sm-6">
                                            <input type="file" name="file">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Subject ID</label>
                                        <div class="col-sm-6">
                                            <input type="text" name= "sj_id" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Subject Name</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="sj_name" class="form-control round-input">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Submit Subject</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<%@include file="//template_admin/footer.jsp" %>

