package com.ae2dms.Util;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;


public class GameTimer {

//    private AnimationTimer timer;
    private Timeline timer;
    private int foo = 0;

    private int seconds = 0;


    public StringProperty timeToDisplay = new SimpleStringProperty("00:00");

    public void start() {
        seconds = 0;
        timer = new Timeline(new KeyFrame(Duration.millis(1000), event -> timeToDisplay.set(parseToTimeFormat(++seconds))));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }

//    public void start() {
//        seconds = 0;
//        timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                foo ++;
//                seconds = foo % 60;
//            }
//        };
//        timer.start();

//        timer = new Timeline(new KeyFrame(Duration.millis(1000), event -> timeToDisplay.set(parseToTimeFormat(++seconds))));
//        timer.setCycleCount(Animation.INDEFINITE);
//        timer.play();
//    }


    public void stop(){
        if (timer != null) {
            timer.stop();
        }
    }

    public int getTime() {
        return seconds;
    }


    public void pause() {
//        timer.stop();
        timer.pause();
    }

    public void resume() {
//        timer.start();
        timer.play();
    }

    public static String parseToTimeFormat(int seconds) {
        Integer minute = seconds / 60;
        String minuteString = "0" + minute.toString();
        Integer second = seconds % 60;
        String secondString = "0" + second.toString();

        if (minuteString.length() != 2) {
            minuteString = minuteString.substring(minuteString.length() - 2);
        }

        if (secondString.length() != 2) {
            secondString = secondString.substring(secondString.length() - 2);
        }
        return minuteString + ":" + secondString;
    }
}

