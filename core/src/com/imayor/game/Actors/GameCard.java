package com.imayor.game.Actors;

/*
Класс карточек
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;
import java.util.Random;

public class GameCard extends Actor{
    //----Для удобства локализуем переменные ресурсов----
    final Resources res;
    final Settings set;
    final IMayor game;
    final Random random = new Random();

    //----Текстовое представление вопроса----
    public Label label;

    //----Массив картинок----
    public Array<Image> imageture = new Array <Image>();

    //----Массив надписей----
    public Array<String> scripture = new Array <String>();

    //----Набор массивов непотребства справа----
    public Array<Integer>
            Heap1R = new Array<Integer>(),
            Heap2R = new Array<Integer>(),
            Heap3R = new Array<Integer>(),
            Heap4R = new Array<Integer>();

    //----Набор массивов непотребства слева----
    public Array<Integer>
            Heap1L = new Array<Integer>(),
            Heap2L = new Array<Integer>(),
            Heap3L = new Array<Integer>(),
            Heap4L = new Array<Integer>();

    //----Текущая карточка----
    public int current=0;

    //Для коллизий
    public Rectangle l,r,c;

    private String stk;
    private String str;

    public GameCard(final IMayor game){
        this.set = game.set;
        this.res = game.res;
        this.game = game;

        Create();
    }

    public void Create(){//Создаём все карточки
        c=new Rectangle();
        c.setSize(res.width*8/10, res.width*8/10);
        l = new Rectangle(0,0,1,res.height);
        r = new Rectangle(res.width,0,1, res.height);

        int j=0;
        for(int i = 0; i<res.counts; i++) {
            stk = Integer.toString(j) + Integer.toString(i);
            imageture.add(new Image(new Texture("card" + stk +".png")));
            Recard(j);
            j++;
        }

        FileHandle query = Gdx.files.internal("query.pack");
        //----ОЧЕНЬ ВАЖНО СОХРАНЯТЬ ФАЙЛ С ВОПРОСАМИ В КОДИРОВКЕ UTF-8
        str = new String(query.readString());
        for(int i =0; i<res.counts; i++) {
            scripture.add(str.substring(0, str.indexOf("$")));
            str = str.substring(str.indexOf('$') + 1);
        }

        FileHandle licentiousness = Gdx.files.internal("licentiousness.pack");
        str = licentiousness.readString();
        for(int i = 0; i<res.counts; i++) {
            Heap1R.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap2R.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap3R.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap4R.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap1L.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap2L.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap3L.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            Heap4L.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
            str = str.substring(str.indexOf('$') + 1);
            res.won.add(i);
        }

            res.arial((res.height*8/10 - res.width)/8);
            label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
            label.setWrap(true);
            label.setWidth(res.width*8/10);
            label.setHeight((res.height*8/10 - res.width)/8);
            Relabel();
    }

    public void Select(){
        current = random.nextInt(res.wounts);
    }

    public void Recard(int i){//Размер и изменение размера.
        imageture.get(i).setSize(res.width*8/10, res.width*8/10);
        imageture.get(i).setPosition(res.width*1/10+res.pos, res.height*1/10 + res.width*1/10);
        Origin(this.current);
    }

    public void Relabel(){
        label.setAlignment(Align.center, Align.center);
        label.setPosition(res.width*1/10, res.height*1/10 + res.width + (res.height*8/10-res.width)/2);
        label.setText(scripture.get(current));
    }

    //----Угол поворота карточки----
    public void Origin(int i){
        imageture.get(i).setOriginX(160);
    }

    //----Возвращение переменной обратно----
    public void Return(){
    if (collides()){
        //ЗДЕсь БУДЕТ ПРОИСХОДИТЬ ВЕСЬ ПИЗДЕЦ
    }
    }

    //----Возникновение коллизии----
    public boolean collides(){
        return c.overlaps(l) || c.overlaps(r);
    }
}
