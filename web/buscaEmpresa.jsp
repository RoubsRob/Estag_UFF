<%-- 
    Document   : buscaAluno
    Created on : Jul 7, 2018, 4:03:59 PM
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca Empresa</title>
    </head>
    <body>
        <img src= "imagem/uff.PNG">
        <h1>Busca Empresa</h1>    
        <form action="ExibirEmpresa" method="POST">
            Nome <input type="text" name="nomeEmpresa"> <br>
            <input type="submit" value="Buscar"></h1>
        </form>
    </body>
</html>
