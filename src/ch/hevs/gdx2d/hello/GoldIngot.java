package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class GoldIngot implements DrawableObject {

	 static BitmapImage ingot;
	public void onInit() {
	ingot = new BitmapImage("data/images/gold.png");}
	
	
	int posX;
	int posY;
	int ale;
	

	
	public void drawingPositionIngot(CubeManager c){
		
		posY = (int) (c.cubes.get(0).rectangle.height/2 + ingot.getImage().getHeight()/4);
		posX = (int) (c.cubes.get(0).rectangle.x + c.cubes.get(0).rectangle.width/4);}
	
	@Override
	public void draw(GdxGraphics g) {
		g.drawTransformedPicture(posX, posY, 0, 0.25f, ingot);
		
	}

}
