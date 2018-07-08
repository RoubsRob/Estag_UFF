<%-- 
    Document   : cria_empresa
    Created on : Jul 7, 2018, 10:03:27 PM
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
            <form action="CriaEmpresa" method="POST">
        Nome <input type="text" name="nome"> <br>
        Login <input type="text" name="login"><br>
        Senha <input type="password" name="senha"><br>
        ID <input type="password" name="id"><br>
        ID <input type="password" name="cnpj"><br>
        <input type="submit" value="Login"></h1>
            </form>
    </body>
</html>
