package ProjektWirus;

public class Agent {
	public int x;//po³o¿enie agenta na osi x
	public int y;//po³o¿enie agenta na osi y
	public int infected;//0-agent zdrowy, 1- agent zara¿ony wirusem pierwszym, 2-agent zara¿ony wirusem œmiertelnym
	public int daysinfected;//ile dni agent jest ju¿ zara¿ony
	private int infectionlength;//wylosowana d³ugoœæ zara¿enia w przypadku gdy agent zachoruje
	public boolean vaccinated;//czy agent jest zara¿ony
	public Agent(int x,int y,int z,int l,boolean v) //Konstruktor przypisuj¹cy podstawowe atrybuty agentów
	{
		this.x=x;
		this.y=y;
		this.infected=z;
		this.infectionlength=l;
		this.vaccinated=v;
	}
	public void Checkinfection() //funkcja 'uzdrawiaj¹ca' agenta w przypadku gdy jego okres zara¿enia dobieg³ koñca
	{
		if(this.daysinfected==infectionlength){this.infected=0;};
	}

}
