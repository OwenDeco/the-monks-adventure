package dev.darkheerser.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		try {
		return sheet.getSubimage(x, y, width, height);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
