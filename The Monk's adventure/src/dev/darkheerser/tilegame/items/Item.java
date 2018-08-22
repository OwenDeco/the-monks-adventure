package dev.darkheerser.tilegame.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.Text;

public class Item {

	// handler

	public static Item[] items = new Item[256];
	public static Item surfaceTreeWoodItem = new Item(Assets.surfaceTreeWood, "logs", 0);
	public static Item desertTreeWoodItem = new Item(Assets.desertTreeWood, "dry logs", 1);
	public static Item surfaceRockItem = new Item(Assets.surfaceOre, "rocks", 2);
	public static Item desertRockItem = new Item(Assets.desertOre, "heated rocks", 3);
	public static Item caveRockItem = new Item(Assets.caveOre, "dark rocks", 4);
	public static Item goldBagItem = new Item(Assets.goldBag, "gold", 5);

	// class
	public static final int ITEMWIDTH = 48, ITEMHEIGHT = 48;

	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;

	protected int x, y, count;
	protected boolean pickedUp = false;

	protected Rectangle bounds;

	Random rand = new Random();


	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;

		bounds = new Rectangle(x, y, ITEMWIDTH / 2, ITEMHEIGHT / 2);

		items[id] = this;

	}

	public void tick() {
		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			if (this.getId() == 5) {
				handler.getWorld().getEntityManager().getPlayer().getInventory().coinsDrop = rand.nextInt(20);
				handler.getWorld().getEntityManager().getPlayer().getInventory().coins += handler.getWorld().getEntityManager().getPlayer().getInventory().coinsDrop;
				System.out.println(handler.getWorld().getEntityManager().getPlayer().getInventory().coinsDrop);

			} else {
				handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
			}
		}
	}

	public void render(Graphics g) {
		if (handler == null) {
			return;
		}
		render(g, (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()));
		

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}

	public Item createNew(int count) {
		Item i = new Item(texture, name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}

	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}

	// getters setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}


}
