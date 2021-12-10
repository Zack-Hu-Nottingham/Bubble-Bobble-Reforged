package com.ae2dms.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;


/**
 * The timer of the game, which records how long player spend to finish the game.
 */
public class GameTimer {

    private Timeline timer;

    private int seconds = 0;

    private StringProperty timeToDisplay = new SimpleStringProperty("00:00");

    /**
     * Time to display property string property.
     *
     * @return the string property
     */
    public StringProperty timeToDisplayProperty() {
        return timeToDisplay;
    }

    /**
     * Start the timer.
     */
    public void start() {
        seconds = 0;
        timer = new Timeline(new KeyFrame(Duration.millis(1000), event -> timeToDisplay.set(parseToTimeFormat(++seconds))));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }

    /**
     * Stop the timer.
     */
    public void stop(){
        if (timer != null) {
            timer.stop();
        }
    }

    /**
     * Pause the timer.
     */
    public void pause() {
        timer.pause();
    }

    /**
     * Resume the timer.
     */
    public void resume() {
        timer.play();
    }

    /**
     * Gets total time consumed in integer format.
     *
     * @return the time
     */
    public int getTime() {
        return seconds;
    }


    /**
     * Parse to time format string.
     *
     * @param seconds the seconds
     * @return the string
     */
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

