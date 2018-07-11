<%-- 
    Document   : menuLogadoAluno
    Created on : 02/07/2018, 14:57:55
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Aluno</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
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
                      <li><a href="erro.jsp">Visualizar Candidaturas</a></li>
                     
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
