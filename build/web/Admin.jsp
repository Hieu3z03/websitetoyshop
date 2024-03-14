<%-- 
    Document   : Admin
    Created on : Nov 5, 2023, 9:38:55 AM
    Author     : FPT1174
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">Admin Controller</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Hello ${sessionScope.acc.user_name}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout</a>
                            </li> 
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row p-5">
                <div class="col-md-4">
                    <a href="manager" style="text-decoration: none;">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fa-regular fa-square-plus fa-3x text-primary"></i>
                                <h4 style="color: black">Manager Product</h4>
                                ------------
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="manageracc" style="text-decoration: none;">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fa-solid fa-users fa-3x text-danger"></i>
                                <h4 style="color: black">Manager User</h4>
                                ------------
                            </div>
                        </div>
                    </a>
                </div><!-- comment -->
                <div class="col-md-4">
                    <a href="oraccam" style="text-decoration: none;">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fa-solid fa-cart-shopping fa-3x text-warning"></i>
                                <h4 style="color: black">Order Detail</h4>
                                ------------
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        
    </body>
</html>
