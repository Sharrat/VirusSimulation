package ProjektWirus;

public class Agent {
	public int x;
	public int y;
	public int infected;
	public int daysinfected;
	private int infectionlength;
	public boolean vaccinated;
	public Agent(int x,int y,int z,int l,boolean v) 
	{
		this.x=x;
		this.y=y;
		this.infected=z;
		this.infectionlength=l;
		this.vaccinated=v;
	}
	public void Checkinfection() 
	{
		if(this.daysinfected==infectionlength){this.infected=0;};
	}

}
