package dev.darkheerser.tilegame.entities.statics;

import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

	@Override
	public void gainedXp() {

	}

	@Override
	public int getId() {
		return -1;
	}
}
