package com.imayor.game.Menu.Game.Over;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;

/**
 * Created by Kalina on 02.12.2016.
 */

public class OverLabel {
    private final Resources res;
    private final IMayor game;

    public Label label;

    public OverLabel(final IMayor game){
        this.game = game;
        this.res = game.res;

        res.arial((res.height*8/10 - res.width)/8);
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label.setWrap(true);
        label.setWidth(res.width*8/10);
        label.setHeight((res.height*8/10 - res.width)/8);

        label.setAlignment(Align.center, Align.center);
        label.setPosition(res.width*1/10, res.height*1/10 + res.width + (res.height*8/10-res.width)/2);

        Create();
    }

    public void Create(){
        if (res.wounts==-1)//Нулевая вправо
            label.setText("Вам стоит пересмотреть свои взгляды на жизнь");
        else
        if (res.heap1>=100 & res.heap2>=100 & res.heap3>=100 & res.heap4>=100 & res.wounts<=0)
            label.setText("Вы выиграли. Благодаря вам беличьи семьи населили скверы и парки, дети гуляют без респираторов, а взрослые тщательно следят за флорой и фауной");
        else
        if(res.heap1>=100 & res.heap2>=100 & res.heap3>=100 & res.wounts<=0)
            label.setText("Вы выиграли. Благодаря вам беличьи семьи населили скверы и парки, дети гуляют без респираторов, а взрослые тщательно следят за флорой и фауной");
        else
        if(res.heap2>=10 & res.wounts<=0) label.setText("Вы выиграли. Ни одной пробки. Солнце наполняет город и радует всех жителей.");
        else
        if(res.heap3>=10 & res.wounts<=0) label.setText("Вы выиграли. Люди поддерживают вас на новой избирательной компании");
        else
        if(res.heap4>=10 & res.wounts<=0) label.setText("Вы выиграли. Бюджет города полон и готов к расцвету не только города, но и края");
        else
        if(res.heap1<=0) label.setText("Вы проиграли. Город задыхается в пыли. Обнаруженный рак лёгких вас доканал и прикончил к радости толпы");
        else
        if(res.heap2<=0) label.setText("Вы проиграли. Вам грозит пожизненное заключение за массовое убийство по неосторожности, ведь из под вашей лёгкой руки вышел приказ строить то здание над лабиринтом с острова Русский");
        else
        if(res.heap3<=0) label.setText("Вы проиграли. В порыве ненависти толпа закидала вас собственными ботинками во время выступления на дебатах. ");
        else
        if(res.heap4<=0) label.setText("Вы проиграли. Вас преследуют за хищение в особо крупных размерах");

    }

}
