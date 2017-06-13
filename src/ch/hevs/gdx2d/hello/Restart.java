package ch.hevs.gdx2d.hello;

import java.io.StreamTokenizer;

public class Restart {
//moi
	static void restart() {
		Cube.play = true;
		CubeManager.play = true;
		Bonhomme.score = 0;
		EggDofusManager.nbreEgg = 0;
		IngotManager.nbreIngot = 0;
		Bonhomme.sexCharacter = 0;
		Bonhomme.SPRITE_HEIGHT = 68;
		Bonhomme.SPRITE_WIDTH = 64;
		Bonhomme.offset = 10;
		StartScreen.world = 0;
		Screens.getInstance().s.activateScreen(0);
	}

}
