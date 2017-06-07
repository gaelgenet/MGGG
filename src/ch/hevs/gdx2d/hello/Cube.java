
package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;


public class Cube implements DrawableObject {
	Color c = Color.WHITE;
	Rectangle rectangle;
	static boolean play = true;

	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		this.c = col;
		rectangle = new Rectangle(initX, initY, initWidth, initHeight);
	}

	public void move(float dx){
		if (play){
		rectangle.x += dx;}
	}
	

	@Override
	public void draw(GdxGraphics g) {
		g.drawFilledRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height, 0, c);
		//update();
	}
	


}
