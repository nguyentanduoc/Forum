<%-- 
    Document   : profileMember
    Created on : Oct 21, 2017, 8:59:52 PM
    Author     : NTD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//template_admin/header.jsp"%>
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
                                Cập Nhật Thông Tin Cá Nhân  
                            </header>
                            <div class="panel-body">
                                <%                                    if (member.isMemberAccept() == true) {
                                %>     
                                <div class="alert alert-success">
                                    <strong>Member </strong>is accept!
                                </div>

                                <%} else {%>
                                <div class="alert alert-danger">
                                    <strong>Member </strong>is·n't accept!
                                </div>
                                <%
                                    }
                                %>

                                <form class="form-horizontal bucket-form" method="get" action="updateProfileMember">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Tên hiển thị:</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="name" class="form-control" value="<%=member.getMemberName()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Giới tính</label>
                                        <div class="radio col-sm-6">
                                            <c:set var = "sex" scope = "session" value = "${member.getMemberSex()}"/>
                                            <c:choose>
                                                <c:when test = "${sex =='Nam'}">
                                                    <label>                                                   
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nam" checked="true"/>                                                     
                                                        Nam
                                                    </label>
                                                    <label>
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nu"/>
                                                        Nữ
                                                    </label>
                                                </c:when>
                                                <c:when test = "${sex == 'Nu'}">
                                                    <label>                                                   
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nam"/>Nam
                                                    </label>
                                                    <label>
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nu" checked="true"/>Nữ
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>                                                   
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nam"/>Nam
                                                    </label>
                                                    <label>
                                                        <input type="radio" name="sex" id="optionsRadios1" value="Nu"/>Nữ
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Sinh nhật</label>
                                        <div class="col-sm-6">
                                            <input id="date" type="text" name="birthday" class="datepicker" value="<%=member.getMemberBirthDay()%>" data-date-format="yyyy/mm/dd">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Giới thiệu</label>
                                        <div class="col-sm-6">
                                            <textarea type="text" name="introduce" class="form-control"> <%=member.getMemberIntroduce()%> </textarea>
                                        </div>
                                    </div>          
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Cập Nhật</button>
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
    <!--main content end-->
</section>

<%@include file="//template_admin/footer.jsp" %>