package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Bachground implements DrawableObject {

	BitmapImage background;
	int i = 0;
	float posXfirstbackground;
	float posXsecondbackground;
	int scaleBG = 3;

	public void onInit() {
		background = new BitmapImage("data/images/background.jpg");
		posXfirstbackground = HelloWorld.WINDOWS_WIDTH / 2;
		posXsecondbackground = (float) (HelloWorld.WINDOWS_WIDTH / 2 + background.getImage().getWidth() * scaleBG);
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

		g.drawTransformedPicture(posXfirstbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
		g.drawTransformedPicture(posXsecondbackground, HelloWorld.WINDOWS_HEIGHT / 2, 0, scaleBG, background);
		posXfirstbackground -= 3;
		posXsecondbackground -= 3;

	}

}