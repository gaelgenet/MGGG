package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionScore;
import ch.hevs.gdx2d.lib.GdxGraphics;

public class GoldIngotManager {
	
Vector<GoldIngot> ingot = new Vector<GoldIngot>();
	

	float dt;
	float speedTime;
	int posx = 1150;
	int posy = 0;

	float speed = -4f;
	float variablespeed = 2f;
	int nbreIngot =0;
	
	
	void generateIngot(){
		dt += Gdx.graphics.getDeltaTime();

		
		if ( dt > variablespeed) {
			
			dt = 0;

			posy = (int) (Math.random() * 800);

			if (posy < 350 || posy > 650) {
				posy = 500;
			}

			ingot.add(new GoldIngot(posx, posy));
			
		}

	
	}
	public void comptableIngotAndDostroy (Collision.CollisionScore collide ){
		if(collide == CollisionScore.IN){
			nbreIngot ++; 
			ingot.remove(0);
		}
		if(ingot.get(0).posX < -15){
			ingot.remove(0);
		}
		
		if(nbreIngot % 20 == 0){
			Bonhomme.sex = 3;
		}
	}
	
	public void moveingot(GdxGraphics g) {
		
		speedTime += Gdx.graphics.getDeltaTime();
		
		//Logger.log("pouet" + speedTime);

		if (speedTime > 7) {
			//speed -= 0.1;
			//variablespeed -= 0.1;
			speedTime = 0;
		}
		
		for (GoldIngot i : ingot) {
			i.draw(g);
			i.updateSquarre();
			i.moveIngot(speed);
		}}
		public void generatefirstingot(){
			ingot.add(new GoldIngot(500,400));
			ingot.add(new GoldIngot(1200,500));
			
		}

}
