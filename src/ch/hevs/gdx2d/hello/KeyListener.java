package ch.hevs.gdx2d.hello;

import com.badlogic.gdx.Input;

public class KeyListener {
	
	static boolean change = true;
	
	public static void onKeyDown(int keycode) {
		switch (keycode) {
		
		//jump
		case Input.Keys.SPACE:
			Bonhomme.move = true;
			break;
			
		//pause-play
		case Input.Keys.SHIFT_RIGHT:
			
			if(change){
			Cube.play = false;
			CubeManager.play = false;
			change = false;
			}
			else{
				Cube.play = true;
				CubeManager.play = true;
				change = true;
			}
			break;
			
		default:
			break;
		}

}}
