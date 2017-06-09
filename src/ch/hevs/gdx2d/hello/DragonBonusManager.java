package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.hello.Collision.CollisionBonus;
import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;

public class DragonBonusManager {

	Vector<DragonBonus> bonus = new Vector<DragonBonus>();

	int posx = 500;
	int posy = 500;

	float speed = -4f;
	static boolean dragon = false;
	static boolean activeDragonBonus = false;

	void generateBonus() {
		
		bonus.add(new DragonBonus(posx, posy));

	}

	public void Destroy(Collision.CollisionBonus collide) {
		
			if (collide == CollisionBonus.IN) {
				bonus.remove(0);
				DragonBonusManager.dragon = true;
				Bonhomme.sex = 3;
			}

			if (bonus.get(0).posX < -15) {
				bonus.remove(0);
			}
		}


	public void moveBonus(GdxGraphics g) {

		if (CubeManager.speedTime > 7) {
			speed -= 0.2;
		}

		for (DragonBonus i : bonus) {
			i.draw(g);
			i.updateSquarre();
			i.moveDragonBonus(speed);
		}
	}

	public void generatefirstBonus() {
		
			bonus.add(new DragonBonus(500, 400));
		
		// bonus.add(new DragonBonus(1200, 500));

	}

}
