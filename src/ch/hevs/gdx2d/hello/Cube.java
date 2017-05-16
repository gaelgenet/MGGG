
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
	int w;
	int h;
	Color c = Color.WHITE;
//	private AbstractPhysicsObject cube;

	public Cube(int initX, int initY, int initWidth, int initHeight, Color col) {
		posx = initX;
		posy = initY;
		w = initWidth;
		h = initHeight;
		this.c = col;
		Rectangle r = new Rectangle();
//		cube = new PhysicsBox("test", new Vector2(posx, posy), w, h);
	}

	public void move(int dx){
//		cube.setBodyLinearVelocity(dx, 0);
//		Logger.log(cube.getBodyPosition().toString());
		posx += dx;
	}
	
	private void update() {
		if (posx < -100) {
			posx = (int) (Math.random() * 1000) + 1000;
			posy = (int) (Math.random() * 100) + 150;
		}
		 
	}

	@Override
	public void draw(GdxGraphics g) {
		g.drawFilledRectangle(posx, 0, w, 2 * posy + h, 0, c);
		update();
	}

}
