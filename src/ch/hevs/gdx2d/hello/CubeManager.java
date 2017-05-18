package ch.hevs.gdx2d.hello;

import java.util.Random;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class CubeManager {

	Vector<Cube> cubes = new Vector<Cube>();
	
	float dt;
	int posx = 1000;
	int posy = 0;
	int width;
	int high;
	int speed = -1;
	float speedTime;
	
	Color c = Color.WHITE;

	Random r = new Random();
	
	void generatecube() {
		dt += Gdx.graphics.getDeltaTime();
		
	//	Logger.log("Current time " + dt);
		if (dt > 3) {
		//	Logger.log("Generating a CUBBEEEEE!");
			dt = 0;
			width = (int) (Math.min(Math.random() * 1000, 500));
			high = (int) (Math.min(Math.random() * 1000, 600));
			
			cubes.add(new Cube(posx, posy, width, high, new Color(r.nextInt())));
		}

	}

	public void drawCubes(GdxGraphics g) {
		speedTime += Gdx.graphics.getDeltaTime();
	//	Logger.log("pouet"+speedTime);
		
		if(speedTime>5){
			speed -= 2;
			speedTime = 0;
		}
		
		for(Cube c: cubes){
			c.draw(g);
			c.move(speed);
		}
		Logger.log("salut" + speed + "");
	}

	public void generateInitialCubes() {

	}

}
