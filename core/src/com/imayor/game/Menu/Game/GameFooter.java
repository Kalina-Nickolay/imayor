package com.imayor.game.Menu.Game;

/*
Нижний колонтитул,  котором отражено количество карточек, на которых ответил игрок (завуалировано количеством прожитых дней, 1 день = 1 карточка)
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class GameFooter {
    private final Resources res;

    //----Фон хидера----
    public Image background;

    public Label label;

    public Group group;

    public GameFooter(final IMayor game) {
        this.res = game.res;
        Create();
    }

    public void Create(){
        if (res.ton.equals("Lite"))
            background =  new Image(res.skin.getSprite("Six"));
        else
            background = new Image(res.skin.getSprite("One"));
        background.setSize(res.height, res.height*1/10);
        background.setPosition(0, 0);

        res.arial(res.height*1/10/2);
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label.setText("" + res.meownts);
        label.setPosition(res.width*1/10, res.height*1/10/2);

        group = new Group();
        group.addActor(background);
        group.addActor(label);
    }

    public void Update(){
        label.setText("" + res.meownts);
    }
}
