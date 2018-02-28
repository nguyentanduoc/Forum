<%-- 
    Document   : detailquestion
    Created on : Oct 30, 2017, 12:35:14 PM
    Author     : NTD
--%>

<%@page import="vn.edu.ctu.forum.models.pojos.Subject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vn.edu.ctu.forum.models.service.ImageServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.service.ImageService"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Image"%>
<%@page import="java.util.List"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Question"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template/header.jsp" %>
<%@include file="//template/modall.jsp" %>

<%    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Question question = (Question) request.getAttribute("question");
    List<Answer> listAnwser = (List<Answer>) request.getAttribute("listAnswers");
    List<Subject> listSubject = (List<Subject>) request.getAttribute("listSubject");
%>
<div class="agile_inner_banner_info">
    <h2>Study And Share</h2>
    <p>Phấn đấu vì một tương lai</p>
</div>

<%if (question != null) {%>
<!-- single -->
<div class="services">
    <div class="container">
        <div class="col-md-8 single-left">
            <div class="single-left1">
                <img src="<%=question.getSubject().getImage().getImageSrc()%>" alt="<%=question.getSubject().getImage().getImageAlt()%>" class="img-responsive" />
                <h3><%=question.getQuestionDecription()%></h3>
                <ul>
                    <li><span class="fa fa-user" aria-hidden="true"></span><a href="#"><%=question.getMember().getMemberName()%></a></li>                   
                </ul>
                <%=question.getQuestionContent()%>
            </div>        
            <br/>

            <div class="event-left1-left">

                <div class="event-left1-left-pos">
                    <ul>
                        <input id="qsid" type="hidden" value="<%=question.getQuestionId()%>"></input>
                        <li><a href="" id="llike"><span id="iconlike" class="fa fa-thumbs-up" aria-hidden="true"></span><b id="qsvt"><%=question.getVote()%></b> Likes</a></li>
                        <li><a href="#comment"><span class="fa fa-user" aria-hidden="true"></span><b>Comment</b></a></li>
                    </ul>
                </div>
            </div><br/>

            <%if (listAnwser.size() > 0) {%>
            <div class="comments" id="comment">
                <h3>Our Recent Comments</h3>
                <div class="comments-grids">
                    <%
                        for (int i = 0; i < listAnwser.size(); i++) {
                            ImageService imageService = new ImageServiceImpl();
                            Image image = imageService.findByIdMember(listAnwser.get(i).getMember().getMemberId());

                    %>
                    <div class="comments-grid">
                        <div class="comments-grid-left">
                            <img src="<%=image.getImageSrc()%>" alt="image.getImageAlt()" class="img-responsive" />
                        </div>
                        <div class="comments-grid-right">
                            <h4><a href="#"><%=listAnwser.get(i).getMember().getMemberName()%></a></h4>
                            <ul>
                                <li><%=dateFormat.format(listAnwser.get(i).getAnwserDate())%><i>|</i></li>
                                <li><a href="#">Reply</a></li>
                            </ul>
                            <p><%=listAnwser.get(i).getAnwserContent()%></p>
                        </div>
                        <div class="clearfix"> </div>
                    </div> 
                    <%}%>
                </div>
            </div>                
            <%}
                if (member == null) {%>
            <div class="leave-coment-form">
                <h3>Vui lòng đăng nhập để comment</h3>
            </div>
            <%} else {%>
            <div class="leave-coment-form">
                <h3>Leave Your Comment</h3>
                <form action="addAnwser" method="post">                    
                    <textarea name="message" placeholder="Your comment here..." required=""></textarea>
                    <input type="hidden" value="<%=question.getQuestionId()%>" name="questionId"/>
                    <div class="w3_single_submit">
                        <input type="submit" value="Submit Comment" >
                    </div>
                </form>
            </div>
            <%}%>
        </div>
        <div class="col-md-4 event-right wthree-event-right">
            <div class="event-right1 agileinfo-event-right1">                
                <div class="tags tags1 w3layouts-tags">
                    <h3>Recent Tags</h3>
                    <ul>
                        <%for (int i = 0; i < listSubject.size(); i++) {%>                        
                        <li><a href="view?subject=<%=listSubject.get(i).getSubjectId()%>"><%=listSubject.get(i).getSubjectName()%></a></li>
                            <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<%}%>
<%@include file="//template/footer.jsp" %>
