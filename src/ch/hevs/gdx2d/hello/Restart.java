package ch.hevs.gdx2d.hello;

/**
 * this class is used to re-initialize some attributes after losing
 * and to go the first screen
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class Restart {

	/**
	 * Attributes to restart
	 */
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
		Screens.getInstance().s.activateScreen(0);//go to the first screen
	}

}
