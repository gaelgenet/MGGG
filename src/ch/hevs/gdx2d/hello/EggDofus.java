package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class EggDofus implements DrawableObject {

	static BitmapImage egg1;
	static BitmapImage egg2;
	static BitmapImage egg3;
	static BitmapImage egg4;
	static BitmapImage egg5;
	static BitmapImage egg6;

	Rectangle square;
	Bonhomme b = new Bonhomme();
	;

	int posX;
	int posY;
	int ale = 1;;
	int increment = 1;

	public EggDofus(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;

		square = new Rectangle();

		square.height = 25;

		square.width = 25;

		egg1 = new BitmapImage("data/images/dofusemeraude.png");

		egg2 = new BitmapImage("data/images/o1.png");

		egg3 = new BitmapImage("data/images/o2.png");
		egg4 = new BitmapImage("data/images/o3.png");

		egg5 = new BitmapImage("data/images/o4.png");

		egg6 = new BitmapImage("data/images/o5.png");
	}

	

	public void moveEgg(float speed) {

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
		if(b.score >= 20){
			g.drawTransformedPicture(posX, posY, 0, 0.3f, egg6);
		}
		else if (b.score >= 18 && b.score < 20) {
			g.drawTransformedPicture(posX, posY, 0, 0.32f, egg5);
		}
		else if (b.score >= 15 && b.score < 18) {
			g.drawTransformedPicture(posX, posY, 0, 0.35f, egg4);
		}
		else if (b.score >= 10 && b.score < 15) {
			g.drawTransformedPicture(posX, posY, 0, 0.45f, egg3);
		}
		else if (b.score >= 5 && b.score < 10) {
			g.drawTransformedPicture(posX, posY, 0, 0.35f, egg2);
		}
		else if (b.score < 5) {
			g.drawTransformedPicture(posX, posY, 0, 0.3f, egg1);
		}

	}
}
