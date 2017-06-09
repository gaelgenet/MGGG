package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.components.bitmaps.Spritesheet;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Explosion  implements DrawableObject{
	
	
	static int SPRITE_WIDTH = 150;
	static int SPRITE_HEIGHT = 356;

	
	/**
	 * The currently selected sprite for animation
	 */
	int textureX = 0;
	int textureY = 0;
	/**
	 * Another parametre
	 */
	float dt = 0;
	int currentFrame = 0;
	int nFrames = 4;
	double FRAME_TIME = 0.15; // Duration of each frame
	static Spritesheet loser;
	static BitmapImage loser2;
	int posx = 800;
	int posy = 40;
	float alpha = 0.7f;
	float scale = 0.7f;
	float angle = 0;
	int var1 = 1;
	int var2 = 1;
	int var3 =1;
	float inc1=0.01f;
	float inc2=0.01f;
	float inc3=0.5f;
	
	public void moveSprite() {
		dt += Gdx.graphics.getDeltaTime();

		if (dt > FRAME_TIME) {
			dt = 0;

			currentFrame += 1;
			if (currentFrame == nFrames) {
				currentFrame = 0;
				

			}
}
		
		}
	public void loser(GdxGraphics g){
		if(posx >325){
		posx-=2;}
		
		
		if(var1%20 == 0){
			inc1*=-1;
		}
		if(var2%25 == 0){
			inc2*=-1;
		}
//		
		scale+=inc1;
		alpha+=inc2;
		
		
			
		
		var1++;
		var2++;
		
	}
	
	public void onInit(){
		loser = new Spritesheet("data/images/loser.png", SPRITE_WIDTH, SPRITE_HEIGHT);
		loser2 = new BitmapImage("data/images/loser2.png");
	}
	@Override
	public void draw(GdxGraphics g) {
		// TODO Auto-generated method stub
		
		g.draw(loser.sprites[textureY][currentFrame],posx,posy);
		if(posx <= 325){
		g.drawAlphaPicture(400, 550, angle, scale, alpha, loser2);}
		
	}

}
