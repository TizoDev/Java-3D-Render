package physics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import render.Calculator;
import render.Screen;
import render.Vector;

public class Controls implements KeyListener
{
	boolean[] keys = new boolean[20];
	
	public Controls()
	{
		
	}
	
	public void keyFunctions()
	{
		Vector ViewVector = new Vector(Screen.ViewTo[0] - Screen.ViewFrom[0], Screen.ViewTo[1] - Screen.ViewFrom[1], Screen.ViewTo[2] - Screen.ViewFrom[2]);
		if(keys[4]) //W
		{
			Screen.ViewFrom[0] += ViewVector.x;
			Screen.ViewFrom[1] += ViewVector.y;
			Screen.ViewFrom[2] += ViewVector.z;
			Screen.ViewTo[0] += ViewVector.x;
			Screen.ViewTo[1] += ViewVector.y;
			Screen.ViewTo[2] += ViewVector.z;
		}
		
		if(keys[6])//S
		{
			Screen.ViewFrom[0] -= ViewVector.x;
			Screen.ViewFrom[1] -= ViewVector.y;
			Screen.ViewFrom[2] -= ViewVector.z;
			Screen.ViewTo[0] -= ViewVector.x;
			Screen.ViewTo[1] -= ViewVector.y;
			Screen.ViewTo[2] -= ViewVector.z;
		}
		
		Vector VerticalVector = new Vector(0, 0, 1);
		Vector SideViewVector = ViewVector.CrossProduct(VerticalVector);
		
		if(keys[5])//A
		{
			Screen.ViewFrom[0] += SideViewVector.x;
			Screen.ViewFrom[1] += SideViewVector.y;
			Screen.ViewFrom[2] += SideViewVector.z;
			Screen.ViewTo[0] += SideViewVector.x;
			Screen.ViewTo[1] += SideViewVector.y;
			Screen.ViewTo[2] += SideViewVector.z;
		}
		
		if(keys[7])//D
		{
			Screen.ViewFrom[0] -= SideViewVector.x;
			Screen.ViewFrom[1] -= SideViewVector.y;
			Screen.ViewFrom[2] -= SideViewVector.z;
			Screen.ViewTo[0] -= SideViewVector.x;
			Screen.ViewTo[1] -= SideViewVector.y;
			Screen.ViewTo[2] -= SideViewVector.z;
		}
		
		
		if(keys[0]) //LEFT
		{
			Screen.ViewTo[0] += SideViewVector.x;
			Screen.ViewTo[1] += SideViewVector.y;
			Screen.ViewTo[2] += SideViewVector.z;
		}
		
		if(keys[1])//RIGHT
		{
			Screen.ViewTo[0] -= SideViewVector.x;
			Screen.ViewTo[1] -= SideViewVector.y;
			Screen.ViewTo[2] -= SideViewVector.z;
		}
		
		Vector rotacion = Calculator.GetRotationVector(Screen.ViewFrom, Screen.ViewTo);
		Vector rotY = ViewVector.CrossProduct(rotacion);
		
		if(keys[2])//UP
		{
			Screen.ViewTo[0] -= rotY.x;
			Screen.ViewTo[1] -= rotY.y;
			Screen.ViewTo[2] -= rotY.z;
		}
		
		if(keys[3])//DOWN
		{
			Screen.ViewTo[0] += rotY.x;
			Screen.ViewTo[1] += rotY.y;
			Screen.ViewTo[2] += rotY.z;
		}
		
		if(keys[8])
		{
			Screen.Figures3D[1].moveFigure(0, 0, -0.1, 1);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = true;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = true;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = true;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = true;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = true;
		if(e.getKeyCode() == KeyEvent.VK_O)
			Screen.outlines = false;
		if(e.getKeyCode() == KeyEvent.VK_K)
			keys[8] = true;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			keys[0] = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			keys[1] = false;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			keys[2] = false;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			keys[3] = false;
		if(e.getKeyCode() == KeyEvent.VK_W)
			keys[4] = false;
		if(e.getKeyCode() == KeyEvent.VK_A)
			keys[5] = false;
		if(e.getKeyCode() == KeyEvent.VK_S)
			keys[6] = false;
		if(e.getKeyCode() == KeyEvent.VK_D)
			keys[7] = false;
		if(e.getKeyCode() == KeyEvent.VK_O)
			Screen.outlines = true;
		if(e.getKeyCode() == KeyEvent.VK_K)
			keys[8] = false;

	}

	public void keyTyped(KeyEvent e) {}
}
