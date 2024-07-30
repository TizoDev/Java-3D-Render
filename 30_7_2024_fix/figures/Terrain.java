package figures;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Terrain extends Plane
{
	public Terrain(double x, double y, double z, double width, double depth, Color c, double size, double spikes) 
	{
		super(x, y, z, width, depth, c, size);
		changeTerrain(spikes);
	}
	
	public void changeTerrain(double spikes)
	{
		for(int i=0; i<this.polys.size(); i+=6)
		{
			boolean isNeg = ThreadLocalRandom.current().nextBoolean();
			double sp = (Math.random() * spikes);
			if(isNeg) sp*=-1;
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				addHeight(i, sp);
			}
		}
		for(int i=0; i<this.polys.size(); i+=4)
		{
			boolean isNeg = ThreadLocalRandom.current().nextBoolean();
			double sp = (Math.random() * spikes);
			if(isNeg) sp*=-1;
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				addHeight(i, sp);
			}
		}
		
		
		
	}
	
	public void resetTerrain()
	{
		for(int i=0; i<this.polys.size(); i+=6)
		{
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				changePoint(i, coords[2]);
			}
		}
		for(int i=0; i<this.polys.size(); i+=4)
		{
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				changePoint(i, coords[2]);
			}
		}
		
	}
	
	public void changePoint(int i, double z)
	{
		this.polys.get(i+0).z[2]=z;
		this.polys.get(i+1).z[1]=z;
		this.polys.get(i+3).z[2]=z;
		this.polys.get(i+(int)(depth*2+0)).z[1]=z;
		this.polys.get(i+(int)(depth*2+2)).z[0]=z;
		this.polys.get(i+(int)(depth*2+3)).z[0]=z;
	}
	
	public void addHeight(int i, double z)
	{
		this.polys.get(i+0).z[2]+=z;
		this.polys.get(i+1).z[1]+=z;
		this.polys.get(i+3).z[2]+=z;
		this.polys.get(i+(int)(depth*2+0)).z[1]+=z;
		this.polys.get(i+(int)(depth*2+2)).z[0]+=z;
		this.polys.get(i+(int)(depth*2+3)).z[0]+=z;
	}
}
