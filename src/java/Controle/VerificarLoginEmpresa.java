/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.EmpresaDAO;
import java.io.IOException;
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
 * @author Henrique
 */
@WebServlet(name = "VerificarLoginEmpresa", urlPatterns = {"/VerificarLoginEmpresa"})
public class VerificarLoginEmpresa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

try{
       System.out.println("Entrou no servlet VerificarLoginEmpresa");
        String nome_user = request.getParameter("loginEmpresa");
        String senha_user = request.getParameter("senha");
        
        
        
        try {
              if(EmpresaDAO.SenhaCorreta(nome_user, senha_user)){  
                
                  System.out.println("senha aluno correta");
                  
                  
                HttpSession session = request.getSession();
                session.setAttribute("NomeEmpresaLogado", nome_user);
                session.setAttribute("logado", "ok");
                
                
                Cookie meuCookie = new Cookie("Nome", nome_user);
                meuCookie.setMaxAge(60*30);
                response.addCookie(meuCookie);
                
                RequestDispatcher resposta = request.getRequestDispatcher("/menuLogadoEmpresa.jsp");
                resposta.forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            RequestDispatcher resposta = request.getRequestDispatcher("/erro.jsp");
            resposta.forward(request, response);
            Logger.getLogger(VerificarLoginEmpresa.class.getName()).log(Level.SEVERE, null, ex);
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
