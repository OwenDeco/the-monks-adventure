package dev.darkheerser.tilegame.entities.statics.desert;

import java.awt.Color;
import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.items.Item;
import dev.darkheerser.tilegame.tile.Tile;

public class DesertTree extends StaticEntity {

	public DesertTree(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		bounds.x = width/3+15;
		bounds.y = height/2+32;
		bounds.width = width/4;
		bounds.height = height/5-10;
		
	}
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.desertTreeWoodItem.createNew((int)x+Tile.TILEWIDTH/2,(int) y+3*Tile.TILEHEIGHT/2));
	}
	

	public void tick() {
		
	}

	public void render(Graphics g) {

		g.drawImage(Assets.desertTree, (int)(x-handler.getCamera().getxOffset()), (int)(y-handler.getCamera().getyOffset()),width, height,null);
//		 g.setColor(Color.red);
//		 g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
//		 + bounds.y - handler.getCamera().getyOffset()),bounds.width,
//		 bounds.height);
	}


}
