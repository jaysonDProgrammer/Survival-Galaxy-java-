package com.jaysonfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject{

	
	private navigator handler;
	private BufferedImage enemy_image;
	public BasicEnemy(int x, int y, ID id,navigator handler ) 
	{
		super(x, y, id);
		this.handler= handler;
		velX = 5;
		velY = 5;
		
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet2);     
		
		enemy_image = ss.grabImage(2,1,16,16);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 16,16);
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+=velY;
		if(y<= 0 || y >= Game.HEIGHT-16)velY *=-1;
		if(x<= 0 || x >= Game.WIDTH-16)velX *=-1;
		//handler.addObject(new trail(x,y, ID.trail, Color.orange, 16,16,0.2f, handler));
	
	
	}


	public void render(Graphics g) 
	{
		//g.setColor(Color.orange);
		//g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image,(int)x , (int)y, null);
	}

}
