package render;

public class Calculator 
{
	static double DrawX = 0, DrawY = 0;
	static double t;
	
	static public double CalculatePositionX(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		iniciar(ViewFrom, ViewTo, x, y, z);
		return DrawX;
	}

	static public double CalculatePositionY(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		iniciar(ViewFrom, ViewTo, x, y, z);
		return DrawY;		
	}
	
	static void iniciar(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
		
		Vector RotationVector = GetRotationVector(ViewFrom, ViewTo);
		Vector WeirdVector1 = ViewVector.CrossProduct(RotationVector);
		Vector WeirdVector2 = ViewVector.CrossProduct(WeirdVector1);
		
		Vector ViewToPoint = new Vector(x - ViewFrom[0], y - ViewFrom[1], z - ViewFrom[2]);
		
		t = (ViewVector.x * ViewTo[0] + ViewVector.y*ViewTo[1] + ViewVector.z*ViewTo[2]
		-  (ViewVector.x * ViewFrom[0] + ViewVector.y*ViewFrom[1] + ViewVector.z*ViewFrom[2]))
		/  (ViewVector.x * ViewToPoint.x + ViewVector.y*ViewToPoint.y + ViewVector.z*ViewToPoint.z);
		
		x = ViewFrom[0] + ViewToPoint.x * t;
		y = ViewFrom[1] + ViewToPoint.y * t;
		z = ViewFrom[2] + ViewToPoint.z * t;
		
		
		if(t > 0)
		{
			DrawX = WeirdVector2.x * x + WeirdVector2.y * y + WeirdVector2.z * z;
			DrawY = WeirdVector1.x * x + WeirdVector1.y * y + WeirdVector1.z * z;
		}
	}
	
	static public Vector GetRotationVector(double[] ViewFrom, double[] ViewTo)
	{
		double dx = Math.abs(ViewFrom[0]-ViewTo[0]);
		double dy = Math.abs(ViewFrom[1]-ViewTo[1]);
		double xRot, yRot;
		
		xRot=dy/(dx+dy);		
		yRot=dx/(dx+dy);
		
		if(ViewFrom[1]>ViewTo[1])
			xRot = -xRot;
		if(ViewFrom[0]<ViewTo[0])
			yRot = -yRot;

		Vector V = new Vector(xRot, yRot, 0);
		return V;
	}
}