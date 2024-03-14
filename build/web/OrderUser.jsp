<%-- 
    Document   : OrderUser
    Created on : Nov 10, 2023, 2:59:08 AM
    Author     : FPT1174
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">No</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Order ID</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Name</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Image</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Price</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Quantity</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                        
                                        <tbody>
                                            <c:forEach items="${ListO}" var="o">
                                                <tr>
                                                    <td class="align-middle">${o.od_id}</td>
                                                    
                                                    <td class="align-middle">
                                                        ${o.order_id}
                                                    </td>
                                                    <td class="align-middle">
                                                        ${o.name}
                                                    </td>
                                                    <td class="align-middle">
                                                        <img src="${o.image}" width="100px" height="50px"/>
                                                    </td>
                                                    <td class="align-middle">
                                                        <fmt:formatNumber pattern="##.##" value="${o.price}" />
                                                    </td>
                                                    <td class="align-middle">${o.quantity}</td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        <div class="col-lg-5">
                            <a href="home" style="text-decoration: none;"><button type="button" class="btn btn-dark rounded-pill py-2 btn-block">Back to home</button></a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
