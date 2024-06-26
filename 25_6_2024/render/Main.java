package render;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame
{
	static public Dimension PcSize = Toolkit.getDefaultToolkit().getScreenSize();
	static public Dimension ScreenSize = new Dimension(920, 720);
	static JFrame F = new Main();
	Screen ScreenObject = new Screen();
	GeneratorWindow gw = new GeneratorWindow();
	 
	public Main()
	{
		add(ScreenObject);
		setUndecorated(false);
		setSize(ScreenSize);
		setVisible(true);
		setTitle("3D World");
		setResizable(false);
		gw.main(null);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
