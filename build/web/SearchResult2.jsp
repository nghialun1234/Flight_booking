<%-- 
    Document   : SearchResult
    Created on : Jul 22, 2023, 1:38:04 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            margin-left: 20px;
            margin-top: 50px;
            border-radius: 25px;
            height: 75px;
            width: 150px;
            font-size: 20px;
            background-color: #ff9800;
        }
        #a{
            margin-left: 15px;
            margin-top: -30px;
        }
        </style>
    </head>
    <body class="w3-light-blue">
        <header class="w3-container w3-aqua">
            <h1 align='center'>Flight ticket website</h1>
        </header>
        <table class="w3-table" border="1">
            <tr>
                <td>Order ID</td>
                <td>Phone number</td>
                <td>Name</td>
                <td>Airline</td>
                <td>Departure</td>
                <td>DepartureTime</td>
                <td>DeparturePlace</td>
                <td>Arrival</td>
                <td>ArrivalTime</td>
                <td>ArrivalPlace</td>
                <td>Class</td>
            </tr>
            <c:set var="count" value="0"/>
            <c:forEach items="${dataF}" var="f">                
                <tr>
                    <td>${data.get(count).getOID()}</td>
                    <td>${data.get(count).getNumber()}</td>
                    <td>${data.get(count).getName()}</td>
                    <td>${f.getAirline()}</td>
                    <td>${f.getDepartureDate()}</td>
                    <td>${f.getDepartureTime()}</td>
                    <td>${f.getDeparturePlace()}</td>
                    <td>${f.getArrivalDate()}</td>
                    <td>${f.getArrivalTime()}</td>
                    <td>${f.getArrivalPlace()}</td>
                    <td>${data.get(count).getCLASS()}</td>
                </tr>
                <c:set var="count" value="${count + 1}"/>
            </c:forEach>
        </table><br>   
        <a href="Home">Return to home</a>
    </body>
</html>
