package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * this class is used to create a dragon bonus
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */
public class DragonBonus implements DrawableObject {

	// class' instance
	Rectangle square;

	// picture
	static BitmapImage dragonEggBonus = new BitmapImage("data/images/dragonEgg.png");

	// the position of the bonus
	int posX = 1000;
	int posY = 600;

	// the movment of the bonus
	int heightVariation = 1;;
	int direction = 1;
	boolean activeBonus = false;

	/**
	 * constructor
	 * 
	 * @param posX
	 * @param posY
	 */
	public DragonBonus() {
		square = new Rectangle();
		square.height = 25;
		square.width = 25;
	}

	/**
	 * move up/down and to the left
	 * 
	 * @param speed
	 */
	public void moveDragonBonus(float speed) {
		if (heightVariation % 15 == 0) {
			direction *= -1;
		}
		posX += speed;
		posY += direction * 2;
		heightVariation++;
	}

	/**
	 * when the bonus goes too far on the right, update the position to the left side of the screen.
	 */
	public void updatePos() {
		posX = 1000;
		posY = 500;
	}

	/**
	 * update the position of the bonus
	 */
	public void updateSquarre() {
		square.x = posX;
		square.y = posY;
	}

	/**
	 * create a dragon bonus
	 */
	public void createBonus() {
		if ((IngotManager.nbreIngot +1) % 10 == 0 || (EggDofusManager.nbreEgg +1) % 10 ==0) {
			activeBonus = true;
			Logger.log("bonus creer");
			updatePos();
		}
	}

	/**
	 * draw the bonus
	 */
	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.3f, dragonEggBonus);
	}
}
