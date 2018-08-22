package dev.darkheerser.tilegame.entities.statics.desert;

import java.awt.Color;
import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.tile.Tile;

public class DesertSpike extends StaticEntity {

	int type = 1;

	public DesertSpike(Handler handler, float x, float y, int type) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		this.type = type;

		if (type == 2)
			killable = false;

		bounds.x = 0;
		bounds.y = height / 2 - 10;
		bounds.width = width;
		bounds.height = height / 2;

	}

	public void die() {

	}

	public void tick() {

	}

	public void render(Graphics g) {

		g.drawImage(Assets.desert_spike, (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), width, height, null);

		// g.setColor(Color.red);
		// g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
		// + bounds.y - handler.getCamera().getyOffset()),bounds.width,
		// bounds.height);
	}

}
