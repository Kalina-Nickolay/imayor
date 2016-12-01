package com.imayor.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;

/*

 */

public class OverState implements Screen {
    final IMayor game;
    final Resources res;
    private Stage stage;
    public Image background;
    public Image restart;
    public OverState over;
    public Label label;
    public OverState(IMayor game) {
        this.game = game;
        this.res = game.res;
        over = this;

        res.musicG.stop();
        res.musicM.stop();

        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label.setPosition(res.width/2, res.height/2);
        if(res.heap1<=0) label.setText("Вы проиграли. Город задыхается в пыли. Обнаруженный рак лёгких вас доканал и прикончил к радости толпы");
        if(res.heap2<=0) label.setText("Вы проиграли. Вам грозит пожизненное заключение за массовое убийство по неосторожности, ведь из под вашей лёгкой руки вышел приказ строить то здание над лабиринтом с острова Русский");
        if(res.heap3<=0) label.setText("Вы проиграли. В порыве ненависти толпа закидала вас собственными ботинками во время выступления на дебатах. ");
        if(res.heap4<=0) label.setText("Вы проиграли. Вас преследуют за хищение в особо крупных размерах");
        if(res.heap1<=0 & res.wounts<=0) label.setText("Вы выиграли. Благодаря вам беличьи семьи населили скверы и парки, дети гуляют без респираторов, а взрослые тщательно следят за флорой и фауной");
        if(res.heap2<=0 & res.wounts<=0) label.setText("Вы выиграли. Ни одной пробки. Солнце наполняет город и радует всех жителей.");
        if(res.heap3<=0 & res.wounts<=0) label.setText("Вы выиграли. Люди поддерживают вас на новой избирательной компании");
        if(res.heap4<=0 & res.wounts<=0) label.setText("Вы выиграли. Бюджет города полон и готов к расцвету не только города, но и края");

        create();
    }

    private void create(){

        stage = new Stage(new ScreenViewport());

        background = new Image(new Texture("splash.png"));
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        background.setPosition(0,0);
;
        restart = new Image(new Texture("rs.png"));
        restart.setSize(res.width*3/10, res.width*3/10);
        restart.setPosition(res.width/2-res.width*15/100, res.height*3/8);
        restart.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MenuState(game));
                over.dispose();
            };
        });

        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(false);//Встроенная кнопка назад на устройстве.
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.addActor(label);
        stage.addActor(restart);
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
