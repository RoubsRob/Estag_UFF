<%-- 
    Document   : editaCoordenador
    Created on : 02/07/2018, 14:27:00
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Perfil</title>
    </head>
    <body>
        <img src= "imagem/uff.PNG">
        <h1>Edite sua senha ou nome:</h1>
            <form action="UpdateCoordenador" method="POST">
        Nome <input type="text" name="nome"> <br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Salvar informações"></h1>
            </form>
    </body>
</html>
