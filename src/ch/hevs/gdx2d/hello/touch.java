package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Vector2;

import ch.hevs.gdx2d.components.physics.primitives.PhysicsBox;
import ch.hevs.gdx2d.lib.physics.AbstractPhysicsObject;

public class touch extends PhysicsBox {
	
	boolean collision = false;

	protected touch(String name, Vector2 position, Vector2[] vertices, float density, float restitution, float friction,
			boolean isDynamic) {
		super(name, position, density, restitution);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
