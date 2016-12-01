package com.imayor.game;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.imayor.game.IMayor;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;//Для экономии заряда выключаем акселерометр.
		config.useCompass = false;//Для экономии заряда выключаем компасс.
		config.useGyroscope = false;//Для экономии арда выключаем гироскоп.
		initialize(new IMayor(), config);

	}

	@Override
	public void exit() {

	}
}
