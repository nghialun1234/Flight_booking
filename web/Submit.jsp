<%-- 
    Document   : Submit
    Created on : Jul 15, 2023, 12:12:08 PM
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
            <h1 align='center'>Flight Booking website</h1>
        </header>
        <table class="w3-table" border="1">
            <tr>
                <td>Airline</td>
                <td>Departure</td>
                <td>DepartureTime</td>
                <td>DeparturePlace</td>
                <td>Arrival</td>
                <td>ArrivalTime</td>
                <td>ArrivalPlace</td>
                <td>Class</td>
                <td>Cost</td>
            </tr>
            <c:forEach items="${sessionScope.result}" var="f">
                <tr>
                    <td>${f.getAirline()}</td>
                    <td>${f.getDeparture()}</td>
                    <td>${f.getDepartureTime()}</td>
                    <td>${f.getDeparturePlace()}</td>
                    <td>${f.getArrival()}</td>
                    <td>${f.getArrivalTime()}</td>
                    <td>${f.getArrivalPlace()}</td>
                    <td>${sessionScope.CLASS}</td>                
                    <td>${f.getCost()}VND</td> 
                </tr>
            </c:forEach>
        </table><br>
        <div id="rec">
                
            
            <form action="Submit?id=${id}&CLASS=${CLASS}&no=${no}" method="post">                
                Phone number:<input name="number"><br>
                <c:forEach var = "i" begin = "1" end = "${no}">
                    Name ${i}:<input name="${i}"><br>
                </c:forEach>
                    

                    <input id ="s" type="submit" name="submit" value="Submit">
            </form>
        </div>

    </body>
</html>
