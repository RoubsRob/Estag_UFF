<%-- 
    Document   : menuLogadoCoordenador
    Created on : Jun 25, 2018, 2:14:03 PM
    Author     : Henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Coordenador</title>
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
            <li><a href="#">Autorizar Pedidos</a>
                <ul>
                      <li><a href="ExibeAlunoNaoAutorizado?">Autorizar Aluno</a></li>
                      <li><a href="erro.jsp">Autorizar Empresa</a></li>
                      <li><a href="erro.jsp">Autorizar Vaga</a></li>
                      <li><a href="erro.jsp">Autorizar Contrato</a></li>                    
                </ul>
            </li>
        <li><a href="links.jsp">Links</a></li>
        <li><a href="contato.jsp">Contato</a></li>     
</ul>
</nav><br><br> 
<br>
                    <form action="ExibeAluno" method="POST">
                    <input type="submit" value="Exibir Todos os Alunos"></form>

                    <form action="ExibeAlunoNaoAutorizado" method="POST">
                    <input type="submit" value="Exibir Alunos Não autorizados"></form>
        
                    <form action="ExibeVagaNaoAutorizado" method="POST">
                    <input type="submit" value="Exibir Vagas Não autorizadas"></form>

                    <form action="ExibeEmpresaNaoAutorizado" method="POST">
                    <input type="submit" value="Exibir Empresas Não autorizadas"></form>


<br>
       <form method="POST" action="ExibirVaga.html">
        <input type="text" name="pesquisa" value="Pesquisar">
        <input type="submit" value="Pesquisar Vagas">
        </form> 
    </body>
</html>
