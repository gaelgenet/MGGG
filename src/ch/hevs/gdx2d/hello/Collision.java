package ch.hevs.gdx2d.hello;

public class Collision {
	
	public enum CollisionType {NONE, TOP, LEFT};

	public static CollisionType collides(Cube cube, Bonhomme bonhomme) {
		if (bonhomme.squarre.overlaps(cube.rectangle)) {
			if (bonhomme.squarre.y >= cube.rectangle.height) {
				return CollisionType.TOP;
			} else {
				return CollisionType.LEFT;
			}
		}

		return CollisionType.NONE;
	}
}
