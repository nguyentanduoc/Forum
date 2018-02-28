<%-- 
    Document   : index
    Created on : Oct 20, 2017, 1:12:52 PM
    Author     : NTD
--%>



<%@page import="vn.edu.ctu.forum.models.pojos.Subject"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.SubjectService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="vn.edu.ctu.forum.models.service.QuestionServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.QuestionService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template/header.jsp" %>
<%@include file="//template/modall.jsp" %>

<script>
    $(document).ready(function () {
        $(".current_page").click(function () {
            var current_page = $(this).attr("page");           
            $("#questionLoadAjax").detach();
            $.post("listQuestionViewAjax", {page: current_page}, function (data) {   
                alert(data);
                $("#questionLoadAjax").html(data);
            });
            $("html, body").animate({scrollTop: 250}, "slow");           
        });
    });
</script>
<%    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    List<Subject> listSucject = (List<Subject>) request.getAttribute("listSubject");
    List<Question> listQuestion = (List<Question>) request.getAttribute("listQuestion");
    String stringTotalPage = (String) request.getAttribute("totalPage");
    Integer totalPage = Integer.parseInt(stringTotalPage);

%>
<div class="agile_inner_banner_info">
    <h2>Study And Share</h2>
    <p>Phấn đấu vì một tương lai</p>
</div>

<div class="services">
    <div class="container">
        <% if (listQuestion.size() > 0) {%>
        <div class="col-md-8 event-left w3-agile-event-left" >
            <span id="questionLoadAjax">
                <%
                    for (int i = 0; i < listQuestion.size(); i++) {
                        if (i % 2 == 0) {
                %>                 

                <div class="event-left1">
                    <div class="col-xs-6 event-left1-left">
                        <a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>">
                            <img src="<%=listQuestion.get(i).getSubject().getImage().getImageSrc()%>" alt="<%=listQuestion.get(i).getSubject().getImage().getImageAlt()%>" class="img-responsive" /></a>
                        <div class="event-left1-left-pos">
                            <ul>                           
                                <li><a href="#"><span class="fa fa-user" aria-hidden="true"></span><%=listQuestion.get(i).getMember().getMemberName()%></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-xs-6 event-left1-right">
                        <h4><%=dateFormat.format(listQuestion.get(i).getQuestionDate())%></h4>
                        <h5><a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>"><%=listQuestion.get(i).getQuestionName()%></a></h5>
                        <p><%=listQuestion.get(i).getQuestionDecription()%></p>

                    </div>
                    <div class="clearfix"> </div>
                </div>
                <%} else {%>

                <div class="event-left1">
                    <div class="col-xs-6 event-left1-right">
                        <h4><%=dateFormat.format(listQuestion.get(i).getQuestionDate())%></h4>
                        <h5><a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>"><%=listQuestion.get(i).getQuestionName()%></a></h5>
                        <p><%=listQuestion.get(i).getQuestionDecription()%></p>
                    </div>
                    <div class="col-xs-6 event-left1-left agileinfo-event-left1-left">
                        <a href="detailQuestion?questionId=<%=listQuestion.get(i).getQuestionId()%>">
                            <img src="<%=listQuestion.get(i).getSubject().getImage().getImageSrc()%>" alt="<%=listQuestion.get(i).getSubject().getImage().getImageAlt()%>" class="img-responsive" /></a>
                        <div class="event-left1-left-pos">
                            <ul>                           
                                <li><a href="#"><span class="fa fa-user" aria-hidden="true"></span><%=listQuestion.get(i).getMember().getMemberName()%></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </span>

            <%}
                }%>
            <nav class="paging1">
                <ul class="pagination paging">
                    <%
                        String pageCurent = request.getParameter("page");
                        if (pageCurent == null) {
                            pageCurent = "1";
                        }
                    %>
                    <li>
                        <a href="view?previous=<%=pageCurent%>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <% for (int i = 1; i <= totalPage; i++) {%>
                    <li><span class="current_page" page = "<%=i%>"><%=i%></span></li>                    
                        <%}%>
                    <li>
                        <a href="view?next=<%=pageCurent%>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <%} else {%>
        <div class="col-md-8 event-left w3-agile-event-left" >
            Hệ thống chưa cập nhật <a href="view"> Về trang chủ </a>
        </div>
        <%}%>
        <div class="col-md-4 event-right wthree-event-right">
            <div class="search1 agileits-search1">
                <form action="view" method="post">
                    <input type="search" name="Search" placeholder="Search here..." required=""/>
                    <input type="submit" value="Search"/>
                </form>
            </div>
            <div class="">                      
                <div class="tags tags1">
                    <h3>Recent Tags</h3>
                    <ul>
                        <%for (int i = 0; i < listSucject.size(); i++) {%>                        
                        <li><a href="view?subject=<%=listSucject.get(i).getSubjectId()%>"><%=listSucject.get(i).getSubjectName()%></a></li>
                            <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<%@include file="//template/footer.jsp" %>