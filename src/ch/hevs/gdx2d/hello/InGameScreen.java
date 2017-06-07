package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Input;
import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
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
	GoldIngot ingot;
	BirdManager bird;
	Bachground background;
	int keycode;
	public boolean move = false;
	static boolean change = true;
	

	

	@Override
	public void onInit() {
		bonhomme = new Bonhomme();
		cManager = new CubeManager();
		collision = new Collision();
		ingot = new GoldIngot();
		bird = new BirdManager();
		background = new Bachground();
		// background = new BitmapImage("data/images/background.png");
		bonhomme.onInit();
		cManager.generateInitialCubes();
		ingot.onInit();
		bird.generatefirstbird();
		background.onInit();
		new PhysicsScreenBoundaries(HelloWorld.WINDOWS_WIDTH, 100);
		// Check if game over and switch to ending screen if necessary
//		if (bonhomme.dead == true) {
//			Logger.log("bonjour");
//			Screens.getInstance().s.activateNextScreen();
//		}
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
		ingot.drawingPositionIngot(cManager);
		ingot.draw(g);
		bonhomme.physics_update(Collision.collides(cManager.cubes.get(0), bonhomme,cManager.speed), cManager);

		// for (Cube c : cManager.cubes)
		//Logger.log("position of the cube " + cManager.cubes.get(0).rectangle.height);
		
		// Logger.log("Collision " + Collision.collides(cManager.cubes.get(1),
		// bonhomme));

		bonhomme.moveBonhomme();
		keycode = 0;
		
		g.drawString(700, 700, "score : " + bonhomme.score);
	}

	@Override
	public void onKeyDown(int keycode) {
		super.onKeyDown(keycode);
		switch (keycode) {

		// jump
		case Input.Keys.SPACE:
			bonhomme.jump(Collision.collides(cManager.cubes.get(0), bonhomme,cManager.speed));
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
