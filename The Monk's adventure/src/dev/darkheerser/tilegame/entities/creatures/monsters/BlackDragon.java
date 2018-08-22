package dev.darkheerser.tilegame.entities.creatures.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.Entity;
import dev.darkheerser.tilegame.entities.creatures.Creature;
import dev.darkheerser.tilegame.gfx.Animation;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.items.Item;
import dev.darkheerser.tilegame.tile.Tile;

public class BlackDragon extends Creature {

	private Animation animUp, animDown, animLeft, animRight;
	long startTimer = System.currentTimeMillis();
	Random rand = new Random();
	private int tempDir = 0;
	private long lastAttackTimer, attackCooldown = 1000, attackTimer = attackCooldown;

	Rectangle ar = new Rectangle();
	Rectangle br = new Rectangle();
	int direction = 1;
	public int id = 6;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BlackDragon(Handler handler, float x, float y, int health, int direction) {
		super(handler, x, y, 120, 120, 1);

		this.direction = direction;
		this.health = health;
		this.tempHealth = health;

		speed = 1;


		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 90;
		bounds.height = 90;

		animUp = new Animation(350, Assets.blackDragon_up);
		animDown = new Animation(350, Assets.blackDragon_down);
		animLeft = new Animation(350, Assets.blackDragon_left);
		animRight = new Animation(350, Assets.blackDragon_right);

	}

	@Override
	public void tick() {
		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();

		checkAttacks();
		move();

		regenerate();
	}

	@Override
	public void render(Graphics g) {
		if (System.currentTimeMillis() - startTimer >= 5000) {
			startTimer = System.currentTimeMillis();
			direction = rand.nextInt(4);

		} else if (System.currentTimeMillis() - startTimer >= 2000) {

			g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getCamera().getxOffset()),
					(int) (y - handler.getCamera().getyOffset()), width, height, null);

			if (checkEntityCollisions(xMove, yMove) || tileCollision == true) {
				xMove *= -1;
				yMove *= -1;
				startTimer = 0;
			}

			tempDir = direction;

		} else {
			xMove = 0;
			yMove = 0;
			if (tempDir == 0) {
				g.drawImage(Assets.blackDragon_up[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else if (tempDir == 1) {
				g.drawImage(Assets.blackDragon_down[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else if (tempDir == 2) {
				g.drawImage(Assets.blackDragon_right[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else {
				g.drawImage(Assets.blackDragon_left[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			}
		}

		g.setColor(Color.red);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15, 100,
				6);
		g.setColor(Color.green);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15,
				health * 100 / tempHealth, 6);

//		 g.setColor(Color.red);
//		 g.fillRect((int)(x+ bounds.x - handler.getCamera().getxOffset()),(int) (y +
//		 bounds.y - handler.getCamera().getyOffset()), (int)bounds.width,(int)
//		 bounds.height);
//		 g.setColor(Color.red);
//		 g.drawRect((int)ar.x,(int) (ar.y), (int)ar.width,(int) ar.height);

	}

	private void checkAttacks() {

		// attacking back immediately
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;
		attackTimer = 0;

		int brSize = 10;
		br.x = (int) (x - brSize);
		br.y = (int) (y - brSize);
		br.width = 140;
		br.height = 140;

		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(br)) {
			handler.getWorld().getEntityManager().getPlayer().hurt(8);
			return;
		}

	}

	private BufferedImage getCurrentAnimationFrame() {

		// System.out.println(System.currentTimeMillis() - startTimer);
		if (direction == 0) {
			yMove = -speed;
			return animUp.getCurrentFrame();
		} else if (direction == 1) {
			yMove = speed;
			return animDown.getCurrentFrame();
		} else if (direction == 2) {
			xMove = speed;
			return animRight.getCurrentFrame();
		} else
			xMove = -speed;
		return animLeft.getCurrentFrame();

		// if (xMove < 0 && yMove < 0) {
		//
		// return animUp.getCurrentFrame();
		// } else if (xMove < 0 && yMove > 0) {
		//
		// return animLeft.getCurrentFrame();
		// } else if (xMove > 0 && yMove < 0) {
		//
		// return animRight.getCurrentFrame();
		// } else
		// ;
		// return animDown.getCurrentFrame();

	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.goldBagItem.createNew((int) x, (int) y + 20));

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
