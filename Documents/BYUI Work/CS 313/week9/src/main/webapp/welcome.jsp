<%-- 
    Document   : welcome
    Created on : Nov 7, 2016, 9:40:28 PM
    Author     : sarahbroat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome ${user}</h1>
        <form method="GET" action="logoutUser">
            <input type="submit" value="Logout" name="logoutButton"/>
        </form>
    </body>
</html>
