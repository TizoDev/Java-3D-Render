package test1;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class Polygon3D 
{
	Color c;
	double[] x, y, z;
	int poly = 0;
	
	public Polygon3D(double[] x, double[] y, double[] z, Color c)
	{
		Screen.NumberPolygons3D++;
		this.x = x;
		this.y = y;
		this.z = z;
		this.c = c;
		createPolygon();
	}
	
	void createPolygon()
	{
		poly = Screen.NumberOfPolygons;
 		Screen.DrawablePolygons[Screen.NumberOfPolygons] = new PolygonObject(new double[]{}, new double[]{}, c);
 		updatePolygon();
	}
	
	void updatePolygon()
	{
		double dx = - 50 * Calculator.CalculatePositionX(Screen.ViewFrom, Screen.ViewTo, Screen.ViewTo[0], Screen.ViewTo[1], Screen.ViewTo[2]);
		double dy = - 50 * Calculator.CalculatePositionY(Screen.ViewFrom, Screen.ViewTo, Screen.ViewTo[0], Screen.ViewTo[1], Screen.ViewTo[2]);
		double[] newX = new double[x.length];
		double[] newY = new double[x.length];
		boolean draw = true;
		
		for(int i = 0; i < x.length; i++)
		{
			newX[i] = dx + Main.ScreenSize.getWidth()/2 + 50 * Calculator.CalculatePositionX(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
			newY[i] = dy + Main.ScreenSize.getHeight()/2 + 50 * Calculator.CalculatePositionY(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
			if(Calculator.t < 0) draw = false;
		}		

		Screen.DrawablePolygons[poly].updatePolygon(newX, newY, GetDist(Screen.ViewFrom));
		Screen.DrawablePolygons[poly].draw = draw;

	}
	
	double GetDist(double[] ViewFrom)
	{
		double total = 0;
		for(int i = 0; i < x.length; i++)
			total += GetDistanceToP(i, ViewFrom);
		return total / x.length;
	}
	
	double GetDistanceToP(int i, double[] ViewFrom)
	{
		return Math.sqrt(
				(ViewFrom[0] - x[i])*(ViewFrom[0] - x[i]) +
				(ViewFrom[1] - y[i])*(ViewFrom[1] - y[i]) +
				(ViewFrom[2] - z[i])*(ViewFrom[2] - z[i]));
	}
	
	
/*	 public Vector calculateTriangleNormal(Vector v1, Vector v2, Vector v3) 
	 {
		 Vector edge1 = v2.subtract(v1);
		 Vector edge2 = v3.subtract(v1);
		 return edge1.CrossProduct(edge2).normalize();
	 }
	 
	 public List<Vector[]> dividePolygonIntoTriangles() 
	 {
		 List<Vector[]> triangles = new ArrayList<>();

		 for (int i = 2; i < this.x.length; i++) 
		 {
			 Vector v1 = new Vector(x[0], y[0], z[0]); 
			 Vector v2 = new Vector(x[i-1], y[i-1], z[i-1]);
			 Vector v3 = new Vector(x[i], y[i], z[i]);
			 triangles.add(new Vector[]{v1, v2, v3});
	        }

	        return triangles;
	    }

	 public Vector calculatePolygonNormal() 
	 {
		 Vector sumNormals = new Vector(0, 0, 0);
		 List<Vector[]> triangles = dividePolygonIntoTriangles();

		 for (Vector[] triangle : triangles) 
		 {
			 Vector normal = calculateTriangleNormal(triangle[0], triangle[1], triangle[2]);
			 sumNormals = sumNormals.add(normal);
	     }

		 return sumNormals.normalize();
	 }*/
}