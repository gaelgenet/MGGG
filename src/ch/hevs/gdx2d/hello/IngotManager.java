package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class IngotManager {

	Vector<IngotBonus> ingot = new Vector<IngotBonus>();

	float dt;
	float speedTime;
	int posx = 1150;
	int posy = 0;

	float speed = -4f;
	float variablespeed = 2f;
	public static int nbreIngot = 19;
	int a = 0;

	void generateIngot() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > variablespeed) {

			dt = 0;

			posy = 500;

			ingot.add(new IngotBonus(posx, posy));

		}

	}

	public void comptableIngotAndDestroy(Collision.CollisionGold collide) {
		// float difference= CubeManager.position-Bonhomme.positionBonhomme;
		// Logger.log("difference " + difference );
		Logger.log("lingot: " + nbreIngot);

		if (collide == CollisionGold.IN) {

			nbreIngot++;
			ingot.remove(0);
			
			if (nbreIngot % 20 == 0) {
				DragonBonusManager.activeDragonBonus = true;
				Logger.log("dragon bonus activated");
				// DragonBonusManager.activeBonus =true;
				// Bonhomme.sex = 3;
			}
		}
		
		if (nbreIngot % 6 == 0 && Bonhomme.sex == 3) {
			Logger.log("salut");
			if (CubeManager.position < 300 && CubeManager.position > 295) {
				DragonBonusManager.dragon = false;
				Bonhomme.sex = StartScreen.playerChoise;
				// Bonhomme.SPRITE_HEIGHT = DragonBonusManager.lastHeight;
				// Bonhomme.SPRITE_WIDTH = DragonBonusManager.lastWidth;
				Logger.log("sex " + Bonhomme.sex + Bonhomme.SPRITE_HEIGHT);
			}
		}

		if (ingot.get(0).posX < -15)

		{
			ingot.remove(0);
		}

	}

	public void moveingot(GdxGraphics g) {

		// speedTime += Gdx.graphics.getDeltaTime();

		// Logger.log("pouet" + speedTime);

		if (CubeManager.speedTime > 7) {
			speed -= 0.2;
			// variablespeed -= 0.1;
			speedTime = 0;
		}

		for (IngotBonus i : ingot) {
			i.draw(g);
			i.updateSquarre();
			i.moveIngot(speed);
		}
	}

	public void generatefirstingot() {
		ingot.add(new IngotBonus(500, 500));
		ingot.add(new IngotBonus(1200, 500));

	}

}
