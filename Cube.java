
package ch.hevs.gdx2d.hello;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;
import ch.hevs.gdx2d.lib.physics.AbstractPhysicsObject;

public class Cube implements DrawableObject {

	ArrayList<Cube> cubes = new ArrayList<Cube>();

	int posx;
	int posy;
	int w;
	int h;
	Color c = Color.WHITE;
	AbstractPhysicsObject cube;

	public Cube() {

	}

	public Cube(int a, int b, int c, int d, Color col) {
		posx = a;
		posy = b;
		w = c;
		h = d;
		this.c = col;

	}

	public void update() {
		if (posx < -100) {
			posx = (int) (Math.random() * 1000) + 1000;
			posy = (int) (Math.random() * 100) + 150;
		}
		// cube = new PhysicsBox("test", new Vector2(posx, 0), w, h + 2 * posy);
	}

	public void drawC(GdxGraphics g) {
		for (Cube c : cubes) {
			c.draw(g);
			c.posx -= 3;
		}
	}

	public void onInit() {

		Cube c1 = new Cube(1000, 200, 120, 50, Color.MAGENTA);
		Cube c2 = new Cube(1500, 300, 100, 40, Color.GREEN);
		Cube c3 = new Cube(2000, 350, 150, 100, Color.BLUE);
		Cube c4 = new Cube(2500, 250, 300, 80, Color.MAROON);
		cubes.add(c1);
		cubes.add(c2);
		cubes.add(c3);
		cubes.add(c4);

	}

	@Override
	public void draw(GdxGraphics g) {

		g.drawFilledRectangle(posx, 0, w, 2 * posy + h, 0, c);

		for (Cube c : cubes) {
			c.update();
		}

	}

}
