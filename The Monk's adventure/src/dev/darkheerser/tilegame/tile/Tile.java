package dev.darkheerser.tilegame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	// STATIC STUFF
	public static Tile[] tiles = new Tile[256];
	
	public static Tile tryDirt = new TryDirt(11);
	public static Tile tryDirtWall = new TryDirtWall(12);
	
	public static Tile DirtTile = new DirtTile(2);
	public static Tile StoneTile = new StoneTile(3);
	public static Tile GrassTile = new GrassTile(4);
	public static Tile DarkWillTile = new DarkWallTile(0);
	public static Tile DarkFloorTile1 = new DarkFloorTile1(1);
	public static Tile DarkFloorTile2 = new DarkFloorTile2(5);
	public static Tile DarkFloorTile3 = new DarkFloorTile3(6);
	
	
	public static Tile CaveDoor = new CaveDoor(7);
	public static Tile SurfaceDoor = new SurfaceDoor(9);
	public static Tile DesertDoor = new DesertDoor(10);
	public static Tile SurfaceToDesertDoor = new SurfaceToDesertDoor(14);
	//CLASS
	
	
	public static final int TILEWIDTH =64, TILEHEIGHT =64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public boolean isSolid() {
		return false;
	}

	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT,null);
		
	}
	
	public int getId() {
		return id;
	}
	
}
