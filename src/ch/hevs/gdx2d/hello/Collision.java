package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.geometry.Point;

public class Collision {

	public enum CollisionType {
		NONE, TOP, LEFT
	};

	public static CollisionType collides(Cube cube, Bonhomme bonhomme) {
		Point basDroit = new Point((int) bonhomme.squarre.x + (Bonhomme.SPRITE_WIDTH / 2),
				(int) bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2));

		if ((bonhomme.squarre.x + (Bonhomme.SPRITE_WIDTH / 2)) >= cube.rectangle.x - (cube.rectangle.width / 2)) {
			if ((bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2)) >= (cube.rectangle.height / 2)-25 && (bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2)) < (cube.rectangle.height / 2) ) {
				return CollisionType.TOP;
			}
			else if(bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2) < (cube.rectangle.height / 2)){
			return CollisionType.LEFT;}

		}
		
		return CollisionType.NONE;

		// if (bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2) <=
		// cube.rectangle.height / 2) {
		// if (bonhomme.squarre.x + (Bonhomme.SPRITE_WIDTH / 2) >=
		// cube.rectangle.x - (cube.rectangle.width / 2)) {
		// return CollisionType.LEFT;
		// }
		// if (bonhomme.squarre.y - (Bonhomme.SPRITE_HEIGHT / 2) <=
		// cube.rectangle.height / 2 && bonhomme.squarre.y -
		// (Bonhomme.SPRITE_HEIGHT / 2) >= (cube.rectangle.height / 2) - 20) {
		// return CollisionType.TOP;
		// }
		// }

	}
}
