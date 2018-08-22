package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class SurfaceToDesertDoor extends Tile{

	public SurfaceToDesertDoor(int id) {
		super(Assets.surfaceToDesert_door, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}

}
