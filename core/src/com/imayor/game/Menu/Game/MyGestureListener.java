package com.imayor.game.Menu.Game;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.imayor.game.IMayor;
import com.imayor.game.Menu.Game.Over.OverState;
import com.imayor.game.Res.Resources;
import com.imayor.game.Res.Settings;

public class MyGestureListener implements GestureDetector.GestureListener {
    public final IMayor game;
    public final GameState gamestate;

    public MyGestureListener(IMayor game, GameState gamestate) {
        this.game = game;
        this.gamestate = gamestate;
    }
    //----Нажатие
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        gamestate.res.maybemust = true;
        return false;
    }

    //----Отпускание----
    @Override
    public boolean tap(float x, float y, int count, int button) {
        gamestate.res.maybemust = false;
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

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        gamestate.res.pos += deltaX;
        gamestate.card.Recard();

        gamestate.answer.update();
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
                if (Math.abs(gamestate.res.pos)>=gamestate.res.width/3) {

                    //----Звуки карточки----
                    if (gamestate.res.sound) {
                        if (gamestate.res.pos < 0)
                            gamestate.res.soundL.play(gamestate.res.volume);
                        else
                            gamestate.res.soundR.play(gamestate.res.volume);
                    }

                    //----Если это последняя карточка в топе, то кикаем её
                    /*if (gamestate.card.annexLeft!="end" & gamestate.card.annexRight!="end") {
                            //!!!!Удаляем один индекс и, соответственно, содержимое!!!!
                            gamestate.res.won.removeIndex(gamestate.card.tur);

                        gamestate.res.wounts--;
                            //!!!!Уменьшаем количество оставшихся карточек!!!!
                    }*/

                    gamestate.res.meownts++;

                    //----Прибавляем и отнимаем ресурсы----
                    if (gamestate.res.pos>0) {
                        if (gamestate.res.heap1+gamestate.card.licentiousnessRight1>100)
                            gamestate.res.heap1=100;
                        else
                            gamestate.res.heap1 += gamestate.card.licentiousnessRight1;
                        if (gamestate.res.heap2+gamestate.card.licentiousnessRight2>100)
                            gamestate.res.heap2=100;
                        else
                            gamestate.res.heap2 += gamestate.card.licentiousnessRight2;
                        if (gamestate.res.heap3+gamestate.card.licentiousnessRight3>100)
                            gamestate.res.heap3=100;
                        else
                            gamestate.res.heap3 += gamestate.card.licentiousnessRight3;
                        if (gamestate.res.heap4+gamestate.card.licentiousnessRight4>100)
                            gamestate.res.heap4=100;
                        else
                            gamestate.res.heap4 += gamestate.card.licentiousnessRight4;
                    }
                    else{
                        gamestate.res.heap1 += gamestate.card.licentiousnessLeft1;
                        gamestate.res.heap2 += gamestate.card.licentiousnessLeft2;
                        gamestate.res.heap3 += gamestate.card.licentiousnessLeft3;
                        gamestate.res.heap4 += gamestate.card.licentiousnessLeft4;
                    }

                    if (gamestate.res.pos<0 & gamestate.res.leftCrete!=0)
                        gamestate.res.wounts=gamestate.res.leftCrete;
                    if (gamestate.res.pos>0 & gamestate.res.rightCrete!=0)
                        gamestate.res.wounts=gamestate.res.rightCrete;
                    //----Игра закончилась----
                    if (gamestate.res.wounts <= 0 | gamestate.res.heap1 <= 0 | gamestate.res.heap2 <= 0 | gamestate.res.heap3 <= 0 | gamestate.res.heap4 <= 0) {
                        if (gamestate.res.music)
                            gamestate.res.musicG.pause();
                        gamestate.res.pos=0;
                        game.setScreen(new OverState(game, gamestate));//В случае конца игры переходим к экрану конца игры
                    }
                    //----Игра не закончилась----
                    else {
                        if (gamestate.res.pos <0){
                            if (gamestate.card.annexLeft.equals("end"))
                                gamestate.card.Select();
                            else
                                gamestate.res.cardName = gamestate.card.annexLeft;
                        }
                        else
                        {
                            if (gamestate.card.annexRight.equals("end"))
                                gamestate.card.Select();
                            else
                                gamestate.res.cardName = gamestate.card.annexRight;
                        }
                        gamestate.res.maybemust = true;
                        gamestate.stageUpdate();
                    }
                }
                else {
                    gamestate.res.maybemust = false;
                    ////Возвращаем игровой стейдж в исхоное состояние
                    //game.answer.Zero();
                }
        //gamestate.res.maybemust = false;
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
