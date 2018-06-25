<%-- 
    Document   : index
    Created on : 22/06/2018, 22:57:21
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo ao sistema de Estágios da UFF</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    </head>
    <body>
<img src= "imagem/uff.PNG">
<h1>Sistema de Estágios da UFF</h1>        
<nav>
  <ul class="menu">
        <li><a href="#">Home</a></li>
        <li><a href="sobre.jsp">Sobre</a></li>
            <li><a href="#">Faça seu login</a>
                <ul>
                      <li><a href="loginCoordenador.jsp">Login Coordenador</a></li>
                      <li><a href="loginAluno.jsp">Login Aluno</a></li>
                      <li><a href="loginEmpresa.jsp">Login Empresa</a></li>                    
                </ul>
            </li>
                        <li><a href="#">Crie Seu Usuário</a>
                <ul>
                      <li><a href="cria_coordenador.jsp">Coordenador</a></li>
                      <li><a href="cria_aluno.jsp">Aluno</a></li>
                      <li><a href="cria_empresa.jsp">Empresa</a></li>                    
                </ul>
            </li>
        <li><a href="links.jsp">Links</a></li>
        <li><a href="contato.jsp">Contato</a></li>                
</ul>
</nav><br><br>
<br>    <form method="POST" action="erro.html">
        <input type="text" name="pesquisa" value="Pesquisar">
        <input type="submit" value="Pesquisar Vagas">
        </form> 
    </body>
</html>
