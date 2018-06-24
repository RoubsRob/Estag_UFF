<%-- 
    Document   : loginEmpresa
    Created on : 24/06/2018, 12:47:45
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Empresa</title>
    </head>
    <body>
        <h1>Login Empresa</h1>    
        <form action="VerificarLoginEmpresa" method="POST">
        Nome <input type="text" name="loginEmpresa"> <br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Login"></h1>
            </form>

    </body>
</html>
