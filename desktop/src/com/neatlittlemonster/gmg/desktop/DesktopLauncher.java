package com.neatlittlemonster.gmg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.neatlittlemonster.gmg.GMG;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game Masters Guide";
		config.width = GMG.camWidth;
		config.height = GMG.camHeight;
		new LwjglApplication(new GMG(), config);
	}
}
