package DAO;

import java.util.ArrayList;
import java.util.List;

public class Vaga 
{
        private int id;
        private int publicada;
        private int area;
        private List<Area> areas;       
        
/*    public Vaga(int id, int publicada, int area){
            this.id= id;
            this.publicada = publicada;
            this.area = area;
        }
*/    
    public Vaga(int id, int area){
            this.id= id;
            this.area = area;
        }
    
    public Vaga(int id){
            this.id= id;
        }

    /**
     * @return the id
     */
    public int GetID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void SetID(int id) {
        this.id = id;
    }

    /**
     * @return the publicada
     */
    public int getPublicada() {
        return publicada;
    }

    /**
     * @param publicada the publicada to set
     */
    public void setPublicada(int publicada) {
        this.publicada = publicada;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }
    public boolean AddArea(Area novaArea)
    {
        if(areas.contains(novaArea))
            return false;
        
        return areas.add(novaArea);
    }    
/*    private int id;public Vaga(int id, List<Area> areas) 
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
		return getId();
	}
	
	public boolean EstaPublicada()
	{
		return getPublicada();
	}
	
	public void Publicar()
	{
		setPublicada(true);
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

*/
}
