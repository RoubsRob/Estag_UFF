/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Area;
import DAO.VagaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CriaVaga", urlPatterns = {"/CriaVaga"})
public class CriaVaga extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Entrou no VERIFICAR LOGIN!!!");
try{
       System.out.println("Entrou no servlet CriaVaga");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        List<Area> areas = new ArrayList();
             
        
        
        try {

              if(VagaDAO.Criar(id, areas)){  
                RequestDispatcher resposta = request.getRequestDispatcher("/sucesso.jsp");
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
