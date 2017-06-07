package ch.hevs.gdx2d.hello;

import java.util.Random;
import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.lib.GdxGraphics;

public class BirdManager {
	Vector<Bird> birdes = new Vector<Bird>();
	

	float dt;
	float speedTime;
	int posx = 1000;
	int posy = 0;

	float speed = -4;
	float variablespeed = 3f;
	

	

	Random r = new Random();

	
	
	void generateBird(){
		dt += Gdx.graphics.getDeltaTime();

		
		if ( dt > variablespeed) {
			
			dt = 0;
			posx = (int) (Math.random() * 7000);
			if (posx < 800 || posx > 2500) {
				posx = 1000;
			}
			posy = (int) (Math.random() * 800);

			if (posy < 300 || posy > 700) {
				posy = 580;
			}

			birdes.add(new Bird(posx, posy));
			
		}

	}

	void distroyBird() {
		if (birdes.get(0).posX< -100) {
			birdes.remove(0);
		}
	}
	public void moveTotalBird(GdxGraphics g) {
	for (Bird b : birdes) {
		b.draw(g);
		b.moveBird();
	}}
	public void generatefirstbird(){
		birdes.add(new Bird(1200,300));
		birdes.add(new Bird(1800,300));
		
	}
	
}
