package com.jaysonfinal;

import java.awt.Color;
import java.awt.Graphics;



public class HeadsUpDisplay 
{
	public static int HEALTH = 100;
	private int cyanValue= 255;
	private int level=1, score =0;
	public int bounds =0;
	public void tick() 
	{
		HEALTH =  Game.clamp(HEALTH, 0,100+ (bounds/2));
		cyanValue= HEALTH*2;
		cyanValue=  Game.clamp(cyanValue, 0, 255);
		
		score++;
		

	}
	public void render(Graphics g) 
	{
		g.setColor(Color.gray);
		g.fillRect(15,400,200+ bounds,32);
		g.setColor(new Color(255, cyanValue,0));
		g.fillRect(15,400,HEALTH *2,32);
		g.setColor(Color.white);
		g.drawRect(15,400,200 + bounds,32);
		g.setColor(Color.cyan);
		g.drawString("Score: ", 15,370);
		g.setColor(Color.white);
		g.drawString(" " + score, 50,370);
		g.setColor(Color.cyan);
		g.drawString("Level:  " , 15,390);
		g.setColor(Color.white);
		g.drawString(" " + level, 50,390);
		g.setColor(Color.cyan);
		g.drawString("Space for Shop" , 15,15);
		g.drawString("P for Pause" , 550,15);
	}
	
	


	
	
	public void setScore(int score)
	{
		this.score=score;
	}
	public int getScore()
	{
		

		return score;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level=level;
	}
	
}
