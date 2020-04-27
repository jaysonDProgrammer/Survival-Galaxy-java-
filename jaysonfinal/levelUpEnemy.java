package com.jaysonfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class levelUpEnemy extends GameObject{

	
	private navigator handler;
	public levelUpEnemy(int x,int y, ID id,navigator handler) 
	{
		super(x, y, id);
		this.handler= handler;
		velX = 5;
		velY = 9;
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y, 16,16);
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+=velY;
		if(y<= 0 || y >= Game.HEIGHT-16)velY *=-1;
		if(x<= 0 || x >= Game.WIDTH-16)velX *=-1;
		handler.addObject(new trail(x,y, ID.trail, Color.pink, 10,10,0.05f, handler));
		
	
	}


	public void render(Graphics g) 
	{
		g.setColor(Color.pink);
		g.fillOval((int)x,(int)y, 10, 10);
	}

}
