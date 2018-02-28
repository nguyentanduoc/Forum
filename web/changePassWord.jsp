<%-- 
    Document   : changePassWord
    Created on : Oct 23, 2017, 9:54:48 AM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="//template_admin/header.jsp"%>
<%@include file="//template_admin/sidebar.jsp" %>
<section id="main-content">
    <section class="wrapper">
        <div class="form-w3layouts">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Change PassWord
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                            </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="form-horizontal"  method="POST" action="changePassWord" >
                                    <div class="form-group ">                                        
                                        <% if (request.getAttribute("success") != null) {%>
                                        <div class="alert alert-success" role="alert">
                                            <%=request.getAttribute("success")%>
                                        </div>
                                        <%}
                                            if (request.getAttribute("error")!= null) {%>
                                        <div class="alert alert-danger" role="alert">
                                            <%=request.getAttribute("error")%>
                                        </div>
                                        <%}%>
                                        <label for="password_current" class="control-label col-lg-3">Password current</label>
                                        <div class="col-lg-6">
                                            <input class="form-control" id="password_current" name="password_current" type="password" required="">
                                        </div>
                                    </div>
                                    <input type="hidden" name="id" value="<%=member.getMemberId()%>">
                                    <div class="form-group ">
                                        <label for="password" class="control-label col-lg-3">Password</label>
                                        <div class="col-lg-6">
                                            <input class="form-control" type="password" name="password" id="password1" placeholder="Password" required="">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="password2" class="control-label col-lg-3">Confirm Password</label>
                                        <div class="col-lg-6">
                                            <input class="form-control" type="password" name="password2" id="password2" placeholder="Confirm Password" required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Save</button>
                                            <!--                                            <button class="btn btn-default" type="button">Cancel</button>-->
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </section>
</section>
<!-- password-script -->
<script type="text/javascript">
    window.onload = function () {
        document.getElementById("password1").onchange = validatePassword;
        document.getElementById("password2").onchange = validatePassword;
    }
    function validatePassword() {
        var pass2 = document.getElementById("password2").value;
        var pass1 = document.getElementById("password1").value;
        if (pass1 !== pass2)
            document.getElementById("password2").setCustomValidity("Passwords Don't Match");
        else
            document.getElementById("password2").setCustomValidity('');
        //empty string means no validation error
    }
</script>
<!-- //password-script -->
<%@include file="//template_admin/footer.jsp" %>