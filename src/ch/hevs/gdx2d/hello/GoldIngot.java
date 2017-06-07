package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.math.Rectangle;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class GoldIngot implements DrawableObject {

	 static BitmapImage ingot;
	 Rectangle square;
	 
	 
	 
	 
	
	
	int posX;
	int posY;
	int ale;
	

	public void onInit() {
		ingot = new BitmapImage("data/images/gold.png");
		square = new Rectangle();
		square.height= 25;
		square.width =25;
		
		}
	
	public void drawingPositionIngot(CubeManager c){
		
		posY = (int) (c.cubes.get(0).rectangle.height/2 + ingot.getImage().getHeight()/4);
		posX = (int) (c.cubes.get(0).rectangle.x + c.cubes.get(0).rectangle.width/4);
		square.x = posX;
		square.y = posY;
		}
		
	
	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.25f, ingot);
		
		
	}

}
