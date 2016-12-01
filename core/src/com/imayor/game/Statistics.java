package com.imayor.game;

/*
Класс переменных и расчета статистики
 */

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

public class Statistics {
    final IMayor game;
    //----Количество сессий----
    int AMOUNT;

    //----Карта, на которой провалился игрок----
    private IntArray MAP = new IntArray();

    //----Общее время игровой сессии----
    private IntArray TIME = new IntArray();

    //----Сессия, карта и время ожидания (раздумия)----
    private Array<String> MAPTIME = new Array<String>();

    //----Общий счёт во время окончания игры----
    private IntArray SCORE = new IntArray();

    public Statistics(IMayor game){
        this.game = game;
    }
}
