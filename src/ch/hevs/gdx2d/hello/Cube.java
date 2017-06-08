
package ch.hevs.gdx2d.hello;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;


public class Cube implements DrawableObject {
	Color c = Color.WHITE;
	Rectangle rectangle;
	static boolean play = true;
	static BitmapImage img;
	int offX, offY;
	
	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		this.c = col;
		if(img == null)
			img = new BitmapImage("data/images/bricks2.jpg");
		rectangle = new Rectangle(initX, initY, initWidth, initHeight);
		offX = r.nextInt(200);
		offY = r.nextInt(200);
	}

	public void move(float dx){
		if (play){
		rectangle.x += dx;
	}
	}
	
	Random r = new Random();

	
	@Override
	public void draw(GdxGraphics g) {
		float x = rectangle.x;
		float y = rectangle.y;
		g.drawFilledRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height, 0, c); 
		g.draw(img.getImage(), x-rectangle.width/2, y, rectangle.width, rectangle.height/2, offX, offY, (int)rectangle.width, (int)rectangle.height/2, false, false);
		//update();
	}
	


}
