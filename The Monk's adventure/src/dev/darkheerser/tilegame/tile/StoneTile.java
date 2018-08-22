package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class StoneTile extends Tile{

	public StoneTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
