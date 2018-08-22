package dev.darkheerser.tilegame.worlds.maps;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.creatures.monsters.BlackDragon;
import dev.darkheerser.tilegame.entities.creatures.monsters.Goblin;
import dev.darkheerser.tilegame.entities.creatures.monsters.GoblinSword;
import dev.darkheerser.tilegame.entities.statics.surface.SurfaceRock;
import dev.darkheerser.tilegame.entities.statics.surface.SurfaceTree;
import dev.darkheerser.tilegame.states.GameState;
import dev.darkheerser.tilegame.worlds.World;

public class Surface extends World {
	int count =0;
	public Surface(Handler handler, GameState gamestate,String path) {
		super(handler,gamestate, path);
		
		// player
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		// entityManager = handler.getWorld().getEntityManager()
		
		// goblin
		
		entityManager.addEntity(new Goblin(handler, 400, 420, 3, 1));
		entityManager.addEntity(new Goblin(handler, 1670, 1440, 3, 1));
		entityManager.addEntity(new Goblin(handler, 1600, 365, 3, 1));
		entityManager.addEntity(new Goblin(handler, 800, 1200, 3, 2));
		entityManager.addEntity(new Goblin(handler, 1900, 1040, 3, 2));
		
		//goblinsword
		for(int i = 0; i<15;i++) {
		entityManager.addEntity(new GoblinSword(handler, 328 + 100*i, 2100, 10, 3));
		}

		// tree
		entityManager.addEntity(new SurfaceTree(handler, 1410, 892));
		entityManager.addEntity(new SurfaceTree(handler, 1600, 762));
		entityManager.addEntity(new SurfaceTree(handler, 2050, 892));
		entityManager.addEntity(new SurfaceTree(handler, 1780, 122));
		entityManager.addEntity(new SurfaceTree(handler, 1800, 1472));
		entityManager.addEntity(new SurfaceTree(handler, 1300, 318));
		for (int i = 0; i < 3; i++) {
			entityManager.addEntity(new SurfaceTree(handler, 100, 0 + 150 * i));
		}
		for (int j = 0; j < 4; j++) {
			entityManager.addEntity(new SurfaceTree(handler, 80, 600 + 200 * j));
		}
		for (int k = 0; k < 5; k++) {
			entityManager.addEntity(new SurfaceTree(handler, 960, 550 + 200 * k));
		}

		// rocks//
		// type1
		entityManager.addEntity(new SurfaceRock(handler, 255, 350, 1));
		entityManager.addEntity(new SurfaceRock(handler, 700, 160, 1));
		entityManager.addEntity(new SurfaceRock(handler, 890, 360, 1));
		entityManager.addEntity(new SurfaceRock(handler, 590, 810, 1));
		entityManager.addEntity(new SurfaceRock(handler, 590, 1220, 1));
		entityManager.addEntity(new SurfaceRock(handler, 140, 1520, 1));
		entityManager.addEntity(new SurfaceRock(handler, 1220, 1520, 1));
		entityManager.addEntity(new SurfaceRock(handler, 1600, 1140, 1));
		entityManager.addEntity(new SurfaceRock(handler, 1665, 820, 1));
		entityManager.addEntity(new SurfaceRock(handler, 1225, 760, 1));
		entityManager.addEntity(new SurfaceRock(handler, 1230, 370, 1));
		// type2
		entityManager.addEntity(new SurfaceRock(handler, 190, 60, 2));
		entityManager.addEntity(new SurfaceRock(handler, 890, 700, 2));
		entityManager.addEntity(new SurfaceRock(handler, 1280, 60, 2));
		entityManager.addEntity(new SurfaceRock(handler, 1980, 60, 2));
		// type3
		entityManager.addEntity(new SurfaceRock(handler, 1980, 700, 3));
		entityManager.addEntity(new SurfaceRock(handler, 2050, 445, 3));
		entityManager.addEntity(new SurfaceRock(handler, 190, 830, 3));



	}

	// public void tick() {
	//
	//
	// }
	//
	// public void render() {
	//
	// }

	public void addEntitiesToSurface() {

	}

}
