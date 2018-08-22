package dev.darkheerser.tilegame.worlds.maps;

import dev.darkheerser.tilegame.Handler;
import dev.darkheerser.tilegame.entities.creatures.monsters.Camel;
import dev.darkheerser.tilegame.entities.creatures.monsters.Lizard;
import dev.darkheerser.tilegame.entities.creatures.monsters.Snake;
import dev.darkheerser.tilegame.entities.statics.desert.DesertRock;
import dev.darkheerser.tilegame.entities.statics.desert.DesertSandpile;
import dev.darkheerser.tilegame.entities.statics.desert.DesertSpike;
import dev.darkheerser.tilegame.entities.statics.desert.DesertTree;
import dev.darkheerser.tilegame.entities.statics.desert.DesertWater;
import dev.darkheerser.tilegame.states.GameState;
import dev.darkheerser.tilegame.worlds.World;

public class Desert extends World {

	public Desert(Handler handler, GameState gamestate, String path) {
		super(handler, gamestate, path);
		// entityManager = new EntityManager(handler, new Player(handler, 100, 250));

		////// monsters///////
		// camel
		
		
		for (int i = 0; i < 10; i++) {
			entityManager.addEntity(new Camel(handler, 200 + 200 * i, 300, 20, 1));
		}
		entityManager.addEntity(new Camel(handler, 600, 1250, 20, 1));
		entityManager.addEntity(new Camel(handler, 1350, 1100, 20, 1));
		entityManager.addEntity(new Camel(handler, 1750, 1230, 20, 1));
		entityManager.addEntity(new Camel(handler, 2350, 1400, 20, 1));
		entityManager.addEntity(new Camel(handler, 1250, 1100, 20, 1));
		entityManager.addEntity(new Camel(handler, 3500, 500, 20, 1));
		entityManager.addEntity(new Camel(handler, 4050, 650, 20, 1));
		entityManager.addEntity(new Camel(handler, 4050, 1225, 20, 1));
		entityManager.addEntity(new Camel(handler, 3600, 270, 20, 1));

		// snake

		entityManager.addEntity(new Snake(handler, 300, 2150, 5, 2));
		entityManager.addEntity(new Snake(handler, 950, 2150, 5, 2));
		entityManager.addEntity(new Snake(handler, 1320, 2910, 5, 2));
		entityManager.addEntity(new Snake(handler, 690, 2860, 5, 2));
		entityManager.addEntity(new Snake(handler, 690, 2970, 5, 2));

		/// snake den
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				entityManager.addEntity(new Snake(handler, 3700 + 150 * i, 3040 + 200*j, 5, 2));
			}
		}

		// sand
		entityManager.addEntity(new DesertSandpile(handler, 610, 3180));
		// spike

		for (int i = 0; i < 7; i++) {
			entityManager.addEntity(new DesertSpike(handler, 2050 + 32 * i, 1800, 1));

		}
		for (int j = 0; j < 3; j++) {

			entityManager.addEntity(new DesertSpike(handler, 1485 + 32 * j, 2700 + 32 * j, 1));

		}
		for (int d = 0; d < 7; d++) {
			entityManager.addEntity(new DesertSpike(handler, 570 + 32 * d, 3100, 2));
		}
		// trees
		entityManager.addEntity(new DesertTree(handler, 310, 3220));
		entityManager.addEntity(new DesertTree(handler, 4400, 480));
		entityManager.addEntity(new DesertTree(handler, 760, 1800));
		entityManager.addEntity(new DesertTree(handler, 1000, 1800));
		entityManager.addEntity(new DesertTree(handler, 4070, 2750));
		entityManager.addEntity(new DesertTree(handler, 95, 2900));

		for (int i = 0; i < 3; i++) {
			entityManager.addEntity(new DesertTree(handler, 100, 0 + 150 * i));
			entityManager.addEntity(new DesertTree(handler, 1040, 2650 + 150 * i));
			entityManager.addEntity(new DesertTree(handler, 166 + 250 * i, 2440));
		}
		for (int j = 0; j < 4; j++) {
			entityManager.addEntity(new DesertTree(handler, 80, 600 + 200 * j));
			entityManager.addEntity(new DesertTree(handler, 1520 + 250 + 250 * j, 2450 + 500));
			entityManager.addEntity(new DesertTree(handler, 1520 + 500 + 250 * j, 2450 + 750));
			for (int k = 0; k < 5; k++) {
				entityManager.addEntity(new DesertTree(handler, 960, 550 + 200 * k));
				entityManager.addEntity(new DesertTree(handler, 2130 + 250 * k + 250 * j, 275 + 500 * j));

			}
		}

		// rocks//
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				entityManager.addEntity(new DesertRock(handler, 490 + 64 * j, 410 + 64 * i, j + 1));
				entityManager.addEntity(new DesertRock(handler, 4095 + 64 * j, 210 + 64 * i, j + 1));
				entityManager.addEntity(new DesertRock(handler, 3180 + 64 * j, 2470 + 64 * i, j + 1));
				entityManager.addEntity(new DesertRock(handler, 1050 + 250 * j + 600 * i, 173 + 500 * i, 3));
			}
		}
		entityManager.addEntity(new DesertRock(handler, 3040, 540, 3));
		entityManager.addEntity(new DesertRock(handler, 4210, 1090, 2));
		entityManager.addEntity(new DesertRock(handler, 3820, 1720, 3));
		// water
		entityManager.addEntity(new DesertWater(handler, 130, 3100, 3, 3, 1));
		entityManager.addEntity(new DesertWater(handler, 385, 2900, 1, 2, 2));

		//
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		// loadWorld(path);
		// entityManager.getPlayer().setX(spawnX);
		// entityManager.getPlayer().setY(spawnY);

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
