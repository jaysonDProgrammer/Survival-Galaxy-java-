package com.jaysonfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.jaysonfinal.Game.STATE;


public class Menu extends MouseAdapter 
{
	private Game game;
	private navigator handler;
	private Random r= new Random();
	private HeadsUpDisplay hud;
	private Shop shop;
	public Menu(Game game, navigator handler, HeadsUpDisplay hud)
	{
		this.game= game;
		this.hud = hud;
		this.handler= handler;	
	}
	public void mousePressed(MouseEvent e)
	{
		
		
		int mx= e.getX();
		int my= e.getY();
		//play button
		if(Game.gameState== STATE.Menu)
		{
			
			if(mouseOver(mx, my ,210 ,150,200,64))
			{
				Game.gameState= STATE.Difficulty;
				AudioPlayer.getSound("menu_sound").play();
				return;
			
			}
			//help button
			if(mouseOver(mx, my, 210, 250, 200,64))
				{
					Game.gameState = STATE.Help;
					AudioPlayer.getSound("menu_sound").play();

				}
			
			
			//quit button
			if(mouseOver(mx,my,210,350,200,64))
				{
					System.exit(1);
					

				}
			
		}
			if(Game.gameState== STATE.Difficulty)
			{	//normal button
				if(mouseOver(mx, my ,210 ,150,200,64))
					{
						Game.gameState= STATE.Game;
						handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
						handler.addObject(new BasicEnemy(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.BasicEnemy, handler));
						game.dif=0;
						AudioPlayer.getSound("menu_sound").play();

					
					}
				//hard button
				if(mouseOver(mx, my, 210, 250, 200,64))
					{
						Game.gameState= STATE.Game;
						handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
					
						handler.addObject(new HardEnemy(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.BasicEnemy, handler));
						game.dif=1;
						AudioPlayer.getSound("menu_sound").play();

					}
				
				
				//back button
				if(mouseOver(mx,my,210,350,200,64))
					{
					
						Game.gameState= STATE.Menu;
						AudioPlayer.getSound("menu_sound").play();

						return;
					
					}
				
			}
		
		//back button for help
				if(Game.gameState==STATE.Help)
					{
						if(mouseOver(mx,my, 210,350,200,64))
						{
							Game.gameState= STATE.Menu;
							AudioPlayer.getSound("menu_sound").play();

							return;
						}
					}
		//try again button 
		if(Game.gameState==STATE.End)
		{
			if(mouseOver(mx,my, 210,250,230,64))
			{
				Game.gameState= STATE.Menu;
				
				
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player((Game.WIDTH/2)-32, (Game.HEIGHT/2)-32,ID.Player, handler));
				handler.clearEnemies();
				shop.resetShop();
				AudioPlayer.getSound("menu_sound").play();

			}
		}
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height)
	{
		if(mx> x && mx < x + width)
			{if(my> y && my < y + height)
				{
					return true;
				}else return false;
			}else return false;
	}
	
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		if(Game.gameState==STATE.Menu)
		{		
			Font font= new Font("arial", 1,50);
			Font font2= new Font("arial", 1,30);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Menu", 240, 100);
	 
			
			g.setFont(font2);
			g.drawRect(210, 150, 200, 64);
			
			g.drawString("Play", 270, 190);
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 290);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);
		}else if(Game.gameState ==STATE.Help)
			{
			Font font= new Font("arial", 1,50);
			Font font2= new Font("arial", 1,30);
			Font font3= new Font("arial", 1,20);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Help", 250, 100);
			
			g.setFont(font3);
			g.drawString("Use arrow keys to move player and dodge enemies" , 70, 200);
			
			g.setFont(font2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
			}else if(Game.gameState ==STATE.End)
			{
			Font font= new Font("arial", 1,50);
			Font font2= new Font("arial", 1,30);
			Font font3= new Font("arial", 1,20);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 100);
			
			g.setFont(font2);
			g.drawString("Your Score is ",220,170);
			g.setColor(Color.yellow);
			g.drawString(" " +  hud.getScore(), 280, 220);
			
		
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(210, 250, 230, 64);
			g.drawString("Try Again", 250, 290);
		}else if(Game.gameState==STATE.Difficulty)
			{		
				Font font= new Font("arial", 1,50);
				Font font2= new Font("arial", 1,30);
				g.setFont(font);
				g.setColor(Color.white);
				g.drawString("SELECT DIFFICULTY", 60, 100);
				
				g.setFont(font2);
				g.drawRect(210, 150, 200, 64);
				g.drawString("Normal", 260, 190);
				
				g.drawRect(210, 250, 200, 64);
				g.drawString("Hard", 275, 290);
				
				g.drawRect(210, 350, 200, 64);
				g.drawString("Back", 275, 390);
			}
	}
	
	
	
}
