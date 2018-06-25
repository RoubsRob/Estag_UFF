/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberta
 */

@WebServlet(name = "VerificarLoginCoordenador", urlPatterns = {"/VerificarLoginCoordenador"})
public class VerificarLoginCoordenador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Entrou no VERIFICAR LOGIN!!!");
try{
       System.out.println("Entrou no servlet VerificarLoginCoordenador");
        String nome_user = request.getParameter("loginCoord");
        String senha_user = request.getParameter("senha");
        
        
        
        try {
            //if (Administrador_DAO.SenhaCorreta(nome_user, senha_user)){
              if(Coordenador_DAO.SenhaCorreta(nome_user, senha_user)){  

//    senha_user.equals(administrador.Consulta(administrador))
                HttpSession session = request.getSession();
                session.setAttribute("NomeCoordenadorLogado", nome_user);
                session.setAttribute("logado", "ok");
                
                
                Cookie meuCookie = new Cookie("Nome", nome_user);
                meuCookie.setMaxAge(60*30);
                response.addCookie(meuCookie);
                
                RequestDispatcher resposta = request.getRequestDispatcher("/menuLogadoCoordenador.jsp");
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
