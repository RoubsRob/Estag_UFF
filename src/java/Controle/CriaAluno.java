/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.AlunoDAO;
import DAO.Coordenador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "CriaAluno", urlPatterns = {"/CriaAluno"})
public class CriaAluno extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
try{
       System.out.println("Entrou no servlet CriaAluno");
       String nome = request.getParameter("nome"); 
       String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String matricula = request.getParameter("matricula");
        Integer id = Integer.parseInt(request.getParameter("matricula"));
        Integer carga = Integer.parseInt(request.getParameter("cargaHoraria"));
        Integer disciplinas = Integer.parseInt(request.getParameter("disciplinas"));
        String perfil = request.getParameter("perfil");
        
        
        try {

              if(AlunoDAO.Criar(id,login,senha,nome,matricula)){  

                Cookie meuCookie = new Cookie("Nome", nome);
                meuCookie.setMaxAge(60*30);
                response.addCookie(meuCookie);
                
                RequestDispatcher resposta = request.getRequestDispatcher("/sucesso.jsp");
                resposta.forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            RequestDispatcher resposta = request.getRequestDispatcher("/erro.jsp");
            resposta.forward(request, response);
            Logger.getLogger(VerificarLoginCoordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }catch (Exception e){
    System.out.println("ERRO NO LOGIN");
    RequestDispatcher resposta = request.getRequestDispatcher("/erro.jsp");
    resposta.forward(request, response);
    }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }

}
