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
                    this.areas = new List<Area>(); //Ta dando erro aqui pra newList mas n sei pq
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
		if(areas.equals(newArea))
			return false;
		
		areas.add(newArea);
		return true;
	}
	
	public boolean RemoveArea(Area oldArea)
	{
		Area area = areas.get(areas.indexOf(oldArea));
		if(area != null)
		{
			areas.remove(area);
			return true;
		}
		else
			return false;
	}
	
	public boolean RemoveArea(int areaID)
	{
		Area area = areas.get(areas.indexOf(areaID));
		if(area != null)
		{
			areas.remove(areas.indexOf(area));
			return true;
		}
		else
			return false;
	}
}