
package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ch.hevs.gdx2d.components.physics.primitives.PhysicsBox;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.physics.AbstractPhysicsObject;
import ch.hevs.gdx2d.lib.utils.Logger;

public class Cube implements DrawableObject {
	
	int posx;
	int posy;
	int width;
	int high;
	Color c = Color.WHITE;

	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		posx = initX;
		posy = initY;
		width = initWidth;
		high = initHeight;
		this.c = col;
		new Rectangle(initX, initY, initWidth, initHeight);
	}

	public void move(int dx){
		posx += dx;
	}
	
//	private void update() {
//		if (posx < -100) {
//			posx = (int) (Math.random() * 1000) + 1000;
//			posy = (int) (Math.random() * 100) + 150;
//		}
//		 
//	}

	@Override
	public void draw(GdxGraphics g) {
		g.drawFilledRectangle(posx, posy, width, high, 0, c);
		//update();
	}

}
