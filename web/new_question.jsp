<%-- 
    Document   : main
    Created on : Oct 19, 2017, 9:00:25 PM
    Author     : feng
--%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectService"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Subject"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
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
                                Add new Question
                            </header>
                            <div class="panel-body">
                                <form class="form-horizontal bucket-form"  action="addNewQuestion" method="get">
                                    
                                    <%
                                        if (request.getParameter("error") != null) {%>
                                    <div class="alert alert-danger" role="alert">
                                        Value is null
                                    </div>
                                    <%}%>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Name</label>
                                        <div class="col-sm-6">
                                            <input name="questionname" type="text" class="form-control" required >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Selection Subject</label>
                                        <div class="col-lg-6">                                           

                                            <%                                                SubjectService subjectService = new SubjectServiceImpl();
                                                List<Subject> listSubject = subjectService.findAll();

                                            %>

                                            <select name="subject" class="form-control input-lg m-bot15">
                                                <%for (Subject s : listSubject) {
                                                        out.println("<option value=" + s.getSubjectId() + ">" + s.getSubjectName() + "</option>");
                                                    }
                                                %>

                                            </select>


                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Description</label>
                                        <div class="col-sm-6">
                                            <textarea name="questiondescription" type="text" class="form-control" required ></textarea>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Content</label>
                                        <div class="col-sm-6">
                                            <textarea id="editor1" name="questioncontent" type="text" class="form-control"  required="true"></textarea>
                                            <script>

                                                var editor = CKEDITOR.replace('editor1',
                                                        {
                                                            filebrowserBrowseUrl: '',
                                                            // Image dialog, "Browse Server" button
                                                            filebrowserImageBrowseUrl: '',
                                                            // Upload tab in the Image dialog
                                                            filebrowserFlashBrowseUrl:''
                                                        });
                                                CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/ckfinder/');

                                            </script>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit" >Make Question</button>
                                            <a href="new_question.jsp"  class="btn btn-danger">
                                                Refresh
                                            </a>
                                            
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
    <%@include file="//template_admin/footer.jsp" %>