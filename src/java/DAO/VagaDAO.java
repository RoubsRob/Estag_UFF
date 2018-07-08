package DAO;

import Controle.Conexao;
import Controle.ListaDeVaga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO 
{
    private final static String selectSQL = "SELECT * FROM VAGA";
    private final static String findSQL = "SELECT * FROM VAGA WHERE ID = ? ";
    private final static String findAreasSQL = "SELECT * FROM VAGA_AREA WHERE VAGA_ID = ? ";
    private final static String insertSQL = "INSERT INTO VAGA (id,nome) VALUES(?,?)";
    private final static String insertAreaSQL = "INSERT INTO VAGA_AREA (vaga_id,area_id) VALUES(?,?)";
    private final static String updateValidationSQL = "UPDATE vaga SET publicada = ? WHERE id = ? ";
    private final static String deleteSQL = "DELETE FROM VAGA WHERE ID LIKE ? ";
    
/*    public static List<Vaga> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Vaga> vagas = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Vaga proximaVaga = new Vaga(resultado.getInt("id"),
                            null);
                    CarregarAreas(proximaVaga, conexao);
                    vagas.add(proximaVaga);

                    System.out.println("Vaga " + proximaVaga.GetID() + " foi lida");
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
       
       return vagas;
    }
    */
    
    public static ListaDeVaga Listar() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeVaga admin = new ListaDeVaga();
       
       try{
           String selectSQL= "select id, area from vaga";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosVaga(resultado);
               System.out.println("Entrou no listar vaga DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }

    public static ListaDeVaga ListarNaoAutorizado() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeVaga admin = new ListaDeVaga();
       
       try{
           String selectSQL= "select id, area from vaga where publicada = 0";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosVaga(resultado);
               System.out.println("Entrou no listar vaga nao autorizado DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }

        
    
    public static void CarregarAreas(Vaga vaga, Conexao conexao)
    {
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(findAreasSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                while(resultado.next())
               {
                    Area area = new Area(resultado.getInt("id"),
                            resultado.getString("nome"));
                    
                    if(vaga.AddArea(area))
                    {
                        System.out.println("Area " + area.GetNome() + " foi adicionada a vaga " + vaga.GetID());
                    }
                    else
                    {
                        System.out.println("Area " + area.GetNome() + " duplicada na vaga " + vaga.GetID());
                    }    
               }   
            }
        }
        catch (SQLException e)
        {
            System.out.println("Vaga " + vaga.GetID() + " não possui areas!");
        }
    }
    
    public static Vaga Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Vaga vaga = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 vaga = new Vaga(resultado.getInt("id"));
                 CarregarAreas(vaga, conexao);
                 
                 System.out.println("Vaga " + vaga.GetID() + " foi encontrada.");
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
        
        return vaga;
    }

    public static boolean Criar(Integer id, List<Area> areas) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertSQL);
            sql.setInt(1, id);
            sql.executeUpdate();
            sucesso = true;
            
            
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar nova Vaga.");
        }
        finally
        {
            conexao.closeConexao();
        }

        return sucesso;
    }
    
    public static boolean CriarAreaDaVaga(Vaga vaga, int areaID, Conexao conexao)
    {
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertAreaSQL);
            sql.setInt(1, vaga.GetID());
            sql.setInt(2, areaID);
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar relação area - vaga.");
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
    public static boolean ValidaVaga(int vagaID) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
          PreparedStatement sql = conexao.getConexao().prepareStatement(updateValidationSQL);
          sql.setInt(1, 1);
          sql.setInt(2, vagaID);
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
