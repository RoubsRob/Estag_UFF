<%-- 
    Document   : autorizarVaga
    Created on : 05/07/2018, 11:18:40
    Author     : Roberta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.Vaga"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autorizar Vaga</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="index.jsp">Home</a></li>      
            </ul>
        </nav>
        <h1>Escolha a vaga para autorizar!</h1>
        <a href="erro.jsp">Exibir vagas</a>        
        
        <table>
                    
                    
                    
            <%
                List<Vaga> vaga = new ArrayList();
                
                Vaga resultado = (Vaga) request.getAttribute("listaVagas");
            for (int i=0; i<resultado.etSize();i++){
                Vaga aux= resultado.GetVaga(i);
            
            %>
            <tr>
            <td> <%=aux.GetID()%></td>
            <td><%=aux.getNome()%> </td>
            </tr>
            
            <%
                }
           %>
            </table>
            
                <br><br>
         
     </body></html>
