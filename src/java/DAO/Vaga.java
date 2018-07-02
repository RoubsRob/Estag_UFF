package DAO;

import java.util.ArrayList;
import java.util.List;

public class Vaga 
{
    private int id;public Vaga(int id, List<Area> areas) 
	{
        this.id = id;
        this.publicada = false;
		if(areas == null || areas.size() <= 0)
                {
                    this.areas = new ArrayList();
                }
		else
                {
                    this.areas = areas;
                }
    }
    private boolean publicada;
    private List<Area> areas;
    

    
    
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
		if (Find(newArea)!= null) 
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
		Area temp ;
                
		for(int i = 0; i < areas.size(); i++)
		{
			temp = areas.get(i);
			if(temp.GetID() == areaID)
				return temp;
		}
		return null;
                
                
	}
	
	private Area Find(Area oldArea)
	{
		if(areas.isEmpty())
			return null;
		
		for(int i = 0; i < areas.size(); i++)
		{
			if(areas.get(i) == oldArea)
				return areas.get(i);
		}
		
		return null;
	}
}
