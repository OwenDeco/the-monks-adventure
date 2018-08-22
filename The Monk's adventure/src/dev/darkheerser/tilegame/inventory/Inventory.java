package dev.darkheerser.tilegame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.Text;
import dev.darkheerser.tilegame.items.Item;

public class Inventory {

	Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX =10, invY = 10,
			invWidth = 400, invHeight = 533,
			invListCenterX = invX + 90,
			invListCenterY = invY + 155,
			invListSpacing = 35;
	
	private int invImageX = 253, invImageY = 112,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 246, invCountY = 229;
	
	private int selectedItem =0;
	
	public int coins =0;
	public int coinsDrop = 0;
			
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		
		//testing code
		
		addItem(Item.surfaceRockItem.createNew(1));
		addItem(Item.surfaceTreeWoodItem.createNew(2));
		
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I))
			active = !active;
		if(!active)
			return;
//		System.out.println("Inventory: ");
//		for(Item i : inventoryItems) {
//			System.out.println(i.getName() + ": " + i.getCount());
//		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_NUMPAD8))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_NUMPAD2))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size()-1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem =0;
	}
	
	public void render(Graphics g) {
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, invX,invY, invWidth,invHeight,null);

		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		for(int i = -2; i< 3; i++) {
			if(selectedItem + i < 0 || selectedItem +i >= len)
				continue;
			
			if(i ==0) {
				Text.drawString(g, ">> " + inventoryItems.get(selectedItem +i).getName() +" <<", invListCenterX, invListCenterY + i*invListSpacing, true, Color.BLACK, Assets.font28);
			}else {
				Text.drawString(g,  inventoryItems.get(selectedItem +i).getName(), invListCenterX, invListCenterY + i*invListSpacing, true, Color.BLACK, Assets.font28);
				
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight,null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.black, Assets.font38);
		Text.drawString(g, Integer.toString(coins), invCountX + 80, invCountY, true, Color.black, Assets.font32);

	
	}
	
	//inventory methods
	
	public void addItem(Item item) {
		for(Item i: inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount()+ item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//getters setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
