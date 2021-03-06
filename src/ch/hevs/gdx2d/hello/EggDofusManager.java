package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionEgg;
import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class generate the creation of the eggs and their movement
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class EggDofusManager {

	// vattributes
	Vector<EggDofus> eggs = new Vector<EggDofus>();

	// paramter of time
	float dt;
	float speedTime;
	float speed = -4f;
	float variablespeed = 2f;

	//positions
	int posx = 1150;
	int posy = 500;

	// the number of eggs taken
	public static int nbreEgg = 0;

	/**
	 * generate egg
	 */
	void generateEgg() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {
			dt = 0;
			eggs.add(new EggDofus(posx, posy));
		}
	}

	/**
	 * count the eggs recolted
	 * destroy them after a while
	 * 
	 * @param collide
	 */
	public void comptableEggAndDestroy(Collision.CollisionEgg collide) {

		// count and destroy if collision is made
		if (collide == CollisionEgg.IN) {
			nbreEgg++;
			eggs.remove(0);
		}

		// destroy the eggs when they are no longer visible
		if (eggs.get(0).posX < -15) {
			eggs.remove(0);
		}

	}

	/**
	 * movement of egg and drawing
	 * 
	 * @param g
	 */
	public void moveegg(GdxGraphics g) {

		if (CubeManager.speedTime > 7) {
			speed -= 0.2;
			speedTime = 0;
		}
		for (EggDofus i : eggs) {
			i.draw(g);
			i.updateSquarre();
			i.moveEgg(speed);
		}
	}

	/**
	 * generate first eggs
	 */
	public void generatefirstegg() {
		eggs.add(new EggDofus(500, 400));
		eggs.add(new EggDofus(1200, 500));
	}

}
