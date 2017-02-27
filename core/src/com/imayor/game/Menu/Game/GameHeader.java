package com.imayor.game.Menu.Game;

/*
Верхний колонтитул с ресурсами
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class GameHeader {
    private final Resources res;

    //----Фон хидера----
    private Image background;
    public Group group;

    //Картинки ресурсов
    private Image heap1, heap2, heap3, heap4;

    //----Фоны ресурсов----
    private Image heap1w, heap2w, heap3w, heap4w;
    private Image heap1b, heap2b, heap3b, heap4b;

    //---- ----
    private int w,h;

    //---- -----
    Skin skin;

    //---- ----
    TextureAtlas heapAtlas;

    public GameHeader(final IMayor game) {

        this.res = game.res;
        Create();
        group = new Group();
        //----Добавляем актёра - хидера----
        group.addActor(background);

        //----Добавляем актёров - фоны для ресурсов----
        group.addActor(heap1b);
        group.addActor(heap2b);
        group.addActor(heap3b);
        group.addActor(heap4b);

        //----Добавляем актёров - количество ресурсов----
        group.addActor(heap1w);
        group.addActor(heap2w);
        group.addActor(heap3w);
        group.addActor(heap4w);

        //----Добавляем формочки ресурсов----
        group.addActor(heap1);
        group.addActor(heap2);
        group.addActor(heap3);
        group.addActor(heap4);

        //----Добавляем подписи количества ресурсов под формочками ресурсов----
        //this.stage.addActor(label1);
        //this.stage.addActor(label2);
        //this.stage.addActor(label3);
        //this.stage.addActor(label4);

    }

    public void Create(){
        if (res.ton.equals("Lite"))
        background =  new Image(res.skin.getSprite("Six"));
        else
        background = new Image(res.skin.getSprite("One"));
        skin = new Skin();//Для цветовой палитры.
        heapAtlas = new TextureAtlas(Gdx.files.internal(res.ton + "Heap.pack"));//Цветовая палитра.
        skin.addRegions(heapAtlas);//Регионы цветовой палитры.
        heap1 = new Image(skin.getSprite("Heap1"));
        heap2 = new Image(skin.getSprite("Heap2"));
        heap3 = new Image(skin.getSprite("Heap3"));
        heap4 = new Image(skin.getSprite("Heap4"));

        heap1b = new Image(res.skin.getSprite("Eight"));
        heap2b = new Image(res.skin.getSprite("Eight"));
        heap3b = new Image(res.skin.getSprite("Eight"));
        heap4b = new Image(res.skin.getSprite("Eight"));

        heap1w = new Image(res.skin.getSprite("Seven"));
        heap2w = new Image(res.skin.getSprite("Seven"));
        heap3w = new Image(res.skin.getSprite("Seven"));
        heap4w = new Image(res.skin.getSprite("Seven"));

        w = res.height*1/10*7/10;//Ширина одной формочки;
        h = res.height*1/10;//Высота одной формочки;

        background.setSize(res.width, h);
        background.setPosition(0, res.height*9/10);

        heap1b.setSize(w,h);
        heap2b.setSize(w,h);
        heap3b.setSize(w,h);
        heap4b.setSize(w,h);

        heap1b.setPosition((res.width - w*4)/5*1 + w*0 , res.height*9/10);
        heap2b.setPosition((res.width - w*4)/5*2 + w*1 , res.height*9/10);
        heap3b.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10);
        heap4b.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10);

        heap1w.setPosition((res.width - w*4)/5*1 + w*0, res.height*9/10+h*15/100);
        heap2w.setPosition((res.width - w*4)/5*2 + w*1, res.height*9/10+h*15/100);
        heap3w.setPosition((res.width - w*4)/5*3 + w*2, res.height*9/10+h*15/100);
        heap4w.setPosition((res.width - w*4)/5*4 + w*3, res.height*9/10+h*15/100);

        heap1.setSize(w,h);
        heap2.setSize(w,h);
        heap3.setSize(w,h);
        heap4.setSize(w,h);

        heap1.setPosition((res.width - w*4)/5*1 + w*0 , res.height*9/10);
        heap2.setPosition((res.width - w*4)/5*2 + w*1 , res.height*9/10);
        heap3.setPosition((res.width - w*4)/5*3 + w*2 , res.height*9/10);
        heap4.setPosition((res.width - w*4)/5*4 + w*3 , res.height*9/10);
        Resize();
    }

    public void Resize(){
        heap1w.setSize(w, h * 7/10 * res.heap1/100);
        heap2w.setSize(w, h * 7/10 * res.heap2/100);
        heap3w.setSize(w, h * 7/10 * res.heap3/100);
        heap4w.setSize(w, h * 7/10 * res.heap4/100);
    }
}
