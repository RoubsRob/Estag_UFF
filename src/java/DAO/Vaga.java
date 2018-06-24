package DAO;

public class Vaga 
{
    private int id;
    private bool publicada;
    private List<Area> areas;

    public Vaga(int id, List<Area> areas) 
	{
        this.id = id;
        this.publicada = false;
		if(areas.Count > 0)
		{
			this.areas = areas;
		}
		else
		{
			this.areas = new List<Area>();
		}
    }
    
	public int GetID()
	{
		return id;
	}
	
	public bool EstaPublicada()
	{
		return publicada;
	}
	
	public void Publicar()
	{
		publicada = true;
	}
	
	public List<Area> GetAreas()
	{
		return areas;
	}
	
	public bool AddArea(Area newArea)
	{
		if(areas.Find(newArea))
			return false;
		
		areas.Add(newArea);
		return true;
	}
	
	public bool RemoveArea(Area oldArea)
	{
		Area area = areas.Find(oldArea);
		if(area != null)
		{
			areas.Remove(area);
			return true;
		}
		else
			return false;
	}
	
	public void RemoveArea(int areaID)
	{
		Area area = areas.Find(x => x.GetID() == areaID);
		if(area != null)
		{
			areas.Remove(area);
			return true;
		}
		else
			return false;
	}
}