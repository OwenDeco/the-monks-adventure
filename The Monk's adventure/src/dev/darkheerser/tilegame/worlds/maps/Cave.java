package dev.darkheerser.tilegame.worlds.maps;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.creatures.monsters.BlackDragon;
import dev.darkheerser.tilegame.entities.creatures.monsters.GoblinSword;
import dev.darkheerser.tilegame.entities.creatures.monsters.Lizard;
import dev.darkheerser.tilegame.entities.creatures.monsters.RedDragon;
import dev.darkheerser.tilegame.entities.statics.cave.CaveRock;
import dev.darkheerser.tilegame.entities.statics.surface.SurfaceRock;
import dev.darkheerser.tilegame.entities.statics.surface.SurfaceTree;
import dev.darkheerser.tilegame.states.GameState;
import dev.darkheerser.tilegame.worlds.World;

public class Cave extends World {

	public Cave(Handler handler,GameState gamestate, String path) {
		super(handler,gamestate, path);
//		entityManager = new EntityManager(handler, new Player(handler,100,250));

		/////monsters////
		
		// reddragon!!!!
		entityManager.addEntity(new RedDragon(handler, 2900,2175,150,1));
		entityManager.addEntity(new RedDragon(handler, 4133,2214,300,2));
		
		//lizard
		entityManager.addEntity(new Lizard(handler,580,150,15,2));
		entityManager.addEntity(new Lizard(handler,610,450,15,3));
		entityManager.addEntity(new Lizard(handler,670,870,15,1));
		entityManager.addEntity(new Lizard(handler,587,1070,15,1));
		entityManager.addEntity(new Lizard(handler,175,1540,15,1));
		//goblin
		entityManager.addEntity(new GoblinSword(handler,610,1880,15,1));
		entityManager.addEntity(new GoblinSword(handler,610,2080,15,1));
		entityManager.addEntity(new GoblinSword(handler,610,2280,15,1));
		
		//blackdragon
		
		entityManager.addEntity(new BlackDragon(handler,155,700,50,1));
		entityManager.addEntity(new BlackDragon(handler,2900,275,80,1));
		entityManager.addEntity(new BlackDragon(handler,3400,275,80,1));
		entityManager.addEntity(new BlackDragon(handler,3725,515,80,1));
		entityManager.addEntity(new BlackDragon(handler,4225,375,80,1));
		entityManager.addEntity(new BlackDragon(handler,4225,865,80,1));
		entityManager.addEntity(new BlackDragon(handler,3750,875,80,1));
		entityManager.addEntity(new BlackDragon(handler,4100,1500,80,1));
		entityManager.addEntity(new BlackDragon(handler,3620,1500,80,1));
		entityManager.addEntity(new BlackDragon(handler,3230,1120,80,1));
		entityManager.addEntity(new BlackDragon(handler,2800,1120,80,1));
		
		//tree
		entityManager.addEntity(new SurfaceTree(handler,100,200));
		for(int i =0; i< 5; i++) {
			for(int j =0; j<5; j++) {
				entityManager.addEntity(new SurfaceTree(handler,1950+(100*i),135+(20*i)+(64*3*j)));
				entityManager.addEntity(new SurfaceTree(handler,1950+(100*i),1510-(20*i)+(64*3*j)));
				
				
			}
		}
		
		//rocks//
		//type1
		entityManager.addEntity(new CaveRock(handler, 320,375,1));
		entityManager.addEntity(new CaveRock(handler, 715,188,1));
		entityManager.addEntity(new CaveRock(handler, 765,390,1));
		entityManager.addEntity(new CaveRock(handler, 769,985,1));
		//type2
		entityManager.addEntity(new CaveRock(handler, 325,570,2)); 
		//type3
		entityManager.addEntity(new CaveRock(handler, 1130,175,3)); 
		entityManager.addEntity(new CaveRock(handler, 640,560,3)); 
		entityManager.addEntity(new CaveRock(handler, 525,855,3)); 
		entityManager.addEntity(new CaveRock(handler, 65,890,3)); 
		//type surface rocks
		entityManager.addEntity(new SurfaceRock(handler,515,1400,2));
		
		/////////
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
//		entityManager.getPlayer().getCollisionBounds(xOffset, yOffset);
//		loadWorld(path);
//		entityManager.getPlayer().setX(spawnX);
//		entityManager.getPlayer().setY(spawnY);

	}

//	public void tick() {
//		
//
//
//	}
//
//	public void render() {
//
//	}

	public void addEntitiesToCave() {

	}

	@Override
	public void addEntitiesToSurface() {
		// TODO Auto-generated method stub
		
	}

}
