package com.jaysonfinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

	Random r= new Random();
	navigator handler;
	private BufferedImage player_image;

	public Player(int x, int y, ID id, navigator handler) 
	{
		super(x, y, id);
		this.handler = handler;
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet);  
		player_image = ss.grabImage(1,1,32,32);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, 32,32);
	}
	
	public void tick() 
	{
		x+=velX;
		y+=velY;
		x = Game.clamp(x, 0, Game.WIDTH -37);
		y= Game.clamp(y, 0, Game.HEIGHT -60);
		collision();
	}
	private void collision() 
	{
		for(int i=0; i< handler.object.size();i++)
		{
			GameObject tmpObject = handler.object.get(i);
			if(tmpObject.getId()== ID.BasicEnemy || tmpObject.getId()==ID.levelUpEnemy || tmpObject.getId()==ID.AI|| tmpObject.getId()==ID.Boss|| tmpObject.getId()==ID.BossBullets|| tmpObject.getId()==ID.HardBossEnemy)//tmpObject is now BasicEnemy
			{	
				if(getBounds().intersects(tmpObject.getBounds()))
					{//collision code
					AudioPlayer.getSound("collision").play();
						HeadsUpDisplay.HEALTH -=2;
						
					}
			}
		}
		
	}

	public void render(Graphics g)
	{
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		//g.setColor(Color.white);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(player_image, (int)x ,(int) y, null);
	}
	
	
}
