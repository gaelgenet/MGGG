package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * this class manage the creation of random ingots and their movement
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class IngotManager {

	// Attributes
	Vector<IngotBonus> ingot = new Vector<IngotBonus>();

	// paramter of time
	float dt;
	float speedTime;
	float speed = -4f;
	float variablespeed = 2f;

	// number of ingot recolted
	public static int nbreIngot = 0;

	// parameter positions
	int posx = 1150;
	int posy = 0;

	/**
	 * generate ingots
	 */
	void generateIngot() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {
			dt = 0;
			posy = 500;
			ingot.add(new IngotBonus(posx, posy));

		}
	}

	/**
	 * count the number of ingot recolted and destroy them if need it.
	 * @param collide
	 */
	public void comptableIngotAndDestroy(Collision.CollisionGold collide) {
		
		// count and remove if their is a collsion between the man and the ingot
		if (collide == CollisionGold.IN) {
			nbreIngot++;
			ingot.remove(0);
		}
		
		// remove the ingot when hthey are not any more visible
		if (ingot.get(0).posX < -15)		{
			ingot.remove(0);
		}
	}

	/**
	 * movement of ingot and drawing
	 * 
	 * @param g
	 */
	public void moveingot(GdxGraphics g) {

		if (CubeManager.speedTime > 7) {
			speed -= 0.2;
			speedTime = 0;
		}
		for (IngotBonus i : ingot) {
			i.draw(g);
			i.updateSquarre();
			i.moveIngot(speed);
		}
	}

	/**
	 * generate first eggs
	 */
	public void generatefirstingot() {
		ingot.add(new IngotBonus(500, 500));
		ingot.add(new IngotBonus(1200, 500));

	}

}
