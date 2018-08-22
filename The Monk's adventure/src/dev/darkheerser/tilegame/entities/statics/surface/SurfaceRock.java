package dev.darkheerser.tilegame.entities.statics.surface;

import java.awt.Color;
import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.items.Item;
import dev.darkheerser.tilegame.tile.Tile;

public class SurfaceRock extends StaticEntity {

	int type = 1;

	public SurfaceRock(Handler handler, float x, float y, int type) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		this.type = type;

		bounds.x = 0;
		bounds.y = height / 2;
		bounds.width = width;
		bounds.height = height / 4;
		
		

	}
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.surfaceRockItem.createNew((int)x,(int) y+Tile.TILEHEIGHT/2));
	
	}

	public void tick() {

	}
	


	public void render(Graphics g) {
		
		if (type == 1) {
			g.drawImage(Assets.surfaceRock, (int) (x - handler.getCamera().getxOffset()),
					(int) (y - handler.getCamera().getyOffset()), width, height, null);
		} else if (type == 2) {
			g.drawImage(Assets.surfaceRock2, (int) (x - handler.getCamera().getxOffset()),
					(int) (y - handler.getCamera().getyOffset()), width, height, null);
		} else if (type == 3) {
			g.drawImage(Assets.surfaceRock3, (int) (x - handler.getCamera().getxOffset()),
					(int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
//		 g.setColor(Color.red);
//		 g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
//		 + bounds.y - handler.getCamera().getyOffset()),bounds.width,
//		 bounds.height);
	}

}
