package dev.darkheerser.tilegame.playerScreen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.gfx.Text;
import dev.darkheerser.tilegame.items.Item;
import dev.darkheerser.tilegame.states.State;

public class PlayerScreen {

	Handler handler;
	private boolean active = false;

	private int invX = 400, invY = 10, invWidth = 400, invHeight = 533;

	public PlayerScreen(Handler handler) {
		this.handler = handler;
		


	}

	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_P))
			active = !active;
		if (!active)
			return;

	}

	public void render(Graphics g) {
	
		if (!active)
			return;

		g.drawImage(Assets.playerScreen, invX, invY, invWidth, invHeight, null);
		Text.drawString(g, "Monk " + handler.getGame().menuState.getName(), 580, 60, true, Color.WHITE, Assets.font38);
		
		Text.drawString(g, "Health : " + handler.getWorld().getEntityManager().getPlayer().getHealth()+"|"+ handler.getWorld().getEntityManager().getPlayer().getTempHealth(), 425, 90, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Weapon : none", 425, 110, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Damage : "+ handler.getWorld().getEntityManager().getPlayer().getDamage(), 425, 130, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Level : " + handler.getWorld().getEntityManager().getPlayer().getLevel(), 425, 160, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Exp to level : " + handler.getWorld().getEntityManager().getPlayer().getXpleft(), 425, 180, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Total expierence : " + handler.getWorld().getEntityManager().getPlayer().getExpierence(), 425, 200, false, Color.WHITE, Assets.font28);
		// Text.drawString(g, ">> " + inventoryItems.get(selectedItem + i).getName() + "
		// <<", invListCenterX,
		// invListCenterY + i * invListSpacing, true, Color.BLACK, Assets.font28);
		//
		// Text.drawString(g, inventoryItems.get(selectedItem + i).getName(),
		// invListCenterX,
		// invListCenterY + i * invListSpacing, true, Color.BLACK, Assets.font28);
		//
		// g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth,
		// invImageHeight, null);
		// Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY,
		// true, Color.black, Assets.font38);

	}

	// inventory methods

	// getters setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
