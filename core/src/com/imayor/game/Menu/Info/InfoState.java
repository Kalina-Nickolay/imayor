package com.imayor.game.Menu.Info;

/*
Класс информации об авторах. Вероятно будет использоваться в целях вывода статистики последней игровой сессии.
 */


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.MenuState;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class InfoState implements Screen {
    final Settings set;
    final Resources res;
    final IMayor game;
    final InfoState infostate;

    private Stage stage;

    public InfoState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        infostate = this;
        create();
    }

    private void create(){
        stage = new Stage(new ScreenViewport());
        //stage.addActor(res.background);

        Gdx.input.setCatchBackKey(true);

        InputProcessor inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                switch(keycode){
                    case Input.Keys.BACK:
                        game.setScreen(new MenuState(game));
                        infostate.dispose();
                        break;
                }
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
