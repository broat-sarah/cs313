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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles.css" type="text/css" rel="stylesheet" />
        <script src="autocomplete.js"></script>
        <title>LocalFeed 1.0</title>
    </head>
    <body>
        
        <header>
            <h1>LiveFeed 1.0</h1>
        </header>
        <main>
            <div class="center">
                <div class="column1">
                    <form method="post" action="GetGeoCoding" class="searchform">
                        <label for="searchParam">Search: </label>
                        <input type="text" id="searchParam" class="controls" name="searchParam" value="What's your location?"/>
                        <input type="submit" value="Search"/>
                        <br/>
                        <br/>
                    </form>
                </div>

                <div class="column2">
                    <h2>Webcams</h2>
                    <div class="content-grid">
                        <c:forEach var="webcam" items="${webcams}">
                            <div class="content-grid-item">
                                <a name="lkr-timelapse-player" data-id="${webcam.id}" data-play="day" href="//lookr.com/${webcam.id}" target="_blank">${webcam.title}</a><script async type="text/javascript" src="//api.lookr.com/embed/script/timelapse.js"></script>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <p>&copy; LiveFeed 1.0, 2016</p>
        </footer>
        
        
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyApkTcgdI9Hi9vAg6eNUCXPNUZu-yfWSdE&libraries=places&callback=init"
        async defer></script>
    </body>
</html>
