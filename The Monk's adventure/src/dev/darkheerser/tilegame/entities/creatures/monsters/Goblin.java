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

public class Goblin extends Creature {

	private Animation animUp, animDown, animLeft, animRight;
	long startTimer = System.currentTimeMillis();
	Random rand = new Random();
	private int tempDir = 0;
	private long lastAttackTimer, attackCooldown = 900, attackTimer = attackCooldown;

	Rectangle ar = new Rectangle();
	Rectangle br = new Rectangle();
	int direction = 1;
	public int id = 1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goblin(Handler handler, float x, float y, int health, int direction) {
		super(handler, x, y, 80, 80, 1);

		this.direction = direction;
		this.health = health;
		this.tempHealth = health;

		speed = 2;


		bounds.x = 20;
		bounds.y = 30;
		bounds.width = 40;
		bounds.height = 45;

		animUp = new Animation(150, Assets.goblin_up);
		animDown = new Animation(150, Assets.goblin_down);
		animLeft = new Animation(150, Assets.goblin_left);
		animRight = new Animation(150, Assets.goblin_right);

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
				g.drawImage(Assets.goblin_up[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else if (tempDir == 1) {
				g.drawImage(Assets.goblin_down[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else if (tempDir == 2) {
				g.drawImage(Assets.goblin_right[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			} else {
				g.drawImage(Assets.goblin_left[0], (int) (x - handler.getCamera().getxOffset()),
						(int) (y - handler.getCamera().getyOffset()), width, height, null);
			}
		}

		g.setColor(Color.red);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15, 50,
				6);
		g.setColor(Color.green);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15,
				health * 50 / tempHealth, 6);

		// g.setColor(Color.red);
		// g.fillRect((int)(x+ bounds.x - handler.getCamera().getxOffset()),(int) (y +
		// bounds.y - handler.getCamera().getyOffset()), (int)bounds.width,(int)
		// bounds.height);
		// g.setColor(Color.red);
		// g.drawRect((int)ar.x,(int) (ar.y), (int)ar.width,(int) ar.height);

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
		br.width = 84;
		br.height = 84;

		if (handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(-10, -10).intersects(br)) {
			handler.getWorld().getEntityManager().getPlayer().hurt(1);
			//testen of ik de hp kan resetten
//			if(handler.getWorld().getEntityManager().getPlayer().getHealth() == 0) {
//				this.health = this.tempHealth;
//			}
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
