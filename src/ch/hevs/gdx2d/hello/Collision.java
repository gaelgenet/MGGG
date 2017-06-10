package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.geometry.Point;
import ch.hevs.gdx2d.lib.utils.Logger;

public class Collision {

	public enum CollisionType {
		NONE, TOP, LEFT, END
	};

	public static CollisionType collides(Cube cube, Bonhomme bonhomme, float bonhommeSpeedX) {
		// Point basDroit = new Point((int) bonhomme.squarre.x +
		// (Bonhomme.SPRITE_WIDTH / 4), (int) bonhomme.squarre.y -
		// (Bonhomme.SPRITE_HEIGHT / 2));

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

	public enum CollisionGold {
		IN, OUT
	};

	public static CollisionGold scored(IngotBonus ingot, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(ingot.square)) {
			return CollisionGold.IN;
		}
		return CollisionGold.OUT;

	}
	public enum CollisionEgg {
		IN, OUT
	};

	public static CollisionEgg scored1(EggDofus egg, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(egg.square)) {
			return CollisionEgg.IN;
		}
		return CollisionEgg.OUT;

	}
	
	public enum CollisionBonus {
		IN, OUT
	};

	public static CollisionBonus bonus(DragonBonus bonus, Bonhomme bonhomme) {

		if (bonhomme.square.overlaps(bonus.square)) {
			return CollisionBonus.IN;
		}
		return CollisionBonus.OUT;

	}
}
