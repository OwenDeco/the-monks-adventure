package dev.darkheerser.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.Entity;
import dev.darkheerser.tilegame.gfx.Animation;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.Text;
import dev.darkheerser.tilegame.inventory.Inventory;
import dev.darkheerser.tilegame.playerScreen.PlayerScreen;

public class Player extends Creature {

	// playerscreen
	PlayerScreen playerScreen;
	// inventory
	Inventory inventory;

	// atttimer
	private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;

	// gold count
	private int count = 0;

	private Animation animUp, animDown, animLeft, animRight, animUpR, animDownR, animUpL, animDownL, goldDrop;
	private int upDown = 0, rightLeft = 0;
	Rectangle ar = new Rectangle();

	private boolean dead = false;
	private boolean deadAnnouncement = false;

	public int expierence = 0;
	private int expierenceToLevelUp = 0;
	public int level = 1;
	public int xpleft = 0;
	public int damage = 1;

	public int id = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player(Handler handler, int health, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH - 10, Creature.DEFAULT_CREATURE_HEIGHT - 10, 0);

		this.tempHealth = health;
		this.health = health;
		killable = false;
		inventory = new Inventory(handler);
		playerScreen = new PlayerScreen(handler);

		bounds.x = 12;
		bounds.y = 27;
		bounds.width = 34;
		bounds.height = 27;

		// Animations

		animUp = new Animation(350, Assets.player_up);
		animDown = new Animation(350, Assets.player_down);
		animUpR = new Animation(350, Assets.player_upR);
		animDownR = new Animation(350, Assets.player_downR);
		animUpL = new Animation(350, Assets.player_upL);
		animDownL = new Animation(350, Assets.player_downL);
		animLeft = new Animation(350, Assets.player_left);
		animRight = new Animation(350, Assets.player_right);

		goldDrop = new Animation(250, Assets.gold);
	}

	public void tick() {
		// System.out.println(health);
//		 System.out.println(x + " " + y);

		// animations
		if (deadAnnouncement) {
			if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER))
				deadAnnouncement = false;

		}

		// if ((System.currentTimeMillis() - timer) > 20000 && health < tempHealth) {
		// health++;
		// timer = System.currentTimeMillis();
		// }

		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animDownL.tick();
		animDownR.tick();
		animUpL.tick();
		animUpR.tick();
		goldDrop.tick();
		//
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
		// attack
		checkAttack();
		checkLevel();
		regenerate();

		playerScreen.tick();
		inventory.tick();

	}

	public void checkAttack() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		if (inventory.isActive() || deadAnnouncement)
			return;
		Rectangle cb = getCollisionBounds(0, 0);

		int arSize = 50;
		ar.width = arSize;
		ar.height = arSize;
		
		if (upDown == 1 && handler.getKeyManager().attack) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize / 2;
		} else if ((upDown == -1) && handler.getKeyManager().attack) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height + arSize / 2;
		} else if (rightLeft == -1 && handler.getKeyManager().attack) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (rightLeft == 1 && handler.getKeyManager().attack) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if ((upDown == 0) && handler.getKeyManager().attack) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height + arSize / 2;
		} else {
			return;
		}

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar) && e.isKillable()) {
				e.hurt(damage);
				return;
			}
		}

	}

	public void die() {

		dead = true;
		deadAnnouncement = true;
	}

	private void checkLevel() {
		expierenceToLevelUp = 10 + 10 * (int) (Math.pow(level, 2));
		// System.out.println(expierence +" " + expierenceToLevelUp + " " + level);
		if (expierence >= expierenceToLevelUp) {
			level++;
			tempHealth += 2;
			health += 2;
		} else {
			xpleft = expierenceToLevelUp - expierence;
		}
		if(level != 1) {
		this.setDamage(this.level + 2);
		}
	}

	private void getInput() {

		xMove = 0;
		yMove = 0;
		if (inventory.isActive() || deadAnnouncement)
			return;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;

	}

	public void render(Graphics g) {

		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), width, height, null);
		g.setColor(Color.red);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15, 50,
				6);
		g.setColor(Color.green);
		g.fillRect((int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()) - 15,
				health * 50 / tempHealth, 6);

		if (deadAnnouncement) {
			Text.drawString(g, "YOU DIED", (int) (x - handler.getCamera().getxOffset() + 180) + 15,
					(int) (y - handler.getCamera().getyOffset()) - 90, true, Color.red, Assets.font48);
			Text.drawString(g, " Press 'Enter' to continue", (int) (x - handler.getCamera().getxOffset() + 180) + 15,
					(int) (y - handler.getCamera().getyOffset()) - 60, true, Color.black, Assets.font38);

		}
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getCamera().getyOffset()), (int) bounds.width, (int) bounds.height);

		if (handler.getWorld().getItemManager().isGoldAnim() == true) {

			g.drawImage(goldDrop.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()) + 30,
					(int) (y - handler.getCamera().getyOffset()) - 30, width, height, null);

			if (goldDrop.getCurrentFrame() == Assets.gold[8]) {
				handler.getWorld().getItemManager().setGoldAnim(false);

			}
		}
	}

	public void postRender(Graphics g) {

		inventory.render(g);
		playerScreen.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {

		if (xMove < 0 && yMove < 0) {
			upDown = 1;
			rightLeft = 0;
			return animUpL.getCurrentFrame();
		} else if (xMove < 0 && yMove > 0) {
			upDown = 0;
			rightLeft = 0;
			return animDownL.getCurrentFrame();
		} else if (xMove > 0 && yMove < 0) {
			upDown = 1;
			rightLeft = 0;
			return animUpR.getCurrentFrame();
		} else if (xMove > 0 && yMove > 0) {
			upDown = 0;
			rightLeft = 0;
			return animDownR.getCurrentFrame();
		} else if (xMove < 0) {
			rightLeft = -1;
			upDown = 0;
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			rightLeft = 1;
			upDown = 0;
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			upDown = 1;
			rightLeft = 0;
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			upDown = 0;
			rightLeft = 0;
			return animDown.getCurrentFrame();
		} else if (upDown == 1) {
			return Assets.player_up[0];
		}else if( upDown == -1) {
			return Assets.player_down[0];
		} else if (rightLeft == -1) {
			return Assets.player_left[0];
		} else if (rightLeft == 1) {
			return Assets.player_right[0];
		} else
			return Assets.player;

	}

	//// getters setters

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public int getExpierence() {
		return expierence;
	}

	public void setExpierence(int expierence) {
		this.expierence = expierence;
	}

	public int getExpierenceToLevelUp() {
		return expierenceToLevelUp;
	}

	public int getXpleft() {
		return xpleft;
	}

	public void setXpleft(int xpleft) {
		this.xpleft = xpleft;
	}

	public void setExpierenceToLevelUp(int expierenceToLevelUp) {
		this.expierenceToLevelUp = expierenceToLevelUp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
