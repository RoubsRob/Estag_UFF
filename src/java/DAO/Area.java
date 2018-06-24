package DAO;

public class Area 
{
    private int id;
    private String nome;

    public Area(int id, String nome) 
	{
        this.id = id;
        this.nome = nome;
    }
    
	public int GetID()
	{
		return id;
	}
	
    public String GetNome() 
	{
        return nome;
    }
}
