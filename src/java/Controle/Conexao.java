/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "Conexao", urlPatterns = {"/Conexao"})
public class Conexao {

    private Connection conexao;

public Conexao() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//load driver
            conexao = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Sistag_UFF", "estagiouff", "12345678Aa");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel efetuar uma conexao com o BD!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel encontrar a classe referente! Verifique o driver!");
        }
    }
    
    
    public Connection getConexao(){
        return this.conexao;
    }
    
    public void closeConexao(){
        try {
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

 
}
