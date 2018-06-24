/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Conexao;
import Controle.ListaDeCoordenador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Roberta
 */
public class Coordenador_DAO {
    
    
    public static ListaDeCoordenador Listar() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeCoordenador admin = new ListaDeCoordenador();
       
       try{
           String selectSQL= "select * from coordenador";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosAdmin(resultado);
               System.out.println("Entrou no listar DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }






    public static boolean SenhaCorreta(String login, String senha) throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeCoordenador admin = new ListaDeCoordenador();
       boolean logado = false;
       
       try{
           String selectSQL= "select * from coordenador";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosAdmin(resultado);
               System.out.println("RESULTADO SQL: "+ resultado);
            }
           for (int i=0; i<admin.getSize();i++){
               if (admin.getCoordenador(i).getLogin().equalsIgnoreCase(login) && 
                    admin.getCoordenador(i).getSenha().equalsIgnoreCase(senha) ){
                    logado=true; 
               }
           }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return logado;
    }


    public static boolean criar(String login, String senha) throws SQLException{
          Conexao conexao = new Conexao();
          boolean deu = false;
          try{
              String sqlQ="INSERT INTO ADMINISTRADOR VALUES(?,?)"; //sem aspas no ?
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, login);
              sql.setString(2, senha);
              sql.executeUpdate();
              deu = true;
           }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Erro insert SQL");
          }finally{

           conexao.closeConexao();
       }return deu;
       }
    public static ListaDeCoordenador Consultar() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeCoordenador admin = new ListaDeCoordenador();
       
       try{
           String selectSQL= "select * from coordenador";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosAdmin(resultado);
               System.out.println("Entrou no consultar DAO");
            } 
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }
    public static boolean atualizar(String login, String senha) throws SQLException{
          Conexao conexao = new Conexao();
          boolean deu = false;
          try{
              String sqlQ="UPDATE ADMINISTRADOR SET SENHA = ? WHERE LOGIN = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, senha);
              sql.setString(2, login);
              sql.executeUpdate();
              
              deu = true;
           }catch (SQLException e){
              e.printStackTrace();
          }finally{

           conexao.closeConexao();
       }return deu;
       }
    public static boolean deletar(String login) throws SQLException{
          Conexao conexao = new Conexao();
          boolean deu = false;
          try{
              String sqlQ="DELETE FROM ADMINISTRADOR WHERE LOGIN LIKE ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, login);
              sql.executeUpdate();
              deu = true;
           }catch (SQLException e){
              e.printStackTrace();
          }finally{

           conexao.closeConexao();
       }return deu;
       }
    
}
