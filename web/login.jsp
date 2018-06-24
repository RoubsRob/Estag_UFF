<%-- 
    Document   : login
    Created on : 22/06/2018, 22:57:31
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Estudante</h1>    
    <form action="VerificarLoginEstudante" method="POST">
        Nome <input type="text" name="nome"> <br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Login"></h1>
            </form>
        <br>        <h1>Login Empresa</h1>    
        <form action="VerificarLoginEmpresa" method="POST">
        Nome <input type="text" name="nome"> <br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Login"></h1>
            </form>
        <br>        <h1>Login Coordenador</h1>    
        <form action="VerificarLoginCoordenador" method="POST">
        Nome <input type="text" name="nome"> <br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Login"></h1>
            </form>
        
        
    </body>
</html>
