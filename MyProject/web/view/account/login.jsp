<%-- 
    Document   : login
    Created on : Jul 18, 2022, 11:19:38 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post"> 
            Username: <input type="text" name="user"/> <br/>
            Password: <input type="password" name="pass" /> <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
