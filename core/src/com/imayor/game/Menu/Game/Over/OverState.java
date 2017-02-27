package com.imayor.game.Menu.Game.Over;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.Menu.Game.GameState;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;

/*

 */

public class OverState implements Screen {
    final IMayor game;
    final Resources res;
    private OverButtons overbuttons;
    private Stage stage;
    public GameState gamestate;
    public Image background;
    public OverState overstate;
    public OverLabel overlabel;

    public OverState(IMayor game, GameState gamestate) {
        this.game = game;
        this.res = game.res;
        this.gamestate = gamestate;
        overstate = this;
        overbuttons = new OverButtons(game, this, gamestate);
        overlabel = new OverLabel(game);

        res.musicG.pause();
        res.musicM.pause();

        create();
    }

    private void create(){
        //gamestate.treate();//Пересобираем весь игровой стейдж
        stage = new Stage(new ScreenViewport());

        gamestate.card.Recard();
        gamestate.header.Resize();
        gamestate.footer.Update();

        stage.addActor(res.BackgroundSettings);
        stage.addActor(gamestate.card.group);
        stage.addActor(gamestate.header.group);
        stage.addActor(gamestate.footer.group);

        stage.addActor(overbuttons.group);
        stage.addActor(overlabel.label);

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
