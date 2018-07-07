<%-- 
    Document   : loginCoordenador
    Created on : 24/06/2018, 12:47:02
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Coordenador</title>
    </head>
    <body>
        <img src= "imagem/uff.PNG">
        <h1>Login Coordenador</h1>    
        <form action="VerificarLoginCoordenador" method="POST">
            Nome <input type="text" name="loginCoord"> <br>
            Senha <input type="password" name="senha"><br>
            <input type="submit" value="Login"></h1>
        </form>

    </body>
</html>
