package DAO;

import Controle.Conexao;
import Controle.ListaDeAluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO 
{
    private final static String selectSQL = "SELECT * FROM ALUNO";
    private final static String findSQL = "SELECT * FROM ALUNO WHERE ID = ? ";
    private final static String findValidSQL = "SELECT * FROM ALUNO WHERE VALIDADO = 1 ";
    private final static String findInvalidSQL = "SELECT * FROM ALUNO WHERE VALIDADO = 0 ";
    private final static String findAreasSQL = "SELECT * FROM ALUNO_AREAS WHERE ALUNO_ID = ? ";
    private final static String findDisciplinasSQL = "SELECT * FROM ALUNO_DISCIPLINAS WHERE ALUNO_ID = ? ";
    private final static String insertSQL = "INSERT INTO ALUNO (id,login,senha,nome,matricula,cargaHoraria) VALUES(?,?,?,?,?,?)";
    private final static String updatePasswordSQL = "UPDATE ALUNO SET SENHA = ? WHERE LOGIN = ? ";
    private final static String updateValidationSQL = "UPDATE ALUNO SET VALIDADO = ? WHERE ID = ? ";
    private final static String deleteSQL = "DELETE FROM ALUNO WHERE LOGIN LIKE ? ";
    
    
    /*
    public static List<Aluno> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Aluno> alunos = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Aluno proximoAluno = new Aluno(resultado.getInt("id"),
                            resultado.getString("login"),
                            resultado.getString("senha"),
                            resultado.getString("nome"), 
                            resultado.getString("matricula"), 
                            resultado.getInt("cargaHoraria"));
                    alunos.add(proximoAluno);

                    System.out.println("Aluno " + proximoAluno.GetNome() + " foi lido");
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
       
       return alunos;
    }*/
    
        
    public static ListaDeAluno Listar() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeAluno admin = new ListaDeAluno();
       
       try{
           String selectSQL= "select id,login,senha,nome,cargaHoraria,matricula from aluno";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosAluno(resultado);
               System.out.println("Entrou no listar aluno DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }

    /*
    public static List<Aluno> Listar(boolean validado)
    {
        Conexao conexao = new Conexao();
        List<Aluno> alunos = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           if(validado)
               preparedStatement = conexao.getConexao().prepareStatement(findValidSQL);
           else
               preparedStatement = conexao.getConexao().prepareStatement(findInvalidSQL);
           
           
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Aluno proximoAluno = new Aluno(resultado.getInt("id"),
                            resultado.getString("login"),
                            resultado.getString("senha"),
                            resultado.getString("nome"), 
                            resultado.getString("matricula"), 
                            resultado.getInt("cargaHoraria"));
                    alunos.add(proximoAluno);

                    System.out.println("Aluno " + proximoAluno.GetNome() + " foi lido");
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
       
       return alunos;
    }
    */
    public static Aluno Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Aluno aluno = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 aluno = new Aluno(resultado.getInt("id"),
                         resultado.getString("login"),
                         resultado.getString("senha"),
                         resultado.getString("nome"), 
                         resultado.getString("matricula"), 
                         resultado.getInt("cargaHoraria"));

                 System.out.println("Aluno " + aluno.GetNome() + " foi encontrado.");
            }
            CarregaAreas(aluno, conexao);
            CarregaDisciplinas(aluno, conexao);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            conexao.closeConexao();
        }
        
        return aluno;
    }
    
    public static void CarregaAreas(Aluno aluno, Conexao conexao)
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
                    
                    if(aluno.AddArea(area))
                    {
                        System.out.println("Area " + area.GetNome() + " foi adicionada ao Aluno " + aluno.GetNome());
                    }
                    else
                    {
                        System.out.println("Area " + area.GetNome() + " duplicada no aluno " + aluno.GetNome());
                    }    
               }   
            }
        }
        catch (SQLException e)
        {
            System.out.println("Aluno " + aluno.GetNome() + " não possui áreas selecionadas!");
        }
    }
    
    public static void CarregaDisciplinas(Aluno aluno, Conexao conexao)
    {
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(findDisciplinasSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                while(resultado.next())
               {
                    Disciplina disciplina = new Disciplina(resultado.getInt("id"),
                                            resultado.getString("nome"),
                                            resultado.getString("ementa"));
                    
                    if(aluno.AddDisciplina(disciplina))
                    {
                        System.out.println("Disciplina " + disciplina.GetNome() + " foi adicionada ao aluno " + aluno.GetNome());
                    }
                    else
                    {
                        System.out.println("Disciplina " + disciplina.GetNome() + " duplicada no aluno " + aluno.GetNome());
                    }    
               }   
            }
        }
        catch (SQLException e)
        {
            System.out.println("Aluno " + aluno.GetNome() + " não possui disciplinas!");
        }
    }

    public static boolean SenhaCorreta(String login, String senha) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean logado = false;

        try
        {
            List<Aluno> alunos = (List<Aluno>) Listar();
            for (int i=0; i < alunos.size();i++)
            {
                if ((alunos.get(i).EstaValidado()==true) && alunos.get(i).GetLogin().equalsIgnoreCase(login) && 
                        alunos.get(i).GetSenha().equalsIgnoreCase(senha))
                {
                    logado = true; 
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

        return logado;
    }

    public static boolean Criar(Integer id,String login, String senha, String nome, String matricula) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(insertSQL);
            sql.setInt(1, id);
            sql.setString(2, login);
            sql.setString(3, senha);
            sql.setString(4, nome);
            sql.setString(5, matricula);
            sql.setInt(6, 0); //Carga Horária é alterada pelo Coordenador, não pelo aluno.
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar novo Aluno.");
        }
        finally
        {
            conexao.closeConexao();
        }

        return sucesso;
    }
    
    public static boolean AtualizarSenha(String login, String senha) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
          PreparedStatement sql = conexao.getConexao().prepareStatement(updatePasswordSQL);
          sql.setString(1, senha);
          sql.setString(2, login);
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
    
    public static boolean ValidaAluno(int alunoID, Coordenador coordenador) throws SQLException
    {
        if(coordenador == null)
        {
            System.out.println("Validação inválida.");
            return false;
        }
        
        
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
          PreparedStatement sql = conexao.getConexao().prepareStatement(updateValidationSQL);
          sql.setInt(1, 1);
          sql.setInt(2, alunoID);
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
    
    public static boolean Deletar(String login) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean sucesso = false;
        try
        {
            PreparedStatement sql = conexao.getConexao().prepareStatement(deleteSQL);
            sql.setString(1, login);
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
