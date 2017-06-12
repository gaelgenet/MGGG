package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * cette class permet la creation d'un portail, pour changer de monde
 * 
 *
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG)
 * @version 1.0
 */


public class Zaap implements DrawableObject {
    
	// instance class
	Bonhomme b = new Bonhomme();
	Rectangle square;
	static BitmapImage zaap = new BitmapImage("data/images/Zaap.png");

	//variable class
	int heightVariation = 1;
	int direction = 1;
	int posX;
	int posY;
	static Boolean zaapy = false;

	// 
	public void onInit() {
		posX = 1000;
		posY = 500;
		square = new Rectangle();

		square.height = 25;

		square.width = 25;

	}

	public void moveZaap() {
		if (heightVariation % 30 == 0) {
			direction *= -1;
		}
		posX -= 3;

		posY += direction * 2;
		heightVariation++;
	}

	public void updatePos() {
		posX = 1000;
		posY = 500;
	}

	public void updateSquarre() {

		square.x = posX;
		square.y = posY;
	}
/
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
