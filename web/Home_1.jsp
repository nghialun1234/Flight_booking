<%-- 
    Document   : Home
    Created on : Jul 15, 2023, 6:10:16 AM
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
    
    <script>
        function myFunction() {
            // Get the checkbox
            var checkBox = document.getElementByID("myCheck");
            // Get the output text
            var text = document.getElementById("text");
            var text1 = document.getElementById("text1");
            // If the checkbox is checked, display the output text
            if (checkBox.checked === true) {
                text.style.display = "block";
                text1.style.display = "block";
            } else {
                text.style.display = "none";
                text1.style.display = "block";
            }
        }
        function swapText() {
            var obj1 = document.getElementById('f').value;
            var obj2 = document.getElementById('t').value;

            var temp = obj1;
            obj1 = obj2;
            obj2 = temp;

            // Save the swapped values to the input element.
            document.getElementById('f').value = obj1;
            document.getElementById('t').value = obj2;
        }
    </script>

    <body class="w3-light-blue">
        <header class="w3-container w3-aqua">
            <h1 align='center'>Flight ticket website</h1>
        </header>
        <!--        <p><a href="/Flight_ticket/Admin">Admin</a></p><br>-->
        <div id='rec'>
        <div>
            <form action="SearchFlight" method="post">
                <div class="w3-row-padding">
                    <div class="w3-third">
                        <label>From:</label>
                        <input class="w3-input" type="text" list="browsers" name="From" id='f'>
                    </div>
                    <div class="w3-third">
                        <label>To:</label>
                        <input class="w3-input" type="text" list="browsers" name="To" id='t'>
                    </div>
                    <div class="w3-third">
                        <input type='button' id='swap' name='swap' value="swap" onclick="swapText()">
                    </div>                    
                </div>
                <datalist id="browsers">
                    <c:forEach items="${data}" var="a">                
                        <option value="${a.getID()}" label="${a.getCity()}">
                    </c:forEach>
                </datalist><br>
                <div class="w3-row-padding">
                    <div class="w3-third">
                        <label>Date:</label>
                        <input type='date' name ='date' value="${today}" min="${today}">
                    </div>
                    <div class="w3-third">
                        <label>Class:</label><br>
                        <select name="class" id="c">
                            <option value="Business">Business</option>  
                            <option value="Economy">Economy</option>    
                        </select><br>
                    </div>   
                    <div class="w3-third">
                        Number of ticket
                        <select name="no">
                            <option value="1">1</option>  
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select><br>
                    </div>
                </div>
                <datalist id="browsers">
                    <c:forEach items="${data}" var="a">                
                        <option value="${a.getID()}" label="${a.getCity()}">
                        </c:forEach>
                </datalist><br>
                <!--Return date: <input type="checkbox" id="myCheck" onclick="myFunction()">
                <p id="text" style="display:none">Return Date</p>
                <input id='text1' type='date' name ='returnDate' style="display:none" value="${today}" min="${today}">
                <br>-->
                
                    
                

                <br>            
            
            <a id="a" href="SearchOrder.jsp">Look up order</a>
            <input id="s" type='submit' name='Search' value='Search'>
            </form>
        </div>
        </div>
        
       
    </body>
</html>
