package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class GoldIngot implements DrawableObject {

	static BitmapImage ingot;
	Rectangle square;

	int posX;
	int posY;
	int ale = 1;;
	int increment = 1;

	public GoldIngot(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		square = new Rectangle();

		square.height = 25;
		square.width = 25;
		ingot = new BitmapImage("data/images/gold.png");

	}

	public void moveIngot(float speed) {

		if (ale % 30 == 0) {
			increment *= -1;
		}
		posX += speed;

		posY += increment * 2;
		ale++;
	}

	public void updateSquarre() {

		square.x = posX;
		square.y = posY;
	}

	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.25f, ingot);

	}

}
