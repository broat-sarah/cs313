<%-- 
    Document   : login
    Created on : Nov 9, 2016, 7:04:02 PM
    Author     : sarahbroat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="GET">
              User Name: <input type="text" name="username" /><br />
              Password: <input type="text" name="password" /><br /> 
              <input type="submit" value="Login" />
       </form>
    </body>
</html>
