package dev.darkheerser.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.creatures.monsters.Goblin;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 3;

	protected float x, y;
	protected int width, height;

	protected int health;
	protected Handler handler;
	protected Rectangle bounds;
	protected boolean passCaveDoor = false;
	protected boolean passSurfaceDoor = false;
	protected boolean passDesertToSurfaceDoor = false;
	protected boolean passSurfaceToDesertDoor = false;
	protected boolean active = true;
	protected boolean killable = true;
	protected long respawnTimer = System.currentTimeMillis();

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;

		health = DEFAULT_HEALTH;

		bounds = new Rectangle(0, 0, width, height);

	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void die();

	public abstract void gainedXp();

	public abstract int getId();

	// public abstract void respawn();

	public boolean killable() {
		return killable;
	}

	public void hurt(int amt) {
		health -= amt;
		// System.out.println(health);
		if (health <= 0) {
			if (this != handler.getWorld().getEntityManager().getPlayer()) {
				active = false;
			}
			die();

			if (this != handler.getWorld().getEntityManager().getPlayer()) {
				gainedXp();

			}
		}
	}

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (getCollisionBounds(xOffset, yOffset).intersects(e.getCollisionBounds(0f, 0f)))

				return true;
		}
		return false;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {

		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
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

	public boolean isPassCaveDoor() {
		return passCaveDoor;
	}

	public void setPassCaveDoor(boolean passCaveDoor) {
		this.passCaveDoor = passCaveDoor;
	}

	public boolean isPassSurfaceDoor() {
		return passSurfaceDoor;
	}

	public void setPassSurfaceDoor(boolean passSurfaceDoor) {
		this.passSurfaceDoor = passSurfaceDoor;
	}

	public boolean isPassDesertToSurfaceDoor() {
		return passDesertToSurfaceDoor;
	}

	public void setPassDesertToSurfaceDoor(boolean passDesertToSurfaceDoor) {
		this.passDesertToSurfaceDoor = passDesertToSurfaceDoor;
	}

	public boolean isPassSurfaceToDesertDoor() {
		return passSurfaceToDesertDoor;
	}

	public void setPassSurfaceToDesertDoor(boolean passSurfaceToDesertDoor) {
		this.passSurfaceToDesertDoor = passSurfaceToDesertDoor;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isKillable() {
		return killable;
	}

	public void setKillable(boolean killable) {
		this.killable = killable;
	}

}
