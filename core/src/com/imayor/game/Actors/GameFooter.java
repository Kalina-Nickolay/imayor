package com.imayor.game.Actors;

/*
Нижний колонтитул,  котором отражено количество карточек, на которых ответил игрок (завуалировано количеством прожитых дней, 1 день = 1 карточка)
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;

public class GameFooter {
    private final Settings set;
    private final Resources res;
    private final IMayor game;

    //----Фон хидера----
    public Image background;

    public Label label;

    public GameFooter(final IMayor game) {
        this.set = game.set;
        this.res = game.res;
        this.game = game;
        Create();
    }

    public void Create(){
        background =  new Image(res.skin.getSprite("RubyColor"));
        res.arial(res.height*1/10/2);
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        Resize();
        label.setPosition(res.width*1/10, res.height*1/10/2);
    }

    public void Resize(){
        background.setSize(res.height, res.height*1/10);
        background.setPosition(0, 0);

        Relabel();

    }

    public void Relabel(){
        label.setText("" + res.meownts);
    }
}
