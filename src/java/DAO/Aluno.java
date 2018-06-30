package DAO;

import java.util.ArrayList;
import java.util.List;

public class Aluno 
{
    private int id;
    private String login;
    private String senha;
    
    private String nome;
    private String matricula;
    private int cargaHoraria;
    private boolean validado;
    private List<Disciplina> disciplinas;
    private List<Area> areas;

    public Aluno(int id, String login, String senha, String nome, String matricula, int cargaHoraria) 
    {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.matricula = matricula;
        this.cargaHoraria = cargaHoraria;
        this.validado = false;
        this.disciplinas = new ArrayList();
        this.areas = new ArrayList();
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
    
    public String GetMatricula()
    {
        return matricula;
    }
    
    public int GetCargaHoraria()
    {
        return cargaHoraria;
    }
    
    public boolean EstaValidado()
    {
        return validado;
    }
    
    public void Valida()
    {
        validado = true;
    }

    public boolean AddArea(Area novaArea)
    {
        if(areas.contains(novaArea))
            return false;
        
        return areas.add(novaArea);
    }
    
    public List<Area> GetAreas()
    {
        return areas;
    }
    
    public boolean AddDisciplina(Disciplina novaDisciplina)
    {
        if(disciplinas.contains(novaDisciplina))
            return false;
        
        return disciplinas.add(novaDisciplina);
    }
    
    public List<Disciplina> GetDisciplinas()
    {
        return disciplinas;
    }
}
