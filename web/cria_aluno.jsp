<%-- 
    Document   : cria_empresa
    Created on : 08/07/2018, 10:34:04
    Author     : Roberta
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
            <form action="CriaAluno" method="POST">
        Nome <input type="text" name="nome"> <br><br>
        Login <input type="text" name="login"><br><br>
        Senha <input type="password" name="senha"><br><br>
        Matrícula <input type="text" name="matricula"><br><br>
        Carga Horária Realizada <input type="text" name="cargaHoraria"><br><br>
        Disciplina de maior interesse 
        <select name="disciplinas">
            <option value="1">Desenv Aplic Corporativas</option>
            <option value="2">Desenvolvimento Web</option>
            <option value="3">Segurança da Informação</option>
        </select><br><br>
        Perfil <input type="text" name="perfil"><br><br>
        <input type="submit" value="Criar Login"></h1>
            </form>
       
    </body>
</html>
