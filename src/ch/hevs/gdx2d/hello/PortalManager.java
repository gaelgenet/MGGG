package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.hello.Collision.CollisionPortal;
import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class manage the creation of the portals and make them move
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class PortalManager {
	// Attributes
	Portal portal = new Portal();

	/**
	 * manager of the portal
	 * @param bonhomme
	 * @param g
	 */
	public void Manager(Bonhomme bonhomme, GdxGraphics g) {

		portal.createPortal();

		//condition to move the portal and condition to change the sex and the world
		
		if (Collision.portal(portal, bonhomme) == CollisionPortal.OUT && portal.createPortal == true && Bonhomme.sexCharacter != 3) {
			portal.movePortal();
			portal.updateSquarre();
			portal.draw(g);

		} else if (Collision.portal(portal, bonhomme) == CollisionPortal.IN && portal.createPortal == true) {

			if (Bonhomme.sexCharacter != 4) {
				StartScreen.world = 1;
				Bonhomme.sexCharacter = 4;
				portal.updatePos();
				portal.createPortal = false;
			} else {
				if (StartScreen.playerChoise == 1) {
					Bonhomme.sexCharacter = 1;
				} else if (StartScreen.playerChoise == 2) {
					Bonhomme.sexCharacter = 2;
				}
				StartScreen.world = 0;
				portal.updatePos();
				portal.createPortal = false;
			}
		}
	}

}
