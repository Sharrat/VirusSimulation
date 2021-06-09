package ProjektWirus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.NumberFormatter;

public class Menu extends JPanel{	

	private static final long serialVersionUID = 1L;
	public static Parametry parametry;
	public Menu(){
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		
	    JPanel panel = new JPanel();
		JFrame frame = new JFrame("Projekt Wirus");
		frame.setLocationRelativeTo(null); 
		frame.setSize(600, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel numAgentsLabel = new JLabel("Liczba ludzi");
		numAgentsLabel.setBounds(10, 20, 80, 25);
		panel.add(numAgentsLabel);
		
		JFormattedTextField numAgentsText = new JFormattedTextField(formatter);
		numAgentsText.setBounds(200, 20, 170, 25);
		numAgentsText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(numAgentsText);
		
		JLabel procMovingLabel = new JLabel("Procent poruszaj¹cych siê");
		procMovingLabel.setBounds(10, 50, 165, 25);
		panel.add(procMovingLabel);
		
		JFormattedTextField procMovingText = new JFormattedTextField(formatter);
		procMovingText.setBounds(200, 50, 170, 25);
		procMovingText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(procMovingText);

		JLabel procSickLabel = new JLabel("Procent zara¿onych");
		procSickLabel.setBounds(10, 80, 165, 25);
		panel.add(procSickLabel);
		
		JFormattedTextField procSickText = new JFormattedTextField(formatter);
		procSickText.setBounds(200, 80, 170, 25);
		procSickText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(procSickText);
		
		JLabel procVaccLabel = new JLabel("Procent zaszczepionych");
		procVaccLabel.setBounds(10, 110, 165, 25);
		panel.add(procVaccLabel);
		
		JFormattedTextField procVaccText = new JFormattedTextField(formatter);
		procVaccText.setBounds(200, 110, 170, 25);
		procVaccText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(procVaccText);
		
		JLabel dayEndLabel = new JLabel("Liczba dni");
		dayEndLabel.setBounds(10, 140, 165, 25);
		panel.add(dayEndLabel);
		
		JFormattedTextField dayEndText = new JFormattedTextField(formatter);
		dayEndText.setBounds(200, 140, 170, 25);
		dayEndText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(dayEndText);
		
		JLabel vaccEffLabel = new JLabel("Skutecznoœæ szczepionki");
		vaccEffLabel.setBounds(10, 170, 165, 25);
		panel.add(vaccEffLabel);
		
		JFormattedTextField vaccEffText = new JFormattedTextField(formatter);
		vaccEffText.setBounds(200, 170, 170, 25);
		vaccEffText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(vaccEffText);
		
		JLabel virusInfLabel = new JLabel("ZaraŸliwoœæ wirusa");
		virusInfLabel.setBounds(10, 200, 165, 25);
		panel.add(virusInfLabel);
		
		JFormattedTextField virusInfText = new JFormattedTextField(formatter);
		virusInfText.setBounds(200, 200, 170, 25);
		virusInfText.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(virusInfText);
		
		JLabel procent1 = new JLabel("%");
		procent1.setBounds(370, 50, 100, 25);
		panel.add(procent1);
		
		JLabel procent2 = new JLabel("%");
		procent2.setBounds(370, 80, 100, 25);
		panel.add(procent2);
		
		JLabel procent3 = new JLabel("%");
		procent3.setBounds(370, 110, 100, 25);
		panel.add(procent3);
		
		JLabel procent4 = new JLabel("%");
		procent4.setBounds(370, 170, 100, 25);
		panel.add(procent4);
		
		JLabel procent5 = new JLabel("%");
		procent5.setBounds(370, 200, 100, 25);
		panel.add(procent5);
		
		JButton buttonStart = new JButton("Start");
		buttonStart.setBounds(420, 50, 160, 25);
		buttonStart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Plansza plansza = new Plansza();
				JDialog dialog = new JDialog(); 
				dialog.add(plansza);
		        dialog.setSize(600, 600);
				dialog.setVisible(true);
				Timer timer = new Timer(1000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(parametry.getDayEnd()==parametry.getDay()) 
		            	{
		            		 dialog.setVisible(false);
				             dialog.dispose();
				             plansza.timer.stop();
				             try {
								Zwrot.toFile();
							 } catch (IOException e1) {}
				             Menu.parametry=null;
				             JOptionPane.showMessageDialog(frame,"Symulacja zakoñczona.","",JOptionPane.PLAIN_MESSAGE);
				             System.exit(0);
		            	}
		               
		            }
		        });
		        timer.setRepeats(true);
		        timer.start();
			}
		});
		JButton buttonParametry = new JButton("ZatwierdŸ parametry");
		buttonParametry.setBounds(420, 20, 160, 25);
		buttonParametry.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(numAgentsText.getText().isEmpty() || procMovingText.getText().isEmpty() || procSickText.getText().isEmpty() || procVaccText.getText().isEmpty() || dayEndText.getText().isEmpty() || vaccEffText.getText().isEmpty() || virusInfText.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(frame,"Proszê wype³niæ wszystkie pola!","",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					int numAgents = (int) numAgentsText.getValue();
					int procMoving = (int) procMovingText.getValue();
					int procSick = (int) procSickText.getValue();
					int procVacc = (int) procVaccText.getValue();
					int dayEnd = (int) dayEndText.getValue();	
					int vaccEff = (int) vaccEffText.getValue();
					int virusInf = (int) virusInfText.getValue();
					//System.out.println(numAgents + ", " + procMoving + ", " + procSick + ", " + procVacc + ", " + dayEnd +","+vaccEff+ "," +virusInf);
					if(numAgents>10000){JOptionPane.showMessageDialog(frame,"Liczba ludzi powinna nie przekraczaæ 10000","",JOptionPane.ERROR_MESSAGE);} 
					else if(procMoving>100 || procSick>100 || procVacc>100 || vaccEff>100 || virusInf>100){JOptionPane.showMessageDialog(frame,"Wartoœci procentowe powinny byæ z zakresu 0-100","",JOptionPane.ERROR_MESSAGE);} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Parametry zatwierdzone","",JOptionPane.PLAIN_MESSAGE);
						Menu.parametry = new Parametry(numAgents,procMoving,procSick,procVacc,dayEnd,vaccEff,virusInf);
					}
				}
			}
		});
		JButton defaultb = new JButton("Parametry domyœlne");
		defaultb.setBounds(420, 80, 160, 25);
		defaultb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Plansza plansza = new Plansza();
				Menu.parametry = new Parametry(2000,50,40,30,5,85,60);
				JDialog dialog = new JDialog(); 
				dialog.add(plansza);
		        dialog.setSize(600, 600);
				dialog.setVisible(true);
				Timer timer = new Timer(1000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(parametry.getDayEnd()==parametry.getDay()) 
		            	{
		            		 dialog.setVisible(false);
				             dialog.dispose();
				             plansza.timer.stop();
				             try {
								Zwrot.toFile();
							 } catch (IOException e1) {}
				             Menu.parametry=null;
				             JOptionPane.showMessageDialog(frame,"Symulacja zakoñczona.","",JOptionPane.PLAIN_MESSAGE);
				             System.exit(0);
		            	}
		               
		            }
		        });
		        timer.setRepeats(true);
		        timer.start();
			}
		});
		panel.add(defaultb);
		panel.add(buttonStart);
		panel.add(buttonParametry);
		frame.setVisible(true);
	}
}

