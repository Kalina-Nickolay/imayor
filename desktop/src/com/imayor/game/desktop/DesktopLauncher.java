package com.imayor.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.imayor.game.IMayor;
import com.imayor.game.adsController;

public class DesktopLauncher implements adsController {
	public void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "IMayor";//Название окна.
		config.width = 360;//Ширина окна.
		config.height = 640;//Высота окна.

		new LwjglApplication(new IMayor(null), config);
	}

	@Override
	public void showBannerAd() {

	}

	@Override
	public void hideBannerAd() {

	}

	@Override
	public void showInterstitialAd(Runnable then) {

	}

	@Override
	public boolean isWifiConnected() {
		return false;
	}
}