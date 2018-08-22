package dev.darkheerser.tilegame.entities.statics.surface;

import java.awt.Color;
import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.items.Item;
import dev.darkheerser.tilegame.tile.Tile;

public class SurfaceTree extends StaticEntity {

	public SurfaceTree(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH, Tile.TILEHEIGHT*3);
		
		bounds.x = width/4;
		bounds.y = height/2+30;
		bounds.width = width/2;
		bounds.height = height/3-25;
		
	}

	public void die() {
		handler.getWorld().getItemManager().addItem(Item.surfaceTreeWoodItem.createNew((int)x,(int) y+Tile.TILEHEIGHT*2));
	}
	public void tick() {
		
	}

	public void render(Graphics g) {

		g.drawImage(Assets.surfaceTree, (int)(x-handler.getCamera().getxOffset()), (int)(y-handler.getCamera().getyOffset()),width, height,null);
//		 g.setColor(Color.red);
//		 g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
//		 + bounds.y - handler.getCamera().getyOffset()),bounds.width,
//		 bounds.height);
	}

}
