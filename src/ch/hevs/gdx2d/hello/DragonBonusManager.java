package ch.hevs.gdx2d.hello;

import java.util.Vector;
import ch.hevs.gdx2d.hello.Collision.CollisionBonus;
import ch.hevs.gdx2d.hello.Collision.CollisionZaap;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.utils.Logger;

/**
 * this class is used to manage the creation of the dragon bonus
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class DragonBonusManager {

	DragonBonus dragonBonus;

	float speed = -4f;

	/**
	 * instance a class
	 */
	public void instanceDragonBonus() {
		dragonBonus = new DragonBonus();
		
	}

	public void Manager(Bonhomme bonhomme, GdxGraphics g) {
		
		dragonBonus.createBonus();

		// condition to move the zaap and condition to change the sex and the
		// world

		if (Collision.bonus(dragonBonus, bonhomme) == CollisionBonus.OUT && dragonBonus.activeBonus == true) {
			dragonBonus.moveDragonBonus(speed);
			dragonBonus.updateSquarre();
			dragonBonus.draw(g);

		} else if (Collision.bonus(dragonBonus, bonhomme) == CollisionBonus.IN && dragonBonus.activeBonus == true) {
			bonhomme.sexCharacter = 3;
			dragonBonus.updatePos();
			dragonBonus.activeBonus = false;
			
		}
		
		if (IngotManager.nbreIngot % 8 == 0 && Bonhomme.sexCharacter == 3 && StartScreen.world == 0) {

			if (CubeManager.position < 305 && CubeManager.position > 300) {
				Bonhomme.sexCharacter = StartScreen.playerChoise;
			}
		}
		
		if (EggDofusManager.nbreEgg % 6 == 0 && Bonhomme.sexCharacter == 3 && StartScreen.world == 1){
			if (CubeManager.position < 305 && CubeManager.position > 300) {
				Bonhomme.sexCharacter = StartScreen.playerChoise;
			}
		}
	}


}
