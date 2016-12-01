package com.imayor.game.Actors;

/*
Верхний колонтитул с ресурсами
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;
import com.imayor.game.States.GameState;

public class GameHeader {
    private final Settings set;
    private final Resources res;
    private final IMayor game;

    //----Фон хидера----
    public Image background;

    //Картинки ресурсов
    public Image heap1, heap2, heap3, heap4;

    //----Фоны ресурсов----
    public Image heap1w, heap2w, heap3w, heap4w;
    public Image heap1b, heap2b, heap3b, heap4b;

    //----Подписи количества ресурсов (В идеале)----
    public Label label1, label2, label3, label4;

    //---- ----
    private int w,h;
    //---- -----
    Skin skin;

    //---- ----
    TextureAtlas heapAtlas;

    public GameHeader(final IMayor game) {
        this.set = game.set;
        this.res = game.res;
        this.game = game;
        Create();
    }

    public void Create(){
        background =  new Image(res.skin.getSprite("RubyColor"));

        skin = new Skin();//Для цветовой палитры.
        heapAtlas = new TextureAtlas(Gdx.files.internal("heap.pack"));//Цветовая палитра.
        skin.addRegions(heapAtlas);//Регионы цветовой палитры.
        heap1b = new Image(res.skin.getSprite("BlackColor"));
        heap2b = new Image(res.skin.getSprite("BlackColor"));
        heap3b = new Image(res.skin.getSprite("BlackColor"));
        heap4b = new Image(res.skin.getSprite("BlackColor"));

        heap1 = new Image(skin.getSprite("Heap1"));
        heap2 = new Image(skin.getSprite("Heap2"));
        heap3 = new Image(skin.getSprite("Heap3"));
        heap4 = new Image(skin.getSprite("Heap4"));

        heap1w = new Image(res.skin.getSprite("WhiteColor"));
        heap2w = new Image(res.skin.getSprite("WhiteColor"));
        heap3w = new Image(res.skin.getSprite("WhiteColor"));
        heap4w = new Image(res.skin.getSprite("WhiteColor"));

        label1 = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label2 = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label3 = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label4 = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));

        Resize();

        background.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                label1.setText("" + res.heap1);
                label2.setText("" + res.heap2);
                label3.setText("" + res.heap3);
                label4.setText("" + res.heap4);

                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                label1.setText("");
                label2.setText("");
                label3.setText("");
                label4.setText("");
            };
        });
    }

    public void Resize(){
        background.setSize(res.height, res.height*1/10);
        background.setPosition(0, res.height*9/10);

        w = res.height*1/10*7/10;//Ширина одной формочки;
        h = res.height*1/10;//Высота одной формочки;

        heap1b.setSize(w,h);
        heap1b.setPosition((res.width - w*4)/5*1 + w*0 , res.height*9/10);
        heap2b.setSize(w,h);
        heap2b.setPosition((res.width - w*4)/5*2 + w*1 , res.height*9/10);
        heap3b.setSize(w,h);
        heap3b.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10);
        heap4b.setSize(w,h);
        heap4b.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10);

        Reheader();

        heap1.setSize(w,h);
        heap1.setPosition((res.width - w*4)/5*1 + w*0 , res.height*9/10);
        heap2.setSize(w,h);
        heap2.setPosition((res.width - w*4)/5*2 + w*1 , res.height*9/10);
        heap3.setSize(w,h);
        heap3.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10);
        heap4.setSize(w,h);
        heap4.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10);


        label1.setPosition((res.width - w*4)/5*1 + w*0 , res.height*9/10 + h*5/100);
        //label1.setFontScale(h*15/100);//МОЖНО ПОПРОБОВАТЬ ИЗМЕНИТЬ 5 НА 15!!!
        label2.setPosition((res.width - w*4)/5*2 + w*1 , res.height*9/10 + h*5/100);
        //label2.setFontScale(h*15/100);//МОЖНО ПОПРОБОВАТЬ ИЗМЕНИТЬ 5 НА 10!!!
        label3.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10 + h*5/100);
        //label3.setFontScale(h*15/100);
        label4.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10 + h*5/100);
        //label4.setFontScale(h*15/100);
    }

    public void Reheader(){
        heap1w.setSize(w, h * 7/10 * res.heap1/100);
        heap1w.setPosition((res.width - w*4)/5*1 + w*0, res.height*9/10+h*15/100);
        heap2w.setSize(w, h * 7/10 * res.heap2/100);
        heap2w.setPosition((res.width - w*4)/5*2 + w*1, res.height*9/10+h*15/100);
        heap3w.setSize(w, h * 7/10 * res.heap3/100);
        heap3w.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10+h*15/100);
        heap4w.setSize(w, h * 7/10 * res.heap4/100);
        heap4w.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10+h*15/100);
    }
}
