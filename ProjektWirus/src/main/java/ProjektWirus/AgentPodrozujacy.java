package ProjektWirus;

public class AgentPodrozujacy extends Agent {

	public AgentPodrozujacy(int x,int y,int z,int l,boolean v)
	{
		super(x,y,z,l,v);
	}
	public void Move()
	{
		switch(this.x) 
		{
		case 600:
			this.x-=1;
			break;
		case 0:
			this.x+=1;
			break;
		default:
			this.x+=Stoper.rand.nextFloat()*3-1;
			break;
		}
		switch(this.y)
		{
		case 600:
			this.y-=1;
			break;
		case 0:
			this.y+=1;
			break;
		default:
			this.y+=Stoper.rand.nextFloat()*3-1;
			break;
		}
	}
}
