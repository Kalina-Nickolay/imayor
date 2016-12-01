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
import com.imayor.game.States.GameState;
import com.imayor.game.States.MenuState;

import javax.smartcardio.Card;

/**
Кнопка начала игры
 */

public class PlayButton {
    private final Settings set;
    private final Resources res;
    private final IMayor game;
    private final GameCard card;
    private final MenuState ms;

    private Skin skin;
    private TextureAtlas buttonAtlas;
    private ImageButton.ImageButtonStyle imageButtonStyle;
    public ImageButton button;

    public PlayButton(final IMayor game, MenuState menustate) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card = game.card;
        ms = menustate;

        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.pack"));
        skin.addRegions(buttonAtlas);
        imageButtonStyle = new ImageButton.ImageButtonStyle();
        imageButtonStyle.up = skin.getDrawable("PlayButton-up");
        imageButtonStyle.down = skin.getDrawable("PlayButton-down");
        imageButtonStyle.checked = skin.getDrawable("PlayButton-up");

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
                //----Важное замечание. Создаю игровой экран каждый раз во время нажатия начала игры,
                //однако, достаю уже имеющийся класс главного меню, который остается неизменным,
                //не удаяляется и не создается вновь. Вот такая залепа----
                game.setScreen(new GameState(game));
                ms.dispose();
                res.musicM.stop();
                res.musicG.play();
            };
        });
    }

    public void resize(){
        button.setSize(res.width*2/7, res.width*2/7);
        button.setPosition(res.width*2/14, res.height/2 + res.width*1/7);
    }
}
