<%-- 
    Document   : Admin
    Created on : Jul 15, 2023, 6:06:53 AM
    Author     : admin
--%>

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
            <form action="Admin" method="POST">
                Username<input type='text' name='username'><br>
                Password:<input type='text' name='password'><br>
                <input type='submit' value='LOGIN'>
            </form>
        </div>
        
    </body>
</html>
