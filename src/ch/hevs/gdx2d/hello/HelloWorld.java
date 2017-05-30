package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import ch.hevs.gdx2d.components.physics.utils.PhysicsScreenBoundaries;
import ch.hevs.gdx2d.lib.GdxGraphics;

import ch.hevs.gdx2d.lib.physics.PhysicsWorld;
import ch.hevs.gdx2d.lib.utils.Logger;
import ch.hevs.gdx2d.desktop.PortableApplication;
import ch.hevs.gdx2d.desktop.physics.DebugRenderer;
import ch.hevs.gdx2d.hello.Collision.CollisionType;

/**
 * Hello World demo.
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 2.1
 */
public class HelloWorld extends PortableApplication {

	public HelloWorld(int x, int y) {
		super(x, y);
	}

	// parameter for the physique of the screen
	DebugRenderer dbgRenderer;
	World world = PhysicsWorld.getInstance();
	Bonhomme bonhomme = new Bonhomme();
	CubeManager cManager = new CubeManager();
	KeyListener keyListener;
	Collision collision;
	Mur mur = new Mur();
	int keycode;
	public boolean move = false;

	@Override

	public void onInit() {
		bonhomme.onInit();
		cManager.generatecube();
		cManager.generateInitialCubes();
		// cManager.onInit();

		// mur.onInit();
		world.setGravity(new Vector2(0, -5));
		// new PhysicsScreenBoundaries(Bonhomme.SPRITE_WIDTH + 100,
		// getWindowHeight());
		new PhysicsScreenBoundaries(this.getWindowWidth(), 100);
		dbgRenderer = new DebugRenderer();
	}

	@Override
	public void onKeyDown(int keycode) {
		super.onKeyDown(keycode);
		bonhomme.jump();
	}
	
	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		dbgRenderer.render(world, g.getCamera().combined);
		bonhomme.draw(g);
		cManager.speedCube(g);
		// mur.draw(g);
		cManager.generatecube();
		cManager.distroyCube();
		bonhomme.physics_update(Collision.collides(cManager.cubes.get(0), bonhomme), cManager);

//		for (Cube c : cManager.cubes)
			Logger.log("position of the cube " + cManager.cubes.get(0).rectangle.x);
			Logger.log("Collision " + Collision.collides(cManager.cubes.get(0), bonhomme));
			//Logger.log("Collision " + Collision.collides(cManager.cubes.get(1), bonhomme));

		bonhomme.moveBonhomme();
		keycode = 0;
	}

	public static void main(String[] args) {
		new HelloWorld(800, 700);
	}

}
