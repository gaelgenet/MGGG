package ch.hevs.gdx2d.hello;

public class Colision {
	Cube cube;
	Bonhomme bonhomme;
	boolean colision = false;

	public void colision() {
		if (bonhomme.squarre.contains(cube.rectangle)) {
			colision = true;}
		else{
			colision = false;
			}
	}

}
