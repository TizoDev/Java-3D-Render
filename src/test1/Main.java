package test1;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame
{
	static public Dimension PcSize = Toolkit.getDefaultToolkit().getScreenSize();
	static public Dimension ScreenSize = new Dimension(720, 520);
	static JFrame F = new Main();
	Screen ScreenObject = new Screen();
	
	
	public Main()
	{
		add(ScreenObject);
		setUndecorated(true);
		setSize(ScreenSize);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
