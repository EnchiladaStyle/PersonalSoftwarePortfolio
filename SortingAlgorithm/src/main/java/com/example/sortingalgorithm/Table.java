package com.example.sortingalgorithm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.*;

public class Table {
    private List<Node> nodes = new ArrayList<Node>();
    private Timeline checkIfFinished;
    private ArrayList<Integer> heights;
    private Timeline helpline;
    private int rowNumber;
    private boolean sorted;
    Table(GridPane window, int _rowNumber){
        this.rowNumber = _rowNumber;
        initializeNodes(window);
    }

    public void setNodeHeights(ArrayList<Integer> newHeights){

        for (int i = 0; i < 24; i++){
            nodes.get(i).setFixedHeight(newHeights.get(i));
        }
    }

    public ArrayList<Integer> getHeightValues(){
        heights = new ArrayList<Integer>();
        for (int i = 0; i < 24; i++){
            heights.add(nodes.get(i).height);
        }

        return heights;
    }

    //the function below recursively calls the Sort function of the algorithm, creating a makeshift async loop.
    public void recursion(Algorithm algo){

        helpline = new Timeline(new KeyFrame(Duration.seconds(.0001), e->{

            for (int i=0; i<23; i++){
                if (nodes.get(i).height > nodes.get(i+1).height){
                    algo.sort(nodes, this);
                    break;
                }
                else{
                    helpline.stop();
                }
            }
        }));

        helpline.setCycleCount(1);
        helpline.play();
    }

    public void sort(Algorithm algo){

            Timeline line = new Timeline(new KeyFrame(Duration.seconds(.01), e->{
                algo.sort(nodes, this);
            }));

            line.setCycleCount(1);
            line.play();

            checkIfFinished = new Timeline(new KeyFrame(Duration.seconds(.5), e->{
                sorted = true;
                for (int i=0; i<23; i++){
                    if (nodes.get(i).height > nodes.get(i+1).height){
                        sorted = false;
                    }
                }

                if (sorted){
                    final int[] i = {0};
                    Timeline finishLine = new Timeline(new KeyFrame(Duration.seconds(.05), f -> {
                        nodes.get(i[0]).currentNode();
                        i[0]++;

                        Timeline makeGreen = new Timeline(new KeyFrame(Duration.seconds(1.2), j -> {
                            for (int q = 0; q < 24; q++){
                                nodes.get(q).finished();
                            }
                        }));
                        makeGreen.setCycleCount(1);
                        makeGreen.play();

                        checkIfFinished.stop();
                    }));
                    finishLine.setCycleCount(24);
                    finishLine.play();
                }
            }));

            checkIfFinished.setCycleCount(100);
            checkIfFinished.play();
    }

    public void randomize(){
        for (int i = 0; i < 24; i++){
            nodes.get(i).setRandomHeight();
        }
    }
    public void initializeNodes(GridPane window){

        Node node1 = new Node(); Node node2 = new Node(); Node node3 = new Node();
        Node node4 = new Node(); Node node5 = new Node(); Node node6 = new Node();
        Node node7 = new Node(); Node node8 = new Node(); Node node9 = new Node();
        Node node10 = new Node(); Node node11 = new Node(); Node node12 = new Node();
        Node node13 = new Node(); Node node14 = new Node(); Node node15 = new Node();
        Node node16 = new Node(); Node node17 = new Node(); Node node18 = new Node();
        Node node19 = new Node(); Node node20 = new Node(); Node node21 = new Node();
        Node node22 = new Node(); Node node23 = new Node(); Node node24 = new Node();

        nodes.add(node1); nodes.add(node2); nodes.add(node3); nodes.add(node4);
        nodes.add(node5); nodes.add(node6); nodes.add(node7); nodes.add(node8);
        nodes.add(node9); nodes.add(node10); nodes.add(node11); nodes.add(node12);
        nodes.add(node13); nodes.add(node14); nodes.add(node15); nodes.add(node16);
        nodes.add(node17); nodes.add(node18); nodes.add(node19); nodes.add(node20);
        nodes.add(node21); nodes.add(node22); nodes.add(node23); nodes.add(node24);

        for (int i = 0; i < 24; i++){
            nodes.get(i).changeColumn(i);
            nodes.get(i).displayNode(window, rowNumber);
        }
    }
}
