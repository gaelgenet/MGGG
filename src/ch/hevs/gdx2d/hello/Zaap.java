package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Zaap implements DrawableObject {

	static BitmapImage zaap = new BitmapImage("data/images/Zaap.png");

	Rectangle square;
	Bonhomme b = new Bonhomme();
	static Boolean zaapy = false;

	int posX;
	int posY;
	int ale = 1;;
	int increment = 1;

	public void onInit() {
		posX = 1000;
		posY = 500;
		square = new Rectangle();

		square.height = 25;

		square.width = 25;

	}

	public void moveZaap() {
		if (ale % 30 == 0) {
			increment *= -1;
		}
		posX -= 3;

		posY += increment * 2;
		ale++;
	}

	public void updatePos() {
		posX = 1000;
		posY = 500;
	}

	public void updateSquarre() {

		square.x = posX;
		square.y = posY;
	}

	public void createZaap(Bonhomme b) {
		if ((b.score + 1) % 30 == 0) {
			zaapy = true;
			updatePos();
		}

	}

	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.5f, zaap);

	}

}
