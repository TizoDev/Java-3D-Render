package figures;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public class Terrain extends Plane
{
	public Terrain(double x, double y, double z, double width, double depth, Color c, double size, double spikes) 
	{
		super(x, y, z, width, depth, c, size);
		changeTerrain(spikes, width, depth);
	}
	
	void changeTerrain(double spikes, double width, double depth)
	{
		for(int i=0; i<this.polys.size(); i+=6)
		{
			boolean isNeg = ThreadLocalRandom.current().nextBoolean();
			double sp = (Math.random() * spikes);
			if(isNeg) sp*=-1;
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				this.polys.get(i+0).z[2]+=sp;
				this.polys.get(i+1).z[1]+=sp;
				this.polys.get(i+3).z[2]+=sp;
				this.polys.get(i+(int)(depth*2+0)).z[1]+=sp;
				this.polys.get(i+(int)(depth*2+2)).z[0]+=sp;
				this.polys.get(i+(int)(depth*2+3)).z[0]+=sp;
			}
		}
		for(int i=0; i<this.polys.size(); i+=4)
		{
			boolean isNeg = ThreadLocalRandom.current().nextBoolean();
			double sp = (Math.random() * spikes);
			if(isNeg) sp*=-1;
			if(i+(int)(depth*2+3) <= this.polys.size())
			{
				this.polys.get(i+0).z[2]+=sp;
				this.polys.get(i+1).z[1]+=sp;
				this.polys.get(i+3).z[2]+=sp;
				this.polys.get(i+(int)(depth*2+0)).z[1]+=sp;
				this.polys.get(i+(int)(depth*2+2)).z[0]+=sp;
				this.polys.get(i+(int)(depth*2+3)).z[0]+=sp;
			}
		}
		
	}
}
