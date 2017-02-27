package com.imayor.game.Menu.Game;

/*
Класс карточек
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;

import java.util.Random;

public class GameCard extends Actor{
    //----Для удобства локализуем переменные ресурсов----
    final Resources res;

    final Random random = new Random();

    //Левый ответ, правый ответ, вопрос, префикс, карточка в случае сдвига вправо, карточка в случае сдвига влево
    public String question, annexLeft, annexRight;

    //----Непотребство----
    public int licentiousnessLeft1, licentiousnessLeft2, licentiousnessLeft3, licentiousnessLeft4, licentiousnessRight1, licentiousnessRight2, licentiousnessRight3, licentiousnessRight4;
    //----Текстовое представление вопроса----

    //----Изображение карточка----
    public Image cardImage;

    public Label label;

    //----Индекс текущей карточки----
    public int tur = 1;

    //----Текущая карточка----
    public int cur = 1;

    public Group group;

    private String str;

    public GameCard(final IMayor game){
        this.res = game.res;

        res.arial((res.height*8/10 - res.width)/8);
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label.setWrap(true);
        label.setWidth(res.width*8/10);
        label.setHeight((res.height*8/10 - res.width)/8);
        label.setAlignment(Align.center, Align.center);
        label.setPosition(res.width*1/10, res.height*1/10 + res.width + (res.height*8/10-res.width)/2);

        Record();


        Create();

    }

    //----Выбор карточки----
    public void Select() {
            tur = (int) (Math.random() * res.wounts);
            res.cardName = res.won.get(tur) + "";
            res.won.removeIndex(tur);
            res.wounts--;
    }

    public void Record(){
        FileHandle cardPack = Gdx.files.internal(res.cardName+".card.pack");
        str = new String(cardPack.readString());




        res.leftAnswer = ((str.substring(0, str.indexOf("$"))));
        str = str.substring(str.indexOf('$') + 1);
        res.rightAnswer = ((str.substring(0, str.indexOf("$"))));
        str = str.substring(str.indexOf('$') + 1);
        question = ((str.substring(0, str.indexOf("$"))));
        str = str.substring(str.indexOf('$') + 1);
        annexLeft = ((str.substring(0, str.indexOf("$"))));
        str = str.substring(str.indexOf('$') + 1);
        annexRight = ((str.substring(0, str.indexOf("$"))));
        str = str.substring(str.indexOf('$') + 1);

        licentiousnessLeft1 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessLeft2 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessLeft3 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessLeft4 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);

        licentiousnessRight1 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessRight2 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessRight3 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        licentiousnessRight4 = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);



        res.leftCrete = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);
        res.rightCrete = (Integer.parseInt((str.substring(0, str.indexOf("$")))));
        str = str.substring(str.indexOf('$') + 1);

        cardImage = new Image(new Texture(res.cardName + ".card.png"));
        cardImage.setSize(res.width*8/10, res.width*8/10);

        label.setText(question);
    }

    public void Create(){


        Recard();
        group = new Group();
        group.addActor(label);
        group.addActor(cardImage);
    }

    public void Recard(){//Размер и изменение размера.
        cardImage.setPosition(res.width*1/10+res.pos, res.height*1/10 + res.width*1/10);
    }

    public void Zero(){
        res.cardName="0";
        res.meownts=0;
        res.wounts=res.counts;
        res.heap1=50;
        res.heap2=50;
        res.heap3=50;
        res.heap4=50;
        res.won.clear();

        for (int i=1; i<=res.counts; i++){
            res.won.add(i);
        }
    }
}
