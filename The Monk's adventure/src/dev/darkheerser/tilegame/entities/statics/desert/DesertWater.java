package dev.darkheerser.tilegame.entities.statics.desert;

import java.awt.Color;
import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.statics.StaticEntity;
import dev.darkheerser.tilegame.gfx.Assets;
import dev.darkheerser.tilegame.tile.Tile;

public class DesertWater extends StaticEntity {

	int type =1;
	public DesertWater(Handler handler, float x, float y,int widthscale, int heightscale, int type) {
		super(handler, x, y,Tile.TILEWIDTH*widthscale, Tile.TILEHEIGHT*heightscale);
		killable = false;
		this.type = type;
		
	
		
	}
	public void die() {
		
	}

	public void tick() {
		
	}

	public void render(Graphics g) {

		if(type ==1) {
		g.drawImage(Assets.desert_water, (int)(x-handler.getCamera().getxOffset()), (int)(y-handler.getCamera().getyOffset()),width, height,null);
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = width-20;
		bounds.height = height-40;
		}else if(type ==2){
		g.drawImage(Assets.desert_water2, (int)(x-handler.getCamera().getxOffset()), (int)(y-handler.getCamera().getyOffset()),width, height,null);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width+5;
		bounds.height = height;
			
		}
//		 g.setColor(Color.red);
//		 g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()),(int)(y
//		 + bounds.y - handler.getCamera().getyOffset()),bounds.width,
//		 bounds.height);
	}

}
