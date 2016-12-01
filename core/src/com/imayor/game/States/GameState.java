package com.imayor.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.Actors.GameAnswer;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.GameFooter;
import com.imayor.game.Actors.GameHeader;
import com.imayor.game.IMayor;
import com.imayor.game.MyGestureListener;
import com.imayor.game.Resources;
import com.imayor.game.Settings;

/*
Класс игрового экрана
 */

public class GameState implements Screen {
    final Settings set;
    final Resources res;
    final IMayor game;
    final GameCard card;
    final GameHeader header;
    final GameFooter footer;
    final GameAnswer answer;

    private Stage stage;

    public GameState(final IMayor game) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card= game.card;
        this.header = game.header;
        this.footer = game.footer;
        this.answer = game.answer;

        stage = new Stage(new ScreenViewport());
        create();
    }

    private void create(){
        //----Очищаем сцену----
        //stage.dispose();

        //----Обнуляем смещение----
        res.pos = 0;

        //----Выбираем карту----
        card.Select();

        //----Добавляем актёра - фон
        this.stage.addActor(res.background);

        //----Добавляем актёра - карточку----
        this.stage.addActor(card.imageture.get(card.current));

        //----Добавляем актёра - текс карточки----
        this.stage.addActor(card.label);

        //----Добавляем актёра - хидера----
        this.stage.addActor(header.background);

        //----Добавляем актёров - фоны для ресурсов----
        this.stage.addActor(header.heap1b);
        this.stage.addActor(header.heap2b);
        this.stage.addActor(header.heap3b);
        this.stage.addActor(header.heap4b);

        //----Добавляем актёров - количество ресурсов----
        this.stage.addActor(header.heap1w);
        this.stage.addActor(header.heap2w);
        this.stage.addActor(header.heap3w);
        this.stage.addActor(header.heap4w);

        //----Добавляем формочки ресурсов----
        this.stage.addActor(header.heap1);
        this.stage.addActor(header.heap2);
        this.stage.addActor(header.heap3);
        this.stage.addActor(header.heap4);

        //----Добавляем подписи количества ресурсов под формочками ресурсов----
        //this.stage.addActor(header.label1);
        //this.stage.addActor(header.label2);
        //this.stage.addActor(header.label3);
        //this.stage.addActor(header.label4);

        //----Добавляем футер с количеством очков----
        this.stage.addActor(footer.background);
        this.stage.addActor(footer.label);

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener(game, this)));
        Gdx.input.setCatchBackKey(true);//Встроенная кнопка назад на устройстве.
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        answer.Create();
        if (res.pos != 0) {
                this.stage.addActor(answer.wanser);
                this.stage.addActor(answer.label);
            }
        stage.act(delta);
        stage.draw();
        SpriteBatch batch = new SpriteBatch();
        batch.begin();

        batch.enableBlending();//Включили прозрачность

        //batch.draw(answer.tanser, 0, res.height*1/10 + res.width*1/10 + res.width*8/10*9/10, res.width, res.width*8/10*2/10);
        batch.disableBlending();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

        //----Меняем разрешение экрана----
        res.width=width;
        res.height=height;

        //----Пересчитываем все координаты для нового разрешения экрана----
        for (int i=0; i<res.counts; i++)
        card.Recard(i);
        header.Resize();
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
