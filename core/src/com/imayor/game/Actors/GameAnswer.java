package com.imayor.game.Actors;

/*
Класс ответочки
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;

public class GameAnswer {
    final Resources res;
    final Settings set;
    final GameCard card;
    final IMayor game;

    public Texture tanser;
    public Image wanser;
    public Label label;

    public Texture t;
    public GameAnswer(IMayor game){
        this.set = game.set;
        this.res = game.res;
        this.card = game.card;
        this.game = game;
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        Create();
    }

    public void Create(){
        if (res.pos==0)
        {
            tanser = new Texture("d.png");
            wanser = new Image(res.skin.getSprite("FieryColor"));//Красный
            wanser.setSize(res.width, res.width*8/10*4/10);
            wanser.setPosition(0, res.height*1/10 + res.width*1/10 + res.width*8/10*8/10);

            label.setText("");
            label.setPosition(res.width/2, res.height*1/10 + res.width*1/10 + res.width*8/10*9/10);
        }
        else
        if (res.pos<0){
            tanser = new Texture("a.png");
            wanser = new Image(res.skin.getSprite("FloorLucid"));//Красный
            wanser.setSize(res.width, res.width*8/10*2/10);
            wanser.setPosition(0, res.height*1/10 + res.width*1/10 + res.width*8/10*8/10);
            label.setText("Да");
            label.setPosition(res.width/2, res.height*1/10 + res.width*1/10 + res.width*8/10*9/10 -  label.getWidth()/2);
    }
        else {
            tanser = new Texture("b.png");
            wanser = new Image(res.skin.getSprite("FloorGreen"));//Зеленый
            wanser.setSize(res.width, res.width*8/10*2/10);
            wanser.setPosition(0, res.height*1/10 + res.width*1/10 + res.width*8/10*8/10);
            label.setText("Нет");
            label.setPosition(res.width/2, res.height*1/10 + res.width*1/10 + res.width*8/10*9/10 - label.getWidth()/2);
        }
    }
}
