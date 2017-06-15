package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * This class generate the background and make it move
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */ 

public class Background implements DrawableObject {
	
	//Attributes
	static BitmapImage background; 	//background world 1
	static BitmapImage backdofus;	//background world 2
	
	int i = 0;
	static float posXfirstbackground;
	static float posXfirstdofusground;
	static float posXsecondbackground;
	static float posXseconddofusground;
	static float scaleBG = 1.5f;
	static float scaleBDG = 2.5f;

	/**
	 * initialize backgrounds
	 */
	public void onInit() {
		
			background = new BitmapImage("data/images/Cave.png");
			posXfirstbackground = HelloWorld.WINDOWS_WIDTH / 2;
			posXsecondbackground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + background.getImage().getWidth() * scaleBG);

			backdofus = new BitmapImage("data/images/background doffus.jpg");
			posXseconddofusground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + backdofus.getImage().getWidth() * scaleBDG);
			posXfirstdofusground = HelloWorld.WINDOWS_WIDTH / 2;
	}

	/**
	 * draw backgrounds
	 */
	@Override
	public void draw(GdxGraphics g) {
		
		//re-initialize the position of the background
		if (posXfirstbackground < -HelloWorld.WINDOWS_WIDTH) {
			posXfirstbackground = posXsecondbackground + background.getImage().getWidth() * scaleBG;
		}
		if (posXsecondbackground < -HelloWorld.WINDOWS_WIDTH) {
			posXsecondbackground = posXfirstbackground + background.getImage().getWidth() * scaleBG;
		}
		if (posXseconddofusground < -HelloWorld.WINDOWS_WIDTH - 500) {
			posXseconddofusground = (float) (posXfirstdofusground + backdofus.getImage().getWidth() * scaleBDG);

		}
		if (posXfirstdofusground < -HelloWorld.WINDOWS_WIDTH - 500) {
			posXfirstdofusground = (float) (posXseconddofusground + backdofus.getImage().getWidth() * scaleBDG);

		}

		//draw one of the backgrounds according to StartScreen.world
		switch (StartScreen.world) {

		case 0:
			g.drawTransformedPicture(posXfirstbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
			g.drawTransformedPicture(posXsecondbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
			posXfirstbackground -= 3;
			posXsecondbackground -= 3;
			break;

		case 1:
			Logger.log("monde 2");
			g.drawTransformedPicture(posXfirstdofusground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBDG, backdofus);
			g.drawTransformedPicture(posXseconddofusground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBDG, backdofus);
			posXfirstdofusground -= 3;
			posXseconddofusground -= 3;
			break;
			
		default:
			break;
		}

	}

}