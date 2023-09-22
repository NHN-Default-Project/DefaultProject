package com.nhnacademy.yunhwa.Exercise3_9;

import com.nhnacademy.yunhwa.Exercise3_8.SimpleGraphicsStarter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Exercise3_9 extends Application {

    public static void main(String[] args) {
        SimpleAnimationStarter.main(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SimpleAnimationStarter simpleAnimationStarter = new SimpleAnimationStarter();
        simpleAnimationStarter.start(new Stage());
    }
}
