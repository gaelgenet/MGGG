package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Input;
import ch.hevs.gdx2d.components.audio.MusicPlayer;
import ch.hevs.gdx2d.components.screen_management.RenderingScreen;
import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * the seconde screen of the game. The one who manage the game
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 2.1
 */

public class InGameScreen extends RenderingScreen {

	// Class' attributs
	Bonhomme bonhomme;
	CubeManager cManager;
	Collision collision;
	IngotManager ingots;
	EggDofusManager eggs;
	BirdManager bird;
	Background background;
	DragonBonusManager dragonManager;
	StorageBonhomme storageBonhomme;
	PortalManager zaapManager;

	static MusicPlayer fear = new MusicPlayer("data/musiques/peur2.mp3");

	static boolean change = true;

	/**
	 * initialize the instances
	 */
	@Override
	public void onInit() {
		bonhomme = new Bonhomme();
		cManager = new CubeManager();
		collision = new Collision();
		ingots = new IngotManager();
		eggs = new EggDofusManager();
		bird = new BirdManager();
		background = new Background();
		dragonManager = new DragonBonusManager();
		storageBonhomme = new StorageBonhomme();
		zaapManager = new PortalManager();
		bonhomme.onInit();
		cManager.generateInitialCubes();
		bird.generatefirstbird();
		ingots.generatefirstingot();
		eggs.generatefirstegg();
		background.onInit();
	}

	/**
	 * load the differente methode which the game need
	 */
	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.drawFPS();
		background.draw(g);
		bonhomme.draw(g);
		bird.generateBird();
		bird.moveTotalBird(g);
		bird.distroyBird();
		cManager.speedCube(g);
		cManager.generatecube();
		cManager.distroyCube();
		dragonManager.Manager(bonhomme, g);
		zaapManager.Manager(bonhomme, g);
		fear.loop();
		bonhomme.moveBonhomme();
		storageBonhomme.storage();
		g.drawString(700, 700, "score : " + Bonhomme.score);

		// switch between the eggs and the ingot
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

		//remove the physic of the game if the character is the dragon flying
		if (Bonhomme.sexCharacter != 3) {
			bonhomme.physics_update(Collision.collides(cManager.cubes.get(0), bonhomme, cManager.speed), cManager);

		}

	}
/**
 * space to jump and shift-right to make a break
 */
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
