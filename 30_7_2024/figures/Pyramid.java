package figures;

import java.awt.Color;

import render.Polygon3D;
import render.Screen;

public class Pyramid extends Figure
{
	public Pyramid(double x, double y, double z, double width, double height, double depth, Color c, double size)
	{
		super();
		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x, x + width*size, x + width*size / 2},
			    new double[]{y, y, y + depth*size / 2},
			    new double[]{z, z, z + height*size},
			    c, this.ID
			); 
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x + width*size, x + width*size, x + width*size / 2},
			    new double[]{y, y + depth*size, y + depth*size / 2},
			    new double[]{z, z, z + height*size},
			    c, this.ID
			);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x + width*size, x, x + width*size / 2},
			    new double[]{y + depth*size, y + depth*size, y + depth*size / 2},
			    new double[]{z, z, z + height*size},
			    c, this.ID
			);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x, x, x + width*size / 2},
			    new double[]{y + depth*size, y, y + depth*size / 2},
			    new double[]{z, z, z + height*size},
			    c, this.ID
			);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		// base
		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x, x + width*size, x + width*size},
			    new double[]{y, y, y + depth*size},
			    new double[]{z, z, z},
			    c, this.ID
			);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
		
		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D(
			    new double[]{x, x + width*size, x},
			    new double[]{y, y + depth*size, y + depth*size},
			    new double[]{z, z, z},
			    c, this.ID
			);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
			
	}
}
