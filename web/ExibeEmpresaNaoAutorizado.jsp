<%-- 
    Document   : ExibeEmpresaNaoAutorizado
    Created on : 07/07/2018, 21:48:30
    Author     : Roberta
--%>

<%@page import="Controle.ListaDeEmpresa"%>
<%@page import="DAO.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                      <li><a href="autorizarEmpresa.jsp">Autorizar Empresa</a></li>
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

        <h1>Lista de empresas do sistema:</h1>
    
                <table>
            <%
                ListaDeEmpresa resultado = (ListaDeEmpresa) request.getAttribute("listaempresanaoautorizado");
            for (int i=0; i<resultado.getSize();i++){
                Empresa aux= resultado.getEmpresa(i);
            
            %>
            <tr>
                <td>ID</td>
                <td>LOGIN</td>
                <td>NOME</td>
                <td>CNPJ</td>
                
            </tr>
            <tr>
            <td> <%=aux.GetID()%></td>
            <td><%=aux.GetLogin()%> </td>
            <td><%=aux.GetNome()%> </td>
            <td><%=aux.GetCNPJ()%> </td>
            
            <td><a href="AutorizarEmpresa?id=<%=aux.GetID()%>">Autorizar</a> </td>
            
            </tr>
            
            <%
                }
           %>
            </table>
            
                <br><br>

    </body>
</html>
