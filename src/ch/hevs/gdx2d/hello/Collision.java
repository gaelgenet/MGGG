package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.geometry.Point;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * The class is used to check the collision between the different object of the
 * game
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class Collision {

	// different type of collision between the man and the platform
	public enum CollisionType {
		NONE, TOP, LEFT, END
	};

	/**
	 * Method to check the collision between the man and the platform
	 * @param cube
	 * @param bonhomme
	 * @param bonhommeSpeedX
	 * @return
	 */
	public static CollisionType collides(Cube cube, Bonhomme bonhomme, float bonhommeSpeedX) {

		//check if the distance of the character's left corner is smaller than the right corner of the platform
		if ((bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4)) <= (cube.rectangle.x + (cube.rectangle.width / 2))
				&& (bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4)) - bonhommeSpeedX >= (cube.rectangle.x + (cube.rectangle.width / 2))) {
			if (!bonhomme.jump) {
				//Logger.log("Collision end");
				return CollisionType.END;
			}
		}
		
		//check if the bottom of character is higher than the platform
		if ((bonhomme.square.x + (Bonhomme.SPRITE_WIDTH / 4)) >= cube.rectangle.x - (cube.rectangle.width / 2)
				&& (bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4)) <= cube.rectangle.x + (cube.rectangle.width / 2)) {
			
			//when the character is above the platform --> TOP
			if ((bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2)) >= (cube.rectangle.height / 2) - 20
					&& (bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2)) < (cube.rectangle.height / 2) - 2) {
				//Logger.log("Collision top");
				return CollisionType.TOP;
			}
			
			//when the Y position of the character is on the left side of the platform
			if (bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2) < (cube.rectangle.height / 2) - 25) {
				//Logger.log("Collision left");
				return CollisionType.LEFT;
			}
		}

		return CollisionType.NONE;

	}

	// different type of collisions between the man and the ingot
	public enum CollisionGold {
		IN, OUT
	};

	/**
	 * used to check the collision between the man and the ingot
	 * @param ingot
	 * @param bonhomme
	 * @return
	 */
	public static CollisionGold scored(IngotBonus ingot, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(ingot.square)) {
			//Logger.log("Collision Gold");
			return CollisionGold.IN;

		}
		return CollisionGold.OUT;

	}

	// different type of collisions between the man and the eggs
	public enum CollisionEgg {
		IN, OUT
	};

	/**
	 * Collision between the man and the eggs
	 * @param egg
	 * @param bonhomme
	 * @return
	 */
	public static CollisionEgg scored1(EggDofus egg, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(egg.square)) {
			//Logger.log("Collision dofus egg");
			return CollisionEgg.IN;
		}
		return CollisionEgg.OUT;

	}

	// different type of collisions between the man and the dragon bonus
	public enum CollisionBonus {
		IN, OUT
	};

	/**
	 * Collision between the man and the dragon bonus
	 * @param bonus
	 * @param bonhomme
	 * @return
	 */
	public static CollisionBonus bonus(DragonBonus bonus, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(bonus.square)) {
			//Logger.log("Collision dragon");
			return CollisionBonus.IN;
		}
		return CollisionBonus.OUT;

	};
	
	// different type of collision between the man and the Zaap (portal)
	
	public enum CollisionZaap {
		IN, OUT
	}

	/**
	 * Collision between the man and the portal
	 * @param zaap
	 * @param bonhomme
	 * @return
	 */
	public static CollisionZaap zaap(Zaap zaap, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(zaap.square)) {
			return CollisionZaap.IN;
		}
		return CollisionZaap.OUT;

	};

}
