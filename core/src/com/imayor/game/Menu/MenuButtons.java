package com.imayor.game.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.Setting.SettingState;
import com.imayor.game.Res.Resources;

/**
 * Created by Kalina on 02.12.2016.
 */
//КАКОГО ХУЯ? ТЕПЕРЬ У МЕНЯ ПРИЛОЖЕНИЕ ВООбще не запускается???
public class MenuButtons {
    private final Resources res;
    private final IMayor game;
    private final MenuState menu;

    private Image hint1, hint2, keyword;//Картинка фона, которая перемещается вниз по экрану.
    private Skin skin, skin1;//
    private TextureAtlas settingAtlas, hintAtlas;//
    private ImageButton.ImageButtonStyle imageButtonStyle1,imageButtonStyle2;//1 - настройки, 2 - магазин
    public ImageButton settingButton, storeButton;//setting - настройки, store - магазин
    public Group group;//для всех кнопок

    public MenuButtons(final IMayor game, MenuState menustate) {
        this.game = game;
        this.res = game.res;
        menu = menustate;

        //----Если в настройках музыка включена, то воспроизводим музыку меню, иначе остановим её. На всякий пожарный----
        if (res.music) {
            if (res.pause)
                res.musicM.pause();
            else
                res.musicM.stop();
            res.musicM.play();
        }
        else {
            res.musicM.stop();
        }

        //----Загружаем картинку фона----
        keyword = new Image(new Texture("Menu01.png"));
        keyword.setSize(res.width*67/100, res.width*67/100*37/100);

        skin = new Skin();
        //----Загружаем текстурки кнопок----
        settingAtlas = new TextureAtlas(Gdx.files.internal("set.pack"));
        //----Находим нужные диапазоны картинок----
        skin.addRegions(settingAtlas);
        //----Инициализируем стили кнопок----
        imageButtonStyle1 = new ImageButton.ImageButtonStyle();
        //----Присваиваем кнопкам картинки согласно ----
        SettingButton();
        //----Считаем размеры и расположение кнопочек----

        hint1= new Image(new Texture("Menu04.png"));
        hint2 = new Image(new Texture("Menu05.png"));

        hint1.setSize(res.width*45/100, res.width*45/100*3/10);
        hint2.setSize(res.width*45/100, res.width*45/100*3/10);
        keyword.setSize(res.width*67/100,res.width*67/100*37/100);

        settingButton.setSize(res.width*4/10, res.width*4/50);

        hint1.setPosition(res.width*2, res.width*45/100*3/10*65/10);
        hint2.setPosition(res.width*2, res.width*45/100*3/10*65/10);
        keyword.setPosition(res.width*2,res.width*45/100*3/10*77/10);

        Resize();
        //----Группируем кнопки----
        group = new Group();

        group.addActor(res.BackgroundMenu);

        group.addActor(hint1);
        group.addActor(hint2);
        group.addActor(keyword);

        group.addActor(settingButton);
    }

    public void SettingButton(){
        imageButtonStyle1.up = skin.getDrawable("SettingButton-up");
        imageButtonStyle1.down = skin.getDrawable("SettingButton-down");
        imageButtonStyle1.checked = skin.getDrawable("SettingButton-up");

        settingButton = new ImageButton(imageButtonStyle1);

        settingButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new SettingState(game));
               menu.dispose();
                res.musicM.pause();
            }
        });
    }

    public void Resize(){
        settingButton.setPosition(res.width*1/10, res.width*4/10+res.scrollbackground);

        res.BackgroundMenu.setPosition(0, res.scrollbackground);
    }

    public void ReHint(boolean qwehtrvhrtioe){
        if (qwehtrvhrtioe) {
            hint1.setPosition(res.width * 2, res.width * 45 / 100 * 3 / 10 * 65 / 10);
            hint2.setPosition(res.width * 55 / 100 / 2, res.width * 45 / 100 * 3 / 10 * 65 / 10);
        }
        else {
            hint1.setPosition(res.width * 55 / 100 / 2, res.width * 45 / 100 * 3 / 10 * 65 / 10);
            hint2.setPosition(res.width * 2, res.width * 45 / 100 * 3 / 10 * 65 / 10);
        }
    }

    public void GroupCorrect(){
        //hint1.setPosition(res.width*55/100/2, res.width*45/100*3/10*65/10);
        //hint2.setPosition(res.width*55/100/2, res.width*45/100*3/10*65/10);
        keyword.setPosition(res.width*33/100/2,res.width*45/100*3/10*77/10);
    }
}
