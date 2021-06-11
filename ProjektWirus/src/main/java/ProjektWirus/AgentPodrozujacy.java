package ProjektWirus;

public class AgentPodrozujacy extends Agent {

	public AgentPodrozujacy(int x,int y,int z,int l,boolean v)
	{
		super(x,y,z,l,v);
	}//konstruktor oraz atrybuty identyczne jak w klasie Agent
	public void Move()//funkcja zmieniaj¹ce po³o¿enie agenta na osiach x oraz y w losowym kierunku o jeden pixel
	{
		switch(this.x) 
		{
		case 600: 
			this.x-=1;
			break;
		case 0: //case 600 oraz 0 s¹ aby agenci nie wychodzili poza granice planszy symulacji
			this.x+=1;
			break;
		default:
			this.x+=Stoper.rand.nextFloat()*3-1;//losowanie kierunku ruchu na osi x
			break;
		}
		switch(this.y)
		{
		case 600:
			this.y-=1;
			break;
		case 0://case 600 oraz 0 s¹ aby agenci nie wychodzili poza granice planszy symulacji
			this.y+=1;
			break;
		default:
			this.y+=Stoper.rand.nextFloat()*3-1;//losowanie kierunku ruchu na osi y
			break;
		}
	}
}
