<%-- 
    Document   : loginAluno
    Created on : 24/06/2018, 12:47:35
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Estudante</title>
    </head>
    <body>
        <img src= "imagem/uff.PNG">
        <h1>Login Estudante</h1>    
        <form action="VerificarLoginEstudante" method="POST">
            Nome <input type="text" name="loginEst"> <br>
            Senha <input type="password" name="senha"><br>
            <input type="submit" value="Login"></h1>
            <br>
            <a href="cria_aluno.jsp"> Crie seu login! </a>
            
        </form>
    </body>
</html>
