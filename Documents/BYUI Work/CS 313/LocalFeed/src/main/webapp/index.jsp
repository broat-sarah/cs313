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
        <title>LocalFeed</title>
    </head>
    <body>
        <h1>Webcam Search!</h1>
        <form method="post" action="WebcamSearch">
            <label for="searchParam">Search: </label>
            <input type="text" id="searchParam" name="searchParam" value="What's your location?"/>
            <input type="submit" value="Search"/>
            <br/>
            <br/>
        </form>
        
        <h2>Webcams</h2>
        <c:forEach var="webcams" items="${webcams}">
            <p>${webcams})</p>
        </c:forEach>
    </body>
</html>
