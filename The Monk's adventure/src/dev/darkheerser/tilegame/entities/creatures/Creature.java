package dev.darkheerser.tilegame.entities.creatures;

import java.awt.Rectangle;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.Entity;
import dev.darkheerser.tilegame.tile.Tile;

public abstract class Creature extends Entity {

	public static final float DEFAULT_SPEED = 3f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;

	protected float speed;
	protected float xMove, yMove;
	protected boolean tileCollision = false;
	protected int tempHealth;
	protected int id;

	protected long timer = System.currentTimeMillis();
	
	public Creature(Handler handler, float x, float y, int width, int height, int id) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;

		this.id = id;
	}

	public void regenerate() {
		if ((System.currentTimeMillis() - timer) > 20000 && health < tempHealth) {
			health++;
			timer = System.currentTimeMillis();
		}

	}
	
	public void move() {

		if (!checkEntityCollisions(xMove, 0f)) {
			if (handler.getWorld()
					.getTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT)
					.getId() == 7) {
				passCaveDoor = true;
			} else if (handler.getWorld()
					.getTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT)
					.getId() == 9) {
				passSurfaceDoor = true;
			} else if (handler.getWorld()
					.getTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT)
					.getId() == 10) {
				passDesertToSurfaceDoor = true;
			} else if (handler.getWorld()
					.getTile((int) (x + bounds.x) / Tile.TILEWIDTH, (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT)
					.getId() == 14) {
				passSurfaceToDesertDoor = true;
			}
			moveX();
		}
		if (!checkEntityCollisions(0f, yMove))
			moveY();
	}

	public void moveX() {
		if (xMove > 0) { // moving right duh

			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
				tileCollision = false;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
				tileCollision = true;
			}

		} else if (xMove < 0) { // moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
				tileCollision = false;
			} else {

				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
				tileCollision = true;
			}
		}
	}

	public void moveY() {
		if (yMove < 0) {

			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
				tileCollision = false;
			} else {

				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
				tileCollision = true;
			}

		} else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
				tileCollision = false;
			} else {
				tileCollision = true;
			}
		}

	}

	protected boolean collisionWithTile(int x, int y) {

		return handler.getWorld().getTile(x, y).isSolid();

	}

	protected boolean checkSurroundingBounds(Rectangle size) {

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {

				if (e.getCollisionBounds(0, 0).intersects(size)) {

					return true;
				} else {
					System.out.println("not surrounded bounds" + this);
					return false;
				}
			}
		}
		return true;
	}

	public void gainedXp() {
		System.out.println(tempHealth);
		handler.getWorld().getEntityManager().getPlayer().expierence += 3 * this.tempHealth;

	}

	//// GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTempHealth() {
		return tempHealth;
	}

	public void setTempHealth(int tempHealth) {
		this.tempHealth = tempHealth;
	}

}
