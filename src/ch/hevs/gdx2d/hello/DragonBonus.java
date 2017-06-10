package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class DragonBonus implements DrawableObject {

	static BitmapImage dragonBonus = new BitmapImage("data/images/dragonEgg.png");

	Rectangle square;

	int posX;
	int posY;
	int ale = 1;;
	int increment = 1;

	public DragonBonus(int posX, int posY) {

		this.posX = posX;
		this.posY = posY;

		square = new Rectangle();

		square.height = 25;

		square.width = 25;

	}

	public void moveDragonBonus(float speed) {

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
		g.drawTransformedPicture(posX, posY, 0, 0.3f, dragonBonus);
	}

}
