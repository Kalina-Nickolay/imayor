//Пора сделать этот город легендой!
//Или хотя бы разрушить его

package com.imayor.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.imayor.game.Menu.Game.GameAnswer;
import com.imayor.game.Menu.Game.GameCard;
import com.imayor.game.Menu.Game.GameFooter;
import com.imayor.game.Menu.Game.GameHeader;
import com.imayor.game.Menu.Game.GameState;
import com.imayor.game.Menu.MenuState;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class IMayor extends Game{

	//----Хранилища постоянных и переменных величин----
	public com.imayor.game.Res.Resources res;
	public com.imayor.game.Res.Settings set;
	public GameCard card;
	public GameHeader header;
	public GameFooter footer;
	public GameAnswer answer;
	public GameState gamestate;

	public adsController controller;
	//
	public IMayor(adsController controller) {
		if (controller != null) {
			this.controller = controller;
		} else {
			this.controller = new DummyAdsController();
		}
	}

	@Override
	public void create () {
		//----Создаём и инициализируем хранилища постоянных и переменных велечин----
		res = new Resources();
		set = new Settings(res);

		this.setScreen(new MenuState(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}



	public void InterstitialAd(){
		//if (controller.isWifiConnected()) {
			controller.showInterstitialAd(new Runnable() {
				@Override
				public void run() {
					System.out.println("Interstitial app closed");
					Gdx.app.exit();
				}
			});
		//} else {
		//	System.out.println("Interstitial ad not (yet) loaded");
		//}
	}
}
