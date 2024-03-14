<%-- 
    Document   : OrderDetail
    Created on : Nov 10, 2023, 10:28:30 AM
    Author     : FPT1174
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        
        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <link href="css/manager.css" rel="stylesheet" type="text/css"/>
            <style>
                img{
                    width: 200px;
                    height: 120px;
                }
            </style>
        <body>
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Order User Detail</h2>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>uID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>OrderId</th>
                                <th>Price</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listOc}" var="o">
                                <tr>
                                    <!--                                <td>
                                                                        <span class="custom-checkbox">
                                                                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                                            <label for="checkbox1"></label>
                                                                        </span>
                                                                    </td>-->
                                    <td>${o.uid}</td>
                                    <td>${o.ac.user_name}</td>
                                    <td>${o.ac.user}</td>
                                    <td>${o.orderId}</td>
                                    <td>${o.price} $</td>
                                    <td>${o.date}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <a href="Admin.jsp"><button type="button" class="btn btn-primary">Back to home</button></a>
            </div>
        
    </html>
