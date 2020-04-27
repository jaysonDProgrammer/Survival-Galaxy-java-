package com.jaysonfinal;

import java.util.Random;

public class spawn 
{
	private navigator handler;
	private HeadsUpDisplay hud;
	private int scoreKeep =0;
	private Random r= new Random();
	private Game game;
	public spawn(navigator handler, HeadsUpDisplay hud, Game game)
	{
		this.handler= handler;
		this.hud= hud;
		this.game=game;
	}
	public void tick() 
	{
		scoreKeep++;
		if(scoreKeep>=200)
		{
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			if(game.dif==0)
			{
				if(hud.getLevel()==2)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==3)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-25),r.nextInt(Game.HEIGHT-25), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==4)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==5)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==6)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-25), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==8)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==9)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-25), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==10)
				{
					handler.addObject(new AI(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.AI, handler));
				}else if(hud.getLevel()==15)
				{
					handler.clearEnemies();
					handler.addObject(new Boss(r.nextInt(Game.WIDTH/2-48),-120, ID.Boss, handler, game));
				}else if(hud.getLevel()==20)
				{
					handler.addObject(new AI(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.AI, handler));
				}
				
			}else if(game.dif==1)
			{
				if(hud.getLevel()==2)
				{
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==3)
				{
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-25),r.nextInt(Game.HEIGHT-25), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==4)
				{
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-10),r.nextInt(Game.HEIGHT-10), ID.BasicEnemy, handler));
				}else if(hud.getLevel()==5)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-20),r.nextInt(Game.HEIGHT-20), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==6)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==8)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-20),r.nextInt(Game.HEIGHT-20), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==9)
				{
					handler.addObject(new AI(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.AI, handler));
				}else if(hud.getLevel()==10)
				{
					handler.addObject(new levelUpEnemy(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.levelUpEnemy, handler));
				}else if(hud.getLevel()==11)
				{
					handler.addObject(new AI(r.nextInt(Game.WIDTH+90),r.nextInt(Game.HEIGHT+90), ID.AI, handler));
				}else if(hud.getLevel()==15)
				{
					handler.clearEnemies();
					handler.addObject(new Boss(r.nextInt(Game.WIDTH/2-48),-120, ID.Boss, handler,game));
				}else if(hud.getLevel()==20)
				{
					handler.addObject(new AI(r.nextInt(Game.WIDTH-90),r.nextInt(Game.HEIGHT-90), ID.AI, handler));
				}
			}
			
		
		}
	}
	
	
}
