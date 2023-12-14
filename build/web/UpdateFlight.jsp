<%-- 
    Document   : UpdateProduct
    Created on : Jun 17, 2023, 8:40:00 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="ManageFlight" method="post">
            ID:<input type="text" name="ID" value="${f.getID()}" readonly><br>
            Airline:<input type="text" name="Airline" value="${f.getAirline()}"><br>
            Departure:<input type="date" name="Departure" value="${f.getDeparture()}"><br>
            DepartureTime:<input type="time" name="DepartureTime" value="${f.getDepartureTime()}"><br>
            DeparturePlace:<input list="browsers" name="DeparturePlace" value="${f.getDeparturePlace()}">
            <datalist id="browsers">
                <c:forEach items="${data2}" var="a">                
                    <option value="${a.getID()}" label="${a.getCity()}">
                </c:forEach>
            </datalist><br><br>
            Arrival:<input type="date" name="Arrival" value="${f.getArrival()}"><br>
            ArrivalTime:<input type="time" name="ArrivalTime" value="${f.getArrivalTime()}"><br>
            ArrivalPlace:<input list="browsers" name="ArrivalPlace" value="${f.getArrivalPlace()}"><br>
            Economy:<input type="text" name="Economy" value="${f.getEconomy()}"><br>
            Business:<input type="text" name="Business" value="${f.getBusiness()}"><br>
            Cost:<input type="text" name="Cost" value="${f.getCost()}"><br>         
            
            
            <input type='submit' name='update' value='update'>
        </form>
    </body>
</html>
