package dev.darkheerser.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.ImageLoader;
import dev.darkheerser.tilegame.ui.ClickListener;
import dev.darkheerser.tilegame.ui.UIImageButton;
import dev.darkheerser.tilegame.ui.UIManager;
import dev.darkheerser.tilegame.ui.UIObject;

public class MenuState extends State {

	private BufferedImage background;
	public boolean started = false;
	private boolean filledName = false;
	private boolean clickedNoName = false;
	private boolean goNext = false;

	UIObject startbutton, pausebutton;

	Scanner sc = new Scanner(System.in);
	public String name;
	
	private long timer = System.currentTimeMillis();

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		background = ImageLoader.loadImage("/textures/background.png");

		handler.getMouseManager().setUIManager(uiManager);

		startbutton = new UIImageButton(350, 220, 128, 64, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {

				if (State.getState() == handler.getGame().menuState && filledName) {
					State.setState(handler.getGame().gameState);
					started = true;

				} else {
					clickedNoName = true;
					return;
				}
			}
		});

		uiManager.addObject(startbutton);

		uiManager.addObject(new UIImageButton(350, 270, 128, 64, Assets.btn_quit, new ClickListener() {

			@Override
			public void onClick() {

				if (State.getState() == handler.getGame().menuState) {
					System.exit(0);
				}
			}

		}));
	}

	public void tick() {
		uiManager.tick();
//
//		 handler.getMouseManager().setUIManager(null);
//		 State.setState(handler.getGame().gameState);
	}

	public void render(Graphics g) {
		g.drawImage(background, 0, 0, 800, 600, null);

		if(name ==null) {
			name = "the Monk";
		}
		if (!started) {
			Font fnt = new Font("arial", Font.BOLD, 50);
			String title = " The Adventure of "+name;
			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString(title, handler.getWidth() / 2 - title.length() * 13, handler.getHeight() / 5);
		} else {
			Font fnt = new Font("arial", Font.BOLD, 50);
			Font fnt2 = new Font("arial", Font.BOLD, 30);
			String title = " The Adventure of " + name;
			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString(title, handler.getWidth() / 2 - title.length() * 13, handler.getHeight() / 5);
			g.setFont(fnt2);
			g.setColor(Color.red);
			g.drawString("PAUSED GAME", handler.getWidth() / 2 - 100, handler.getHeight() / 4);
		}
		uiManager.render(g);
		if (clickedNoName) {
			g.drawImage(background, 0, 0, 800, 600, null);

			Font fnt = new Font("arial", Font.BOLD, 50);
			String title = " Enter your name below please";
			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString(title, handler.getWidth() / 2 - title.length() * 13, handler.getHeight()/2);
			//
			
			if (System.currentTimeMillis() - timer > 1500) {
				name = sc.nextLine();
				clickedNoName = false;
				filledName = true;
				timer = System.currentTimeMillis();
			}
			goNext = true;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
