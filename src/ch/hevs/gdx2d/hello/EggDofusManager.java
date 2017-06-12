package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionEgg;
import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class EggDofusManager {
	Vector<EggDofus> eggs = new Vector<EggDofus>();

	float dt;
	float speedTime;
	int posx = 1150;
	int posy = 500;

	float speed = -4f;
	float variablespeed = 2f;
	public static int nbreEgg = 0;

	void generateEgg() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {

			dt = 0;

			eggs.add(new EggDofus(posx, posy));

		}

	}

	public void comptableEggAndDestroy(Collision.CollisionEgg collide) {
		
		if (collide == CollisionEgg.IN) {
			nbreEgg++;
			eggs.remove(0);
			
		if (nbreEgg % 20 == 0) {
				DragonBonusManager.activeDragonBonus = true;
				Logger.log("dragon bonus activated");
				// DragonBonusManager.activeBonus =true;
				// Bonhomme.sex = 3;
			}
		}

	if(nbreEgg% 6 == 0 && Bonhomme.sexCharacter==3)	{
		Logger.log("salut");
		if (CubeManager.position < 275 && CubeManager.position > 270) {
			DragonBonusManager.dragon = false;
			Bonhomme.sexCharacter = StartScreen.playerChoise;
			// Bonhomme.SPRITE_HEIGHT = DragonBonusManager.lastHeight;
			// Bonhomme.SPRITE_WIDTH = DragonBonusManager.lastWidth;
			Logger.log("sex " + Bonhomme.sexCharacter + Bonhomme.SPRITE_HEIGHT);
		}
	}

	
	if(eggs.get(0).posX<-15){
		eggs.remove(0);}

	}

	public void moveegg(GdxGraphics g) {

		// speedTime += Gdx.graphics.getDeltaTime();

		// Logger.log("pouet" + speedTime);

		if (CubeManager.speedTime > 7) {
			speed -= 0.2;
			// variablespeed -= 0.1;
			speedTime = 0;
		}

		for (EggDofus i : eggs) {
			i.draw(g);
			i.updateSquarre();
			i.moveEgg(speed);
		}
	}

	public void generatefirstegg() {
		eggs.add(new EggDofus(500, 400));
		eggs.add(new EggDofus(1200, 500));

	}

}
