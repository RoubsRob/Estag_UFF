<%-- 
    Document   : ExibeAluno
    Created on : 05/07/2018, 10:53:00
    Author     : Roberta
--%>

<%@page import="Controle.ListaDeAluno"%>
<%@page import="DAO.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alunos</title>
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
                      <li><a href="autorizarAluno.jsp">Autorizar Aluno</a></li>
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

        <h1>Lista de alunos do sistema:</h1>
    
                <table>
            <%
                ListaDeAluno resultado = (ListaDeAluno) request.getAttribute("listaaluno");
            for (int i=0; i<resultado.getSize();i++){
                Aluno aux= resultado.getAluno(i);
            
            %>
            <tr>
                <td>ID</td>
                <td>LOGIN</td>
                <td>NOME</td>
                <td>MATRICULA</td>
                <td>CARGA HORARIA</td>
            </tr>
            <tr>
            <td> <%=aux.GetID()%></td>
            <td><%=aux.GetLogin()%> </td>
            <td><%=aux.GetNome()%> </td>
            <td><%=aux.GetMatricula()%> </td>
            <td><%=aux.GetCargaHoraria()%> </td>
            
            </tr>
            
            <%
                }
           %>
            </table>
            
                <br><br>

    </body>
</html>
