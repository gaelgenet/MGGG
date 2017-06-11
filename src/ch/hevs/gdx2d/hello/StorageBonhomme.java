package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.Spritesheet;

public class StorageBonhomme {

	public void storage() {

		switch (Bonhomme.sex) {
		default:
		case 1:
			Bonhomme.offset = 20;
			Bonhomme.SPRITE_WIDTH = 64;
			Bonhomme.SPRITE_HEIGHT = 68;
			Bonhomme.sprites = new Spritesheet("data/images/manSmall.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;

		case 2:
			Bonhomme.offset = 20;
			Bonhomme.SPRITE_WIDTH = 64;
			Bonhomme.SPRITE_HEIGHT = 68;
			Bonhomme.sprites = new Spritesheet("data/images/womanSmall.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;
		case 3:
			Bonhomme.offset = 200;
			Bonhomme.SPRITE_WIDTH = 150;
			Bonhomme.SPRITE_HEIGHT = 147;
			DragonBonusManager.dragon = true;
			Bonhomme.sprites = new Spritesheet("data/images/dragon1.png", Bonhomme.SPRITE_WIDTH,
					Bonhomme.SPRITE_HEIGHT);
			break;
			
			
			
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
