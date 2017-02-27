package com.imayor.game.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.Menu.Game.GameCard;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.Game.GameState;
import com.imayor.game.Menu.Setting.SettingState;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

/*
Класс меню
 */

public class MenuState implements Screen {
    final Settings set;
    final Resources res;
    final IMayor game;
    final GameCard card;
    final MenuState menu;

    private MenuButtons menubuttons;
    private Stage stage;

    public MenuState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card= game.card;
        this.menu = this;

        create();
    }

    private void create(){
        menubuttons = new MenuButtons(game, this);

        stage = new Stage(new ScreenViewport());
        stage.addActor(menubuttons.group);

        if(game.controller.isWifiConnected()) {game.controller.showBannerAd();}
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);//Встроенная кнопка назад на устройстве перехватывается и остается без какого-либо действия

        InputProcessor inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (res.canmust) {
                    game.setScreen(new GameState(game));
                    menu.dispose();
                    res.musicM.pause();
                }
                else
                    res.plus=30;
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(inputProcessor);
        Gdx.input.setInputProcessor(multiplexer);

        /*menubuttons = new MenuButtons(game, this);

        stage = new Stage(new ScreenViewport());
        stage.addActor(res.background);
        stage.addActor(menubuttons.group);

        if(game.controller.isWifiConnected()) {game.controller.showBannerAd();}
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);//Встроенная кнопка назад на устройстве перехватывается и остается без какого-либо действия*/
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (res.scrollbackground<=-10)
            res.scrollbackground=res.scrollbackground+res.plus;
        if (res.scrollbackground>=-41 & res.scrollbackground<=-10) {
            res.canmust = true;

        }

        if (res.canmust) {
            if (res.hinttostart>60)
                res.hinttostart = 0;
            menubuttons.GroupCorrect();
            res.hinttostart++;
            if (res.hinttostart == 25) {
               menubuttons.ReHint(false);
            }
            if (res.hinttostart == 50) {
                menubuttons.ReHint(true);
                res.hinttostart = 0;
            }
        }
        menubuttons.Resize();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        res.width = width;
        res.height = height;

        //Изменяем размер кнопок для десктопной версии

        menubuttons.Resize();
    }

    @Override
    public void pause() {
        res.musicM.pause();
    }

    @Override
    public void resume() {
        res.musicM.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        menubuttons = null;
        stage.dispose();
    }
}
