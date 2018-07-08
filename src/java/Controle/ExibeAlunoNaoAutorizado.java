/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.AlunoDAO;
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
@WebServlet(name = "ExibeAlunoNaoAutorizado", urlPatterns = {"/ExibeAlunoNaoAutorizado"})
public class ExibeAlunoNaoAutorizado extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    AlunoDAO aluno = new AlunoDAO();
            
    try{    
            ListaDeAluno listaaluno = AlunoDAO.ListarNaoAutorizado();
            
            
            if (listaaluno != null){
                HttpSession session = request.getSession();
                session.setAttribute("listaalunonaoautorizado", listaaluno);
                request.setAttribute("listaalunonaoautorizado",listaaluno);
                RequestDispatcher resposta = request.getRequestDispatcher("/ExibeAlunoNaoAutorizado.jsp");
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

