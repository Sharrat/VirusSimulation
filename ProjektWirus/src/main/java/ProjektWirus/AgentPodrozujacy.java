package ProjektWirus;

public class AgentPodrozujacy extends Agent {

	public AgentPodrozujacy(int x,int y,int z,int l,boolean v)
	{
		super(x,y,z,l,v);
	}
	public void Move()
	{
		if(this.x==600) {this.x-=1;} //ograniczenie przestrzeni ruchu
    	else
    	if(this.y==600) {this.y-=1;}
    	else if(this.x==0){this.x+=1;}
    	else if(this.y==0){this.y+=1;}
    	else
    	{
        this.x+=Stoper.rand.nextFloat()*3-1; // losowanie kierunku ruchu
        this.y+=Stoper.rand.nextFloat()*3-1;
    	}
	}
}
