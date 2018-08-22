package dev.darkheerser.tilegame.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.darkheerser.tilegame.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;

	public boolean goldAnim = false;
	
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}

	public void tick() {

		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPickedUp()) {
				if(i.getId() == 5) {
					goldAnim = true;
					
				}
				it.remove();
			}
		}
	}

	public void render(Graphics g) {
		for (Item i : items) {
			i.render(g);

		}
	}

	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	public void removeItem(Item i) {
		items.remove(i);
	}

	// getters setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isGoldAnim() {
		return goldAnim;
	}

	public void setGoldAnim(boolean goldAnim) {
		this.goldAnim = goldAnim;
	}

}
