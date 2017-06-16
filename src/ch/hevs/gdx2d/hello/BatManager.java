package ch.hevs.gdx2d.hello;


import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class generate random bats and make them move
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class BatManager {
	
	//Attributes
	Vector<Bat> bats = new Vector<Bat>();

	// parameter of the random generator
	float dt;
	float speed = -4;
	float variablespeed = 3f;

	// position of the birds
	int posx = 1000;
	int posy = 0;

	/**
	 * generate random position of the bat
	 */
	void generatebat() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {

			dt = 0;
			posx = (int) (Math.random() * 7000);
			if (posx < 800 || posx > 2500) {
				posx = 1000;
			}
			posy = (int) (Math.random() * 800);

			if (posy < 300 || posy > 700) {
				posy = 580;
			}

			bats.add(new Bat(posx, posy));

		}

	}

	/**
	 * remove the bat when they are no longer visible
	 */
	void distroybat() {
		if (bats.get(0).posX < -100) {
			bats.remove(0);
		}
	}

	/**
	 * movement of the bat and draw them
	 * @param g
	 */
	public void moveTotalBat(GdxGraphics g) {
		for (Bat b : bats) {
			b.draw(g);
			b.moveBat();
		}
	}

	/**
	 * generate first bat
	 */
	public void generatefirstbat() {
		bats.add(new Bat(1200, 300));
		bats.add(new Bat(1800, 300));

	}

}
