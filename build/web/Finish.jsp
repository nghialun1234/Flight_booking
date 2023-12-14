<%-- 
    Document   : Finish
    Created on : Jul 21, 2023, 11:25:14 PM
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
        <div id="rec">
            <h2>Order complete!</h2>
            Your order ID is : ${OID}<br>
            <a href="home">Return to home</a>
        </div>        
    </body>
</html>
