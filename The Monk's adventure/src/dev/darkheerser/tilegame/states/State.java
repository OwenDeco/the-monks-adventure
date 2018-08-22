package dev.darkheerser.tilegame.states;

import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.ui.UIManager;
import dev.darkheerser.tilegame.worlds.World;
import dev.darkheerser.tilegame.worlds.maps.Cave;
import dev.darkheerser.tilegame.worlds.maps.Surface;

public abstract class State {

	
	private static State currentState = null;
	protected Handler handler;
	protected UIManager uiManager;
	
	public State(Handler handler) {
		this.handler = handler;

		
		// hier laden we de maps in en via state kan je de andere states gebruiken om deze in te laden in het spel

		
	}
	
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	public abstract void tick() ;
	public abstract void render(Graphics g) ;
	
}
