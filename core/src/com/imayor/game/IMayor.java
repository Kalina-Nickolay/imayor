//login: kalina.moran
//password: dionatur

package com.imayor.game;

import com.badlogic.gdx.Game;
import com.imayor.game.Actors.GameAnswer;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.GameFooter;
import com.imayor.game.Actors.GameHeader;
import com.imayor.game.States.GameState;
import com.imayor.game.States.LoadState;
import com.imayor.game.States.MenuState;

public class IMayor /*extends ApplicationAdapter*/ extends Game {

	//----Хранилища постоянных и переменных величин----
	public Resources res;
	public Settings set;
	public GameCard card;
	public GameHeader header;
	public GameFooter footer;
	public Statistics stat;
	public GameAnswer answer;

	//----Переменные для удаления. Реализовано по тупому----
	public MenuState menustate;
	public GameState gamestate;

	public int gotovo=0;

	public IMayor () {
	}

	@Override
	public void create () {
		this.setScreen(new LoadState(this));

		//----Создаём и инициализируем хранилища постоянных и переменных велечин----
		res = new Resources();
		set = new Settings(res);
		card = new GameCard(this);
		header = new GameHeader(this);
		footer = new GameFooter(this);
		stat = new Statistics(this);
		answer = new GameAnswer(this);

		gotovo=1;
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}


}
