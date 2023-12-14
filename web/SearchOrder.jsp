<%-- 
    Document   : SearchOrder
    Created on : Jul 21, 2023, 11:35:50 PM
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
            <form class="w3-" action="SearchResult" method="post">
                <input name="text"><br><!-- comment -->     
                <input class="w3-radio" type="radio" name="search" value="0" checked>
                <label>Phone Number</label>
                <input class="w3-radio" type="radio" name="search" value="1">
                <label>Order ID</label><br>
                <input id="s" type="submit" name="submit" value="Search">
            </form>
        </div>
       
    </body>
</html>
