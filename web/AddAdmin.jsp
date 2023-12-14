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
        <div id="rec">
            <form action="ManageAdmin" method="post">
                Username:<input type="text" name="name" value=""><br>
                Password:<input type="text" name="pass" value="" ><br>      
                Admin level:
                <select name="level">
                    <option value="1">1</option>  
                    <option value="2">2</option>    
                    <option value="3">3</option>    
                </select><br>
                <input type='submit' name='add' value='add'>
            </form>
        </div>
    </body>
</html>
