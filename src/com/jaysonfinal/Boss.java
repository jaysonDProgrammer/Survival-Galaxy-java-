package com.jaysonfinal;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boss extends GameObject{

	private int timer =80;
	private int timer2 =50;
	private navigator handler;
	Random r= new Random();
	private BufferedImage enemy_image;
	private Game game;
	public Boss(int x, int y, ID id,navigator handler, Game game ) 
	{
		super(x, y, id);
		this.handler= handler;
		this.game=game;
		velX = 0;
		velY = 2;
		
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet3);     
		
		enemy_image = ss.grabImage2(0,0,96,96);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 96,96);
		
	}
	
	
	public void tick() 
	{
		x+= velX;
		y+= (float)velY- .5;
		if(timer<=0)velY=0;
		else timer--;
		
		if(timer<=0)timer2--;
		if(timer2<=0)
		{
			if(velX==0)velX=2;
			if(velX>0)
				velX += 0.008f;
			else if(velX<0)
				velX -= 0.008f;
			velX = Game.clamp(velX, -10,10);
			int spawn= r.nextInt(10);
			if(game.dif== 0)
			{
				if(spawn == 0)handler.addObject(new BossBullets((int)(x+48), (int)(y+48),ID.BasicEnemy, handler));
			}
			else if(game.dif==1)
			{
			if(spawn == 0)handler.addObject(new HardBossEnemy((int)(x+48), (int)(y+48),ID.BasicEnemy, handler));
			}
		}
		//if(y<= 0 || y >= Game.HEIGHT-16)velY *=-1;
		if(x<= 0 || x >= Game.WIDTH-48)velX *=-1;
		//handler.addObject(new trail(x,y, ID.trail, Color.orange, 16,16,0.2f, handler));
	
	
	}


	public void render(Graphics g) 
	{
		//g.setColor(Color.orange);
		//g.fillRect(x, y, 16, 16);
		g.drawImage(enemy_image,x , y, null);
	}

}
