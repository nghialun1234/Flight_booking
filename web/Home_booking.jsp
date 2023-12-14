<%-- 
    Document   : Home_booking
    Created on : Dec 12, 2023, 7:22:25 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Booking Form HTML Template</title>

        <style id="style" media="all">/* cyrillic-ext */
            @font-face {
                font-family: 'PT Sans';
                font-style: normal;
                font-weight: 400;
                font-display: swap;
                src: url(/fonts.gstatic.com/s/ptsans/v17/jizaRExUiTo99u79D0-ExdGM.woff2) format('woff2');
                unicode-range: U+0460-052F, U+1C80-1C88, U+20B4, U+2DE0-2DFF, U+A640-A69F, U+FE2E-FE2F;
            }
            /* cyrillic */
            @font-face {
                font-family: 'PT Sans';
                font-style: normal;
                font-weight: 400;
                font-display: swap;
                src: url(/fonts.gstatic.com/s/ptsans/v17/jizaRExUiTo99u79D0aExdGM.woff2) format('woff2');
                unicode-range: U+0301, U+0400-045F, U+0490-0491, U+04B0-04B1, U+2116;
            }
            /* latin-ext */
            @font-face {
                font-family: 'PT Sans';
                font-style: normal;
                font-weight: 400;
                font-display: swap;
                src: url(/fonts.gstatic.com/s/ptsans/v17/jizaRExUiTo99u79D0yExdGM.woff2) format('woff2');
                unicode-range: U+0100-02AF, U+0304, U+0308, U+0329, U+1E00-1E9F, U+1EF2-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
            }
            /* latin */
            @font-face {
                font-family: 'PT Sans';
                font-style: normal;
                font-weight: 400;
                font-display: swap;
                src: url(/fonts.gstatic.com/s/ptsans/v17/jizaRExUiTo99u79D0KExQ.woff2) format('woff2');
                unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+0304, U+0308, U+0329, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
            }
        </style>

        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

        <link type="text/css" rel="stylesheet" href="css/style.css" />


        <!--[if lt IE 9]>
                          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                        <![endif]-->
        <meta name="robots" content="noindex, follow">
        <script>
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
    <body>

        <div id="booking" class="section">
            <div class="section-center">
                <div class="container">
                    <div class="row">
                        <div class="booking-form">
                            <form action="SearchFlight" method="post">                                
                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <span class="form-label">Flying from</span>
                                            <input class="form-control" type="text" placeholder="City or airport"
                                                   list="browsers" name="From" id='f'>

                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <span class="form-label">Flying to</span>
                                            <input class="form-control" type="text" placeholder="City or airport"
                                                   list="browsers" name="To" id='t'>
                                        </div>
                                    </div>
                                    <datalist id="browsers">
                                        <c:forEach items="${data}" var="a">                
                                            <option value="${a.getID()}" label="${a.getCity()}">
                                            </c:forEach>                    
                                    </datalist>
                                    <div class="col-md-1">
                                        <div class="form-btn">
                                            <button type='button' id='swap' name='swap' class="submit-btn"
                                                    onclick="swapText()">Swap</button>   
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <span class="form-label">Departing</span>
                                            <input class="form-control" type='date' id="date" name ='date' value="${today}" min="${today}" required>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <span class="form-label">Returning</span>
                                            <input class="form-control" type='date' id="returndate" name ='returndate' value="${today}" min="${today}" required>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <span class="form-label">Number of ticket</span>
                                            <select class="form-control" name="no">
                                                <option value="1">1</option>  
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <span class="form-label">Travel class</span>
                                            <select class="form-control" name="class" id="c">
                                                <option value="Business">Business</option>  
                                                <option value="Economy">Economy</option>    
                                            </select>
                                            <span class="select-arrow"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">                                    
                                    <div class="col-md-3">
                                        <div class="form-btn">
                                            <button class="submit-btn">Show flights</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
