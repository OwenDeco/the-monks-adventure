package dev.darkheerser.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.darkheerser.tilegame.display.Display;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.Camera;
import dev.darkheerser.tilegame.input.KeyManager;
import dev.darkheerser.tilegame.input.MouseManager;
import dev.darkheerser.tilegame.states.GameState;
import dev.darkheerser.tilegame.states.MenuState;
import dev.darkheerser.tilegame.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private Thread thread;
	public boolean running = false;

	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public GameState gameState;
	public MenuState menuState;
	public int worldLevel = 1;

	//INPUT
	private KeyManager keyManager;
	private MouseManager mouseManager;
	//camera
	
	private Camera cam;

	//handler
	
	private Handler handler;
	
	public Game(String title, int width, int height) {


		
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}


	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		handler = new Handler(this);
		cam = new Camera(handler,0,0);	
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		// hier initialiseer ik de state die start wanneer je op launch klikt, en in die state wordt de world geinitialiseerd
		State.setState(menuState);
	}

	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
		if(handler.getKeyManager().esc) {
			State.setState(menuState);
			
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}


	public Camera getCamera() {
		return cam;
	}


	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		///// clear screen
		g.clearRect(0, 0, width, height);
		///// draw here!
		if(State.getState() != null) {
			State.getState().render(g);
			
		}

		///// end drawing
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		
		
		double timePerTick = 1000000000D/60D;
		double delta =0;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks =0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += (now - lastTime);
			lastTime = now;
			
			if( delta >= 1) {
				tick();
				render();
				ticks++;
				
				delta--;
				
			}
			if(timer >=1000000000) {
				ticks = 0;
				timer =0;
			}
		}
		
		stop();
		
	}
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
}
