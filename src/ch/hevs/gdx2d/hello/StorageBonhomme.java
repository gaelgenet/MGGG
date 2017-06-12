package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.components.bitmaps.Spritesheet;

public class StorageBonhomme {
	

	public void storage() {

		switch (Bonhomme.sexCharacter) {
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
		
//		switch (StartScreen.world){
//		default:
//		case 0:
//			Background.background = new BitmapImage("data/images/background.jpg");
//			Background.posXfirstbackground = HelloWorld.WINDOWS_WIDTH / 2;
//			Background.posXsecondbackground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + Background.background.getImage().getWidth() * Background.scaleBG);
//			break;
//			
//		case 1:
//			Background.backdofus = new BitmapImage("data/images/background doffus.jpg");
//			Background.posXseconddofusground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + Background.backdofus.getImage().getWidth() * Background.scaleBDG);
//			Background.posXfirstdofusground = HelloWorld.WINDOWS_WIDTH / 2;
//			break;
//		}
	}

}
