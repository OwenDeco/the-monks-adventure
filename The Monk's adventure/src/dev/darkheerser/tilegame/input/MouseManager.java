package dev.darkheerser.tilegame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.darkheerser.tilegame.ui.UIManager;

public class MouseManager implements MouseListener,MouseMotionListener{
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	//getters
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	
	
	//Implemented methods
	
	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		if( e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
			
		}
	}

	public void mouseReleased(MouseEvent e) {
		if( e.getButton() == MouseEvent.BUTTON1) 
			leftPressed = false;
	
		
		else if(e.getButton() == MouseEvent.BUTTON3) 
			rightPressed = false;
		
		if(uiManager !=null)
			uiManager.onMouseRelease(e);
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager !=null)
			uiManager.onMouseMove(e);
	}

}
