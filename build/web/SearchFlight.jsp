<%-- 
    Document   : SearchFlight
    Created on : Jul 15, 2023, 10:15:03 AM
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
    </head>
    <body class="w3-light-blue">
        <header class="w3-container w3-aqua">
            <h1 align='center'>Flight booking website</h1>
        </header>
        <h2>Select Flight </h2>
        <table class="w3-table" border="1">
            <tr>
                <td> </td>
                <td>Airline</td>
                <td>Departure</td>
                <td>DepartureTime</td>
                <td>DeparturePlace</td>
                <td>Arrival</td>
                <td>ArrivalTime</td>
                <td>ArrivalPlace</td>
                <td>Economy Seat</td>
                <td>Business Seat</td>
                <td>Cost</td>
            </tr>
            <c:set var="count" value="0"/>
            <c:forEach items="${sessionScope.data}" var="item">
                <c:set var="count" value="${count + 1}"/>
                <tr>
                    <td>${count}</td>
                    <td>${item.getAirline()}</td>
                    <td>${item.getDeparture()}</td>
                    <td>${item.getDepartureTime()}</td>
                    <td>${item.getDeparturePlace()}</td>
                    <td>${item.getArrival()}</td>
                    <td>${item.getArrivalTime()}</td>
                    <td>${item.getArrivalPlace()}</td>
                    <td>${item.getEconomy()}</td>
                    <td>${item.getBusiness()}</td>
                    <td>${item.getCost()}VND</td>            
                    <td><a href='SearchFlight?id=${item.getID()}'>Select</a></td>
                </tr>
            </c:forEach>
        </table><br>      
    </body>
</html>
