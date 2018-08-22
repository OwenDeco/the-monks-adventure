package dev.darkheerser.tilegame.worlds;

import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.Utils;
import dev.darkheerser.tilegame.entities.EntityManager;
import dev.darkheerser.tilegame.entities.creatures.monsters.Goblin;
import dev.darkheerser.tilegame.items.ItemManager;
import dev.darkheerser.tilegame.states.GameState;
import dev.darkheerser.tilegame.tile.Tile;

public abstract class World {

	protected int width, height;
	protected int spawnX, spawnY;
	protected int[][] tiles;
	protected Handler handler;
	GameState gamestate;
	
	// Entities
	
	protected EntityManager entityManager;
	protected ItemManager itemManager;
	
	public World(Handler handler,GameState gamestate, String path) {
		this.handler = handler;
		this.gamestate = gamestate;
		itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, gamestate.getPlayer());
		loadWorld(path);

		
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y<height; y++) {
			for(int x = 0; x< width; x++) {
				tiles[x][y] =Utils.parseInt(tokens[(x+y*width) + 4]);
			}
		}
		
	}
	
	public void tick() {
		entityManager.tick();
		itemManager.tick();
	}
	
	public void render(Graphics g) {

		int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Tile.TILEWIDTH) ;
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) /Tile.TILEWIDTH+1);
		int yStart =(int)Math.max(0, handler.getCamera().getyOffset() / Tile.TILEHEIGHT) ;
		int yEnd =(int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) /Tile.TILEHEIGHT+1);
		
		
		
		for(int y =yStart; y<yEnd; y++) {
			for(int x = xStart; x< xEnd; x++) {
				getTile(x,y).render(g, (int)(x*64 - handler.getCamera().getxOffset()),(int)( y*64 - handler.getCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y <0 || x >= width || y >= height)
			return Tile.GrassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.DirtTile;
		}
		return t;
	}
	public abstract void addEntitiesToSurface() ;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	

	
}
