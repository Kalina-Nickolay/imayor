package com.imayor.game.Menu.Game.Over;

/*
 */


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.imayor.game.Menu.Game.GameState;
import com.imayor.game.IMayor;
import com.imayor.game.Res.Resources;
import com.imayor.game.Menu.MenuState;

public class OverButtons {
    private final Resources res;
    private final IMayor game;
    private final OverState over;
    private final GameState gamestate;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private ImageButton.ImageButtonStyle imageButtonStyle1,imageButtonStyle2,imageButtonStyle3;
    private ImageButton restartButton, menuButton, addHearthButton;
    private Image breast,kreast,treast, mreast;
    public Group group;//Группа и группа в случае победы

    public OverButtons(final IMayor game, OverState over, GameState gamestate) {
        this.game = game;
        this.res = game.res;
        this.over = over;
        this.gamestate = gamestate;
        //РЕКЛАМАРЕКЛАМАРЕКЛАМА


        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal(res.ton + "overbar.pack"));
        skin.addRegions(buttonAtlas);
        imageButtonStyle1 = new ImageButton.ImageButtonStyle();
        imageButtonStyle2 = new ImageButton.ImageButtonStyle();
        imageButtonStyle3 = new ImageButton.ImageButtonStyle();

        breast = new Image(res.skin.getSprite("Eight"));
        breast.setSize(res.width-res.width*2/20,res.width*3/10);
        breast.setPosition(res.width*1/20,res.height/2-res.width*5/20);
        breast.addAction(Actions.alpha(0.4f));

        kreast = new Image(res.skin.getSprite("Eight"));
        kreast.setSize(res.width,res.height);
        kreast.setPosition(0,0);
        kreast.addAction(Actions.alpha(0.5f));

        treast = new Image(res.skin.getSprite("Six"));
        treast.setSize(res.width-res.width*2/20,res.height - res.width*2/20);
        treast.setPosition(res.width*1/20, res.width*1/20);
        treast.addAction(Actions.alpha(0.6f));

        mreast = new Image(res.skin.getSprite("Seven"));
        mreast.setSize(res.width,res.height);
        mreast.setPosition(0,0);
        mreast.addAction(Actions.alpha(0.6f));

        RestartButton();
        MenuButton();
        AddHearthButton();

        if (res.wounts<=0){
            Resizewin();
            group = new Group();
            group.addActor(mreast);
            group.addActor(treast);
            group.addActor(breast);
            group.addActor(restartButton);
            group.addActor(menuButton);
        }
        else {
            Resize();
            group = new Group();
            //group.addActor(kreast);
            group.addActor(treast);
            group.addActor(breast);
            group.addActor(restartButton);
            group.addActor(menuButton);
            group.addActor(addHearthButton);
        }

    }

    public void RestartButton(){
        imageButtonStyle1.up = skin.getDrawable("RestartButton-up");
        imageButtonStyle1.down = skin.getDrawable("RestartButton-down");
        imageButtonStyle1.checked = skin.getDrawable("RestartButton-up");

        restartButton = new ImageButton(imageButtonStyle1);

        restartButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //РЕКЛАМАРЕКЛАМАРЕКЛАМА
                gamestate.card.Zero();
                gamestate.dispose();//Удаляем текущий экран
                //game.set.Read();
                game.setScreen(new GameState(game));
                over.dispose();
                res.musicG.pause();
            }
        });
    }

    public void MenuButton(){
        imageButtonStyle2.up = skin.getDrawable("MenuButton-up");
        imageButtonStyle2.down = skin.getDrawable("MenuButton-down");
        imageButtonStyle2.checked = skin.getDrawable("MenuButton-up");

        menuButton = new ImageButton(imageButtonStyle2);

        menuButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gamestate.card.Zero();
                gamestate.dispose();//Удаляем текущий экран
                //game.set.Read();
                game.setScreen(new MenuState(game));
                over.dispose();
                res.musicG.pause();
            }
        });
    }

    public void AddHearthButton(){
        imageButtonStyle3.up = skin.getDrawable("AddHearthButton-up");
        imageButtonStyle3.down = skin.getDrawable("AddHearthButton-down");
        imageButtonStyle3.checked = skin.getDrawable("AddHearthButton-up");

        addHearthButton = new ImageButton(imageButtonStyle3);

        addHearthButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (game.controller.isWifiConnected()) {
                    game.controller.showInterstitialAd(new Runnable() {
                        @Override
                        public void run() {
                            gamestate.AddHearth();
                            gamestate.dispose();//Удаляем текущий экран
                            game.setScreen(new GameState(game));
                            over.dispose();
                        }
                    });
                } else {
                    gamestate.AddHearth();
                    gamestate.dispose();//Удаляем текущий экран
                    game.setScreen(new GameState(game));
                    over.dispose();

                }

            }
        });
    }

    public void Resize(){
        restartButton.setSize(res.width*2/10, res.width*2/10);
        restartButton.setPosition(res.width*1/10*1 + res.width*2/10*0, res.height/2 - res.width*2/10);

        menuButton.setSize(res.width*2/10, res.width*2/10);
        menuButton.setPosition(res.width*1/10*3 + res.width*2/10*2, res.height/2 - res.width*2/10);

        addHearthButton.setSize(res.width*2/10, res.width*2/10);
        addHearthButton.setPosition(res.width*1/10*2 + res.width*2/10*1, res.height/2 - res.width*2/10);
    }

    public void Resizewin(){
        restartButton.setSize(res.width*2/10, res.width*2/10);
        restartButton.setPosition(res.width*1/20*5 + res.width*2/10*0, res.height/2 - res.width*2/10);

        menuButton.setSize(res.width*2/10, res.width*2/10);
        menuButton.setPosition(res.width*1/20*7 + res.width*2/10*1, res.height/2 - res.width*2/10);
    }

}
