/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.EmpresaDAO;
import Controle.ListaDeEmpresa;

/**
 *
 * @author Henrique
 */
@WebServlet(name = "ExibirEmpresa", urlPatterns = {"/ExibirEmpresa"})
public class ExibirEmpresa extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    try{    
            ListaDeEmpresa listaempresa = EmpresaDAO.Listar();
            
            if (listaempresa != null){
                HttpSession session = request.getSession();
                session.setAttribute("listaempresa", listaempresa);
                request.setAttribute("listaempresa",listaempresa);
                RequestDispatcher resposta = request.getRequestDispatcher("/ExibeEmpresa.jsp");
                resposta.forward(request, response);
            }else {
                RequestDispatcher resposta = request.getRequestDispatcher("/Erro.jsp");
                resposta.forward(request, response);
            }
          }catch (Exception e){
    System.out.println("ERRO NA CONSULTA DE EMPRESA");
}
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }

}

