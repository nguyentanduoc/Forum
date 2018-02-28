<%-- 
    Document   : sidebar
    Created on : Oct 19, 2017, 9:00:08 PM
    Author     : feng
--%>

<%@page import="vn.edu.ctu.forum.models.pojos.Member"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Question" %>
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="glyphicon glyphicon-user"></i>
                        <span>Update Profile</span>
                    </a>
                    <ul class="sub">
                        <li><a href="profileMember.jsp">Update Information</a></li>
                        <li><a href="updateAvatarMember.jsp">Update Avatar</a></li>
                        <li><a href="changePassWord.jsp">Change PassWord</a></li>
                    </ul>
                </li>
                <%
                    Member member3 = (Member) request.getSession().getAttribute("member");
                    if (member3.isMemberIsAdmin()) {
                %>
                <li class="sub-menu">
                    <a href="javascript:;">                        
                        <span>Admin</span>
                    </a>
                    <ul class="sub">
                        <li><a href="acceptmember.jsp">Accept member</a></li>
                        <li><a href="acceptquestion.jsp">Accept question</a></li>
                        <li><a href="add_subject.jsp">Add subject</a></li>
                    </ul>
                </li>                
                <%
                    }
                %>
                <li>
                    <a href="my_questions.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>Question</span>
                    </a>
                </li>
            </ul>            
        </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->