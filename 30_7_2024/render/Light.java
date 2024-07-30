package render;

import java.awt.Color;

public class Light 
{
	double[] ViewFrom;
	double[] ViewTo;
	int[] newOrder;
	int range;
	boolean isAmbient;
	
	public Light(double[] vf, double[] vt, int range, boolean isAmb)
	{
		this.ViewFrom = vf;
		this.ViewTo = vt;
		this.range = range;
		this.isAmbient = isAmb;
	}
	
	public void updateLight()
	{
		setOrder();
		for(int i=0; i < Screen.NumberOfPolygons; i++)
		{
			if(Screen.DrawablePolygons[newOrder[i]] != null)
			{
				if(this.isAmbient)
				{
					double dist = Screen.Polygons3D[newOrder[i]].GetDist(this.ViewFrom);
					if(dist > this.range) Screen.DrawablePolygons[newOrder[i]].c = new Color(0,0,0);
					else
					{
						Polygon3D p = Screen.Polygons3D[newOrder[i]];
						Vector v = new Vector(ViewFrom[0] - p.baricentro[0], ViewFrom[1] - p.baricentro[1], ViewFrom[2] - p.baricentro[2]);
						v = v.normalize();
						double porc = p.normal().productoEscalar(v) * -1;
						
						double po = (dist/range) * 100;
						po = (po - 100) * -1;
						
						int r = Screen.DrawablePolygons[newOrder[i]].original.getRed();
						int g = Screen.DrawablePolygons[newOrder[i]].original.getGreen();
						int b = Screen.DrawablePolygons[newOrder[i]].original.getBlue();
						
						if(porc < 0) porc *= -1;
						
						int nr = (int)((porc * (double)r));
						nr = (int)((po*nr)/100);
						int ng = (int)((porc * (double)g));
						ng = (int)((po*ng)/100);
						int nb = (int)((porc * (double)b));
						nb = (int)((po*nb)/100);
						
						Screen.DrawablePolygons[newOrder[i]].c = new Color(nr,ng,nb);
					}
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
