package com.example.sortingalgorithm;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Node {
    private HBox box;
    private int columnNumber;
    public int height;
    private Rectangle rect;
    private int rowNumber;

    Node(){

        rect = new Rectangle(1, 50, 20, 0);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.LIGHTBLUE);

        setRandomHeight();

        box = new HBox();
        box.setPadding(new Insets(1, 1, 1, 1));
        box.getChildren().addAll(rect);
        box.setAlignment(Pos.BOTTOM_LEFT);
    }
    public void setRandomHeight(){
        Random random = new Random();
        height = random.nextInt(300) + 1;
        rect.setHeight(height);
        rect.setFill(Color.LIGHTBLUE);
    }

    public void displayNode(GridPane window, int _rowNumber){
        this.rowNumber = _rowNumber;
        GridPane.setConstraints(box, columnNumber, rowNumber);
        window.getChildren().addAll(box);
    }

    public void currentNode() {
        Timeline line = new Timeline(new KeyFrame(Duration.seconds(.05), e->{
            rect.setFill(Color.ORANGE);
        }));

        line.setCycleCount(2);
        line.play();
        line.setOnFinished(e -> rect.setFill(Color.LIGHTBLUE));
    }

    public void finished(){
        Timeline line = new Timeline(new KeyFrame(Duration.seconds(.04), e->{
            rect.setFill(Color.LIGHTGREEN);
        }));

        line.setCycleCount(1);
        line.play();
    }

    public void changeColumn(int newCol){

        Timeline line = new Timeline(new KeyFrame(Duration.seconds(.02), e->{
            rect.setFill(Color.LIGHTGREEN);
        }));

        line.setCycleCount(2);
        line.play();
        line.setOnFinished(e -> rect.setFill(Color.LIGHTBLUE));

        columnNumber = newCol;
        GridPane.setConstraints(box, columnNumber, rowNumber);
    }

    public void setFixedHeight(int _height){
        this.height = _height;
        rect.setHeight(height);
        rect.setFill(Color.LIGHTBLUE);
    }

    public int getColumnNumber(){
        return columnNumber;
    }
}