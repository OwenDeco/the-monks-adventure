package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class CaveDoor extends Tile{

	public CaveDoor(int id) {
		super(Assets.cave_door, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}

}
