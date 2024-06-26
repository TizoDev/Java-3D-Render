package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import figures.Plane;

public class Screen extends JPanel implements KeyListener
{
	static double SleepTime = 1000/60; //  100/FPS
	static double lastRefresh = 0;
	
	static double[] ViewFrom = new double[] {10, 10, 10};
	static double[] ViewTo = new double[] {0, 0, 0};
	
	static public int NumberOfPolygons = 0, NumberPolygons3D = 0;
	static PolygonObject[] DrawablePolygons = new PolygonObject[1000];
	static public Polygon3D[] Polygons3D = new Polygon3D[1000];
	
	int[] newOrder;
	boolean[] keys = new boolean[8];
	static boolean outlines = true;	
	static public String coordinates = "";
	static public String test = "";
	
	Light globalLight;
	
	public Screen()
	{
		addKeyListener(this);
		setFocusable(true);
		
		Plane p = new Plane(-10, -10, 0, 20, 20, Color.green, 1);
		
		globalLight = new Light(new double[] {10,10,5}, new double[] {0,0,0}, 25);
	}
	
	public void paintComponent(Graphics g)
	{
		Controls();
		
		g.clearRect(0, 0, 2000, 1200);
		
		globalLight.updateLight();
		
		for(int i = 0; i < NumberPolygons3D; i++)
			Polygons3D[i].updatePolygon();
		
		setOrder();

		for(int i = 0; i < NumberOfPolygons; i++)
			if(DrawablePolygons[newOrder[i]] != null)
				DrawablePolygons[newOrder[i]].drawPolygon(g);
		
		coordinates = "x:" + (int)ViewFrom[0] + "   y:" + (int)ViewFrom[1] + "   z:" + (int)ViewFrom[2];
		g.drawString(coordinates, 20, 20);
		g.drawString(test, 20, 40);
		
		SleepAndRefresh();
	}
	
	void setOrder()
	{
		double[] k = new double[NumberOfPolygons];
		newOrder = new int[NumberOfPolygons];
		
		for(int i = 0; i < NumberOfPolygons; i++)
		{
			if(DrawablePolygons[i] != null) k[i] = DrawablePolygons[i].AvgDist;	
			newOrder[i] = i;
		}
		
	    double temp;
	    int tempr;	    
		for (int a = 0; a < k.length-1; a++)
			for (int b = 0; b < k.length-1; b++)
				if(k[b] < k[b + 1])
				{
					temp = k[b];
					tempr = newOrder[b];
					newOrder[b] = newOrder[b + 1];
					k[b] = k[b + 1];
					   
					newOrder[b + 1] = tempr;
					k[b + 1] = temp;
				}
	}
	
	void SleepAndRefresh()
	{
		while(true)
		{
			if(System.currentTimeMillis() - lastRefresh > SleepTime)
			{
				lastRefresh = System.currentTimeMillis();
				repaint();
				break;
			}
			else
			{
				try 
				{
					Thread.sleep((long)(System.currentTimeMillis() - lastRefresh));
				} 
				catch (Exception e) 
				{

				}
			}
		}
	}

	void Controls()
	{
		Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
		if(keys[4]) //W
		{
			ViewFrom[0] += ViewVector.x;
			ViewFrom[1] += ViewVector.y;
			ViewFrom[2] += ViewVector.z;
			ViewTo[0] += ViewVector.x;
			ViewTo[1] += ViewVector.y;
			ViewTo[2] += ViewVector.z;
		}
		
		if(keys[6])//S
		{
			ViewFrom[0] -= ViewVector.x;
			ViewFrom[1] -= ViewVector.y;
			ViewFrom[2] -= ViewVector.z;
			ViewTo[0] -= ViewVector.x;
			ViewTo[1] -= ViewVector.y;
			ViewTo[2] -= ViewVector.z;
		}
		
		Vector VerticalVector = new Vector(0, 0, 1);
		Vector SideViewVector = ViewVector.CrossProduct(VerticalVector);
		
		if(keys[5])//A
		{
			ViewFrom[0] += SideViewVector.x;
			ViewFrom[1] += SideViewVector.y;
			ViewFrom[2] += SideViewVector.z;
			ViewTo[0] += SideViewVector.x;
			ViewTo[1] += SideViewVector.y;
			ViewTo[2] += SideViewVector.z;
		}
		
		if(keys[7])//D
		{
			ViewFrom[0] -= SideViewVector.x;
			ViewFrom[1] -= SideViewVector.y;
			ViewFrom[2] -= SideViewVector.z;
			ViewTo[0] -= SideViewVector.x;
			ViewTo[1] -= SideViewVector.y;
			ViewTo[2] -= SideViewVector.z;
		}
		
		
		if(keys[0]) //LEFT
		{
			ViewTo[0] += SideViewVector.x;
			ViewTo[1] += SideViewVector.y;
			ViewTo[2] += SideViewVector.z;
		}
		
		if(keys[1])//RIGHT
		{
			ViewTo[0] -= SideViewVector.x;
			ViewTo[1] -= SideViewVector.y;
			ViewTo[2] -= SideViewVector.z;
		}
		
		Vector rotacion = Calculator.GetRotationVector(ViewFrom, ViewTo);
		Vector rotY = ViewVector.CrossProduct(rotacion);
		
		if(keys[2])//UP
		{
			ViewTo[0] -= rotY.x;
			ViewTo[1] -= rotY.y;
			ViewTo[2] -= rotY.z;
		}
		
		if(keys[3])//DOWN
		{
			ViewTo[0] += rotY.x;
			ViewTo[1] += rotY.y;
			ViewTo[2] += rotY.z;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = true;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = true;
		if(e.getKeyCode() == KeyEvent.VK_O)
			outlines = false;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = false;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = false;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = false;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = false;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = false;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = false;
		if(e.getKeyCode() == KeyEvent.VK_O)
			outlines = true;

	}

	public void keyTyped(KeyEvent e) {}
}