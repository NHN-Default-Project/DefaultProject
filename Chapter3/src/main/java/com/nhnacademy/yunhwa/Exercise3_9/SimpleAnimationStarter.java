package com.nhnacademy.yunhwa.Exercise3_9;


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

public class SimpleAnimationStarter extends Application {

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

        g.setFill(Color.WHITE);

        // 직사각형 틀 그리기
        g.fillRect(0, 0, width, height);

        int channelsCount = 6;
        int channelHeight = 100;
        int squareLength = 100;
        int N = width - squareLength;

        // 채널 구분 선 긋기
        for (int i = 1; i < channelsCount; i++) {
            g.strokeLine(0, (double) channelHeight * i, width, (double) channelHeight * i);
        }


        // 각 채널 (줄) 마다 정사각형 1개씩 그려주기
        for (int channelPosition = 0; channelPosition < channelsCount; channelPosition++) {
            if (channelPosition < channelsCount / 2) {
                // 순환 운동 : 편도
                drawCyclicFrame(g, (frameNumber * (channelPosition + 1 + ((int) Math.random() * 6) + 1)), elapsedSeconds, width, height, squareLength,
                        channelPosition, N);
            } else {
                // 진동 운동 : 왕복
                drawOscilationFrame(g, (frameNumber * (channelPosition + 4 + ((int) Math.random() * 6) + 1)), elapsedSeconds, width, height, squareLength,
                        channelPosition, N);
            }
        }

    }

    //
    public void drawBasicFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width,
                               int height, int squareLength, int channelPosition) {
        setFillColor(g, channelPosition);
        double x = frameNumber;
        double y = channelPosition * squareLength;
        double w = squareLength;
        double h = squareLength;
        g.fillRect(x, y, w, h);
        g.setStroke(Color.BLACK);
        g.strokeRect(x, y, w, h);
    }

    public void drawCyclicFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width,
                                int height, int squareLength, int channelPosition, int N) {
        // 순환 모션 : 편도
        int cyclicFrameNumber = frameNumber % N;
        drawBasicFrame(g, cyclicFrameNumber, elapsedSeconds, width, height, squareLength, channelPosition);
    }

    public void drawOscilationFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width,
                                    int height, int squareLength, int channelPosition, int N) {
        // 진동 모션 : 왕복
        int oscilationFrameNumber = frameNumber % (2 * N);
        if (oscilationFrameNumber > N) {
            oscilationFrameNumber = (2 * N) - oscilationFrameNumber;
        }
        drawBasicFrame(g, oscilationFrameNumber, elapsedSeconds, width, height, squareLength, channelPosition);

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

    public void setFillColor(GraphicsContext g, int channelPosition) {
        switch (channelPosition) {
            case 0:
                g.setFill(Color.RED);
                break;
            case 1:
                g.setFill(Color.ALICEBLUE);
                break;
            case 2:
                g.setFill(Color.BEIGE);
                break;
            case 3:
                g.setFill(Color.CORAL);
                break;
            case 4:
                g.setFill(Color.LIGHTPINK);
                break;
            case 5:
                g.setFill(Color.DARKGREEN);
                break;
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
