<%-- 
    Document   : modall
    Created on : Oct 20, 2017, 1:12:23 PM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Modal1 -->

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="signin-form">
                    <h3 class="agileinfo_sign">Sign In</h3>                    
                    <%
                        if (request.getAttribute("erros") != null) {
                    %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("erros")%>
                    </div>
                    <%}
                    %>
                    <div class="login-form">
                        <form action="login" method="post">  
                            <input type="email" name="email" placeholder="E-mail" required="true">
                            <input type="password" name="password" placeholder="Password" required="true">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" name="rememberMe">
                                    Remember me!
                                </label>
                            </div>
                            <div class="">
                                <input type="submit" value="Sign In">
                            </div>
                        </form>
                    </div>
                    <div class="login-social-grids">
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-rss"></i></a></li>
                        </ul>
                    </div>
                    <p><a href="#" data-toggle="modal" data-target="#myModal3" > Don't have an account?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //Modal1 -->	
<!-- Modal2 -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <div class="signin-form">
                    <h3 class="agileinfo_sign">Sign Up</h3>
                    <%
                        if (request.getAttribute("erros_register") != null) {
                    %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("erros_register")%>
                    </div>
                    <%}
                    %>
                    <div class="login-form">
                        <form action="register" method="post">
                            <input type="hidden" value="<%=request.getRequestURL()%>" name="currentPage"/>
                            <input type="text" name="name" placeholder="Username" required="">
                            <input type="email" name="email" placeholder="Email" required="">
                            <input type="password" name="password" id="password1" placeholder="Password" required="">
                            <input type="password" name="password2" id="password2" placeholder="Confirm Password" required="">
                            <input type="submit" value="Sign Up">
                        </form>
                    </div>
                    <p><a href="#"> By clicking register, I agree to your terms</a></p>
                </div>
            </div>
        </div>
    </div>
</div>