package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.geometry.Point;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * The class used to check the collision between the different object of the
 * game
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class Collision {

	// collision between the man and the platform

	public enum CollisionType {
		NONE, TOP, LEFT, END
	};

	public static CollisionType collides(Cube cube, Bonhomme bonhomme, float bonhommeSpeedX) {

		if ((bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4)) <= (cube.rectangle.x + (cube.rectangle.width / 2))
				&& (bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4))
						- bonhommeSpeedX > (cube.rectangle.x + (cube.rectangle.width / 2))) {
			if (!bonhomme.move) {
				Logger.log("Collision end");
				return CollisionType.END;
			}
		}
		if ((bonhomme.square.x + (Bonhomme.SPRITE_WIDTH / 4)) >= cube.rectangle.x - (cube.rectangle.width / 2)
				&& (bonhomme.square.x - (Bonhomme.SPRITE_WIDTH / 4)) <= cube.rectangle.x + (cube.rectangle.width / 2)) {
			if ((bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2)) >= (cube.rectangle.height / 2) - 20
					&& (bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2)) < (cube.rectangle.height / 2) - 2) {
				Logger.log("Collision top");
				return CollisionType.TOP;
			}
			if (bonhomme.square.y - (Bonhomme.SPRITE_HEIGHT / 2) < (cube.rectangle.height / 2) - 25) {
				Logger.log("Collision left");
				return CollisionType.LEFT;
			}
		}

		return CollisionType.NONE;

	}

	// collision between the man and the ingot

	public enum CollisionGold {
		IN, OUT
	};

	public static CollisionGold scored(IngotBonus ingot, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(ingot.square)) {
			Logger.log("Collision Gold");
			return CollisionGold.IN;

		}
		return CollisionGold.OUT;

	}

	// collision between the man and the eggs

	public enum CollisionEgg {
		IN, OUT
	};

	public static CollisionEgg scored1(EggDofus egg, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(egg.square)) {
			Logger.log("Collision dofus egg");
			return CollisionEgg.IN;
		}
		return CollisionEgg.OUT;

	}

	// collision between the man and the dragon bonus

	public enum CollisionBonus {
		IN, OUT
	};

	public static CollisionBonus bonus(DragonBonus bonus, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(bonus.square)) {
			Logger.log("Collision dragon");
			return CollisionBonus.IN;
		}
		return CollisionBonus.OUT;

	};
	
	// collision between the man and the zaap
	
	public enum CollisionZaap {
		IN, OUT
	}

	public static CollisionZaap zaap(Zaap zaap, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(zaap.square)) {

			return CollisionZaap.IN;
		}
		return CollisionZaap.OUT;

	};

}
