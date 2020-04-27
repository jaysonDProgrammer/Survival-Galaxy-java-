package com.jaysonfinal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = -1993098202558758817L;
	private BufferedImage backImage;
	public static final int WIDTH= 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	private navigator handler;
	private HeadsUpDisplay hud;
	private spawn spawner;
	private Menu menu;
	public static boolean paused = false;
	private Shop shop;
	public int dif = 0;
	
	
	//0 = normal
	//1 = hard
	//private String galaxy = "galaxy.gif";
	public enum STATE
	{
		Menu,
		Difficulty,
		Help,
		Shop,
		Game,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public static BufferedImage sprite_sheet= null;
	public static BufferedImage sprite_sheet2= null;
	public static BufferedImage sprite_sheet3= null;
	public static BufferedImage sprite_sheet4= null;
	public static BufferedImage sprite_sheet5= null;
	
	
	public Game()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		
			sprite_sheet = loader.loadImage("/player.png");
			sprite_sheet2 = loader.loadImage("/ball2.png");
			sprite_sheet3 = loader.loadImage("/2.png");
			sprite_sheet4 = loader.loadImage("/b4.jpg");
			sprite_sheet5 = loader.loadImage("/ball2.png");
		
		handler = new navigator();
		hud = new HeadsUpDisplay();
		shop= new Shop(handler,hud);
		menu=  new Menu(this, handler, 	hud);
		this.addKeyListener(new KeyInput(handler, this ));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		AudioPlayer.load();
		AudioPlayer.getMusic("music").loop();
		new frame(WIDTH, HEIGHT, "Survivor Galaxy", this);
		
		
		spawner = new spawn(handler, hud, this);
		
		if(gameState == STATE.Game)
		{
				handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32,ID.Player, handler));
				handler.addObject(new BasicEnemy(WIDTH/2-16, HEIGHT/2-16,ID.BasicEnemy, handler));
				handler.addObject(new Boss(Game.WIDTH/2-48, -120,ID.Boss, handler, this ));
		}
		
	}
	
	

	
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop()
	{
		try {
			thread.join();
			running= false;
		}catch(Exception e) 
			{
				e.printStackTrace();
			}
	
	}

	public void run()
	{ 	this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks= 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer= System.currentTimeMillis();
		int frames =0;
		while(running)
		{
			long now = System.nanoTime();
			delta+=(now- lastTime)/ns;
			lastTime= now;
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis()- timer >1000)
			{
				timer += 1000;
				
				frames =0;
			}
		}stop();
		
	}

	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g= bs.getDrawGraphics();
		g.drawImage(backImage,0 , 0, null);
		SpriteSheet ss= new SpriteSheet(Game.sprite_sheet4);
		
		backImage = ss.grabImage2(0,0,WIDTH,HEIGHT);
		
		//g.fillRect(0,0,WIDTH,HEIGHT);
		
		
		if (paused)
		{
			g.setFont(new Font("arial", 0,14));
			g.setColor(Color.orange);
			g.drawString("PAUSED", 280, 250);
		}
		
		if(gameState == STATE.Game)
		{
			hud.render(g);
			handler.render(g);
		}else if(gameState== STATE.Shop)
			{ shop.render(g);
		
			
		}else if(gameState== STATE.Menu|| gameState==STATE.Help|| gameState == STATE.End|| gameState == STATE.Difficulty)
		{
			menu.render(g);
			handler.render(g);
		}
		
		
		g.dispose();
		bs.show();
		
	}
	private void tick() {
		
		if(gameState == STATE.Game)
		{	
			if (!paused)
			{
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if(HeadsUpDisplay.HEALTH<=0)
				{
					
					AudioPlayer.getSound("gameover").play();
					HeadsUpDisplay.HEALTH =100;
					
					gameState = STATE.End;
					
					handler.clearEnemies();
					
				}
			}
			
		}else if(gameState== STATE.Menu || gameState == STATE.End || gameState == STATE.Difficulty)
			{
			
				menu.tick();
				
				handler.tick();
			}
		
		
	}
	
	public static int clamp(int x, int min, int max)
	{
		if(x>= max)
			return x = max;
		else if(x<=min)
			return x =min;
		else 
			return x;	
	}
	public static void main(String[] args) 
	{
		
		new Game();
		

	}

}
