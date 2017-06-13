
package ch.hevs.gdx2d.hello;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

/**
 * Class is used to create a platform
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class Cube implements DrawableObject {

	// class' instances
	BitmapImage img;
	Rectangle rectangle;
	Color c = Color.WHITE;
	Random r = new Random();

	// class variables
	static boolean play = true;
	int offX, offY;

	/**
	 * Constructor
	 * 
	 * @param initX
	 * @param initY
	 * @param initWidth
	 * @param initHeight
	 * @param col
	 */

	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		this.c = col;

		//use a different picture for each world
		switch (StartScreen.world) {
		default:
		case 0:
			img = new BitmapImage("data/images/rockSmall.jpg");
			break;

		case 1:
			img = new BitmapImage("data/images/colorfulBrickSmall.jpg");
		}

		rectangle = new Rectangle(initX, initY, initWidth, initHeight);
		offX = r.nextInt(200);
		offY = r.nextInt(200);
	}

	/**
	 * method to move the platform to the left
	 * 
	 * @param dx
	 */
	public void move(float dx) {
		if (play) {
			rectangle.x += dx;
		}
	}

	/**
	 * draw the rectangle
	 */
	@Override
	public void draw(GdxGraphics g) {
		float x = rectangle.x;
		float y = rectangle.y;
		g.draw(img.getImage(), x - rectangle.width / 2, y, rectangle.width, rectangle.height / 2, offX, offY,
				(int) rectangle.width, (int) rectangle.height / 3, false, false);
	}

}
