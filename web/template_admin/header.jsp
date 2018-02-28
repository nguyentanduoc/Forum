<%-- 
    Document   : header
    Created on : Oct 19, 2017, 8:59:32 PM
    Author     : feng
--%>
<%@page pageEncoding="UTF-8"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Image"%>
<%@page import="vn.edu.ctu.forum.models.service.ImageServiceImpl"%>
<%@page import="vn.edu.ctu.forum.models.pojos.Member"%>

<head>
    <title>Forum A-Q</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
          Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- bootstrap-css -->
    <link rel="stylesheet" href="css_admin/bootstrap.min_admin.css" >
    <!-- //bootstrap-css -->
    <!-- Custom CSS -->
    <link href="css_admin/style_admin.css" rel='stylesheet' type='text/css' />
    <link href="css_admin/style-responsive.css" rel="stylesheet"/>
    <!-- font CSS -->
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="css_admin/font_admin.css" type="text/css"/>
    <link href="css_admin/font-awesome_admin.css" rel="stylesheet"> 
    <!-- //font-awesome icons -->
    <script src="js_admin/jquery2.0.3.min.js"></script>
    <script src="js_admin/raphael-min.js"></script>
    <script src="js_admin/morris.js"></script>
    <script src="<%=request.getContextPath()%>/ckeditor/ckeditor.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/ckfinder/ckfinder.js" type="text/javascript"></script>
    <script src="js/jquery2.0.3.min.js"></script>
    <script src="./ckeditor/ckeditor.js" type="text/javascript"></script>
    <!-- date picker -->
    <link href="css_admin/datepicker.css" rel="stylesheet" type="text/css"/>    
    <script src="js_admin/bootstrap-datepicker.js" type="text/javascript"></script>
    <script>
        $(function () {
            $('.datepicker').datepicker();
        });
    </script>
    <!--//date picker -->
</head>
<body>
    <section id="container">
        <!--header start-->
        <header class="header fixed-top clearfix">
            <!--logo start-->
            <div class="brand">
                <a href="view" class="logo">
                    Forum A&Q
                </a>
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars"></div>
                </div>
            </div>            
            <div class="top-nav clearfix">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    <%
                        Member member = (Member) request.getSession().getAttribute("member");
                        ImageServiceImpl imageService = new ImageServiceImpl();
                        Image image = imageService.findByIdMember(member.getMemberId());
                        
                    %>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="<%=image.getImageSrc()%>">
                            <span class="username"><%=member.getMemberName()%></span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <li><a href="logout"><i class="fa fa-key"></i> Log Out</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!--search & user info end-->
            </div>
        </header>
        <!--header end-->
