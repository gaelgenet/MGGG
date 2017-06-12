package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.hello.Collision.CollisionZaap;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class ZaapManager {
	// class' instance
	Zaap zaap;

	/**
	 * instance a class
	 */
	public void instanceZaap() {
		zaap = new Zaap();
	}

	/**
	 * manager zaap
	 * 
	 * @param bonhomme
	 * @param g
	 */
	public void Manager(Bonhomme bonhomme, GdxGraphics g) {

		zaap.createZaap();

		/**
		 * condition to move the zaap and condition to change the sex and the
		 * world
		 */
		if (Collision.zaap(zaap, bonhomme) == CollisionZaap.OUT && zaap.createZaap == true && Bonhomme.sex != 3) {
			zaap.moveZaap();
			zaap.updateSquarre();
			zaap.draw(g);

		} else if (Collision.zaap(zaap, bonhomme) == CollisionZaap.IN && zaap.createZaap == true) {

			if (bonhomme.sex != 4) {
				StartScreen.world = 1;
				bonhomme.sex = 4;
				zaap.updatePos();
				zaap.createZaap = false;
			} else {
				if (StartScreen.playerChoise == 1) {
					bonhomme.sex = 1;
				} else if (StartScreen.playerChoise == 2) {
					bonhomme.sex = 2;
				}
				StartScreen.world = 0;
				zaap.updatePos();
				zaap.createZaap = false;
			}
		}
	}

}
