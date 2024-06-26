package figures;

import java.awt.Color;

import render.Polygon3D;
import render.Screen;

public class PrismaR extends Figure
{
	public PrismaR(double x, double y, double z, double width, double height, double depth, Color c, double size)
	{
		super();
		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara inferior
		    new double[]{x, x + width*size, x + width*size, x},
		    new double[]{y, y, y + height*size, y + height*size},
		    new double[]{z, z, z, z},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara superior
		    new double[]{x, x + width*size, x + width*size, x},
		    new double[]{y, y, y + height*size, y + height*size},
		    new double[]{z + depth*size, z + depth*size, z + depth*size, z + depth*size},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara frontal
		    new double[]{x, x + width*size, x + width*size, x},
		    new double[]{y, y, y, y},
		    new double[]{z, z, z + depth*size, z + depth*size},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara trasera
		    new double[]{x, x + width*size, x + width*size, x},
		    new double[]{y + height*size, y + height*size, y + height*size, y + height*size},
		    new double[]{z, z, z + depth*size, z + depth*size},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara izquierda
		    new double[]{x, x, x, x},
		    new double[]{y, y + height*size, y + height*size, y},
		    new double[]{z, z, z + depth*size, z + depth*size},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);

		Screen.Polygons3D[Screen.NumberPolygons3D] = new Polygon3D( // Cara derecha
		    new double[]{x + width*size, x + width*size, x + width*size, x + width*size},
		    new double[]{y, y + height*size, y + height*size, y},
		    new double[]{z, z, z + depth*size, z + depth*size},
		    c, this.ID
		);
		this.polys.add(Screen.Polygons3D[Screen.NumberPolygons3D - 1]);
		
	}
}
