package figures;

import java.util.ArrayList;

import render.Polygon3D;
import render.Screen;

public class Figure 
{
	public int ID;
	public ArrayList<Polygon3D> polys = new ArrayList<Polygon3D>();
	
	public Figure()
	{
		this.ID = Screen.NumberFigures3D;
		Screen.NumberFigures3D++;
	}
	
	public void moveFigure(double x, double y, double z, double velocity)
	{
		for(int i=0; i<this.polys.size(); i++)
		{
			double[] newX = new double[this.polys.get(i).x.length];
			double[] newY = new double[this.polys.get(i).x.length];
			double[] newZ = new double[this.polys.get(i).x.length];
			
			for(int j=0; j<this.polys.get(i).x.length; j++)
			{
				newX[j] = this.polys.get(i).x[j] + x*velocity;
				newY[j] = this.polys.get(i).y[j] + y*velocity;
				newZ[j] = this.polys.get(i).z[j] + z*velocity;
			}
			polys.get(i).changeCoords(newX, newY, newZ);
		}
	}
}
