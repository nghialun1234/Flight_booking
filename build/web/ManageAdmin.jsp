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
        List Admin:
        <table class="w3-table" border="1">
            <tr>
                <td>Username</td>
                <td>Password</td>                
                <td>Admin Level</td>
                <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.getUsername()}</td>
                    <td>${item.getPass()}</td>
                    <td>${item.getLevel()}</td>                
                    <td><a href='ManageAdmin?mod=1&id=${item.getUsername()}'>Select</a></td>
                    <td><a href='ManageAdmin?mod=2&id=${item.getUsername()}'>Delete</a></td>
                </tr>
            </c:forEach>
        </table><br>      
        <a href='ManageAdmin?mod=3&id=${item.getUsername()}'>Add</a>
        <a href='Admin'>Back</a>
    </body>
</html>
