package render;

import java.awt.Color;
import java.util.Arrays;

public class Polygon3D 
{
	Color c;
	public double[] x, y, z;
	public double[] baricentro = new double[3];
	int poly = 0;
	int groupID;
	
	public Polygon3D(double[] x, double[] y, double[] z, Color c, int groupID)
	{
		Screen.NumberPolygons3D++;
		this.x = x;
		this.y = y;
		this.z = z;
		this.c = c;
		this.groupID = groupID;
		createPolygon();
	}
	
	void createPolygon()
	{
		poly = Screen.NumberOfPolygons;
 		Screen.DrawablePolygons[Screen.NumberOfPolygons] = new PolygonObject(new double[]{}, new double[]{}, c);
 		updatePolygon();
	}
	
	public void changeCoords(double[] x, double[] y, double[] z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		
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
		obtenerBaricentro();

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
	
	Vector normal()
	{
		Vector res, v1, v2;
		
		v1 = new Vector(x[1] - x[2], y[1] - y[2], z[1] - z[2]);
		v2 = new Vector(x[2] - x[0], y[2] - y[0], z[2] - z[0]);
		
		res = v1.CrossProduct(v2);
		res = res.normalize();
		
		return res;
	}
	
	void obtenerBaricentro()
	{
		baricentro[0] = (x[0] + x[1] + x[2]) / 3;
		baricentro[1] = (y[0] + y[1] + y[2]) / 3;
		baricentro[2] = (z[0] + z[1] + z[2]) / 3;
	}

	@Override
	public String toString() {
		return "Polygon3D [x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + ", z=" + Arrays.toString(z) + "]";
	}
	
	/*
	 * Sacar varicentro del polygono
	 * obtener vector entre el punto de luz y el varicentro
	 * normalizar el vector de distancia
	 * producto ESCALAR entre vector de distancia y normal del triangulo
	 * devuelve valor entre 0 y 1 que va a ser el porcentaje de iluminacion
	 */
	
	

}