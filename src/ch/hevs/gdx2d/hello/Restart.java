package ch.hevs.gdx2d.hello;

public class Restart {

	static void restart() {
		Cube.play = true;
		CubeManager.play = true;
		Bonhomme.score = 0;
		Bonhomme.sex = 0;
		Bonhomme.SPRITE_HEIGHT = 68;
		Bonhomme.SPRITE_WIDTH = 64;
		Bonhomme.offset = 10;
		Screens.getInstance().s.activateScreen(0);
	}

}
