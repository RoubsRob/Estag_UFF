package DAO;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO 
{
    private final static String selectSQL = "SELECT * FROM CONTRATO";
    private final static String findSQL = "SELECT * FROM CONTRATO WHERE ID = ? ";
    private final static String insertSQL = "INSERT INTO CONTRATO (id,alunoID,vagaID) VALUES(?,?,?)";
    private final static String deleteSQL = "DELETE FROM AREA WHERE ID LIKE ? ";
    
    public static List<Contrato> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Contrato> contratos = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Contrato proximoContrato = new Contrato(resultado.getInt("id"),
                            AlunoDAO.Encontrar(resultado.getInt("nome")),
                            VagaDAO.Encontrar(resultado.getInt("vagaID")));
                    contratos.add(proximoContrato);

                    System.out.println("Contrato " + proximoContrato.GetID() + " foi lido");
               }
            }
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }
        finally
        {
            conexao.closeConexao();
        }
       
       return contratos;
    }
    
    public static Contrato Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Contrato contrato = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 contrato = new Contrato(resultado.getInt("id"),
                            AlunoDAO.Encontrar(resultado.getInt("nome")),
                            VagaDAO.Encontrar(resultado.getInt("vagaID")));

                 System.out.println("Contrato " + contrato.GetID() + " foi encontrado.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            conexao.closeConexao();
        }
        
        return contrato;
    }

    public static boolean Criar(Integer id, Integer alunoID, Integer vagaID) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertSQL);
            sql.setInt(1, id);
            sql.setInt(2, alunoID);
            sql.setInt(3, vagaID);
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar novo contrato.");
        }
        finally
        {
            conexao.closeConexao();
        }

        return sucesso;
    }
    
    public static boolean Deletar(Integer id) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(deleteSQL);
            sql.setInt(1, id);
            sql.executeUpdate();
            sucesso = true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }   
        finally
        {
            conexao.closeConexao();
        }
        
        return sucesso;
    }
}
