package com.imayor.game.Menu.Game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.Game.GameState;
import com.imayor.game.Menu.Game.Over.OverState;
import com.imayor.game.Menu.MenuState;

public class MyInputListener implements InputProcessor {
    public final IMayor game;
    public final GameState gamestate;

    public MyInputListener(IMayor game, GameState gamestate) {
        this.game = game;
        this.gamestate = gamestate;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode){
            case Input.Keys.BACK:
                game.setScreen(new MenuState(game));
                gamestate.pause();
                if (gamestate.res.music)
                    gamestate.res.musicG.pause();
                gamestate.res.pause=true;
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
}
