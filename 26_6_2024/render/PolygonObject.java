package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PolygonObject 
{
	Polygon P;
	public Color c;
	public Color original;
	double AvgDist = 0;
	public boolean draw = true;
	
	public PolygonObject(double[] x, double[] y, Color c)
	{
		Screen.NumberOfPolygons++;
		P = new Polygon();
		for(int i = 0; i < x.length; i++)
			P.addPoint((int)x[i], (int)y[i]);
		this.c = c;
		this.original = c;
	}
	
	void updatePolygon(double[] x, double[] y, double dis)
	{
		P.reset();
		for(int i = 0; i<x.length; i++)
		{
			P.xpoints[i] = (int) x[i];
			P.ypoints[i] = (int) y[i];
			P.npoints = x.length;
			AvgDist = dis;
		}
	}
	
	void drawPolygon(Graphics g)
	{
		if(draw)
		{
			g.setColor(c);
			g.fillPolygon(P);
			if(Screen.outlines)
			{
				g.setColor(Color.black);
				g.drawPolygon(P);
			}
		}
	}
}