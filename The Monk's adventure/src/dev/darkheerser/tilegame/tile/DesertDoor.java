package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class DesertDoor extends Tile{

	public DesertDoor(int id) {
		super(Assets.desert_door, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}

}
