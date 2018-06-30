package DAO;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO 
{
    private final static String selectSQL = "SELECT * FROM DISCIPLINA";
    private final static String findSQL = "SELECT * FROM DISCIPLINA WHERE ID = ? ";
    private final static String insertSQL = "INSERT INTO DISCIPLINA (id,nome,ementa) VALUES(?,?,?)";
    private final static String deleteSQL = "DELETE FROM DISCIPLINA WHERE ID LIKE ? ";
    
    public static List<Disciplina> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Disciplina> disciplinas = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Disciplina proximaDisciplina = new Disciplina(resultado.getInt("id"),
                            resultado.getString("nome"),
                            resultado.getString("ementa"));
                    disciplinas.add(proximaDisciplina);

                    System.out.println("Disciplina " + proximaDisciplina.GetNome() + " foi lida");
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
       
       return disciplinas;
    }
    
    public static Disciplina Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Disciplina disciplina = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 disciplina = new Disciplina(resultado.getInt("id"),
                         resultado.getString("nome"),
                         resultado.getString("ementa"));

                 System.out.println("Disciplina " + disciplina.GetNome() + " foi encontrada.");
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
        
        return disciplina;
    }

    public static boolean Criar(Integer id,String nome, String ementa) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertSQL);
            sql.setInt(1, id);
            sql.setString(2, nome);
            sql.setString(3, ementa);
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar nova Disciplina.");
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
