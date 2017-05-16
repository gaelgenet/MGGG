package ch.hevs.gdx2d.hello;

import java.util.ArrayList;

import ch.hevs.gdx2d.components.bitmaps.BitmapImage;
import ch.hevs.gdx2d.lib.GdxGraphics;
import ch.hevs.gdx2d.lib.interfaces.DrawableObject;

public class Mur implements DrawableObject {

	ArrayList<Mur> mures = new ArrayList<Mur>();

	static BitmapImage mur;
	int posx;
	int posy = 50;

	public Mur() {

	}

	public Mur(int posx) {
		this.posx = posx;

	}

	public void update() {
		if (posx < -300) {
			posx += 1920;

		}
	}

	public void onInit() {
		mur = new BitmapImage("data/images/mur.png");

		Mur m1 = new Mur(0);
		Mur m2 = new Mur(640);
		Mur m3 = new Mur(1280);

		mures.add(m1);
		mures.add(m2);
		mures.add(m3);
	}

	public void drawM(GdxGraphics g) {

		for (Mur m : mures) {
			m.draw(g);
			m.posx -= 3;
		}
	}

	@Override
	public void draw(GdxGraphics g) {

		g.drawPicture(posx, posy, mur);

		for (Mur m : mures) {
			m.update();
		}

	}

}
