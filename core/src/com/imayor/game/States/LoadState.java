package com.imayor.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.InfoButton;
import com.imayor.game.Actors.PlayButton;
import com.imayor.game.Actors.SettingButton;
import com.imayor.game.Actors.StoreButton;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;

/**
 * Created by Kalina on 25.11.2016.
 */


public class LoadState implements Screen {
    final IMayor game;
    private Stage stage;
    public Image background;

    public LoadState(IMayor game) {
        this.game = game;

        create();
    }

    private void create(){
        stage = new Stage(new ScreenViewport());

        background = new Image(new Texture("splash.png"));
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        background.setPosition(0,0);

        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(false);//Встроенная кнопка назад на устройстве.

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (game.gotovo ==1)
            game.setScreen(new MenuState(game));
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
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
