package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * this class create the different ingots for the world 1
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class IngotBonus implements DrawableObject {

	// Attributes
	static BitmapImage ingot;
	static BitmapImage silver;
	static BitmapImage saphir;
	Rectangle square;
	Bonhomme b = new Bonhomme();
	IngotManager bonusManager;

	// parameter positions
	int posX;
	int posY;

	// parameter movement
	int heightVariation = 1;;
	int direction = 1;

	/**
	 * constructor and initialize images
	 * 
	 * @param posX
	 * @param posY
	 */
	public IngotBonus(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		square = new Rectangle();
		square.height = 25;
		square.width = 25;
		silver = new BitmapImage("data/images/silver.png");
		saphir = new BitmapImage("data/images/saphir.png");
		ingot = new BitmapImage("data/images/gold.png");
	}

	/**
	 * movement ingot
	 * 
	 * @param speed
	 */
	public void moveIngot(float speed) {

		if (heightVariation % 35 == 0) {
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
	 * drawing eggs in function of number's score
	 */
	@Override
	public void draw(GdxGraphics g) {
		if (IngotManager.nbreIngot >= 50) {
			g.drawTransformedPicture(posX, posY, 0, 0.25f, saphir);
		} else if (IngotManager.nbreIngot>= 20 && IngotManager.nbreIngot < 50) {
			g.drawTransformedPicture(posX, posY, 0, 0.25f, silver);
		} else if (IngotManager.nbreIngot < 20) {
			g.drawTransformedPicture(posX, posY, 0, 0.25f, ingot);
		}

	}

}
