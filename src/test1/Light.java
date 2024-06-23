package test1;

import java.awt.Color;

public class Light 
{
	double[] ViewFrom;
	double[] ViewTo;
	int[] newOrder;
	int intensity = 20;
	
	public Light(double[] vf, double[] vt)
	{
		this.ViewFrom = vf;
		this.ViewTo = vt;
	}
	
	public void updateLight()
	{
		Screen.test = Screen.NumberOfPolygons + "";
		setOrder();
		for(int i=0; i < Screen.NumberOfPolygons; i++)
		{
			if(Screen.DrawablePolygons[newOrder[i]] != null)
			{
				double dist = Screen.Polygons3D[newOrder[i]].GetDist(this.ViewFrom);
				if(dist > this.intensity) Screen.DrawablePolygons[newOrder[i]].c = new Color(0,0,0);
				else
				{
					int color = (int)dist;
					Screen.DrawablePolygons[newOrder[i]].c = new Color(color,color,color);
				}
			}
		}
				
	}
	
	protected void setOrder()
	{
		double[] k = new double[Screen.NumberOfPolygons];
		newOrder = new int[Screen.NumberOfPolygons];
		
		for(int i = 0; i < Screen.NumberOfPolygons; i++)
		{
			if(Screen.DrawablePolygons[i] != null) k[i] = Screen.Polygons3D[i].GetDist(this.ViewFrom);
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
}
