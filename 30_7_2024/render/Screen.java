package render;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import figures.Figure;
import figures.PrismaR;
import figures.Terrain;
import physics.Controls;

public class Screen extends JPanel
{
	static double SleepTime = 1000/60; //  1000/FPS
	static double lastRefresh = 0;
	
	static public double[] ViewFrom = new double[] {10, 10, 10};
	static public double[] ViewTo = new double[] {0, 0, 0};
	
	static public int NumberOfPolygons = 0, NumberPolygons3D = 0, NumberFigures3D = 0;
	static PolygonObject[] DrawablePolygons = new PolygonObject[1000];
	static public Polygon3D[] Polygons3D = new Polygon3D[1000];
	static public Figure[] Figures3D = new Figure[100];
	
	int[] newOrder;
	static public boolean outlines = false;	
	static public String coordinates = "";
	static public String test = "";
	Controls control = new Controls();
	
	Light globalLight;
	
	public Screen()
	{
		addKeyListener(control);
		setFocusable(true);
		
		Figures3D[NumberFigures3D] = new Terrain(-10, -10, 0, 20, 20, new Color(20, 20, 255, 0), 1, 0.5);
		Figures3D[NumberFigures3D] = new PrismaR(0, 0, 5, 1, 1, 1, Color.gray, 1);
		
		globalLight = new Light(new double[] {0,0,10}, new double[] {0,0,0}, 50, true);
		Figures3D[NumberFigures3D] = new PrismaR(globalLight.ViewFrom[0], globalLight.ViewFrom[1], globalLight.ViewFrom[2], 0.5, 0.5, 0.5, Color.blue, 1);
	}
	
	public void paintComponent(Graphics g)
	{
		control.keyFunctions();
		
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

	
}