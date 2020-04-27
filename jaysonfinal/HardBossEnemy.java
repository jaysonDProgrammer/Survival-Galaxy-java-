package com.jaysonfinal;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HardBossEnemy extends GameObject{

	
	private navigator handler;
	private BufferedImage enemy_image;
	Random r= new Random();
	public HardBossEnemy(int x, int y, ID id,navigator handler ) 
	{
		super(x, y, id);
		this.handler= handler;
		velX =(r.nextInt(5- -5)+ -5);
		velY = 7;
		
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet5);     
		
		enemy_image = ss.grabImage(1,3,32,32);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 32,32);
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+=velY;
		if(y>= Game.HEIGHT)
		handler.removeObject(this);
		
		//if(y<= 0 || y >= Game.HEIGHT-16)velY *=-1;
		//if(x<= 0 || x >= Game.WIDTH-16)velX *=-1;
		//handler.addObject(new trail(x,y, ID.trail, Color.orange, 16,16,0.2f, handler));
	
	
	}


	public void render(Graphics g) 
	{
		//g.setColor(Color.orange);
		//g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image,(int)x , (int)y, null);
	}

}
