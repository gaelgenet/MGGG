package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionScore;
import ch.hevs.gdx2d.lib.GdxGraphics;

public class GoldIngotManager {
Vector<GoldIngot> ingot = new Vector<GoldIngot>();
	

	float dt;
	float speedTime;
	int posx = 1000;
	int posy = 0;

	float speed = -4;
	float variablespeed = 2f;
	int nbreIngot =0;
	
	
	void generateIngot(){
		dt += Gdx.graphics.getDeltaTime();

		
		if ( dt > variablespeed) {
			
			dt = 0;
//			posx = (int) ((Math.random() * 1000)+1000);
//			if (posx < 1200|| posx > 1999) {
//				posx = 1500     ;
//			}
			posy = (int) (Math.random() * 800);

			if (posy < 300 || posy > 700) {
				posy = 450;
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
	}
	
	public void moveingot(GdxGraphics g) {
		for (GoldIngot i : ingot) {
			i.draw(g);
			i.updateSquarre();
			i.moveIngot();
		}}
		public void generatefirstingot(){
			ingot.add(new GoldIngot(800,400));
			ingot.add(new GoldIngot(1200,500));
			
		}

}
