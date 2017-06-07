package ch.hevs.gdx2d.hello;

import ch.hevs.gdx2d.lib.ScreenManager;

public class Screens {
	
	// Attributes
	private static Screens instance;
	public ScreenManager s = new ScreenManager();
	
	// Constructor
	private Screens(){}
	
	// Method
	public static Screens getInstance() {
		if(instance == null){
			instance = new Screens();
			return instance;
		}
		else
			return instance;
	}
}
