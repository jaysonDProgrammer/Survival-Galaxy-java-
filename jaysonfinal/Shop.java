package com.jaysonfinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Shop extends MouseAdapter{
	navigator handler;
	HeadsUpDisplay hud;
	private static int A1 =1000;
	private static int A2 =1000;
	private static int A3 =1000;
	public Shop(navigator handler, HeadsUpDisplay hud)
	{
		this.handler =handler;
		this.hud= hud;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.cyan);
		g.setFont(new Font("arial", 0,48));
		g.drawString("SHOP", Game.WIDTH/2-80, 100);
		
		//Shop1
		g.setFont(new Font("arial", 0,14));
		g.setColor(Color.orange);
		g.drawString("Upgrade Health", 100, 170);
		g.setFont(new Font("arial", 0,12));
		g.setColor(Color.white);
		g.drawString("Cost: " + A1 , 120, 200);
		g.setColor(Color.cyan);
		g.drawRect(90, 145, 120, 80);
		
		//Shop2
		g.setFont(new Font("arial", 0,14));
		g.setColor(Color.orange);
		g.drawString("Upgrade Speed", 260, 170);
		g.setFont(new Font("arial", 0,12));
		g.setColor(Color.white);
		g.drawString("Cost: " + A2 , 280, 200);
		g.setColor(Color.cyan);
		g.drawRect(250, 145, 120, 80);
		
		//Shop3
		g.setFont(new Font("arial", 0,14));
		g.setColor(Color.orange);
		g.drawString("Refill Health", 430, 170);
		g.setFont(new Font("arial", 0,12));
		g.setColor(Color.white);
		g.drawString("Cost: " + A3 , 440, 200);
		g.setColor(Color.cyan);
		g.drawRect(410, 145, 120, 80);
		
		g.setColor(Color.orange);
		g.drawString("SCORE:  ", Game.WIDTH/2-40, 280);
		g.setColor(Color.cyan);
		g.drawString(" " + hud.getScore(), Game.WIDTH/2-30, 300);
		g.setColor(Color.orange);
		g.drawString("Press Space to go back: "+ hud.getScore(),Game.WIDTH/2-90, 330);
		
	}
	
	
	public void mousePressed(MouseEvent e)
	{
		
	
		int mX = e.getX();
		int mY = e.getY();
		//shop1
		if (mX >= 90 && mX <= 200)
		{
			if(mY>=120 && mY<= 200)
			{
				//you've selected shop1
				
				if(hud.getScore()>=A1)
				{
					hud.setScore(hud.getScore()-A1);
					A1+=1000;
					hud.bounds+=20;
					hud.HEALTH = (100+(hud.bounds/2));
				}
			}
		}
		//shop2
		if (mX >= 250 && mX <= 370)
		{
			if(mY>=120 && mY<= 200)
			{
				//you've selected shop2
				if(hud.getScore()>=A2)
				{
					hud.setScore(hud.getScore()-A2);
					A2=1000;
					handler.spd++;
				}
			}
		}
		//shop3
		if (mX >= 410 && mX <= 530)
		{
			if(mY>=120 && mY<= 200)
			{
				//you've selected shop3
				if(hud.getScore()>=A3)
				{
					hud.setScore(hud.getScore()-A3);
					hud.HEALTH = (100+(hud.bounds/2));
					
				}
			}
		}

		

		
	}
	
	public static void resetShop() {
		  A1 = 1000;
		  A2 = 1000;
		  A3 = 1000;
		  
		 }

}
