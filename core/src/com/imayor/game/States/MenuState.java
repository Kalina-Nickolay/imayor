package com.imayor.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.InfoButton;
import com.imayor.game.Actors.PlayButton;
import com.imayor.game.Actors.SettingButton;
import com.imayor.game.Actors.StoreButton;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;

/*
Класс меню
 */

public class MenuState implements Screen {
    final Settings set;
    final Resources res;
    final IMayor game;
    final GameCard card;

    private PlayButton play;
    private StoreButton store;
    private SettingButton setting;
    private InfoButton info;

    private Stage stage;

    public MenuState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card= game.card;
        create();
    }

    private void create(){
        play = new PlayButton(game, this);
        info = new InfoButton(game, this);
        setting = new SettingButton(game, this);
        store = new StoreButton(game, this);

        stage = new Stage(new ScreenViewport());
        stage.addActor(res.background);
        stage.addActor(play.button);
        stage.addActor(store.button);
        stage.addActor(setting.button);
        stage.addActor(info.button);

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(false);//Встроенная кнопка назад на устройстве.

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        res.width = width;
        res.height = height;

        //Изменяем размер кнопок для десктопной версии
        play.resize();
        setting.resize();
        info.resize();
        store.resize();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        play = null;
        store = null;
        setting = null;
        info = null;
        stage.dispose();
    }
}
