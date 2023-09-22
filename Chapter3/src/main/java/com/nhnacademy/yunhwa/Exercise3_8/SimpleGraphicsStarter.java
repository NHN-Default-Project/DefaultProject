package com.nhnacademy.yunhwa.Exercise3_8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *  This file can be used to draw simple pictures.  Just fill in
 *  the definition of drawPicture with the code that draws your picture.
 */
public class SimpleGraphicsStarter extends Application {

    /**
     * Draws a picture.  The parameters width and height give the size
     * of the drawing area, in pixels.
     */
    public void drawPicture(GraphicsContext g, int width, int height) {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color.

        // As an example, draw a large number of colored disks.
        // To get a different picture, just erase this code, and substitute your own.

        double centerX;     // The x-coord of the center of a disk.
        double centerY;     // The y-coord of the center of a disk.


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                centerX = 25.0 + i * 50;
                centerY = 25.0 + j * 50;

                if ((i + j) % 2 == 0) {
                    g.setFill(Color.RED);
                } else {
                    g.setFill(Color.BLACK);
                }

                g.fillRect(centerX - 25, centerY - 25, 50, 50);
                g.setStroke(Color.BLACK);
                g.strokeRect(centerX - 25, centerY - 25, 50, 50);
            }
        }

    }

    // end drawPicture()

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
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

} // end SimpleGraphicsStarter
