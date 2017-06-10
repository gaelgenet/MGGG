package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Bachground implements DrawableObject {

	BitmapImage background;
	BitmapImage backdofus;
	int i = 0;
	float posXfirstbackground;
	float posXfirstdofusground;
	float posXsecondbackground;
	float posXseconddofusground;
	int scaleBG = 3;
	double scaleBDG = 2.5;


	public void onInit() {
		
		switch (StartScreen.world){
		default:
		case 0:
			background = new BitmapImage("data/images/background.jpg");
			posXfirstbackground = HelloWorld.WINDOWS_WIDTH / 2;
			posXsecondbackground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + background.getImage().getWidth() * scaleBG);
			break;
			
		case 1:
			backdofus = new BitmapImage("data/images/background doffus.jpg");
			posXseconddofusground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + backdofus.getImage().getWidth() * scaleBDG);
			posXfirstdofusground = HelloWorld.WINDOWS_WIDTH / 2;
			break;
		}
		
	}
	

	@Override
	public void draw(GdxGraphics g) {
		// TODO Auto-generated method stub

		if (posXfirstbackground < -HelloWorld.WINDOWS_WIDTH) {
			posXfirstbackground = posXsecondbackground + background.getImage().getWidth() * scaleBG;
		}
		if (posXsecondbackground < -HelloWorld.WINDOWS_WIDTH) {
			posXsecondbackground = posXfirstbackground + background.getImage().getWidth() * scaleBG;
		}
		if(posXseconddofusground < -HelloWorld.WINDOWS_WIDTH-400){
			posXseconddofusground = (float) (posXfirstdofusground + backdofus.getImage().getWidth() * scaleBDG);
			
		}
		if(posXfirstdofusground < -HelloWorld.WINDOWS_WIDTH-400){
			posXfirstdofusground = (float) (posXseconddofusground + backdofus.getImage().getWidth() * scaleBDG);
			
		}
		
		switch (StartScreen.world){
		
		default:
		case 0:
			g.drawTransformedPicture(posXfirstbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
			g.drawTransformedPicture(posXsecondbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
			posXfirstbackground -= 3;
			posXsecondbackground -= 3;
			break;
			
		case 1:
			g.drawTransformedPicture(posXfirstdofusground, HelloWorld.WINDOWS_HEIGHT / 2, 0, (float) scaleBDG, backdofus);
			g.drawTransformedPicture(posXseconddofusground, HelloWorld.WINDOWS_HEIGHT / 2, 0, (float) scaleBDG, backdofus);
			posXfirstdofusground-=3;
			posXseconddofusground-=3;
			break;
		}

	}

}