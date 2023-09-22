package com.nhnacademy.parkminsu;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This file can be used to create very simple animations.  Just fill in
 * the definition of drawFrame with the code to draw one frame of the
 * animation, and possibly change a few of the values in the rest of
 * the program as noted below.
 */
public class Exercise3_9 extends Application {

    /**
     * Draws one frame of an animation. This subroutine should be called
     * about 60 times per second.  It is responsible for redrawing the
     * entire drawing area. The parameter g is used for drawing. The frameNumber
     * starts at zero and increases by 1 each time this subroutine is called.
     * The parameter elapsedSeconds gives the number of seconds since the animation
     * was started.  By using frameNumber and/or elapsedSeconds in the drawing
     * code, you can make a picture that changes over time.  That's an animation.
     * The parameters width and height give the size of the drawing area, in pixels.
     */
    public void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

        /* NOTE:  To get a different animation, just erase the contents of this
         * subroutine and substitute your own.
         */

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); //

        // Gap between edges of drawing area and outer rectangle.
        int N = width;
        int squareCnt = 6;
        int interval = 20;
        double cycleFrameNumber;
        double oscilationFrameNumber;

        for (int i = 1; i <= squareCnt; i++) {
            g.strokeLine(0, interval * i, width, interval * i);
        }
        g.setStroke(Color.BLACK);  // Draw the rectangle outlines in black.
        for (int i = 0; i < squareCnt; i++) {
            differentColor(i, g);
            oscilationFrameNumber = (frameNumber / (i + 1) + (i * 200)) % (2 * N);
            cycleFrameNumber = ((frameNumber / (i + 1)) + (i * 300)) % N;
            if (i < squareCnt / 2) {
                g.fillRect(cycleFrameNumber, (i * interval), interval, interval);

                g.strokeRect(cycleFrameNumber, (i * interval), interval, interval);
            } else {
                if (oscilationFrameNumber > N) {
                    oscilationFrameNumber = (2 * N) - oscilationFrameNumber;
                    g.fillRect(oscilationFrameNumber, (i * interval), interval, interval);
                }
                g.fillRect(oscilationFrameNumber, (i * interval), interval, interval);
                g.strokeRect(oscilationFrameNumber, (i * interval), interval, interval);
            }

        }
    }


    public void differentColor(int i, GraphicsContext g) {
        switch (i) {
            case 0:
                g.setFill(Color.RED);
                break;
            case 1:
                g.setFill(Color.BLUE);
                break;
            case 2:
                g.setFill(Color.BEIGE);
                break;
            case 3:
                g.setFill(Color.CADETBLUE);
                break;
            case 4:
                g.setFill(Color.YELLOW);
                break;
            case 5:
                g.setFill(Color.DARKBLUE);
                break;
        }

    }
    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public void start(Stage stage) {
        int width = 800;   // The width of the image.  You can modify this value!
        int height = 600;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width, height);
        drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Animation"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;

            public void handle(long now) {
                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
                } else if (now - previousTime > 0.95e9 / 60) {
                    // The test in the else-if is to make sure that drawFrame() is
                    // called about once every 1/60 second.  It is required since
                    // handle() can be called by the system more often than that.
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum, (now - startTime) / 1e9, width, height);
                    previousTime = now;
                }
            }
        };
        anim.start();
    }

    public static void main(String[] args) {
        launch();
    }

} // end SimpleAnimationStarter