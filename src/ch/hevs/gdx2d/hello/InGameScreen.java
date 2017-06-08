package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Input;
import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.components.physics.utils.PhysicsScreenBoundaries;
import ch.hevs.gdx2d.components.screen_management.RenderingScreen;
import ch.hevs.gdx2d.hello.Collision.CollisionType;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class InGameScreen extends RenderingScreen {

	// Attributes
	// parameter for the physique of the screen
	Bonhomme bonhomme;
	CubeManager cManager;
	KeyListener keyListener;
	Collision collision;
	GoldIngotManager ingots;
	BirdManager bird;
	Bachground background;
	DragonBonusManager dragonManager;

	int keycode;
	public boolean move = false;
	static boolean change = true;


	@Override
	public void onInit() {
		bonhomme = new Bonhomme();
		cManager = new CubeManager();
		collision = new Collision();
		ingots = new GoldIngotManager();
		bird = new BirdManager();
		background = new Bachground();
		// background = new BitmapImage("data/images/background.png");
		bonhomme.onInit();
		cManager.generateInitialCubes();
		dragonManager = new DragonBonusManager();

		bird.generatefirstbird();
		ingots.generatefirstingot();
		background.onInit();
		new PhysicsScreenBoundaries(HelloWorld.WINDOWS_WIDTH, 100);
		// Check if game over and switch to ending screen if necessary
		// if (bonhomme.dead == true) {
		// Logger.log("bonjour");
		// Screens.getInstance().s.activateNextScreen();
		// }
	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		background.draw(g);
		bonhomme.draw(g);
		ingots.generateIngot();
		ingots.moveingot(g);
		bird.generateBird();
		bird.moveTotalBird(g);
		bird.distroyBird();
		cManager.speedCube(g);
		cManager.generatecube();
		cManager.distroyCube();
		ingots.comptableIngotAndDestroy(Collision.scored(ingots.ingot.elementAt(0), bonhomme));
		
		if (DragonBonusManager.dragon == false) {
			bonhomme.physics_update(Collision.collides(cManager.cubes.get(0), bonhomme, cManager.speed), cManager);
		}
		
		if(DragonBonusManager.activeBonus == true){
			//dragonManager.generateBonus();
			dragonManager.generatefirstBonus();
			dragonManager.moveBonus(g);
			dragonManager.Destroy(Collision.bonus(dragonManager.bonus.elementAt(0), bonhomme));
		}
		

		bonhomme.moveBonhomme();
		keycode = 0;
		Logger.log("salut : " + Bonhomme.sex);

		if (Bonhomme.sex == 3) {
			Bonhomme.offset = 200;
			Bonhomme.SPRITE_WIDTH = 150;
			Bonhomme.SPRITE_HEIGHT = 147;
			DragonBonusManager.dragon = false;
			// Bonhomme.cubeHeight =
			Bonhomme.sprites = new Spritesheet("data/images/dragon1.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);

		}

		g.drawString(700, 700, "score : " + bonhomme.score);
		g.drawString(600, 680, "Nombre of COINS : " + ingots.nbreIngot);
	}

	@Override
	public void onKeyDown(int keycode) {
		super.onKeyDown(keycode);
		switch (keycode) {

		// jump
		case Input.Keys.SPACE:
			bonhomme.jump(Collision.collides(cManager.cubes.get(0), bonhomme, cManager.speed));
			break;

		// pause-play
		case Input.Keys.SHIFT_RIGHT:
			if (change) {
				Cube.play = false;
				CubeManager.play = false;
				change = false;
			} else {
				Cube.play = true;
				CubeManager.play = true;
				change = true;
			}
			break;

		default:
			break;
		}
	}
}
