package physics;

import figures.Figure;
import render.Screen;

public class Collisions 
{
	static public boolean[][] matrizCollisions = new boolean[100][100];
	
	static boolean isColliding(int ob)
	{
		for(int i=0; i<matrizCollisions.length; i++)
		{
			if(matrizCollisions[ob][i] == true) return true;
		}
		
		return false;
	}
	
	static boolean getCollision(int ob1, int ob2)
	{
		return matrizCollisions[ob1][ob2];
	}
	
	static void updatePhysics(int k)
	{
		for(int i=0; i< matrizCollisions.length; i++)
		{
			matrizCollisions[k][i] = calculatePhysics(k, i);
		}
	}
	
	static boolean calculatePhysics(int ob1, int ob2)
	{
		Figure f1 = Screen.Figures3D[ob1];
		Figure f2 = Screen.Figures3D[ob2];
		
		for(int i=0; i<f1.polys.size(); i++)
		{
			for(int j=0; j<f2.polys.size(); j++)
			{
				
			}
		}
		
		return false;
	}
}
