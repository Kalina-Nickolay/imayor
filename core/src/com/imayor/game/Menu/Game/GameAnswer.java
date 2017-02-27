package com.imayor.game.Menu.Game;

/*
Класс ответочки
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class GameAnswer {
    final Resources res;

    public Group group;
    public Image wanser1,wanser2;
    public Label label;
    private int thirdWidth;

    public GameAnswer(IMayor game){
        this.res = game.res;

        Create();

        group = new Group();
        group.addActor(wanser1);
        group.addActor(wanser2);
        group.addActor(label);
    }

    public void groupUpdate(){

    }

    public void Create() {
        thirdWidth = res.width*1/50;
        label = new Label("", new Label.LabelStyle(res.arial, new Color(1, 1, 1, 1)));
        label.setPosition(res.width/2, res.height*1/10 + res.width*1/10 + res.width*8/10*9/10 - label.getWidth()/2);
        label.setAlignment(Align.center);

        wanser1 = new Image(res.skin.getSprite("Fourteen"));//Зеленый
        wanser2 = new Image(res.skin.getSprite("Twelve"));//Красный
        wanser1.setSize(res.width, res.width*8/10*2/10);
        wanser2.setSize(res.width, res.width*8/10*2/10);
        wanser1.setPosition(res.width, res.height);
        wanser2.setPosition(res.width, res.height);

        wanser1.addAction(Actions.alpha(0.8f));
        wanser2.addAction(Actions.alpha(0.8f));
    }
    public void update(){
        if (res.pos > thirdWidth) {
            label.setText(res.rightAnswer);
            //if (res.pos!=0)
            wanser1.setSize(Math.abs(res.pos)*3, res.width*8/10*2/10);
            wanser1.setPosition(res.width/2-wanser1.getWidth()/2, res.height*1/10 + res.width*1/10 + res.width*8/10*8/10);
            wanser2.setPosition(res.width, res.height);
        } else if (res.pos < -thirdWidth) {
            label.setText(res.leftAnswer);
            wanser2.setSize(Math.abs(res.pos)*3, res.width*8/10*2/10);
            wanser1.setPosition(res.width, res.height);
            wanser2.setPosition(res.width/2-wanser2.getWidth()/2, res.height*1/10 + res.width*1/10 + res.width*8/10*8/10);
        } else if (res.pos >= thirdWidth | Math.abs(res.pos) <= thirdWidth) {
            wanser1.setPosition(res.width, res.height);
            wanser2.setPosition(res.width, res.height);
            label.setText("");
        }
    }

    public void Zero(){
        wanser1.setPosition(res.width, res.height);
        wanser2.setPosition(res.width, res.height);
        label.setText("");
    }
}
