package com.imayor.game.States;

/*
Класс информации об авторах. Вероятно будет использоваться в целях вывода статистики последней игровой сессии.
 */


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.InfoButton;
import com.imayor.game.Actors.PlayButton;
import com.imayor.game.Actors.SettingButton;
import com.imayor.game.Actors.StoreButton;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;
import com.imayor.game.Statistics;

public class InfoState implements Screen {
    final Settings set;
    final Resources res;
    final IMayor game;
    final Statistics stat;

    private Stage stage;

    public InfoState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.stat = game.stat;
        create();
    }

    private void create(){
        stage = new Stage(new ScreenViewport());
        stage.addActor(res.background);

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
        stage.dispose();
    }
}
