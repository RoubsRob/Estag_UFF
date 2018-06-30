package DAO;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO 
{
    private final static String selectSQL = "SELECT * FROM AREA";
    private final static String findSQL = "SELECT * FROM AREA WHERE ID = ? ";
    private final static String insertSQL = "INSERT INTO AREA (id,nome) VALUES(?,?)";
    private final static String deleteSQL = "DELETE FROM AREA WHERE ID LIKE ? ";
    
    public static List<Area> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Area> areas = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Area proximaArea = new Area(resultado.getInt("id"),
                            resultado.getString("nome"));
                    areas.add(proximaArea);

                    System.out.println("Area " + proximaArea.GetNome() + " foi lido");
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
       
       return areas;
    }
    
    public static Area Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Area area = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 area = new Area(resultado.getInt("id"),
                         resultado.getString("nome"));

                 System.out.println("Area " + area.GetNome() + " foi encontrado.");
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
        
        return area;
    }

    public static boolean Criar(Integer id,String nome) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertSQL);
            sql.setInt(1, id);
            sql.setString(2, nome);
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar nova Area.");
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
