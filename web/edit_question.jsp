<%-- 
    Document   : edit_question
    Created on : Oct 30, 2017, 12:16:31 AM
    Author     : Feng
--%>

<%@page import="vn.edu.ctu.forum.models.service.QuestionServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.QuestionService"%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectService"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Subject"%>
<a href="template_admin/header.jsp"></a>
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
                                Edit Question
                            </header>
                            <div class="panel-body">
                                <form class="form-horizontal bucket-form"  action="editQuestion" method="post">
                                    <%                                        
                                        try {
                                            Integer id = Integer.parseInt(request.getParameter("id"));
                                            Question q = new Question(id);
                                            QuestionService qs = new QuestionServiceImpl();
                                            q = qs.findById(id);
                                            request.setAttribute("question", q);
                                        } catch (Exception e) {
                                            Integer id = (Integer) request.getAttribute("id");
                                            Question q = new Question(id);
                                            QuestionService qs = new QuestionServiceImpl();
                                            q = qs.findById(id);
                                            request.setAttribute("question", q);
                                        }


                                    %>
                                    <input type="hidden" name="questionid" value="<%=((Question) request.getAttribute("question")).getQuestionId()%>">

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
                                        <label class="col-sm-3 control-label">Question Name</label>
                                        <div class="col-sm-6">
                                            <input name="questionname" type="text" class="form-control" value="<%=((Question) request.getAttribute("question")).getQuestionName()%>">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Selection Subject</label>
                                        <div class="col-lg-6">                                           

                                            <%   
                                                
                                                SubjectService subjectService = new SubjectServiceImpl();
                                                List<Subject> listSubject = subjectService.findAll();

                                            %>

                                            <select name="subject" class="form-control input-lg m-bot15">
                                                <%for (Subject s : listSubject) {  
                                                        if ((s.getSubjectId()).equals(((Question) request.getAttribute("question")).getSubject().getSubjectId())) {
                                                            out.println("<option  selected=\"selected\" value=" + s.getSubjectId() + ">" + s.getSubjectName() + "</option>");
                                                        } else {
                                                            out.println("<option value=" + s.getSubjectId() + ">" + s.getSubjectName() + "</option>");
                                                        }

                                                    }
                                                %>

                                            </select>


                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Description</label>
                                        <div class="col-sm-6">
                                            <textarea name="questiondescription" type="text" class="form-control"><%=((Question) request.getAttribute("question")).getQuestionDecription()%></textarea>

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Question Content</label>
                                        <div class="col-sm-6">
                                            <textarea id="editor1" name="questioncontent" type="text" class="form-control"><%=((Question) request.getAttribute("question")).getQuestionContent()%></textarea>
                                            <script>

                                                var editor = CKEDITOR.replace('editor1',
                                                        {
                                                            filebrowserBrowseUrl: '',
                                                            // Image dialog, "Browse Server" button
                                                            filebrowserImageBrowseUrl: '',
                                                            // Upload tab in the Image dialog
                                                            filebrowserFlashBrowseUrl: '',
                                                        });
                                                CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/ckfinder/');

                                            </script>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit" >Save</button>
                                            <a href="delQuestion?id=<%=((Question)request.getAttribute("question")).getQuestionId()%>"  class="btn btn-danger">
                                                Delete
                                            </a>
                                            <a href="my_questions.jsp"  class="btn btn-warning">
                                                Cancel
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