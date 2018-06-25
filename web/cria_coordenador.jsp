<%-- 
    Document   : cria_coordenador
    Created on : Jun 25, 2018, 3:01:38 PM
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Login</title>
    </head>
    <body>
        <img src= "imagem/uff.PNG">
        <h1>Entre com os dados abaixo:</h1>
            <form action="CriaCoordenador" method="POST">
        Nome <input type="text" name="nome"> <br>
        Login <input type="text" name="login"><br>
        Senha <input type="password" name="senha"><br>
        Matrícula <input type="password" name="id"><br>
        <input type="submit" value="Login"></h1>
            </form>
    </body>
</html>
