package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * cette class gere la creation des lingots et leurs déplacements
 * 
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class IngotManager {

	// vector
	Vector<IngotBonus> ingot = new Vector<IngotBonus>();

	// paramter of time
	float dt;
	float speedTime;
	float speed = -4f;
	float variablespeed = 2f;

	// variable compte ingot
	public static int nbreIngot = 0;

	// parameter positions
	int posx = 1150;
	int posy = 0;

	/**
	 * generate ingot
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
	 * comptable score ingot and destroy this
	 * @param collide
	 */
	public void comptableIngotAndDestroy(Collision.CollisionGold collide) {
		
		// comptable and destroy during collision
		if (collide == CollisionGold.IN) {
			nbreIngot++;
			ingot.remove(0);

			if (nbreIngot % 20 == 0) {
				DragonBonusManager.activeDragonBonus = true;
			}
		}

		// reinitialize player afther dragonbonus
		if (nbreIngot % 8 == 0 && Bonhomme.sexCharacter == 3) {

			if (CubeManager.position < 305 && CubeManager.position > 300) {
				DragonBonusManager.dragon = false;
				Bonhomme.sexCharacter = StartScreen.playerChoise;
			}
		}
		
		// destroy of the bird when he is not any more visible
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
