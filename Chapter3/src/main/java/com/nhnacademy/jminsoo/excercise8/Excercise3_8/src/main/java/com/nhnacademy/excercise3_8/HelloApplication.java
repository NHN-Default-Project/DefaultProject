package com.nhnacademy.excercise3_8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    //    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
    public void drawPicture(GraphicsContext g, int width, int height) {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color.

        int centerX = 0;
        int centerY = 0;

        int addValue = 50;
        boolean isRed = true;
        for (int countY = 0; countY < 8; countY++) {
            for (int countX = 0; countX < 8; countX++) {

                centerX = centerX + addValue;

                if (isRed) {
                    g.setFill(Color.RED);
                    isRed = false;
                } else {
                    g.setFill(Color.BLACK);
                    isRed = true;
                }
                g.fillRect(centerX, centerY, 50, 50);
            }
            centerX = 0;
            centerY = centerY + addValue;
        }


    } // end drawPicture()

    // ------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------

    public void start(Stage stage) {
        int width = 400; // The width of the image. You can modify this value!
        int height = 400; // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Graphics"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}