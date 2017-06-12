package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class EggDofus implements DrawableObject {

	static BitmapImage egg1 = new BitmapImage("data/images/dofusemeraude.png");
	static BitmapImage egg2 = new BitmapImage("data/images/o1.png");
	static BitmapImage egg3 = new BitmapImage("data/images/o3.png");
	static BitmapImage egg4 = new BitmapImage("data/images/o3.png");
	static BitmapImage egg5 = new BitmapImage("data/images/o4.png");
	static BitmapImage egg6 = new BitmapImage("data/images/o5.png");

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
	}

	

	public void moveEgg(float speed) {

		if (ale % 40 == 0) {
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
		if(EggDofusManager.nbreEgg >= 60){
			g.drawTransformedPicture(posX, posY, 0, 0.3f, egg6);
		}
		else if (EggDofusManager.nbreEgg >= 60 && EggDofusManager.nbreEgg < 60) {
			g.drawTransformedPicture(posX, posY, 0, 0.32f, egg5);
		}
		else if (EggDofusManager.nbreEgg >= 40 && EggDofusManager.nbreEgg < 50) {
			g.drawTransformedPicture(posX, posY, 0, 0.35f, egg4);
		}
		else if (EggDofusManager.nbreEgg >= 30 && EggDofusManager.nbreEgg < 40) {
			g.drawTransformedPicture(posX, posY, 0, 0.45f, egg3);
		}
		else if (EggDofusManager.nbreEgg >= 15 && EggDofusManager.nbreEgg < 30) {
			g.drawTransformedPicture(posX, posY, 0, 0.35f, egg2);
		}
		else if (EggDofusManager.nbreEgg < 15) {
			g.drawTransformedPicture(posX, posY, 0, 0.3f, egg1);
		}

	}
}
