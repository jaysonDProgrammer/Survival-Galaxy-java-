package com.jaysonfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class AI extends GameObject{

	private GameObject player;
	private navigator handler;
	private BufferedImage enemy_image;
	public AI(int x, int y, ID id,navigator handler ) 
	{
		super(x, y, id);
		this.handler= handler;
		
		{
			for (int i=0; i < handler.object.size(); i++)
			if(handler.object.get(i).getId()==ID.Player)
				player= handler.object.get(i);
		}
		
		
		//SpriteSheet ss= new SpriteSheet(Game.sprite_sheet2);     
		
		//enemy_image = ss.grabImage(2,1,16,16);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 16,16);
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+= velY;
		float difX= x- player.getX()-8;
		float difY= y- player.getY()-8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		velX = (int) Math.round((-1/distance) * difX);
		velY = (int) Math.round((-1/distance) * difY);
		
		//if(y<= 0 || y >= Game.HEIGHT-32)velY *=-1;
		//if(x<= 0 || x >= Game.WIDTH-16)velX *=-1;
		handler.addObject(new trail(x,y, ID.trail, Color.cyan, 16,16,0.03f, handler));
	
	
	}


	public void render(Graphics g) 
	{
		g.setColor(Color.cyan);
		g.fillOval(x, y, 16, 16);
		//g.drawImage(enemy_image,(int)x , (int)y, null);
	}

}
