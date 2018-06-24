package DAO;

import java.util.List;

public class Vaga 
{
    private int id;
    private boolean publicada;
    private List<Area> areas;
    

    public Vaga(int id, List<Area> areas) 
	{
        this.id = id;
        this.publicada = false;
		if(areas.size() <= 0)
                {
                    this.areas = new ArrayList();
                }
		else
                {
                    this.areas = areas;
                }
    }
    
	public int GetID()
	{
		return id;
	}
	
	public boolean EstaPublicada()
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
	
	public boolean AddArea(Area newArea)
	{
		if(Find(newArea))
			return false;
		
		areas.add(newArea);
		return true;
	}
	
	public boolean RemoveArea(Area oldArea)
	{
		if(areas.contains(oldArea))
		{
			areas.remove(oldArea);
			return true;
		}
		else
			return false;
	}
	
	public boolean RemoveArea(int areaID)
	{
		Area area = Find(areaID);
		if(area != null)
		{
			areas.remove(area);
			return true;
		}
		else
			return false;
	}
	
	private Area Find(int areaID)
	{
		if(areas.isEmpty())
			return null;
		
		for(int i = 0; i < areas.Count; i++)
		{
			if(areas[i].GetID() == areaID)
				return areas[i];
		}
		
		return null;
	}
	
	private Area Find(Area oldArea)
	{
		if(areas.isEmpty())
			return null;
		
		for(int i = 0; i < areas.Count; i++)
		{
			if(areas[i] == oldArea)
				return areas[i];
		}
		
		return null;
	}
}
