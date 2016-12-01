package com.imayor.game;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.imayor.game.Actors.GameCard;
import com.imayor.game.Actors.GameFooter;
import com.imayor.game.Actors.GameHeader;
import com.imayor.game.States.OverState;
import com.imayor.game.States.GameState;

/*
Слущатель шестов для игровой сцены
 */

public class MyGestureListener implements GestureDetector.GestureListener {
    final Settings set;
    final Resources res;
    final IMayor game;
    final GameCard card;
    final GameState del;
    final GameHeader header;
    final GameFooter footer;

    public MyGestureListener(IMayor game, GameState del) {
        this.game = game;
        this.set = game.set;
        this.res = game.res;
        this.card= game.card;
        this.del = del;
        this.header = game.header;
        this.footer = game.footer;
    }
    //----Нажатие
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    //----Отпускание----
    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    //----Долгое нажатие----
    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    //----Скольжение и вывод отпускание
    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        return false;
    }

    //----Каждая координата скольщения и разница между текущим и предыдущим положением пальца в пикселах экрана.
    //----В нашем случае нужно скольжение длиной в 50% от экрана. Причем, карта сдвинется максимум на 5 процентов.
    //----Карта обязана уметь передвигаться за пальцем со скоростью в 10 раз меньше чем палец и возвращаться на место,
    //а также перехватываться в том положении, что уже есть.
    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        res.pos += deltaX;
        card.Recard(card.current);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        if (res.width*1/10+Math.abs(res.pos)>res.width*1/10+20) {
            if (res.pos<0)
                res.soundL.play(res.volume);
            else
                res.soundR.play(res.volume);
            res.pos=0;//Обнуляем переменную смещения
            card.Recard(card.current);
            res.wounts--;//Уменьшаем количество несыгранных карточек
            res.meownts++;//Увеличиваем количество сыгранных (они же очки)
            footer.Relabel();//Изменяем количество очков
            res.won.removeIndex(card.current);//Удаляем карточку из массива несыгранных карточек
            if (Math.abs(res.pos) >= res.width * 1 / 10) {
                res.heap1 += card.Heap1R.get(res.won.get(card.current));
                res.heap2 += card.Heap2R.get(res.won.get(card.current));
                res.heap3 += card.Heap3R.get(res.won.get(card.current));
                res.heap4 += card.Heap4R.get(res.won.get(card.current));
            }
            header.Reheader();//Изменяем хидер
            if (res.wounts <= 0 | res.heap1 <= 0 | res.heap2 <= 0 | res.heap3 <= 0 | res.heap4 <= 0) {
                game.setScreen(new OverState(game));//В случае конца игры переходим к экрану конца игры
                del.dispose();//Удаляем текущий экран
                res.Zero();
                footer.Relabel();
            }
            else
            card.Select();//Выбираем новую карточку, зная что их стало меньше на одну
        }
        return false;
    }

    @Override
    public boolean zoom (float originalDistance, float currentDistance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}

