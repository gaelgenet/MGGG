package ch.hevs.gdx2d.hello;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import ch.hevs.gdx2d.components.physics.utils.PhysicsScreenBoundaries;
import ch.hevs.gdx2d.lib.GdxGraphics;

import ch.hevs.gdx2d.lib.physics.PhysicsWorld;
import ch.hevs.gdx2d.desktop.PortableApplication;
import ch.hevs.gdx2d.desktop.physics.DebugRenderer;

/**
 * Hello World demo.
 *
 * @author Marco Goncalves (MG)
 * @author Ga�l Genet (GG)
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
	Mur mur = new Mur();
	int keycode;

	@Override

	public void onInit() {
		bonhomme.onInit();
		CubeManager.generateInitialCubes();
		mur.onInit();
		world.setGravity(new Vector2(0, -5));
//		new PhysicsScreenBoundaries(Bonhomme.SPRITE_WIDTH + 100, getWindowHeight());
		new PhysicsScreenBoundaries(this.getWindowWidth(), 100);
		dbgRenderer = new DebugRenderer();
	}

	public void onPhysicRender() {
//		PhysicsWorld.updatePhysics();
	}

	@Override
	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		dbgRenderer.render(world, g.getCamera().combined);
		bonhomme.draw(g);
		CubeManager.drawCubes(g);
		mur.draw(g);
		
		bonhomme.onKeyUp(keycode);
		bonhomme.moveBonhomme();
		keycode = 0;
		onPhysicRender();

	}

	public void onKeyUp(int keycode) {
		this.keycode = keycode;

	}

	public static void main(String[] args) {
		new HelloWorld(800, 700);
	}

}
