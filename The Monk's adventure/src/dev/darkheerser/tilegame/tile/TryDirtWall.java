package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class TryDirtWall extends Tile{

	public TryDirtWall(int id) {
		super(Assets.tryDirtWall, id);
	}

	public boolean isSolid() {
		return true;
	}
}
