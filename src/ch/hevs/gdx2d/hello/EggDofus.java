package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * this class create the eggs for the world 2
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class EggDofus implements DrawableObject {
	
	//Attributes
	static BitmapImage egg1 = new BitmapImage("data/images/dofusemeraude.png");
	static BitmapImage egg2 = new BitmapImage("data/images/o1.png");
	static BitmapImage egg3 = new BitmapImage("data/images/o3.png");
	static BitmapImage egg4 = new BitmapImage("data/images/o3.png");
	static BitmapImage egg5 = new BitmapImage("data/images/o4.png");
	static BitmapImage egg6 = new BitmapImage("data/images/o5.png");
	Rectangle square;
	Bonhomme b = new Bonhomme();
	
	//positions
	int posX;
	int posY;
	
	//movement 
	int heightVariation = 1;;
	int direction = 1;

	/**
	 * constructor
	 * @param posX
	 * @param posY
	 */
	public EggDofus(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;

		square = new Rectangle();

		square.height = 25;
		square.width = 25;
	}

	
	/**
	 * movement of the egg
	 * @param speed
	 */
	public void moveEgg(float speed) {

		if (heightVariation % 40 == 0) {
			direction *= -1;
		}
		posX += speed;
		posY += direction * 2;
		heightVariation++;
	}

	/**
	 * sychronize positions
	 */
	public void updateSquarre() {

		square.x = posX;
		square.y = posY;
	}

	/**
	 * drawing the eggs in function of the number of eggs
	 */
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
