package com.imayor.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.imayor.game.Actors.GameHeader;

import java.util.Set;

public class Resources {

    //----Базовые цвета----
    private TextureAtlas paletteAtlas;

    //----Фон----
    public Image background;

    //----Цвета----
    public Image ruby, white, black, mel;

    //----Ширина, высота----
    public int width;
    public int height;

    //
    public Skin skin;

    //----Звуки----
    public Sound soundL, soundR,//L - левый ответ, R - правый ответ.
            soundB1, soundB2, soundB3, soundB4,//B - нажатие на кнопку. Рандомная нота.
            soundO;//O - конец игры, проигрыш.

    //----Музыка----
    public Music musicM, musicG;//M - экран меню, G - ирговой экран.

    //----Громкость музыки и звуков----
    public float volume;

    //----Ресурсы----
    public int heap1, heap2, heap3, heap4;//Инициализируется при чтении из файла

    //----Количество карточек----
    public final int counts=2;//Инициализируется при чтении из файла

    //----Количество несыгранных карточек----
    public int wounts;

    //----Количество сыгранных карточек----
    public int meownts;

    //----Несыгранные карточки----
    public IntArray won = new IntArray();//Инициализируется при чтении из файла

    //----Шрифты----
    final String FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
    final String FONT_ARIAL = "arial.ttf";
    public BitmapFont arial;

    //----Положение карточки
    public int pos;

    public Resources (){
        Create();
    }

    public void Create(){
        width = Gdx.graphics.getWidth();//Ширина окна.
        height = Gdx.graphics.getHeight();//Высота окна.

        skin = new Skin();//Для цветовой палитры.
        paletteAtlas = new TextureAtlas(Gdx.files.internal("palette.pack"));//Цветовая палитра.
        skin.addRegions(paletteAtlas);//Регионы цветовой палитры.
        background = new Image(skin.getSprite("MelColor"));
        background.setSize(this.width,this.height);
        background.setPosition(0,0);

        musicM = Gdx.audio.newMusic(Gdx.files.internal("m.mp3"));
        musicM.setLooping(true);//Репит
        musicM.play();//Запуск

        musicG = Gdx.audio.newMusic(Gdx.files.internal("g.mp3"));
        musicG.setLooping(true);//Репит
        this.Volume(0.0f);


        soundL = Gdx.audio.newSound(Gdx.files.internal("l.mp3"));
        soundR = Gdx.audio.newSound(Gdx.files.internal("r.mp3"));

        //----Вызов функции создания шрифта----
        arial(30);

    }

    public void arial(int i){
        //----Создание стиля (параметров) шрифта----
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_ARIAL));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARS;
        parameter.color = Color.BLACK;

        //----Изменение размера, где i - высота шрифта----
        parameter.size = i;

        //----Создание непосредственно шрифта----
        arial = generator.generateFont(parameter);
        generator.dispose();
    }

    //----Обнуляем переменные перед началом игры----
    public void Zero(){
        this.meownts=0;
        this.wounts=this.counts;
        this.heap1=60;
        this.heap2=60;
        this.heap3=60;
        this.heap4=60;
        for (int i=0; i<=this.wounts; i++){
            this.won.add(i);
        }

    }

    public void Volume(float volume){
        musicM.setVolume(volume);
        musicG.setVolume(volume);
    }
}
