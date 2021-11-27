package com.example.kg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class SimpleLinesEx extends Application {

    public static GraphicsContext grafiks;
    SomeThing mThing;
    public static Graphics a = new DebugGraphics();


    @Override
    public void start(Stage stage) throws InterruptedException {

        initUI(stage);
    }

    private void initUI(Stage stage)  {

        mThing = new SomeThing();



        var root = new Pane();

        var canvas = new Canvas(800, 800);
        var grafiks = canvas.getGraphicsContext2D();
        this.grafiks = grafiks;
        kub(grafiks);
        drawL(grafiks);
        drawR(grafiks);
        Thread myThready = new Thread(mThing);
        myThready.start();

        root.getChildren().add(canvas);

        var scene = new Scene(root, 800, 800, Color.WHITESMOKE);

        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();

    }

    private void kub(GraphicsContext gc) {

        gc.beginPath();
        gc.moveTo(90.5, 90.5);
        gc.lineTo(150.5, 90.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(90.5,150.5);
        gc.lineTo(90.5,90.5);
        gc.lineTo(70.5,70.5);
        gc.lineTo(70.5, 130.5);
        gc.lineTo(90.5,150.5);
        gc.lineTo(150.5,150.5);
        gc.lineTo(150.5,90.5);
        gc.lineTo(130.5,70.5);
        gc.lineTo(70.5,70.5);
        gc.stroke();

    }
    private void drawL(GraphicsContext gc) {

        gc.beginPath();
        gc.moveTo(200.5, 150.5);
        gc.lineTo(260.5, 150.5);
        gc.lineTo(200.5, 150.5);
        gc.lineTo(180.5, 130.5);
        gc.lineTo(220.5, 70.5);
        gc.lineTo(200.5, 150.5);
        gc.lineTo(260.5, 150.5);
        gc.lineTo(220.5, 70.5);
        gc.stroke();

    }
    private void drawR(GraphicsContext gc) {

        gc.beginPath();
        gc.moveTo(310.5, 130.5);
        gc.lineTo(340.5, 70.5);
        gc.lineTo(370.5, 130.5);
        gc.lineTo(340.5, 190.5);
        gc.lineTo(310.5, 130.5);
        gc.lineTo(335.5, 145.5);//
        gc.lineTo(370.5, 130.5);

        gc.lineTo(340.5, 70.5);
        gc.lineTo(335.5, 145.5);//
        gc.lineTo(340.5, 190.5);


        gc.stroke();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

class SomeThing			//Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    public void runingGO(Graphics gc) throws InterruptedException        //Этот метод будет выполняться в побочном потоке
    {

    }

    @Override
    public void run() {
        Graphics a = SimpleLinesEx.a;
        try {
            runingGO(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}