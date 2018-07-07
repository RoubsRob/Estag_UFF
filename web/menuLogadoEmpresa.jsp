<%-- 
    Document   : menuLogadoEmpresa
    Created on : 05/07/2018, 10:40:31
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo ao SisTag</title>
    </head>
    <body>
            <img src= "imagem/uff.PNG">
        <h1>Sistema de Estágios da UFF</h1> 
        <nav>
        <ul class="menu">
        <li><a href="#">Home</a></li>
            <li><a href="#">Perfil</a>
                <ul>
                      <li><a href="erro.jsp">Alterar senha</a></li>
                      <li><a href="erro.jsp">Alterar contato</a></li>
                </ul>
            </li>
            <li><a href="#">Vagas</a>
                <ul>
                      <li><a href="erro.jsp">Criar Vagas</a></li>
                      <li><a href="erro.jsp">Gerenciar Vagas</a></li>
                      <li><a href="erro.jsp">Visualizar Vagas</a></li>
                      <li><a href="erro.jsp">Visualizar Candidatos</a></li>
                     
                </ul>
            </li>
        <li><a href="links.jsp">Links</a></li>
        <li><a href="contato.jsp">Contato</a></li>     
</ul>
</nav><br><br> 
<br>
       <form method="POST" action="erro.html">
        <input type="text" name="pesquisa" value="Pesquisar">
        <input type="submit" value="Pesquisar Vagas">
        </form> 
    </body>

</html>
