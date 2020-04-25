package com.jaysonfinal;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class trail extends GameObject
{

	private float alpha =1, life;
	private navigator handler;
	private Color color;
	private int width, height;
	
	public trail(int x, int y, ID id,Color color, int width, int height, float life,  navigator handler) 
	{
		super(x, y, id);
		this.color = color;
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.life = life;
		
	}



	public void tick() 
	{
		if (alpha>life)
		{
			alpha-= (life- 0.001f);
		}else handler.removeObject(this);		
	}

	private AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
		
	}
	public void render(Graphics g) 
	{
		Graphics2D g2d= (Graphics2D)g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width , height);
		g2d.setComposite(makeTransparent(1));
	}

	
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
