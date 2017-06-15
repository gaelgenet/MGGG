package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * this class create a portal to change between worlds
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */

public class Portal implements DrawableObject {

	// Attributes
	Rectangle square;
	static BitmapImage portal = new BitmapImage("data/images/Zaap.png");

	int heightVariation = 1;
	int direction = 1;
	int posX = 1000;
	int posY = 500;

	Boolean createPortal = false;

	/**
	 * constructor
	 */
	public Portal() {
		square = new Rectangle();
		square.height = 25;
		square.width = 25;
	}

	/**
	 * mouvement of de portal
	 */
	public void movePortal() {
		if (heightVariation % 30 == 0) {
			direction *= -1;
		}
		posX -= 3;
		posY += direction * 2;
		heightVariation++;
	}

	/**
	 * portal position
	 */
	public void updatePos() {
		posX = 1000;
		posY = 500;
	}

	/**
	 * update squarre position
	 */
	public void updateSquarre() {
		square.x = posX;
		square.y = posY;
	}

	/**
	 * moment to create a portal
	 */
	public void createPortal() {
		if ((Bonhomme.score + 1) % 30 == 0) {
			createPortal = true;
			updatePos();
		}
	}

	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.5f, portal);

	}

}
