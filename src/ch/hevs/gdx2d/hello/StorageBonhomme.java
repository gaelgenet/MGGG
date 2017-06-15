package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;

/**
 * this class is used to store information about each character
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */
public class StorageBonhomme {

	/**
	 * every informations about each caracter
	 */
	public void storage() {

		switch (Bonhomme.sexCharacter) {
		// the man
		default:
		case 1:
			Bonhomme.offset = 20;
			Bonhomme.SPRITE_WIDTH = 64;
			Bonhomme.SPRITE_HEIGHT = 68;
			Bonhomme.sprites = new Spritesheet("data/images/manSmall.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;

		// the woman
		case 2:
			Bonhomme.offset = 20;
			Bonhomme.SPRITE_WIDTH = 64;
			Bonhomme.SPRITE_HEIGHT = 68;
			Bonhomme.sprites = new Spritesheet("data/images/womanSmall.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;

		// the dragon
		case 3:
			Bonhomme.offset = 200;
			Bonhomme.SPRITE_WIDTH = 150;
			Bonhomme.SPRITE_HEIGHT = 147;
			Bonhomme.sprites = new Spritesheet("data/images/dragon1.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;

		// the dragodinde
		case 4:
			Bonhomme.offset = 20;
			Bonhomme.SPRITE_WIDTH = 126;
			Bonhomme.SPRITE_HEIGHT = 93;
			Bonhomme.sprites = new Spritesheet("data/images/dragodindeSmall.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;

		}

	}

}
