package com.example.sortingalgorithm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Sorting Race");

        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(10, 10, 10, 10));
        HBox bottomMenu = new HBox();
        bottomMenu.setPadding(new Insets(50, 50, 50, 50));
        GridPane leftMenu = new GridPane();
        leftMenu.setPadding(new Insets(50, 50, 50, 50));
        GridPane centerMenu = new GridPane();
        centerMenu.setPadding(new Insets(10, 10, 10, 10));
        centerMenu.setVgap(8);
        centerMenu.setHgap(10);

        Button startButton = new Button("                     Sort                     ");
        Button randomize = new Button("              Randomize              ");
        randomize.setStyle("-fx-min-height: 50");
        startButton.setStyle("-fx-min-height: 50;");

        ComboBox<String> choiceBox1 = new ComboBox<String>();
        choiceBox1.getItems().addAll("Bubble Sort", "Insertion Sort", "Merge Sort");
        choiceBox1.setStyle("-fx-min-height: 50");
        choiceBox1.setPromptText("Choose Algorithm 1");
        ComboBox<String> choiceBox2 = new ComboBox<>();
        choiceBox2.getItems().addAll("Bubble Sort", "Insertion Sort", "Merge Sort");
        choiceBox2.setStyle("-fx-min-height: 50");
        choiceBox2.setPromptText("Choose Algorithm 2");

        GridPane.setConstraints(randomize, 1, 15);
        GridPane.setConstraints(startButton, 1, 16);
        GridPane.setConstraints(choiceBox1, 1, 17);
        GridPane.setConstraints(choiceBox2, 1, 30);

        leftMenu.getChildren().addAll(startButton, randomize, choiceBox1, choiceBox2);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(leftMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Table tab1 = new Table(centerMenu, 0);
        Table tab2 = new Table(centerMenu, 1);
        tab2.setNodeHeights(tab1.getHeightValues());
        centerMenu.setAlignment(Pos.BOTTOM_LEFT);

        startButton.setOnAction(e -> {

            switch (choiceBox1.getValue()) {

                case "Insertion Sort":
                    InsertionSort insert = new InsertionSort();
                    tab1.sort(insert);
                    break;
                case "Bubble Sort":
                    BubbleSort bubble = new BubbleSort();
                    tab1.sort(bubble);
                    break;
                case "Merge Sort":
                    MergeSort merge = new MergeSort();
                    tab1.sort(merge);
                    break;
                default:
                    System.out.println("no entry");
            }

            switch (choiceBox2.getValue()) {

                case "Insertion Sort":
                    InsertionSort insert = new InsertionSort();
                    tab2.sort(insert);
                    break;
                case "Bubble Sort":
                    BubbleSort bubble = new BubbleSort();
                    tab2.sort(bubble);
                    break;
                case "Merge Sort":
                    MergeSort merge = new MergeSort();
                    tab2.sort(merge);
                    break;
                default:
                    System.out.println("no entry");
            }
        });

        randomize.setOnAction(e -> {
            tab1.randomize();
            tab2.setNodeHeights(tab1.getHeightValues());
        });

        Scene scene = new Scene(borderPane, 1115, 700);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}