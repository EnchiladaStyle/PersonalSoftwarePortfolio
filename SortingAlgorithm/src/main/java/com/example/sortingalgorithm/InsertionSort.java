package com.example.sortingalgorithm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Collections;
import java.util.List;

public class InsertionSort extends Algorithm {

    private int wall = 1;
    private int current = 1;
    private int inBetween;
    private int iteration = 0;
    private Timeline sortLine;

    public void sort(List<Node> nodes, Table tab){

        Timeline line1 = new Timeline(new KeyFrame(Duration.seconds(wall*.06), e->{
            algorithm(nodes);
        }));

        line1.setCycleCount(1);
        line1.play();

        if (iteration != 22){
            line1.setOnFinished(e -> tab.recursion(this));
        }
    }
    private void algorithm(List<Node> nodes){

        final int[] checkForWall = {0};
        final int[] i = {current};
        sortLine = new Timeline(new KeyFrame(Duration.seconds(.056), e -> {

            if (i[0] != 0 && i[0] < 24){
                nodes.get(i[0]).currentNode();
                if (nodes.get(i[0]).height <= nodes.get(i[0] - 1).height) {
                    inBetween = nodes.get(i[0]).getColumnNumber();
                    nodes.get(i[0]).changeColumn(nodes.get(i[0] - 1).getColumnNumber());
                    nodes.get(i[0] - 1).changeColumn(inBetween);
                    Collections.swap(nodes, i[0], i[0] - 1);
                    i[0]--;

            }
            }
            checkForWall[0]++;

            if (checkForWall[0] == wall){
                iteration++;
                wall = 1;
                current++;
                for (int j = current; j > 0; j--){
                    if (j < 24 && current < 24){

                        if (nodes.get(current).height <= nodes.get(j - 1).height){
                            wall++;
                        }
                    }

                    sortLine.stop();
                }
            }
        }));

        sortLine.setCycleCount(wall);
        sortLine.play();
    }
}
