package dev.darkheerser.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	// blocksheet and entitySheet
	private static final int width = 32, height = 32;
	// playersheet
	public static final int widthP = 100, heightP = 100;
	//goblinsheet
	private static final int widthGoblin = 64, heightGoblin = 64;
	//camelsheet
	private static final int widthCamel =80, heightCamel = 80;
	//snakesheet
	private static final int widthsnake = 48, heightsnake =48;
	//lizardsheet 
	private static final int widthLizard = 80, heightLizard1 =55, heightLizard2=56;
	//blackDragonsheet
	private static final int widthBdragon = 96, heightBdragon = 96;
	//redDragonsheet
	private static final int widthRdragon = 192, heightRdragon =192;
	// FONTS
	
	public static Font font18, font28, font32,font38, font48;
	
	// ITEMS
	public static BufferedImage inventoryScreen, playerScreen;
	public static BufferedImage surfaceTreeWood, desertTreeWood;
	public static BufferedImage surfaceOre, desertOre, caveOre;
	public static BufferedImage goldBag;
	public static BufferedImage[] gold;

	// trees
	public static BufferedImage surfaceTree, desertTree, caveTree;
	// rocks
	public static BufferedImage surfaceRock, surfaceRock2, surfaceRock3, desertRock, desertRock2, desertRock3, caveRock,
			caveRock2, caveRock3;
	// sand
	public static BufferedImage desert_sandpile;
	// spike
	public static BufferedImage desert_spike;
	// doors
	public static BufferedImage cave_door, surface_door, desert_door, surfaceToDesert_door;
	// water
	public static BufferedImage desert_water, desert_water2;
	// tiles
	public static BufferedImage darkWallStone, darkFloorStone1, darkFloorStone2, darkFloorStone3;
	public static BufferedImage dirt, grass, stone, player, rock;

	public static BufferedImage tryDirt, tryDirtWall;
	// player
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_downR, player_upR,player_downL, player_upL;
	
	//monsters
	public static BufferedImage[] goblin_down, goblin_up, goblin_left, goblin_right;
	public static BufferedImage[] goblinS_down, goblinS_up, goblinS_left, goblinS_right;
	public static BufferedImage[] camel_down, camel_up, camel_left, camel_right;
	public static BufferedImage[] snake_down, snake_up, snake_left, snake_right;
	public static BufferedImage[] lizard_down, lizard_up, lizard_left, lizard_right;
	public static BufferedImage[] blackDragon_down, blackDragon_up, blackDragon_left, blackDragon_right;
	public static BufferedImage[] redDragon_down, redDragon_up, redDragon_left, redDragon_right;

	// menu
	public static BufferedImage[] btn_start, btn_quit;

	public static void init() {
		
		font18 = FontLoader.loadFont("res/fonts/slkscr.ttf", 12);
		font28 = FontLoader.loadFont("res/fonts/slkscr.ttf", 14);
		font32 = FontLoader.loadFont("res/fonts/slkscr.ttf", 21);
		font38 = FontLoader.loadFont("res/fonts/slkscr.ttf", 22);
		font48 = FontLoader.loadFont("res/fonts/slkscr.ttf", 36);

		SpriteSheet entitySheet = new SpriteSheet(ImageLoader.loadImage("/textures/entitySheet.png"));
		SpriteSheet blockSheet = new SpriteSheet(ImageLoader.loadImage("/textures/blockSheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/playerSheet.png"));
		
		//monster sheets
		SpriteSheet goblinSheet = new SpriteSheet(ImageLoader.loadImage("/textures/goblinSheet.png"));
		SpriteSheet goblinSwordSheet = new SpriteSheet(ImageLoader.loadImage("/textures/goblinSwordSheet.png"));
		SpriteSheet camelSheet = new SpriteSheet(ImageLoader.loadImage("/textures/camelSheet.png"));
		SpriteSheet snakeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/snakeSheet.png"));
		SpriteSheet lizardSheet = new SpriteSheet(ImageLoader.loadImage("/textures/lizardSheet.png"));
		SpriteSheet blackDragonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/blackDragonSheet.png"));
		SpriteSheet redDragonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/redDragonSheet.png"));

		// Menu
		btn_start = new BufferedImage[2];
		btn_quit = new BufferedImage[2];

		btn_start[0] = playerSheet.crop(3 * widthP, 0 * heightP, 2 * widthP, heightP);
		btn_start[1] = playerSheet.crop(3 * widthP, 1 * heightP, 2 * widthP, heightP);
		btn_quit[0] = playerSheet.crop(3 * widthP, 2 * heightP, 2 * widthP, heightP);
		btn_quit[1] = playerSheet.crop(3 * widthP, 3 * heightP, 2 * widthP, heightP);

		// player

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_downR = new BufferedImage[2];
		player_upR = new BufferedImage[2];
		player_downL = new BufferedImage[2];
		player_upL = new BufferedImage[2];
		
		//monsters
		
		goblin_up = new BufferedImage[7];
		goblin_down = new BufferedImage[7];
		goblin_left = new BufferedImage[7];
		goblin_right = new BufferedImage[7];
		
		goblinS_up = new BufferedImage[7];
		goblinS_down = new BufferedImage[7];
		goblinS_left = new BufferedImage[7];
		goblinS_right = new BufferedImage[7];
		
		camel_up = new BufferedImage[3];
		camel_down = new BufferedImage[3];
		camel_left = new BufferedImage[3];
		camel_right = new BufferedImage[3];
		
		snake_up = new BufferedImage[4];
		snake_down = new BufferedImage[4];
		snake_left = new BufferedImage[4];
		snake_right = new BufferedImage[4];
		
		lizard_up = new BufferedImage[6];
		lizard_down = new BufferedImage[6];
		lizard_left = new BufferedImage[6];
		lizard_right = new BufferedImage[6];
		
		blackDragon_up = new BufferedImage[4];
		blackDragon_down = new BufferedImage[4];
		blackDragon_left = new BufferedImage[4];
		blackDragon_right = new BufferedImage[4];
		
		redDragon_up = new BufferedImage[3];
		redDragon_down = new BufferedImage[3];
		redDragon_left = new BufferedImage[3];
		redDragon_right = new BufferedImage[3];
		//item
		
		gold = new BufferedImage[9];
		
		
		player = playerSheet.crop(2 * widthP, 0 * heightP, widthP, heightP);

		player_up[0] = playerSheet.crop(2 * widthP, 6 * heightP, widthP, heightP);
		player_up[1] = playerSheet.crop(3 * widthP, 6 * heightP, widthP, heightP);
		player_down[0] = playerSheet.crop(0 * widthP, 6 * heightP, widthP, heightP);
		player_down[1] = playerSheet.crop(1 * widthP, 6 * heightP, widthP, heightP);
		player_left[0] = playerSheet.crop(0 * widthP, 2 * heightP, widthP, heightP);
		player_left[1] = playerSheet.crop(0 * widthP, 3 * heightP, widthP, heightP);
		player_right[0] = playerSheet.crop(1 * widthP, 2 * heightP, widthP, heightP);
		player_right[1] = playerSheet.crop(1 * widthP, 3 * heightP, widthP, heightP);

		player_upR[0] = playerSheet.crop(2 * widthP, 5 * heightP, widthP, heightP);
		player_upR[1] = playerSheet.crop(3 * widthP, 5 * heightP, widthP, heightP);
		player_downR[0] = playerSheet.crop(0 * widthP, 5 * heightP, widthP, heightP);
		player_downR[1] = playerSheet.crop(1 * widthP, 5 * heightP, widthP, heightP);
		player_upL[0] = playerSheet.crop(2 * widthP, 4 * heightP, widthP, heightP);
		player_upL[1] = playerSheet.crop(3 * widthP, 4 * heightP, widthP, heightP);
		player_downL[0] = playerSheet.crop(0 * widthP, 4 * heightP, widthP, heightP);
		player_downL[1] = playerSheet.crop(1 * widthP, 4 * heightP, widthP, heightP);

		///////// MONSTERS/////////////////
		//goblin 
		goblin_up[0] = goblinSheet.crop(0*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[1] = goblinSheet.crop(1*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[2] = goblinSheet.crop(2*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[3] = goblinSheet.crop(3*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[4] = goblinSheet.crop(4*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[5] = goblinSheet.crop(5*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_up[6] = goblinSheet.crop(6*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblin_down[0] = goblinSheet.crop(0*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[1] = goblinSheet.crop(1*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[2] = goblinSheet.crop(2*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[3] = goblinSheet.crop(3*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[4] = goblinSheet.crop(4*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[5] = goblinSheet.crop(5*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_down[6] = goblinSheet.crop(6*widthGoblin, 0, widthGoblin, heightGoblin);
		goblin_left[0] = goblinSheet.crop(0*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[1] = goblinSheet.crop(1*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[2] = goblinSheet.crop(2*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[3] = goblinSheet.crop(3*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[4] = goblinSheet.crop(4*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[5] = goblinSheet.crop(5*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_left[6] = goblinSheet.crop(6*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[0] = goblinSheet.crop(0*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[1] = goblinSheet.crop(1*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[2] = goblinSheet.crop(2*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[3] = goblinSheet.crop(3*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[4] = goblinSheet.crop(4*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[5] = goblinSheet.crop(5*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblin_right[6] = goblinSheet.crop(6*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		// goblin with sword
		goblinS_up[0] = goblinSwordSheet.crop(0*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[1] = goblinSwordSheet.crop(1*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[2] = goblinSwordSheet.crop(2*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[3] = goblinSwordSheet.crop(3*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[4] = goblinSwordSheet.crop(4*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[5] = goblinSwordSheet.crop(5*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_up[6] = goblinSwordSheet.crop(6*widthGoblin, 2*heightGoblin, widthGoblin, heightGoblin);
		goblinS_down[0] = goblinSwordSheet.crop(0*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[1] = goblinSwordSheet.crop(1*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[2] = goblinSwordSheet.crop(2*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[3] = goblinSwordSheet.crop(3*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[4] = goblinSwordSheet.crop(4*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[5] = goblinSwordSheet.crop(5*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_down[6] = goblinSwordSheet.crop(6*widthGoblin, 0, widthGoblin, heightGoblin);
		goblinS_left[0] = goblinSwordSheet.crop(0*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[1] = goblinSwordSheet.crop(1*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[2] = goblinSwordSheet.crop(2*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[3] = goblinSwordSheet.crop(3*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[4] = goblinSwordSheet.crop(4*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[5] = goblinSwordSheet.crop(5*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_left[6] = goblinSwordSheet.crop(6*widthGoblin, 3*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[0] = goblinSwordSheet.crop(0*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[1] = goblinSwordSheet.crop(1*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[2] = goblinSwordSheet.crop(2*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[3] = goblinSwordSheet.crop(3*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[4] = goblinSwordSheet.crop(4*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[5] = goblinSwordSheet.crop(5*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);
		goblinS_right[6] = goblinSwordSheet.crop(6*widthGoblin, 1*heightGoblin, widthGoblin, heightGoblin);

		
		camel_up[0] = camelSheet.crop(0*widthCamel, 3*heightCamel, widthCamel, heightCamel);
		camel_up[1] = camelSheet.crop(1*widthCamel, 3*heightCamel, widthCamel, heightCamel);
		camel_up[2] = camelSheet.crop(2*widthCamel, 3*heightCamel, widthCamel, heightCamel);
		camel_down[0] = camelSheet.crop(0*widthCamel, 0*heightCamel, widthCamel, heightCamel);
		camel_down[1] = camelSheet.crop(1*widthCamel, 0*heightCamel, widthCamel, heightCamel);
		camel_down[2] = camelSheet.crop(2*widthCamel, 0*heightCamel, widthCamel, heightCamel);
		camel_left[0] = camelSheet.crop(0*widthCamel, 1*heightCamel, widthCamel, heightCamel);
		camel_left[1] = camelSheet.crop(1*widthCamel, 1*heightCamel, widthCamel, heightCamel);
		camel_left[2] = camelSheet.crop(2*widthCamel, 1*heightCamel, widthCamel, heightCamel);
		camel_right[0] = camelSheet.crop(0*widthCamel, 2*heightCamel, widthCamel, heightCamel);
		camel_right[1] = camelSheet.crop(1*widthCamel, 2*heightCamel, widthCamel, heightCamel);
		camel_right[2] = camelSheet.crop(2*widthCamel, 2*heightCamel, widthCamel, heightCamel);
		
		snake_up[0] = snakeSheet.crop(0*widthsnake, 3*heightsnake, widthsnake, heightsnake);
		snake_up[1] = snakeSheet.crop(1*widthsnake, 3*heightsnake, widthsnake, heightsnake);
		snake_up[2] = snakeSheet.crop(2*widthsnake, 3*heightsnake, widthsnake, heightsnake);
		snake_up[3] = snakeSheet.crop(3*widthsnake, 3*heightsnake, widthsnake, heightsnake);
		snake_down[0] = snakeSheet.crop(0*widthsnake, 0*heightsnake, widthsnake, heightsnake);
		snake_down[1] = snakeSheet.crop(1*widthsnake, 0*heightsnake, widthsnake, heightsnake);
		snake_down[2] = snakeSheet.crop(2*widthsnake, 0*heightsnake, widthsnake, heightsnake);
		snake_down[3] = snakeSheet.crop(3*widthsnake, 0*heightsnake, widthsnake, heightsnake);
		snake_left[0] = snakeSheet.crop(0*widthsnake, 1*heightsnake, widthsnake, heightsnake);
		snake_left[1] = snakeSheet.crop(1*widthsnake, 1*heightsnake, widthsnake, heightsnake);
		snake_left[2] = snakeSheet.crop(2*widthsnake, 1*heightsnake, widthsnake, heightsnake);
		snake_left[3] = snakeSheet.crop(3*widthsnake, 1*heightsnake, widthsnake, heightsnake);
		snake_right[0] = snakeSheet.crop(0*widthsnake, 2*heightsnake, widthsnake, heightsnake);
		snake_right[1] = snakeSheet.crop(1*widthsnake, 2*heightsnake, widthsnake, heightsnake);
		snake_right[2] = snakeSheet.crop(2*widthsnake, 2*heightsnake, widthsnake, heightsnake);
		snake_right[3] = snakeSheet.crop(3*widthsnake, 2*heightsnake, widthsnake, heightsnake);
		
		lizard_up[0] = lizardSheet.crop(0*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_up[1] = lizardSheet.crop(1*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_up[2] = lizardSheet.crop(2*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_up[3] = lizardSheet.crop(3*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_up[4] = lizardSheet.crop(4*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_up[5] = lizardSheet.crop(5*widthLizard, 4*heightLizard1 + 3+ 2*heightLizard2, widthLizard, heightLizard2);
		lizard_down[0] = lizardSheet.crop(0*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_down[1] = lizardSheet.crop(1*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_down[2] = lizardSheet.crop(2*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_down[3] = lizardSheet.crop(3*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_down[4] = lizardSheet.crop(4*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_down[5] = lizardSheet.crop(5*widthLizard, 4*heightLizard1 + 3, widthLizard, heightLizard2);
		lizard_left[0] = lizardSheet.crop(0*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_left[1] = lizardSheet.crop(1*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_left[2] = lizardSheet.crop(2*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_left[3] = lizardSheet.crop(3*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_left[4] = lizardSheet.crop(4*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_left[5] = lizardSheet.crop(5*widthLizard, 2*heightLizard1, widthLizard, heightLizard1);
		lizard_right[0] = lizardSheet.crop(0*widthLizard, 0, widthLizard, heightLizard1);
		lizard_right[1] = lizardSheet.crop(1*widthLizard, 0, widthLizard, heightLizard1);
		lizard_right[2] = lizardSheet.crop(2*widthLizard, 0, widthLizard, heightLizard1);
		lizard_right[3] = lizardSheet.crop(3*widthLizard, 0, widthLizard, heightLizard1);
		lizard_right[4] = lizardSheet.crop(4*widthLizard, 0, widthLizard, heightLizard1);
		lizard_right[5] = lizardSheet.crop(5*widthLizard, 0, widthLizard, heightLizard1);
		
		blackDragon_up[0] = blackDragonSheet.crop(0*widthBdragon, 3*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_up[1] = blackDragonSheet.crop(1*widthBdragon, 3*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_up[2] = blackDragonSheet.crop(2*widthBdragon, 3*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_up[3] = blackDragonSheet.crop(3*widthBdragon, 3*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_down[0] = blackDragonSheet.crop(0*widthBdragon, 0*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_down[1] = blackDragonSheet.crop(1*widthBdragon, 0*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_down[2] = blackDragonSheet.crop(2*widthBdragon, 0*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_down[3] = blackDragonSheet.crop(3*widthBdragon, 0*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_left[0] = blackDragonSheet.crop(0*widthBdragon, 1*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_left[1] = blackDragonSheet.crop(1*widthBdragon, 1*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_left[2] = blackDragonSheet.crop(2*widthBdragon, 1*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_left[3] = blackDragonSheet.crop(3*widthBdragon, 1*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_right[0] = blackDragonSheet.crop(0*widthBdragon, 2*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_right[1] = blackDragonSheet.crop(1*widthBdragon, 2*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_right[2] = blackDragonSheet.crop(2*widthBdragon, 2*heightBdragon, widthBdragon, heightBdragon);
		blackDragon_right[3] = blackDragonSheet.crop(3*widthBdragon, 2*heightBdragon, widthBdragon, heightBdragon);
		
		redDragon_up[0] = redDragonSheet.crop(0*widthRdragon, 3*heightRdragon, widthRdragon, heightRdragon);
		redDragon_up[1] = redDragonSheet.crop(1*widthRdragon, 3*heightRdragon, widthRdragon, heightRdragon);
		redDragon_up[2] = redDragonSheet.crop(2*widthRdragon, 3*heightRdragon, widthRdragon, heightRdragon);
		redDragon_down[0] = redDragonSheet.crop(0*widthRdragon, 0*heightRdragon, widthRdragon, heightRdragon);
		redDragon_down[1] = redDragonSheet.crop(1*widthRdragon, 0*heightRdragon, widthRdragon, heightRdragon);
		redDragon_down[2] = redDragonSheet.crop(2*widthRdragon, 0*heightRdragon, widthRdragon, heightRdragon);
		redDragon_left[0] = redDragonSheet.crop(0*widthRdragon, 1*heightRdragon, widthRdragon, heightRdragon);
		redDragon_left[1] = redDragonSheet.crop(1*widthRdragon, 1*heightRdragon, widthRdragon, heightRdragon);
		redDragon_left[2] = redDragonSheet.crop(2*widthRdragon, 1*heightRdragon, widthRdragon, heightRdragon);
		redDragon_right[0] = redDragonSheet.crop(0*widthRdragon, 2*heightRdragon, widthRdragon, heightRdragon);
		redDragon_right[1] = redDragonSheet.crop(1*widthRdragon, 2*heightRdragon, widthRdragon, heightRdragon);
		redDragon_right[2] = redDragonSheet.crop(2*widthRdragon, 2*heightRdragon, widthRdragon, heightRdragon);
		//////////////////// ITEMS/////////////
		// inventoryScreen
		inventoryScreen = ImageLoader.loadImage("/textures/inventory.png");
		// playerscreen
		playerScreen = ImageLoader.loadImage("/textures/playerScreen.png");
		// gold
		goldBag = entitySheet.crop(8*width, 0*height, width, height);
		
		gold[0] = entitySheet.crop(0*width, 10*height, width, height); 
		gold[1] = entitySheet.crop(1*width, 10*height, width, height); 
		gold[2] = entitySheet.crop(2*width, 10*height, width, height); 
		gold[3] = entitySheet.crop(3*width, 10*height, width, height); 
		gold[4] = entitySheet.crop(4*width, 10*height, width, height); 
		gold[5] = entitySheet.crop(5*width, 10*height, width, height); 
		gold[6] = entitySheet.crop(6*width, 10*height, width, height); 
		gold[7] = entitySheet.crop(7*width, 10*height, width, height); 
		gold[8] = entitySheet.crop(8*width, 10*height, width, height); 
		// wood
		surfaceTreeWood = entitySheet.crop(3 * width, 0 * height, width, height);
		desertTreeWood = entitySheet.crop(4 * width, 0 * height, width, height);
		// ores
		surfaceOre = entitySheet.crop(3 * width, 1 * height, width, height);
		desertOre = entitySheet.crop(4 * width, 1 * height, width, height);
		caveOre = entitySheet.crop(5 * width, 1 * height, width, height);

		// stone
		surfaceRock = entitySheet.crop(0 * width, 4 * height, 2 * width, 2 * height);
		surfaceRock2 = entitySheet.crop(2 * width, 4 * height, 2 * width, 2 * height);
		surfaceRock3 = entitySheet.crop(4 * width, 4 * height, width, 2 * height);
		desertRock = entitySheet.crop(0 * width, 2 * height, 2 * width, 2 * height);
		desertRock2 = entitySheet.crop(2 * width, 2 * height, 2 * width, 2 * height);
		desertRock3 = entitySheet.crop(4 * width, 2 * height, width, 2 * height);
		caveRock = entitySheet.crop(0 * width, 6 * height, 2 * width, 2 * height);
		caveRock2 = entitySheet.crop(2 * width, 6 * height, 2 * width, 2 * height);
		caveRock3 = entitySheet.crop(4 * width, 6 * height, width, 2 * height);

		// tree
		surfaceTree = entitySheet.crop(0, 0, width, 2 * height);
		desertTree = entitySheet.crop(width, 0 * height, 2 * width, 2 * height);
		caveTree = entitySheet.crop(0, 0, width, 2 * height);

		// water
		desert_water = entitySheet.crop(5 * width, 2 * height, 3 * width, 3 * height);
		desert_water2 = entitySheet.crop(8 * width, 2 * height, width, 2 * height);
		// sand
		desert_sandpile = entitySheet.crop(5 * width, 5 * height, 3 * width, 3 * height);
		// spike
		desert_spike = entitySheet.crop(8 * width, 5 * height, width, height);
		// tiles
		tryDirt = blockSheet.crop(0, 5 * height, 2 * width, 2 * height);
		tryDirtWall = blockSheet.crop(4 * width, 0 * height, width, height);
		dirt = blockSheet.crop(0, 0, width, height);
		grass = blockSheet.crop(width, 0, width, height);
		stone = blockSheet.crop(2 * width, 0, width, height);
		darkWallStone = blockSheet.crop(0 * width, height, 2 * width, 2 * height);
		darkFloorStone3 = blockSheet.crop(2 * width, height, 2 * width, 2 * height);
		darkFloorStone2 = blockSheet.crop(4 * width, height, 2 * width, 2 * height);
		darkFloorStone1 = blockSheet.crop(6 * width, height, 2 * width, 2 * height);

		// doors
		cave_door = blockSheet.crop(0 * width, 3 * height, 2 * width, 2 * height);
		surface_door = blockSheet.crop(3 * width, 0 * height, width, height);
		desert_door = blockSheet.crop(6 * width, 0 * height, width, height);
		surfaceToDesert_door = blockSheet.crop(5 * width, 0 * height, width, height);

	}
}
