<%-- 
    Document   : autorizarEmpresa
    Created on : 05/07/2018, 11:15:29
    Author     : Roberta
--%>

<%@page import="DAO.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autorizar Empresa</title>
    </head>
    <body>
        <nav>
            <ul class="menu">
                <li><a href="index.jsp">Home</a></li>      
            </ul>
        </nav>
        <h1>Escolha a empresa para visualizar seu perfil e autorizar!</h1>
        <a href="erro.jsp">Exibir empresas</a>        
        
        <table>
                    
                    
                    
            <%
                List<Empresa> empresa = new ArrayList();
                
                Empresa resultado = (Empresa) request.getAttribute("listaEmpresaPendente");
            for (int i=0; i<resultado.getSize();i++){
                Empresa aux= resultado.getEmpresa(i);
            
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
