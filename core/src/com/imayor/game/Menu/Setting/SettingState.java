package com.imayor.game.Menu.Setting;

/*
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.MenuState;
import com.imayor.game.Res.Resources;

public class SettingState implements Screen{
    final Resources RES;
    final IMayor game;
    final SettingState settingstate;

    private Stage stage;

    private  Image back;
    private Image SetOne1, SetTwo1, SetThree1, SetFour1, SetFive1;
    private Image SetOne2, SetTwo2, SetThree2, SetFour2, SetFive2;
    private ImageButton SetOne3, SetTwo3, SetThree3, SetFour3, SetFive3;
    private Label LabelOne4, LabelTwo4, LabelThree4, LabelFour4, LabelFive4;
    private ImageButton.ImageButtonStyle UniversalStyle5;
    private boolean FlagOne6, FlagTwo6, FlagThree6, FlagFour6, FlagFive6;
    private int adjustmentOne7, adjustmentTwo7, adjustmentThree7, adjustmentFour7, adjustmentFive7;
    private Image FonOne8, FonTwo8, FonThree8, FonFour8, FonFive8;

    //private Skin skin1, skin2, skin3, skin4, skin5;

    public SettingState(final IMayor game) {
        this.game = game;
        this.RES = game.res;
        settingstate = this;

        create();
    }

    private void create(){
        System.out.println("До " + adjustmentOne7);
        BreadStickBorsch(5);
        System.out.println("Посля " + adjustmentOne7);

        stage = new Stage(new ScreenViewport());
        stage.addActor(RES.BackgroundSettings);
        stage.addActor(back);

        stage.addActor(FonOne8);
        stage.addActor(SetOne1);
        stage.addActor(SetOne2);
        stage.addActor(SetOne3);
        stage.addActor(LabelOne4);

        stage.addActor(FonTwo8);
        stage.addActor(SetTwo1);
        stage.addActor(SetTwo2);
        stage.addActor(SetTwo3);
        stage.addActor(LabelTwo4);

        stage.addActor(FonThree8);
        stage.addActor(SetThree1);
        stage.addActor(SetThree2);
        stage.addActor(SetThree3);
        stage.addActor(LabelThree4);

        stage.addActor(FonFour8);
        stage.addActor(SetFour1);
        stage.addActor(SetFour2);
        stage.addActor(SetFour3);
        stage.addActor(LabelFour4);

        stage.addActor(FonFive8);
        stage.addActor(SetFive1);
        stage.addActor(SetFive2);
        stage.addActor(SetFive3);
        stage.addActor(LabelFive4);

        //Gdx.input.setInputProcessor(stage);
        //Gdx.input.setCatchBackKey(true);
        InputProcessor inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                switch(keycode){
                    case Input.Keys.BACK:
                        game.setScreen(new MenuState(game));
                        settingstate.dispose();
                        break;

                }
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(inputProcessor);
        Gdx.input.setInputProcessor(multiplexer);
    }


    private void BreadStickBorsch(int n){
        if (RES.sound) {
            FlagOne6=false;
            adjustmentOne7 = 0;
        }
        else
        {
            FlagOne6=true;
            adjustmentOne7 = RES.width*3/10/2;
        }

        if (RES.music) {
            FlagTwo6=false;
            adjustmentTwo7 = 0;
        }
        else
        {
            FlagTwo6=true;
            adjustmentTwo7 = RES.width*3/10/2;
        }

        if (RES.ton.equals("Lite")) {
            FlagThree6=false;
            adjustmentThree7 = 0;
        }
        else
        {
            FlagThree6=true;
            adjustmentThree7 = RES.width*3/10/2;
        }

        SetOne1 = new Image(new Texture("Setting01.png"));
        SetTwo1 = new Image(new Texture("Setting01.png"));
        SetThree1 = new Image(new Texture("Setting11.png"));
        SetFour1 = new Image(new Texture("Setting10.png"));
        SetFive1 = new Image(new Texture("Setting01.png"));

        SetOne1.setSize(RES.width*3/10, RES.width*3/10/6);
        SetTwo1.setSize(RES.width*3/10, RES.width*3/10/6);
        SetThree1.setSize(RES.width*3/10, RES.width*3/10/6);
        SetFour1.setSize(RES.width*3/10, RES.width*3/10/6);
        SetFive1.setSize(RES.width*3/10, RES.width*3/10/6);

        SetOne1.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10);
        SetTwo1.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        SetThree1.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*2 + (RES.height - RES.width*3/10/6*5)*5/10);
        SetFour1.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10);
        SetFive1.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10);

        SetOne2 = new Image(new Texture("Setting02.png"));
        SetTwo2 = new Image(new Texture("Setting02.png"));
        SetThree2 =  new Image(new Texture("Setting02.png"));
        SetFour2 =  new Image(new Texture("Setting13.png"));
        SetFive2 =  new Image(new Texture("Setting13.png"));

        SetOne2.setSize(RES.width*3/10/2, RES.width*3/10/6);
        SetTwo2.setSize(RES.width*3/10/2, RES.width*3/10/6);
        SetThree2.setSize(RES.width*3/10/2, RES.width*3/10/6);
        SetFour2.setSize(RES.width*3/10/2, RES.width*3/10/6);
        SetFive2.setSize(RES.width*3/10/2, RES.width*3/10/6);

        SetOne2.setPosition(RES.width*3/10*6/3+adjustmentOne7, RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10);
        SetTwo2.setPosition(RES.width*3/10*6/3+adjustmentTwo7, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        SetTwo2.setPosition(RES.width*3/10*6/3+adjustmentThree7, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        SetFour2.setPosition(RES.width*3/10*6/3+adjustmentFour7, RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10);
        SetFive2.setPosition(RES.width*3/10*6/3+adjustmentFive7, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10);

        UniversalStyle5 = new ImageButton.ImageButtonStyle();
        RES.arial((int)RES.width*3/10/6*8/10);

        LabelOne4 = new Label("", new Label.LabelStyle(RES.arial, new Color(1, 1, 1, 1)));
        LabelTwo4 = new Label("", new Label.LabelStyle(RES.arial, new Color(1, 1, 1, 1)));
        LabelThree4 = new Label("", new Label.LabelStyle(RES.arial, new Color(1, 1, 1, 1)));
        LabelFour4 = new Label("", new Label.LabelStyle(RES.arial, new Color(1, 1, 1, 1)));
        LabelFive4 = new Label("", new Label.LabelStyle(RES.arial, new Color(1, 1, 1, 1)));


        LabelOne4.setAlignment(Align.left);
        LabelTwo4.setAlignment(Align.left);
        LabelThree4.setAlignment(Align.left);
        LabelFour4.setAlignment(Align.left);
        LabelFive4.setAlignment(Align.left);

        LabelOne4.setText("Звуки");
        LabelTwo4.setText("Музыка");
        LabelThree4.setText("Оформление");
        LabelFour4.setText("Язык");
        LabelFive4.setText("Обучение");

        FonOne8 = new Image(RES.skin.getSprite("Eight"));
        FonTwo8 = new Image(RES.skin.getSprite("Eight"));
        FonThree8 =  new Image(RES.skin.getSprite("Eight"));
        FonFour8 =  new Image(RES.skin.getSprite("Eight"));
        FonFive8 =  new Image(RES.skin.getSprite("Eight"));

        back = new Image(RES.skin.getSprite("Eight"));
        back.setSize(RES.width*9/10, RES.width*3/10/6*5 + (RES.height - RES.width*3/10/6*5)*4/10 + RES.width*2/20);
        back.setPosition(RES.width*3/10*1/3 - RES.width*1/20, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10 - RES.width*1/20);

        //back.setSize(RES.width*9/10, RES.height - RES.width*2/20);
        //back.setPosition(RES.width*1/20, RES.width*1/20);
        back .addAction(Actions.alpha(0.3f));

        FonOne8.setSize(RES.width*3/10, RES.width*3/10/6);
        FonTwo8.setSize(RES.width*3/10, RES.width*3/10/6);
        FonThree8.setSize(RES.width*3/10, RES.width*3/10/6);
        FonFour8.setSize(RES.width*3/10, RES.width*3/10/6);
        FonFive8.setSize(RES.width*3/10, RES.width*3/10/6);

        FonOne8.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10);
        FonTwo8.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        FonThree8.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*2 + (RES.height - RES.width*3/10/6*5)*5/10);
        FonFour8.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10);
        FonFive8.setPosition(RES.width*3/10*6/3, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10);

        FonOne8.addAction(Actions.alpha(0.4f));
        FonTwo8.addAction(Actions.alpha(0.4f));
        FonThree8.addAction(Actions.alpha(0.4f));
        FonFour8.addAction(Actions.alpha(0.4f));
        FonFive8.addAction(Actions.alpha(0.4f));


        LabelOne4.setPosition(RES.width*3/10*1/3, RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10 + RES.width*3/10/6/2);
        LabelTwo4.setPosition(RES.width*3/10*1/3, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10 + RES.width*3/10/6/2);
        LabelThree4.setPosition(RES.width*3/10*1/3, RES.width*3/10/6*2 + (RES.height - RES.width*3/10/6*5)*5/10 + RES.width*3/10/6/2);
        LabelFour4.setPosition(RES.width*3/10*1/3, RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10 + RES.width*3/10/6/2);
        LabelFive4.setPosition(RES.width*3/10*1/3, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10 + RES.width*3/10/6/2);

        SetOne3 = new ImageButton(UniversalStyle5);
        SetTwo3 = new ImageButton(UniversalStyle5);
        SetThree3 = new ImageButton(UniversalStyle5);
        SetFour3 = new ImageButton(UniversalStyle5);
        SetFive3 = new ImageButton(UniversalStyle5);

        SetOne3.setSize(RES.width*3/10, RES.width*3/10/6);
        SetTwo3.setSize(RES.width*3/10, RES.width*3/10/6);
        SetThree3.setSize(RES.width*3/10, RES.width*3/10/6);
        SetFour3.setSize(RES.width*3/10, RES.width*3/10/6);
        SetFive3.setSize(RES.width*3/10, RES.width*3/10/6);

        SetOne3.setPosition(RES.width*3/10*6/3,  RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10);
        SetTwo3.setPosition(RES.width*3/10*6/3,  RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        SetThree3.setPosition(RES.width*3/10*6/3,  RES.width*3/10/6*2 + (RES.height - RES.width*3/10/6*5)*5/10);
        SetFour3.setPosition(RES.width*3/10*6/3,  RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10);
        SetFive3.setPosition(RES.width*3/10*6/3,  RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10);


        SetOne3.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (FlagOne6){
                    FlagOne6 = false;
                    RES.sound=true;
                }
                else{
                    FlagOne6 = true;
                    RES.sound=false;
                }
            }
        });

        SetTwo3.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (FlagTwo6) {
                    FlagTwo6 = false;
                    RES.music=true;
                }
                else {
                    FlagTwo6 = true;
                    RES.music=false;
                }
            }
        });

        SetThree3.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (FlagThree6) {
                    FlagThree6 = false;
                    RES.ton="Lite";
                }
                else {
                    FlagThree6 = true;
                    RES.ton="Dark";
                }
            }
        });


        SetFour3.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //if (FlagFour6)
                //    FlagFour6 = false;
                //else
                //   FlagFour6 = true;
            }
        });

        SetFive3.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //if (FlagFive6)
                //    FlagFive6 = false;
                //else
                //    FlagFive6 = true;
            }
        });
    }

    @Override
    public void show() {
    }

    public void Adjustment (){
        SetOne2.setPosition(RES.width*3/10*6/3+adjustmentOne7, RES.width*3/10/6*4 + (RES.height - RES.width*3/10/6*5)*7/10);
        SetTwo2.setPosition(RES.width*3/10*6/3+adjustmentTwo7, RES.width*3/10/6*3 + (RES.height - RES.width*3/10/6*5)*6/10);
        SetThree2.setPosition(RES.width*3/10*6/3+adjustmentThree7, RES.width*3/10/6*2 + (RES.height - RES.width*3/10/6*5)*5/10);
        SetFour2.setPosition(RES.width*3/10*6/3+adjustmentFour7, RES.width*3/10/6*1 + (RES.height - RES.width*3/10/6*5)*4/10);
        SetFive2.setPosition(RES.width*3/10*6/3+adjustmentFive7, RES.width*3/10/6*0 + (RES.height - RES.width*3/10/6*5)*3/10);
    }
    @Override
    public void render(float delta) {
        if (FlagOne6 & adjustmentOne7 < SetOne2.getImageWidth()) {
            System.out.println("Вправо " + adjustmentOne7);
            adjustmentOne7 += 5;
        }
        if (FlagOne6 == false & adjustmentOne7 > 0) {
            System.out.println("Влево " + adjustmentOne7);
            adjustmentOne7 -= 5;
        }

        if (FlagTwo6 & adjustmentTwo7 < SetTwo2.getImageWidth())
            adjustmentTwo7+=5;
        if (FlagTwo6 == false & adjustmentTwo7 > 0)
            adjustmentTwo7-=5;

        if (FlagThree6 & (adjustmentThree7 < SetThree2.getImageWidth()))
            adjustmentThree7+=5;
        if (FlagThree6 == false & adjustmentThree7 > 0)
            adjustmentThree7-=5;

        if (FlagFour6 & adjustmentFour7 < SetFour2.getImageWidth())
            adjustmentFour7+=5;
        if (FlagFour6 == false & adjustmentFour7 > 0)
            adjustmentFour7-=5;

        if (FlagFive6 & adjustmentFive7 < SetFive2.getImageWidth())
            adjustmentFive7+=5;
        if (FlagFive6 == false & adjustmentFive7 > 0)
            adjustmentFive7-=5;

        Adjustment();
        stage.act(delta);
        stage.draw();
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void resize(int width, int height) {
        RES.width = width;
        RES.height = height;
        //РЕСАЙЗИМ ДЛЯ НЕРАБОТАЮЩЕЙ ДАВНО И ПОНЫНЕ ДЕСКТОПНОЙ ВЕРСИИ
    }

    @Override
    public void pause() {
        //ТУТ БЫ СДЕЛАТЬ ПАУЗУ МУЗЫКИ
    }

    @Override
    public void resume() {
        //НУ ТУТ БЫ СДЕЛАТЬ ПРОДОЛЖЕНИЕ МУЗЫКИ
    }

    @Override
    public void hide() {
        //ЧТО ЭТО ЗА МЕТОД?
    }

    @Override
    public void dispose() {
        stage.dispose();
        //НАДО ВСЕ ПЕРЕМЕННЫЕ DISPOSE
    }
}
