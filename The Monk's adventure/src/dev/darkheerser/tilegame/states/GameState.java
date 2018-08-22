package dev.darkheerser.tilegame.states;

import java.awt.Graphics;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.creatures.Player;
import dev.darkheerser.tilegame.worlds.World;
import dev.darkheerser.tilegame.worlds.maps.Cave;
import dev.darkheerser.tilegame.worlds.maps.Desert;
import dev.darkheerser.tilegame.worlds.maps.Surface;

public class GameState extends State {
	public World world2;
	public World world1;
	public World world3;
	private World tempWorld;
	long timer=0;	
	
	Player player;
	
	float world1NewSpawnX, world1NewSpawnY, world2NewSpawnX = 0,world2NewSpawnY=0;


	public GameState(Handler handler) {
		super(handler);
		player = new Player(handler, 10,0,0);
		handler.getMouseManager().setUIManager(null);
		world1 = new Surface(handler,this,"res/worlds/worlds1.txt");
		world2 = new Cave(handler,this, "res/worlds/worlds2.txt");
		world3 = new Desert(handler,this,"res/worlds/worlds3.txt");
		handler.setWorld(world1);
		handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
		handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
		
	
	
	}

	public void tick() {
		
		if(handler.getWorld().getEntityManager().getPlayer().isDead()) {
			handler.setWorld(world1);
			handler.getWorld().getEntityManager().getPlayer().setDead(false);
			handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getTempHealth());
			handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
			handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
			
		}
		if(handler.getWorld().getEntityManager().getPlayer().isPassSurfaceDoor()== true) {
			if(System.currentTimeMillis() - timer > 2000) {
			tempWorld = handler.getWorld();
			
			world1NewSpawnX = handler.getWorld().getEntityManager().getPlayer().getX();
			world1NewSpawnY = handler.getWorld().getEntityManager().getPlayer().getY();
			handler.setWorld(world2);
			handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
			handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
	
			handler.getWorld().getEntityManager().getPlayer().setPassSurfaceDoor(false);
			timer = System.currentTimeMillis();

			}else {
				handler.getWorld().getEntityManager().getPlayer().setPassSurfaceDoor(false);
				
			}
		}else if(handler.getWorld().getEntityManager().getPlayer().isPassCaveDoor()== true){
			if(System.currentTimeMillis() - timer > 2000) {
				tempWorld = handler.getWorld();
				handler.setWorld(world1);
				handler.getWorld().getEntityManager().getPlayer().setX(world1NewSpawnX);
				handler.getWorld().getEntityManager().getPlayer().setY(world1NewSpawnY);
				handler.getWorld().getEntityManager().getPlayer().setPassCaveDoor(false);
				timer=System.currentTimeMillis();

			}else {
				handler.getWorld().getEntityManager().getPlayer().setPassCaveDoor(false);
				
			}
		}else if(handler.getWorld().getEntityManager().getPlayer().isPassDesertToSurfaceDoor()== true){
			if(System.currentTimeMillis() - timer > 2000) {
				tempWorld = handler.getWorld();
				world2NewSpawnX = handler.getWorld().getEntityManager().getPlayer().getX();
				world2NewSpawnY = handler.getWorld().getEntityManager().getPlayer().getY();

				handler.setWorld(world1);
				handler.getWorld().getEntityManager().getPlayer().setX(world1NewSpawnX);
				handler.getWorld().getEntityManager().getPlayer().setY(world1NewSpawnY);
				handler.getWorld().getEntityManager().getPlayer().setPassDesertToSurfaceDoor(false);
				timer=System.currentTimeMillis();

			}else {
				handler.getWorld().getEntityManager().getPlayer().setPassDesertToSurfaceDoor(false);
				
			}
		}else if(handler.getWorld().getEntityManager().getPlayer().isPassSurfaceToDesertDoor()== true){
			if(System.currentTimeMillis() - timer > 2000) {
				tempWorld = handler.getWorld();
				world1NewSpawnX = handler.getWorld().getEntityManager().getPlayer().getX();
				world1NewSpawnY = handler.getWorld().getEntityManager().getPlayer().getY();
				handler.setWorld(world3);
				
				if(world2NewSpawnX ==0) {
					handler.getWorld().getEntityManager().getPlayer().setX(handler.getWorld().getSpawnX());
					handler.getWorld().getEntityManager().getPlayer().setY(handler.getWorld().getSpawnY());
					
				}else {
					handler.getWorld().getEntityManager().getPlayer().setX(world2NewSpawnX);
					handler.getWorld().getEntityManager().getPlayer().setY(world2NewSpawnY);
				}
				handler.getWorld().getEntityManager().getPlayer().setPassSurfaceToDesertDoor(false);
				timer=System.currentTimeMillis();

			}else {
				handler.getWorld().getEntityManager().getPlayer().setPassSurfaceToDesertDoor(false);
				
			}
		}
		
		handler.getWorld().tick();

		

	}

	public void render(Graphics g) {

		handler.getWorld().render(g);

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
