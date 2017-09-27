package com.virtusa.morepoints;

import com.virtusa.practice.Points;

public class Point3d extends Points {

	public  int z;
	public void move(int dx,int dy,int dz)
	{
		//int dx;
		//x+=dx;
		//y+=dy;
		super.move(dx,dy);
		z+=dz;
	}
	
	public void move(int dx,int dy)
	{
		move(dx,dy,0);
	}
	
	public static final int q;
	static{
		q=0;
	}
	public final int w;
	
	Point3d()
	{
		w=0;
	}
	
	static int t=0;
	int t1=t;
	//static int t1=this.t;
}
