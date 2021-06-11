package ProjektWirus;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class Plansza extends JPanel {
	private static final long serialVersionUID = 1L;
	private ActionListener regulator = new ActionListener() 
	{ 
		public void actionPerformed(ActionEvent evt) 
		{
			try {
				Stoper.routine(Menu.parametry.points,Menu.parametry.pointsMoving,Menu.parametry.virus,Menu.parametry.virusDeadly,Menu.parametry.vaccine);
			} catch (IOException e) {}
			repaint();
		}
	};
	public Timer timer = new Timer(10,regulator);
	public Plansza() {
		setBackground(Color.lightGray);
        timer.start();
	}
	public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Agent point : Menu.parametry.points) {
        	if(point.infected==1) {g2.setColor(Color.red);}
        	else if(point.infected==2) {g2.setColor(Color.magenta);}
        	else if(point.infected==0&&point.vaccinated==true) {g2.setColor(Color.cyan);}
        	else {g2.setColor(Color.blue);}
            g2.fillOval(point.x, point.y, 4, 4);
        }
        for (AgentPodrozujacy point : Menu.parametry.pointsMoving) {
        	if(point.infected==1) {g2.setColor(Color.red);}
        	else if(point.infected==2) {g2.setColor(Color.magenta);}
        	else if(point.infected==0&&point.vaccinated==true) {g2.setColor(Color.cyan);}
        	else if(point.infected==3) {g2.setColor(Color.black);}
        	else {g2.setColor(Color.blue);}
            g2.fillOval(point.x, point.y, 4, 4);
        }
        g2.setColor(Color.black);
        g.setFont(new Font("default",Font.BOLD,16));
        g.drawString("Dzieñ: "+Menu.parametry.getDay(), 20, 20);
    }
}
