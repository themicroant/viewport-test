package com.demo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.demo.ViewportTest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.x = 200;
		config.y = 200;
		config.width = 1440/3;
		config.height = 2560/3;
		// 	2,560 x 1,440 galaxy s7
		new LwjglApplication(new ViewportTest(), config);
	}
}
