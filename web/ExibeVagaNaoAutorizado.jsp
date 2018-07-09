<%-- 
    Document   : ExibeVagaNaoAutorizado
    Created on : 07/07/2018, 21:39:15
    Author     : Roberta
--%>

<%@page import="DAO.Vaga"%>
<%@page import="Controle.ListaDeVaga"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vagas</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    </head>
    <body>
        <img src= "imagem/uff.PNG">    
        <h1>Lista de Vagas no sistema:</h1>
    
                <table>
            <%
                ListaDeVaga resultado = (ListaDeVaga) request.getAttribute("listavaganaoautorizado");
            for (int i=0; i<resultado.getSize();i++){
                Vaga aux= resultado.getVaga(i);
            
            %>
            <tr>
                <td>ID</td>
                <td>AREA</td>
            </tr>
            <tr>
            <td> <%=aux.GetID()%></td>
            <td><%=aux.getArea()%> </td>
            <td><a href="Autorizar?id=<%=aux.GetID()%>">Autorizar</a> </td>
            
            </tr>
            
            <%
                }
           %>
            </table>
            
                <br><br>

    </body>
</html>
