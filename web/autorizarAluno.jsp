<%-- 
    Document   : autorizarAluno
    Created on : 02/07/2018, 14:36:06
    Author     : Roberta
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alunos com autorização pendente</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="index.jsp">Home</a></li>      
            </ul>
        </nav>
        <h1>Escolha o aluno para visualizar seu perfil e autorizar!</h1>
        <a href="/ListaAlunoPendentes">Exibir alunos</a>        
        
        <table>
                    
                    ListaAlunoPendentes
                    
                    
                    
            <%
                List<Aluno> alunos = new ArrayList();
                
                Aluno resultado = (Aluno) request.getAttribute("listaAlunoPendente");
            for (int i=0; i<resultado.getSize();i++){
                Aluno aux= resultado.getAluno(i);
            
            %>
            <tr>
            <td> <%=aux.getId()%></td>
            <td><%=aux.getNome()%> </td>
            </tr>
            
            <%
                }
           %>
            </table>
            
                <br><br>
         
    
    </body>
</html>
