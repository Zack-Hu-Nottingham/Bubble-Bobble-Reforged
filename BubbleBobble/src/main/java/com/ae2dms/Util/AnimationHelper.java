package com.ae2dms.Util;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Animation helper, which implements the complicated animation for nodes.
 */
public class AnimationHelper {

    /**
     * Let the node which is previously invisible to pop up.
     *
     * @param node the node
     */
    public static void popUp(Node node) {
        node.setVisible(true);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(300), node);
        scaleTransition.setFromX(0.03);
        scaleTransition.setFromY(0.03);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.play();
    }

    /**
     * Let the popped up node fade away.
     *
     * @param node the node
     */
    public static void fadeOut(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((event) -> {
            node.setVisible(false);
            node.setOpacity(1);
        });
        fadeTransition.play();
    }
}
