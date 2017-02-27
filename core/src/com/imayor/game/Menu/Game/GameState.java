package com.imayor.game.Menu.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.Game.Over.OverState;
import com.imayor.game.Menu.MenuState;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

/**
 * Created by Kalina on 02.12.2016.
 */

public class GameState implements Screen {
    public final Settings set;
    public final Resources res;
    public final IMayor game;
    public GameCard card;
    public GameHeader header;
    public GameFooter footer;
    public GameAnswer answer;

    public Image background;
    private float SSS;
    public Stage stage;
    public Group group;
    public InputProcessor inputProcessor;

    public GameState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card = game.card;
        this.footer = game.footer;
        this.header = game.header;
        this.answer = game.answer;

        //!!!!Сразу удаляем первую карточку чтобы она не появилась вновь!!!!
        //res.won.removeIndex(Integer.parseInt(res.cardName));
        //res.wounts--;

        background =  new Image(res.skin.getSprite("Seven"));
        background.setSize(res.width, res.height);
        background.setPosition(0, 0);

        if (res.music) {
            if (res.pause)
                res.musicM.pause();
            else
                res.musicM.stop();
            res.musicM.play();
        } else {
            res.musicM.stop();
        }

        if (res.music) {
            if (res.pause)
                res.musicG.pause();
            else
                res.musicG.stop();
            res.musicG.play();
        } else
            res.musicG.stop();

        create();
    }

    public void create() {
        //----Очищаем сцену---
        card = new GameCard(game);
        footer = new GameFooter(game);
        header = new GameHeader(game);
        answer = new GameAnswer(game);

        stageCreate();
    }

    public void stageCreate() {
        stage = new Stage(new ScreenViewport());
        stage.addActor(background);
        stage.addActor(card.group);
        stage.addActor(footer.group);
        stage.addActor(header.group);
        stage.addActor(answer.group);
        //Gdx.input.setCatchBackKey(true);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(new GestureDetector(new MyGestureListener(game, this)));
        multiplexer.addProcessor(new MyInputListener(game, this));
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void stageUpdate(){

        stage.clear();
        res.pos=0;
        card.Record();//Заменяем файл и картинку
        card.Recard();
        footer.Update();//Изменяем футер
        header.Resize();//хидер
        answer.Zero();
        stage.addActor(background);
        stage.addActor(card.label);
        stage.addActor(card.cardImage);
        stage.addActor(footer.group);
        stage.addActor(header.group);
        stage.addActor(answer.wanser1);
        stage.addActor(answer.wanser2);
        stage.addActor(answer.label);
    }

    public void AddHearth() {
        if (res.heap1 <= 10)
            res.heap1 += 20;
        if (res.heap2 <= 10)
            res.heap2 += 20;
        if (res.heap3 <= 10)
            res.heap3 += 20;
        if (res.heap4 <= 10)
            res.heap4 += 20;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (res.maybemust == false)
        {

            if (res.pos >= -10 & res.pos <= 10) {
                res.maybemust = true;
                res.pos=0;
            }
            if (res.pos < 0)
                res.pos +=20;
            else
                res.pos -=20;
            card.Recard();
            answer.Zero();
        }

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

        //----Меняем разрешение экрана----
        res.width = width;
        res.height = height;
    }

    @Override
    public void pause() {
        res.musicG.pause();
        res.pause = true;
    }

    @Override
    public void resume() {
        res.musicG.play();
        res.pause = false;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}