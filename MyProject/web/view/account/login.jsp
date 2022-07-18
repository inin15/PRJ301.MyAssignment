<%-- 
    Document   : login
    Created on : Jul 18, 2022, 11:19:38 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập vào FPTWebsite</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <main>
            <div class="background">
                <div class="container">
                    <div class="login-form">
                        <form action="login" method="post">
                            <center><h1>FPT EDUCATION</h1></center>
                            <div class="input-box">
                                <i ></i>
                                <input type="text" placeholder="Nhập username" name="user">
                            </div>
                            <div class="input-box">
                                <i ></i>
                                <input type="password" placeholder="Nhập mật khẩu" name="pass">
                            </div>
                            <div class="btn-box">
                                <button type="submit">
                                    Đăng nhập
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
        
    </body>
</html>
