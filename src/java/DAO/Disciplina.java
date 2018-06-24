package DAO;

public class Disciplina 
{
    private int id;
    private String nome;
    private String ementa;

    public Disciplina(int id, String nome, String ementa) 
	{
        this.id = id;
        this.nome = nome;
        this.ementa = ementa;
    }
    
	public int GetID()
	{
		return id;
	}
	
    public String GetNome() 
	{
        return nome;
    }
	
	public String GetEmenta()
	{
		return ementa;
	}
}
