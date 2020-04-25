package com.jaysonfinal;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class HardEnemy extends GameObject{

	
	
	private BufferedImage enemy_image;
	public HardEnemy(int x, int y, ID id,navigator handler) 
	{
		super(x, y, id);
		velX = 5;
		velY = 9;
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet2);     
		
		enemy_image = ss.grabImage(2,4,32,32);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((x+60),(y+60), 32,32);
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+=velY;
		if(y<= 0 || y >= Game.HEIGHT-32)velY *=-1;
		if(x<= 0 || x >= Game.WIDTH-32)velX *=-1;
		//handler.addObject(new trail(x,y, ID.trail, Color.magenta, 16,16,0.05f, handler));

	}


	public void render(Graphics g) 
	{
		//g.setColor(Color.magenta);
		//g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image,(int)x , (int)y, null);
	}

}
