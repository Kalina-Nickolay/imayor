package com.imayor.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.imayor.game.IMayor;
import com.imayor.game.Resources;
import com.imayor.game.Settings;
import com.imayor.game.States.MenuState;

/**
 * Created by Kalina on 20.11.2016.
 */


public class InfoButton {
    private final Settings set;
    private final Resources res;
    private final IMayor game;
    private final GameCard card;

    private Skin skin;
    private TextureAtlas buttonAtlas;
    private ImageButton.ImageButtonStyle imageButtonStyle;
    public ImageButton button;

    public InfoButton(final IMayor game, MenuState menustate) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card = game.card;
        game.menustate = menustate;

        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
        skin.addRegions(buttonAtlas);
        imageButtonStyle = new ImageButton.ImageButtonStyle();
        imageButtonStyle.up = skin.getDrawable("InfoButton-up");
        imageButtonStyle.down = skin.getDrawable("InfoButton-down");
        imageButtonStyle.checked = skin.getDrawable("InfoButton-up");

        button = new ImageButton(imageButtonStyle);

        resize();

        button.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Включаем другой экран
            };
        });
    }

    public void resize(){
        button.setSize(res.width/7*2, res.width/7*2);
        button.setPosition(res.width/2 + res.width*1/14, res.height/2 - res.width*2/7);
    }
}
