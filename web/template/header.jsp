<%-- 
    Document   : header
    Created on : Oct 20, 2017, 1:09:45 PM
    Author     : NTD
--%>

<%@page import="vn.edu.ctu.forum.models.pojos.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ForumA&Q</title>
        <!-- custom-theme -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Treasurer Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //custom-theme -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/blog.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/single.css" rel="stylesheet" type="text/css" media="all" />
        <!-- font-awesome-icons -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome-icons -->
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <link href="//fonts.googleapis.com/css?family=Raleway:100i,200,200i,300,400,500,500i,600,700,700i,800,800i" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var action = true;
                var qsvt = new Number($('#qsvt').text());
                $('#llike').click(function () {
                    var qsid = $('#qsid').val();
                    if (action) {
                        $.ajax({

                            type: "GET",

                            url: "likeUp",

                            data: {qsid: qsid, qsvt: qsvt},

                            success: function (responseText) {
                                $('#qsvt').text(responseText);
                                $("#iconlike").toggleClass('fa-thumbs-up fa-thumbs-down');
                                action = false;
                                qsvt = qsvt + 1;
                            }
                        });
                    } else {
                        $.ajax({

                            type: "GET",

                            url: "likeDown",

                            data: {qsid: qsid, qsvt: qsvt},

                            success: function (responseText) {
                                $('#qsvt').text(responseText);
                                $("#iconlike").toggleClass('fa-thumbs-up fa-thumbs-down');
                                action = true;
                                qsvt = qsvt - 1;
                            }
                        });

                    }
                    return false;
                });
            });
        </script>
    </head>

    <body>
        <% Member member = (Member) request.getSession().getAttribute("member");
            if (member != null) {
        %>
        <%@include file="//template/banner_authentication.jsp" %>
        <% } else {%>     
        <%@include file="//template/banner_unauthentication.jsp" %>
        <%}%>