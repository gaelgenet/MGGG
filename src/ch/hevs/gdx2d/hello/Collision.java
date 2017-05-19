package ch.hevs.gdx2d.hello;

public class Collision {
	Cube cube;
	Bonhomme bonhomme;
	boolean colision = false;

	public void colision() {
		System.out.println(colision);
		if (bonhomme.squarre.contains(cube.rectangle)) {
			colision = true;}
		else{
			colision = false;
			}
	}

}
