package com.imayor.game.Res;

/*
Вытаскиваем и сохраняем настройки
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Settings {
    final private Resources res;
    private String link;//Ссылка на хранилище
    private String str;

    public Settings(Resources res){
        this.res = res;

        if(Gdx.files.isExternalStorageAvailable())//Проверка наличия первого хранилища.
            link = Gdx.files.getExternalStoragePath();//Ссылка на хранилище.
        else if (Gdx.files.isLocalStorageAvailable())//Проверка наличия второго хранилища.
            link = Gdx.files.getLocalStoragePath();//Ссылка на второе хранилище
        Read();
        res.Volume(res.volume);
    }

    public void Read(){
        FileHandle settings = Gdx.files.internal("settings.pack");
        str = settings.readString();
        res.wounts = Integer.parseInt((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        res.heap1 = Integer.parseInt((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        res.heap2 = Integer.parseInt((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        res.heap3 = Integer.parseInt((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        res.heap4 = Integer.parseInt((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        res.volume = Float.parseFloat((str.substring(0, str.indexOf("*"))));
        str = str.substring(str.indexOf('*') + 1);
        //!!!!Очищаем массив карточек!!!!
        res.won.clear();
        //!!!!0,1,2,3,4,5,6,7,8,9 - всего десять!!!!
        for (int i=0; i<res.wounts; i++) {

             res.won.add(Integer.parseInt((str.substring(0, str.indexOf("$")))));
             str = str.substring(str.indexOf('$') + 1);
        }

    }

    public void Write(){
        FileHandle settings = Gdx.files.internal("settings.pack");
        settings.writeString(String.valueOf(res.counts), true);
        settings.writeString(String.valueOf(res.heap1), true);
        settings.writeString(String.valueOf(res.heap2), true);
        settings.writeString(String.valueOf(res.heap3), true);
        settings.writeString(String.valueOf(res.heap4), true);
        str=null;
        for (int i=0; i< res.won.size; i++)
        str = str + String.valueOf(res.won.get(i)) + '$';
        settings.writeString(str, true);
    }
}
