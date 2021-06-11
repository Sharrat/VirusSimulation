package ProjektWirus;

import java.util.ArrayList;

public class Parametry 
{
	private int day=1;
	private int numAgents;
	private int procMoving;
	private int procSick;
	private int procVacc;
	private int dayEnd;
	public ArrayList<Agent> points;
	public ArrayList<AgentPodrozujacy> pointsMoving;
	public Virus virus;
	public VirusSmiertelny virusDeadly;
	public Szczepionka vaccine;
	public Parametry(int a,int b,int c,int d,int e,int f,int g) 
	{
		this.numAgents=a;
		this.procMoving=b;
		this.procSick=c;
		Stoper.infected=a*c/100;//wpisanie pierwotnej liczby zara¿onych w symulacji do stopera aby poprawnie sprawdzaæ warunki koñca symulacji (czy przypadkiem na pocz¹tku ju¿ nie ma ich 0)
		this.procVacc=d;
		this.dayEnd=e;
		this.vaccine = new Szczepionka(f);
		this.virus= new Virus(g);
		this.virusDeadly = new VirusSmiertelny(g);
		points = new ArrayList<Agent>();
        pointsMoving = new ArrayList<AgentPodrozujacy>();
        double moving=Math.floor(numAgents*procMoving/100);
        double stationary=numAgents-moving;
        double movingSick=Math.floor(moving*procSick/100);
        double stationarySick=Math.floor(stationary*procSick/100);
        for(int i=0;i<Math.ceil(stationarySick/2);i++){ //Pêtle wype³niaj¹ce ArrayListy agentami oraz agentami podró¿uj¹cymi z losowym rozmieszczeniem oraz d³ugoœci¹ zara¿enia wed³ug parametrów symulacji
        	points.add(new Agent(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),1,Stoper.rand.nextInt(27)+3,false));}
        for(int i=0;i<Math.floor(stationarySick/2);i++){
        	points.add(new Agent(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),2,Stoper.rand.nextInt(27)+3,false));}
        for(int i=0;i<Math.floor((stationary-stationarySick)*procVacc/100);i++) {
        	points.add(new Agent(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),0,Stoper.rand.nextInt(27)+3,true));}
        for(int i=0;i<Math.ceil((stationary-stationarySick)-((stationary-stationarySick)*procVacc/100));i++) {
        	points.add(new Agent(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),0,Stoper.rand.nextInt(27)+3,false));}
        for(int i=0;i<Math.ceil(movingSick/2);i++){
        	pointsMoving.add(new AgentPodrozujacy(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),1,Stoper.rand.nextInt(27)+3,false));}
        for(int i=0;i<Math.floor(movingSick/2);i++){
        	pointsMoving.add(new AgentPodrozujacy(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),2,Stoper.rand.nextInt(27)+3,false));}
        for(int i=0;i<Math.ceil((moving-movingSick)*procVacc/100);i++) {
        	pointsMoving.add(new AgentPodrozujacy(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),0,Stoper.rand.nextInt(27)+3,true));}
        for(int i=0;i<Math.floor((moving-movingSick)-((moving-movingSick)*procVacc/100));i++) {
        	pointsMoving.add(new AgentPodrozujacy(Stoper.rand.nextInt(600),Stoper.rand.nextInt(600),0,Stoper.rand.nextInt(27)+3,false));}
	}
	public int getDay() 
	{
		return this.day;
	}
	public void setDay(int x)
	{
		this.day=x;
	}
	public int getNumAgents() 
	{
		return this.numAgents;
	}
	public int getProcSick() 
	{
		return this.procSick;
	}
	public int getProcVacc()
	{
		return this.procVacc;
	}
	public int getDayEnd()
	{
		return this.dayEnd;
	}
	public int getProcMoving()
	{
		return this.procMoving;
	}
}
