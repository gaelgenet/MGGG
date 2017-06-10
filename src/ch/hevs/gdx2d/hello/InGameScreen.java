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
	Collision collision;
	IngotManager ingots;
	EggDofusManager eggs;
	BirdManager bird;
	Bachground background;
	DragonBonusManager dragonManager;
	StorageBonhomme storageBonhomme;


	int keycode;
	public boolean move = false;
	static boolean change = true;

	@Override
	public void onInit() {
		bonhomme = new Bonhomme();
		cManager = new CubeManager();
		collision = new Collision();
		ingots = new IngotManager();
		eggs = new EggDofusManager();
		bird = new BirdManager();
		background = new Bachground();
		dragonManager = new DragonBonusManager();
		storageBonhomme = new StorageBonhomme();

		bonhomme.onInit();
		cManager.generateInitialCubes();
		bird.generatefirstbird();
		ingots.generatefirstingot();
		eggs.generatefirstegg();
		background.onInit();
		dragonManager.generatefirstBonus();
		new PhysicsScreenBoundaries(HelloWorld.WINDOWS_WIDTH, 100);

	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		background.draw(g);
		bonhomme.draw(g);
		bird.generateBird();
		bird.moveTotalBird(g);
		bird.distroyBird();
		cManager.speedCube(g);
		cManager.generatecube();
		cManager.distroyCube();

		dragonManager.generateBonus();
		dragonManager.moveBonus(g);
		dragonManager.Destroy(Collision.bonus(dragonManager.bonus.lastElement(), bonhomme));

		switch (StartScreen.world) {

		default:
		case 0:
			ingots.generateIngot();
			ingots.moveingot(g);
			ingots.comptableIngotAndDestroy(Collision.scored(ingots.ingot.elementAt(0), bonhomme));
			g.drawString(600, 680, "Nombre of COINS : " + ingots.nbreIngot);
			break;

		case 1:
			eggs.generateEgg();
			eggs.moveegg(g);
			eggs.comptableEggAndDestroy(Collision.scored1(eggs.eggs.elementAt(0), bonhomme));
			g.drawString(600, 680, "Nombre of EGGS : " + eggs.nbreEgg);
			break;
		}

		if (DragonBonusManager.dragon == false) {
			bonhomme.physics_update(Collision.collides(cManager.cubes.get(0), bonhomme, cManager.speed), cManager);
		}

		bonhomme.moveBonhomme();
		keycode = 0;
		// Logger.log("salut : " + Bonhomme.sex);

		storageBonhomme.storage();

		g.drawString(700, 700, "score : " + bonhomme.score);

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
