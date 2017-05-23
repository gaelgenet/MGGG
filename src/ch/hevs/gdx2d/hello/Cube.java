
package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ch.hevs.gdx2d.components.physics.primitives.PhysicsBox;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.physics.AbstractPhysicsObject;
import ch.hevs.gdx2d.lib.utils.Logger;

public class Cube implements DrawableObject {
	Color c = Color.WHITE;
	Rectangle rectangle;

	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		this.c = col;
		rectangle = new Rectangle(initX, initY, initWidth, initHeight);
	}

	public void move(float dx){
		rectangle.x += dx;
	}
	

	@Override
	public void draw(GdxGraphics g) {
		g.drawFilledRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height, 0, c);
		//update();
	}
	


}
