package DAO;

import Controle.Conexao;
import Controle.ListaDeEmpresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO 
{
    private final static String selectSQL = "SELECT * FROM EMPRESA";
    private final static String findSQL = "SELECT * FROM EMPRESA WHERE ID = ? ";
    private final static String findValidSQL = "SELECT * FROM EMPRESA WHERE VALIDADO = 1 ";
    private final static String findInvalidSQL = "SELECT * FROM EMPRESA WHERE VALIDADO = 0 ";
    private final static String findAreasSQL = "SELECT * FROM EMPRESA_AREAS WHERE EMPRESA_ID = ? ";
    private final static String findVagasSQL = "SELECT * FROM EMPRESA_VAGA WHERE EMPRESA_ID = ? ";
    private final static String insertSQL = "INSERT INTO EMPRESA (id,login,senha,nome,cnpj) VALUES(?,?,?,?,?,?)";
    private final static String updatePasswordSQL = "UPDATE EMPRESA SET SENHA = ? WHERE LOGIN = ? ";
    private final static String updateValidationSQL = "UPDATE EMPRESA SET VALIDADO = ? WHERE ID = ? ";
    private final static String deleteSQL = "DELETE FROM EMPRESA WHERE LOGIN LIKE ? ";
    /*
    public static List<Empresa> Listar() throws SQLException
    {
        Conexao conexao = new Conexao();
        List<Empresa> empresas = new ArrayList();
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
               while(resultado.next())
               {
                    Empresa proximaEmpresa = new Empresa(resultado.getInt("id"),
                            resultado.getString("login"),
                            resultado.getString("senha"),
                            resultado.getString("nome"), 
                            resultado.getInt("cnpj"));
                    empresas.add(proximaEmpresa);

                    System.out.println("Empresa " + proximaEmpresa.GetNome() + " foi lido");
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
       
       return empresas;
    }
    
    public static List<Empresa> Listar(boolean validado)
    {
        Conexao conexao = new Conexao();
        List<Empresa> empresas = new ArrayList();
        
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
                    Empresa proximaEmpresa = new Empresa(resultado.getInt("id"),
                            resultado.getString("login"),
                            resultado.getString("senha"),
                            resultado.getString("nome"),  
                            resultado.getInt("cnpj"));
                    empresas.add(proximaEmpresa);

                    System.out.println("Empresa " + proximaEmpresa.GetNome() + " foi lida");
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
       
       return empresas;
    }
    */
    
        public static ListaDeEmpresa Listar() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeEmpresa admin = new ListaDeEmpresa();
       
       try{
           String selectSQL= "select * from empresa";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosEmpresa(resultado);
               System.out.println("Entrou no listar empresa DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }

        public static ListaDeEmpresa ListarNaoAutorizada() throws SQLException{
       Conexao conexao = new Conexao();
       ListaDeEmpresa admin = new ListaDeEmpresa();
       
       try{
           String selectSQL= "select * from empresa where validada = 0";
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null){
               admin.adicionarTodosEmpresa(resultado);
               System.out.println("Entrou no listar empresa DAO");
            }
       }catch (SQLException e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return admin;
    }

    
    public static Empresa Encontrar(int id)
    {
        Conexao conexao = new Conexao();
        Empresa empresa = null;
        
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                 empresa = new Empresa(resultado.getInt("id"),
                         resultado.getString("login"),
                         resultado.getString("senha"),
                         resultado.getString("nome"), 
                         resultado.getInt("cnpj"));

                 System.out.println("Empresa " + empresa.GetNome() + " foi encontrada.");
            }
            CarregaAreas(empresa, conexao);
            CarregaVagas(empresa, conexao);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            conexao.closeConexao();
        }
        
        return empresa;
    }
    
    public static void CarregaAreas(Empresa empresa, Conexao conexao)
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
                    
                    if(empresa.AddArea(area))
                    {
                        System.out.println("Area " + area.GetNome() + " foi adicionada à empresa " + empresa.GetNome());
                    }
                    else
                    {
                        System.out.println("Area " + area.GetNome() + " duplicada na empresa " + empresa.GetNome());
                    }    
               }   
            }
        }
        catch (SQLException e)
        {
            System.out.println("Empresa " + empresa.GetNome() + " não possui áreas selecionadas!");
        }
    }
    
    public static void CarregaVagas(Empresa empresa, Conexao conexao)
    {
        try
        {
           PreparedStatement preparedStatement;
           preparedStatement = conexao.getConexao().prepareStatement(findVagasSQL);
           ResultSet resultado = preparedStatement.executeQuery();
           if (resultado!= null)
           {
                while(resultado.next())
               {
                    Vaga vaga = new Vaga(resultado.getInt("id"), null);
                    
                    if(empresa.AddVaga(vaga))
                    {
                        System.out.println("Vaga " + vaga.GetID() + " foi adicionada a empresa " + empresa.GetNome());
                    }
                    else
                    {
                        System.out.println("Vaga " + vaga.GetID() + " duplicada na empresa " + empresa.GetNome());
                    }    
               }   
            }
        }
        catch (SQLException e)
        {
            System.out.println("Empresa " + empresa.GetNome() + " não possui vagas!");
        }
    }

    public static boolean SenhaCorreta(String login, String senha) throws SQLException
    {
        Conexao conexao = new Conexao();
        boolean logado = false;

        try
        {
            List<Empresa> empresas = Listar();
            for (int i=0; i < empresas.size();i++)
            {
                if (empresas.get(i).GetLogin().equalsIgnoreCase(login) && 
                     empresas.get(i).GetSenha().equalsIgnoreCase(senha) )
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

    public static boolean Criar(Integer id,String login, String senha, String nome, int cnpj) throws SQLException
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
            sql.setInt(5, cnpj);
            sql.executeUpdate();
            sucesso = true;
         }
        catch (SQLException e)
        {
              e.printStackTrace();
              System.out.println("Falha ao criar nova empresa.");
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
    
    public static boolean ValidaEmpresa(int empresaID, Coordenador coordenador) throws SQLException
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
          sql.setInt(2, empresaID);
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

