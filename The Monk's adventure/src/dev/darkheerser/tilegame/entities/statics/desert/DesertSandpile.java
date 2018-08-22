package dev.darkheerser.tilegame.entities.statics.desert;

import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.tile.Tile;

public class DesertSandpile extends StaticEntity {

	public DesertSandpile(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 3, Tile.TILEHEIGHT * 3);

		
		killable = false;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;

	}

	public void die() {
		
	}
	
	public void tick() {

	}
	
	

	public void render(Graphics g) {

		g.drawImage(Assets.desert_sandpile, (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), width, height, null);
		// g.setColor(Color.red);
		// g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
		// + bounds.y - handler.getCamera().getyOffset()),bounds.width,
		// bounds.height);
	}

}
