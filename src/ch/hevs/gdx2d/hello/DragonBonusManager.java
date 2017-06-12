package ch.hevs.gdx2d.hello;

import java.util.Vector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.decals.PluggableGroupStrategy;

import ch.hevs.gdx2d.hello.Collision.CollisionBonus;
import ch.hevs.gdx2d.hello.Collision.CollisionGold;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

public class DragonBonusManager {
//moi
	Vector<DragonBonus> bonus = new Vector<DragonBonus>();

	int posx = 1000;
	int posy = 525;

	float speed = -4f;
	static boolean dragon = false;
	static boolean activeDragonBonus = false;
	static int lastWidth = 0;
	static int lastHeight = 0;

	void generateBonus() {

		if (activeDragonBonus == true) {
			bonus.add(new DragonBonus(posx, posy));
			activeDragonBonus = false;
		}

	}

	public void Destroy(Collision.CollisionBonus collide) {

		if (collide == CollisionBonus.IN) {
			bonus.remove(bonus.lastElement());
			Bonhomme.sexCharacter = 3;
			Bonhomme.score += 10;
		}

//		if (bonus.get(0).posX < -1000) {
//			bonus.remove(0);
//		}
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

		bonus.add(new DragonBonus(-20, 500));

	}

}
