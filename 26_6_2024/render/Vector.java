package render;

public class Vector 
{
	public double x = 0, y = 0, z = 0;
	public Vector(double x, double y, double z)
	{
		double length = Math.sqrt(x * x + y * y + z * z);
		if(length>0)
		{
			this.x = x/length;
			this.y = y/length;
			this.z = z/length;
		}
	}
	
	public Vector CrossProduct(Vector v)
	{
		Vector CrossVector = new Vector(
				y * v.z - z * v.y,
				z * v.x - x * v.z,
				x * v.y - y * v.x);
		return CrossVector;
	}
	
	public Vector subtract(Vector other) 
	{
        return new Vector(x - other.x, y - other.y, z - other.z);
    }
	
	public Vector add(Vector other) 
	{
        return new Vector(x + other.x, y + other.y, z + other.z);
    }
	
	public double magnitude()
	{
		return Math.sqrt(x * x + y * y + z * z);
	}

	public Vector normalize() 
	{
		double mag = magnitude();
	    return new Vector(x / mag, y / mag, z / mag);
	}
	
	double dotProduct(Vector v)
	{
		return this.x * v.x + this.y * v.y + this.z * v.z;
	}
}