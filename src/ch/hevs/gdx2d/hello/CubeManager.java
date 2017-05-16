package ch.hevs.gdx2d.hello;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;

public class CubeManager {
	
	static Cube cube;
	//static ArrayList<Cube> cubes = new ArrayList<Cube>();

	static public void drawCubes(GdxGraphics g) {
//		for (Cube c : cubes) {
			cube.draw(g);
			cube.move(-3);
		}


	public static void generateInitialCubes() {
		Cube c1 = new Cube(1000, 175, 120, 175, Color.MAGENTA);
//		Cube c2 = new Cube(1500, 300, 100, 40, Color.GREEN);
//		Cube c3 = new Cube(2000, 350, 150, 100, Color.BLUE);
//		Cube c4 = new Cube(2500, 250, 300, 80, Color.MAROON);
		//cubes.add(c1);
//		cubes.add(c2);
//		cubes.add(c3);
//		cubes.add(c4);
	}

}
