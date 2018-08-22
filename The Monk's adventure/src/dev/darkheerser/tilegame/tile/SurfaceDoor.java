package dev.darkheerser.tilegame.tile;

import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.gfx.Assets;

public class SurfaceDoor extends Tile{

	public SurfaceDoor(int id) {
		super(Assets.surface_door, id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSolid() {
		return true;
	}

}
