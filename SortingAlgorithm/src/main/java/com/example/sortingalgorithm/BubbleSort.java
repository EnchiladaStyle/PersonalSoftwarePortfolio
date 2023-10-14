package com.example.sortingalgorithm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.List;
import java.util.Collections;

public class BubbleSort extends Algorithm {

    private int wall = 23;
    private int inBetween;

    public void sort(List<Node> nodes, Table tab){

        Timeline line1 = new Timeline(new KeyFrame(Duration.seconds(wall*.037), e->{
            algorithm(nodes);
        }));

        line1.setCycleCount(1);
        line1.play();
        line1.setOnFinished(e -> tab.recursion(this));
    }

    private void algorithm(List<Node> nodes){

        final int[] i = {0};
        Timeline line = new Timeline(new KeyFrame(Duration.seconds(.038), e -> {
            nodes.get(i[0]).currentNode();
            if (nodes.get(i[0]).height > nodes.get(i[0] + 1).height) {
                inBetween = nodes.get(i[0]).getColumnNumber();
                nodes.get(i[0]).changeColumn(nodes.get(i[0] + 1).getColumnNumber());
                nodes.get(i[0] + 1).changeColumn(inBetween);
                Collections.swap(nodes, i[0], i[0] + 1);
            }

            i[0]++;
        }));

        line.setCycleCount(wall);
        line.play();

        wall--;
    }
}