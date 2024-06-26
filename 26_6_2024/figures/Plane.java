package figures;

import java.awt.Color;

import render.Polygon3D;
import render.Screen;

public class Plane extends Figure
{
	public Plane(double x, double y, double z, double width, double depth, Color c, double size)
	{
		super();
		for(int i = (int)x; i < width + x; i++)
			for(int j = (int)y; j < depth + y; j++)
			{
				Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(new double[]{i, i, i + size, i + size}, new double[]{j, j + size, j + size, j},  new double[]{z, z, z, z}, c, this.ID);
				this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
			}
	}
}
