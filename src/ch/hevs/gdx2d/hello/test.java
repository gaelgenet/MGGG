package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.desktop.PortableApplication;
import ch.hevs.gdx2d.lib.GdxGraphics;

public class test extends PortableApplication{
	
	int radius = 5;
	double speed  = 0.01;
	int screenHeight, screenWidth;
	BitmapImage dofus;
	float scale = 1f;

@Override
public void onInit() {
	setTitle("salut");
	
	screenHeight = Gdx.graphics.getHeight();
	screenWidth = Gdx.graphics.getWidth();
	dofus = new BitmapImage ("pictures/heart.png");
}

@Override
public void onGraphicRender(GdxGraphics g) {
	g.clear();
	//g.drawAntiAliasedCircle(screenWidth/2, screenHeight/2, radius, Color.BLUE);
	g.drawFPS();
	g.drawAlphaPicture(screenHeight/2, screenWidth/2,0,scale,(float) 1, dofus);
	
	if (scale>=1 || scale <=0.5){
		speed *= -1;
	}
	
	
	scale += speed;
	
	g.drawSchoolLogo();
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	new test();

}}
