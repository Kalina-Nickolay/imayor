package com.imayor.game.Res;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.IntArray;

public class Resources {

    //----Базовые цвета----
    private TextureAtlas paletteAtlas;

    //----Ширина, высота----
    public int width;
    public int height;

    //----Фон меню----
    public Image BackgroundMenu, BackgroundSettings;

    //----Флаг взаимодействия. True - можно, false - нельзя взаимодействовать с экраном----
    public boolean canmust=false, maybemust=false;

    //----координаты прокрутки фоновой картинки. Надо бы установить тайминг----
    public int scrollbackground;

    //----Переменная подсказки
    public int hinttostart;

    //----Я честно, не помню что это, но это надо
    public Skin skin;

    //----Скорость прокрутки
    public int plus=15;

    //----Тональность----
    public String ton="Lite";

    //----Ответы на карточки. Записываются из кард в глобальные и считываются ансвером----
    public String leftAnswer, rightAnswer;

    //----Критические ситуации
    public int leftCrete=0, rightCrete=0;

    //----Текущая карточка----
    public String cardName = "0";

    //----Процент ответа----
    //public

    //----Звуки----
    public Sound soundL, soundR,//L - левый ответ, R - правый ответ.
            soundB1, soundB2, soundB3, soundB4,//B - нажатие на кнопку. Рандомная нота.
            soundO;//O - конец игры, проигрыш.

    //----Музыка----
    public Music musicM, musicG;//M - экран меню, G - ирговой экран.

    //----Громкость музыки и звуков----
    public float volume=1.0f;


    //----Игровые ресурсы. Служат для дальнейшего графического отображения----
    public int heap1, heap2, heap3, heap4;//Инициализируется при чтении из файла


    //----Текущий день. Служит для понимания, какую ветку выбирать. Ветка обязана быть сыграна до конца.
    // В ветке есть первая и последняя карточка. Последних может быть несколько. Первой веткой является первый день (первая)----
    public int day=1;

    //----Всего дней----
    public int totalday;

    //----Количество веток. Служит для понимания, сколько карточек всего----
    public final int counts=10;//Инициализируется при чтении из файла

    //----Количество не сыгранных веток----
    public int wounts, meownts;

    //----ПОТЕРЯЛО АКТУАЛЬНОСТЬ Несыгранные карточки----
    public IntArray won = new IntArray();//Инициализируется при чтении из файла

    //----Флаг музыки в игре. Пусть играет по дефолту. В настройках можно изменить----
    public boolean music=true, sound=true;

    //----Флаг паузы игрового экрана для избежания выбора карточки----
    public boolean pause;

    //----Флаг пропадающей херни [Какой ещё херни??]. -1 - в левой части экрана, 1 - в правой. 0 - нет дсмещения----
    public int flag=0;

    //----Шрифты----
    private static final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
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
        scrollbackground = 0 - 4*width + height;
        skin = new Skin();//Для цветовой палитры.
        paletteAtlas = new TextureAtlas(Gdx.files.internal(ton+"Palette.pack"));//Цветовая палитра.
        skin.addRegions(paletteAtlas);//Регионы цветовой палитры.
        BackgroundMenu = new Image(new Texture("Menu06.png"));
        BackgroundMenu.setSize(width, width*4);
        BackgroundMenu.setPosition(0,0);

        BackgroundSettings = new Image(new Texture("Setting03.png"));
        BackgroundSettings.setSize(this.width,this.width*17/10);
        BackgroundSettings.setPosition(0,0);

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



    public void Volume(float volume){
        musicM.setVolume(volume);
        musicG.setVolume(volume);
    }
}
