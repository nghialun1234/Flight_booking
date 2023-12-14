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
        <form action="ManageAdmin" method="post">
            Username:<input type="text" name="name" value="${a.getUsername()}"><br>
            Password:<input type="text" name="pass" value="${a.getPass()}"><br>
            Admin level:
            <select name="level">
                <option value="${a.getLevel()}">${a.getLevel()}</option>
                <option value="1">1</option>  
                <option value="2">2</option>    
                <option value="3">3</option>  
            </select><br>
            <input type='submit' name='update' value='update'>
        </form>
    </body>
</html>
