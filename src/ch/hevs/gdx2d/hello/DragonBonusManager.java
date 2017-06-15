package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.audio.MusicPlayer;
import ch.hevs.gdx2d.hello.Collision.CollisionBonus;
import ch.hevs.gdx2d.lib.GdxGraphics;

/**
 * this class is used to manage the creation of the dragon bonus
 * 
 * @author Marco Goncalves (MG)
 * @author Gaël Genet (GG
 * @version 1.0
 */

public class DragonBonusManager {
	
	//Attributes
	DragonBonus dragonBonus = new DragonBonus();;
	MusicPlayer crydragon = new MusicPlayer("data/musiques/Cri-du-dragon.mp3");
	
	float speed = -4f;

	/**
	 * method who make the bonus appears
	 * @param bonhomme
	 * @param g
	 */
	public void Manager(Bonhomme bonhomme, GdxGraphics g) {
		
		dragonBonus.createBonus();

		// condition to move the dragon bonus
		if (Collision.bonus(dragonBonus, bonhomme) == CollisionBonus.OUT && dragonBonus.activeBonus == true) {
			dragonBonus.moveDragonBonus(speed);
			dragonBonus.updateSquarre();
			dragonBonus.draw(g);
			
		// when the character touch the bonus, the character become a dragon
		} else if (Collision.bonus(dragonBonus, bonhomme) == CollisionBonus.IN && dragonBonus.activeBonus == true) {
			crydragon.play();
			Bonhomme.sexCharacter = 3;
			dragonBonus.updatePos();
			dragonBonus.activeBonus = false;
		}
		
		//after X number of ingot the dragon become again a character
		if (IngotManager.nbreIngot % 8 == 0 && Bonhomme.sexCharacter == 3 && StartScreen.world == 0) {

			if (CubeManager.position < 305 && CubeManager.position > 300) {
				Bonhomme.sexCharacter = StartScreen.playerChoise;
			}
		}

	}


}
