<%-- 
    Document   : index
    Created on : Nov 17, 2016, 10:13:11 PM
    Author     : sarahbroat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap core css-->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- <link href="styles.css" type="text/css" rel="stylesheet" /> -->
        <title>LocalFeed 1.0</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <h1>LiveFeed 1.0</h1>
            </div>
        </div>
        <main>
            <div class="container">
                <form method="post" action="GetGeoCoding" class="form-inline">
                    <label for="searchParam">Search: </label>
                    <input type="text" id="searchParam" class="form-control" name="searchParam" placeholder="What is your location?" size="75"/>
                    </br>
                    <label for="radius">Radius (km): </label>
                    <input type="number" id="radius" class="form-control" name="radius" value="25"/>
                    <input type="submit" value="Search"/>
                </form>
            </div>
            <div class="container">
                <div class="column2">
                    <h2>Webcams</h2>
                    <div class="content-grid">
                        <c:set var="numCams" value="0" scope="page" />
                        <c:forEach var="webcam" items="${webcams}">
                            <c:if test="${numCams} % 3 == 0">
                                <div class="row">
                            </c:if>
                            <c:set var="numCams" value="${numCams + 1}" scope="page"/>
                            <div class="col-sm-4">
                                <a name="lkr-timelapse-player" data-id="${webcam.id}" data-play="day" href="//lookr.com/${webcam.id}" target="_blank">${webcam.title}</a><script async type="text/javascript" src="//api.lookr.com/embed/script/timelapse.js"></script>
                            </div>
                            <c:if test="${numCams} % 4 == 0">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
        <footer class="footer">
            <div class="container">
                <p class="text-muted">&copy; LiveFeed 1.0, 2016</p>
            </div>
        </footer>
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        <script src="autocomplete.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyApkTcgdI9Hi9vAg6eNUCXPNUZu-yfWSdE&libraries=places&callback=init"
        async defer></script>
    </body>
</html>
