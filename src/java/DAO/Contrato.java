package DAO;

public class Contrato 
{
    private int id;
    private Aluno aluno;
    private Vaga vaga;
    private boolean aprovado;
    private Coordenador coordenador;
    
    public Contrato(int id, Aluno aluno, Vaga vaga)
    {
        this.id = id;
        this.aluno = aluno;
        this.vaga = vaga;
        this.aprovado = false;
        this.coordenador = null;
    }
    
    public int GetID()
    {
        return id;
    }
    
    public Vaga GetVaga()
    {
        return vaga;
    }
    
    public boolean EstaAprovado()
    {
        return aprovado;
    }
    
    public void Aprova(Coordenador coordenador)
    {
        aprovado = true;
        this.coordenador = coordenador;
    }
    
    public Coordenador GetCoordenador()
    {
        return coordenador;
    }
}
