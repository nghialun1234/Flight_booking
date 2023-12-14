<%-- 
    Document   : ManageAdmin
    Created on : Jul 15, 2023, 6:57:30 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="w3.css">
        <style>
            #rec {
                border-radius: 25px;
                background: #42b0f5;
                padding: 100px;
                width: 700px;
                height: 432px;
                margin-top: 30px;
                position:absolute;
                top:50%;
                left:50%;
                transform:translate(-50%,-50%);
            }
            #swap{
                margin-left: 6px;
                margin-top: 12px;
            }
            #c{
                height: 28px;
                width: 150px;
            }
            #s{
                margin-left: 200px;
                margin-top: 40px;
                border-radius: 25px;
                height: 75px;
                width: 150px;
                font-size: 20px;
                background-color: #ff9800;
            }
            #a{
                margin-left: 15px;
            }
        </style>
    </head>
    <body class="w3-light-blue">
        <header class="w3-container w3-aqua">
            <h1 align='center'>Flight ticket management</h1>
        </header>
        List Flight:
        <table class="w3-table" border="1">
            <tr>
                <td>ID</td>
                <td>Airline</td>
                <td>Departure</td>
                <td>DepartureTime</td>
                <td>DeparturePlace</td>
                <td>Arrival</td>
                <td>ArrivalTime</td>
                <td>ArrivalPlace</td>
                <td>Economy</td>
                <td>Business</td>
                <td>Cost</td>
                <td>Update</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getID()}</td>
                    <td>${item.getAirline()}</td>
                    <td>${item.getDeparture()}</td>
                    <td>${item.getDepartureTime()}</td>
                    <td>${item.getDeparturePlace()}</td>
                    <td>${item.getArrival()}</td>
                    <td>${item.getArrivalTime()}</td>
                    <td>${item.getArrivalPlace()}</td>
                    <td>${item.getEconomy()}</td>
                    <td>${item.getBusiness()}</td>
                    <td>${item.getCost()}</td>            
                    <td><a href='ManageFlight?mod=1&id=${item.getID()}'>Select</a></td>
                    <td><a href='ManageFlight?mod=2&id=${item.getID()}'>Delete</a></td>
                </tr>
            </c:forEach>
        </table><br>      
        <a href='ManageFlight?mod=3&id=${item.getID()}'>Add</a>
        <a href='Admin'>Back</a>
    </body>
</html>
