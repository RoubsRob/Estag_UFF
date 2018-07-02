package DAO;

import java.util.ArrayList;
import java.util.List;

public class Empresa 
{
    private int id;
    private String login;
    private String senha;
    
    private String nome;
    private int cnpj;
    private List<Vaga> vagas;
    private List<Area> areasAtuacao;
    private boolean validada;
    
    
    public Empresa(int id, String login, String senha, String nome, int cnpj)
    {
        this.id = id;
        this.login = login;
        this.senha = senha;
        
        this.nome = nome;
        this.cnpj = cnpj;
        this.validada = false;
        this.vagas = new ArrayList();
        this.areasAtuacao = new ArrayList();
    }
    
    public int GetID()
    {
        return id;
    }
    
    public String GetLogin()
    {
        return login;
    }
    
    public String GetSenha()
    {
        return senha;
    }
    
    public String GetNome()
    {
        return nome;
    }
    
    public int GetCNPJ()
    {
        return cnpj;
    }
    
    public boolean EstaValidada()
    {
        return validada;
    }
    
    public void Valida()
    {
        validada = true;
    }
    
        public boolean AddArea(Area novaArea)
    {
        if(areasAtuacao.contains(novaArea))
            return false;
        
        return areasAtuacao.add(novaArea);
    }
    
    public List<Area> GetAreas()
    {
        return areasAtuacao;
    }
    
    public boolean AddVaga(Vaga novaVaga)
    {
        if(vagas.contains(novaVaga))
            return false;
        
        return vagas.add(novaVaga);
    }
    
    public List<Vaga> GetVagas()
    {
        return vagas;
    }
}
