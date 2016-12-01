package com.imayor.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.imayor.game.IMayor;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "IMayor";//Название окна.
		config.width = 360;//Ширина окна.
		config.height = 640;//Высота окна.
		new LwjglApplication(new IMayor(), config);
	}
}
