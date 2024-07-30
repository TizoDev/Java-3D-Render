package figures;

import java.awt.Color;

import render.Polygon3D;
import render.Screen;

public class Plane extends Figure
{
	protected double width, depth, size;
	protected double[] coords;
	public Plane(double x, double y, double z, double width, double depth, Color c, double size)
	{
		super();
		this.width = width;
		this.depth = depth;
		this.size = size;
		this.coords = new double[] {x,y,z};
		for(int i = 0; i < width; i++)
			for(int j = 0; j < depth; j++)
			{
				Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(new double[]{i*size + x, i*size + x, i*size + x + size}, new double[]{j*size + y, j*size + y + size, j*size + y + size},  new double[]{z, z, z}, c, this.ID);
				this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
				Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(new double[]{i*size + x, i*size + x + size, i*size + x + size}, new double[]{j*size + y, j*size + y + size, j*size + y},  new double[]{z, z, z}, c, this.ID);
				this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
			}
	}
}
