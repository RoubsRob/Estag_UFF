/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.EmpresaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "ExibeEmpresaNaoAutorizado", urlPatterns = {"/ExibeEmpresaNaoAutorizado"})
public class ExibeEmpresaNaoAutorizado extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    EmpresaDAO empresa = new EmpresaDAO();
            
    try{    
            ListaDeEmpresa listaempresa = EmpresaDAO.ListarNaoAutorizada();
            
            
            if (listaempresa != null){
                HttpSession session = request.getSession();
                session.setAttribute("listaempresanaoautorizado", listaempresa);
                request.setAttribute("listaempresanaoautorizado",listaempresa);
                RequestDispatcher resposta = request.getRequestDispatcher("/ExibeEmpresaNaoAutorizado.jsp");
                resposta.forward(request, response);
            }else {
                RequestDispatcher resposta = request.getRequestDispatcher("/Erro.jsp");
                resposta.forward(request, response);
            }
          }catch (Exception e){
    System.out.println("ERRO NA CONSULTA DE ALUNO NAO AUTORIZADO");
}
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }

}

