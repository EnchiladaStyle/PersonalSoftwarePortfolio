package com.example.sortingalgorithm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class MergeSort extends Algorithm{
    private List<Node> newList = new ArrayList<Node>();
    private List<List<Integer>> indexLeftList;
    private List<List<Integer>> indexRightList;
    private int iteration = 0;
    private int loopCounter = 1;
    private List<Integer> loopCounts;

    MergeSort(){
        assignIndexLeft();
        assignIndexRight();
    }

    public void sort(List<Node> nodes, Table tab){

        loopCounter = 1;
        Timeline line1 = new Timeline(new KeyFrame(Duration.seconds(loopCounts.get(iteration)*.073), e -> {
            if (iteration != 23) {
                algorithm(nodes);
            }
        }));

        line1.setCycleCount(1);
        line1.play();

        line1.setOnFinished(e -> {
            tab.recursion(this);
        });
    }

    private void algorithm(List<Node> nodes){

        final int[] a = {0};
        final int[] b = {0};
        Timeline mergeLine = new Timeline(new KeyFrame(Duration.seconds(.071), e -> {

            if (indexRightList.get(iteration).size() > a[0]) {
                nodes.get(indexLeftList.get(iteration).get(a[0])).currentNode();
            }

            if (indexLeftList.get(iteration).size() > b[0]) {

                if (b[0] < 8) {
                    nodes.get(indexRightList.get(iteration).get(b[0])).currentNode();
                }
            }

            if (indexLeftList.get(iteration).size() <= a[0]) {

                this.newList.add(nodes.get(indexRightList.get(iteration).get(b[0])));
                b[0]++;
            } else if (indexRightList.get(iteration).size() <= b[0]) {
                this.newList.add(nodes.get(indexLeftList.get(iteration).get(a[0])));
                a[0]++;

            } else if (nodes.get(indexLeftList.get(iteration).get(a[0])).height <= nodes.get(indexRightList.get(iteration).get(b[0])).height) {
                this.newList.add(nodes.get(indexLeftList.get(iteration).get(a[0])));
                a[0]++;
            } else if (nodes.get(indexLeftList.get(iteration).get(a[0])).height >= nodes.get(indexRightList.get(iteration).get(b[0])).height) {
                this.newList.add(nodes.get(indexRightList.get(iteration).get(b[0])));
                b[0]++;
            }

            if (loopCounter == loopCounts.get(iteration)) {
                this.loopCounter = 1;

                for (int i = 0; i < newList.size(); i++) {

                    newList.get(i).changeColumn(i + indexLeftList.get(iteration).get(0));
                    nodes.set(i + indexLeftList.get(iteration).get(0), newList.get(i));

                    if (i == newList.size() - 1) {
                        newList.clear();
                        iteration++;
                    }
                }
            }

            loopCounter += 1;
        }));

        mergeLine.setCycleCount(loopCounts.get(iteration));
        mergeLine.play();
    }

    private void assignIndexLeft(){
        indexLeftList = new ArrayList<>();
        List<Integer> Iter1 = new ArrayList<>(); Iter1.add(0);
        indexLeftList.add(Iter1);
        List<Integer> Iter2 = new ArrayList<>();
        Iter2.add(2);
        indexLeftList.add(Iter2);
        List<Integer> Iter3 = new ArrayList<>();
        Iter3.add(0); Iter3.add(1);
        indexLeftList.add(Iter3);
        List<Integer> Iter4 = new ArrayList<>();
        Iter4.add(4);
        indexLeftList.add(Iter4);
        List<Integer> Iter5 = new ArrayList<>();
        Iter5.add(6);
        indexLeftList.add(Iter5);
        List<Integer> Iter6 = new ArrayList<>();
        Iter6.add(4); Iter6.add(5);
        indexLeftList.add(Iter6);
        List<Integer> Iter7 = new ArrayList<>();
        Iter7.add(0); Iter7.add(1); Iter7.add(2); Iter7.add(3);
        indexLeftList.add(Iter7);
        List<Integer> Iter8 = new ArrayList<>();
        Iter8.add(8);
        indexLeftList.add(Iter8);
        List<Integer> Iter9 = new ArrayList<>();
        Iter9.add(10);
        indexLeftList.add(Iter9);
        List<Integer> Iter10 = new ArrayList<>();
        Iter10.add(8); Iter10.add(9);
        indexLeftList.add(Iter10);
        List<Integer> Iter11 = new ArrayList<>();
        Iter11.add(12);
        indexLeftList.add(Iter11);
        List<Integer> Iter12 = new ArrayList<>();
        Iter12.add(14);
        indexLeftList.add(Iter12);
        List<Integer> Iter13 = new ArrayList<>();
        Iter13.add(12); Iter13.add(13);
        indexLeftList.add(Iter13);
        List<Integer> Iter14 = new ArrayList<>();
        Iter14.add(8); Iter14.add(9); Iter14.add(10); Iter14.add(11);
        indexLeftList.add(Iter14);
        List<Integer> Iter15 = new ArrayList<>();
        Iter15.add(0); Iter15.add(1); Iter15.add(2); Iter15.add(3); Iter15.add(4); Iter15.add(5); Iter15.add(6); Iter15.add(7);
        indexLeftList.add(Iter15);
        List<Integer> Iter16 = new ArrayList<>();
        Iter16.add(16);
        indexLeftList.add(Iter16);
        List<Integer> Iter17 = new ArrayList<>();
        Iter17.add(18);
        indexLeftList.add(Iter17);
        List<Integer> Iter18 = new ArrayList<>();
        Iter18.add(16); Iter18.add(17);
        indexLeftList.add(Iter18);
        List<Integer> Iter19 = new ArrayList<>();
        Iter19.add(20);
        indexLeftList.add(Iter19);
        List<Integer> Iter20 = new ArrayList<>();
        Iter20.add(22);
        indexLeftList.add(Iter20);
        List<Integer> Iter21 = new ArrayList<>();
        Iter21.add(20); Iter21.add(21);
        indexLeftList.add(Iter21);
        List<Integer> Iter22 = new ArrayList<>();
        Iter22.add(16); Iter22.add(17); Iter22.add(18); Iter22.add(19);
        indexLeftList.add(Iter22);
        List<Integer> Iter23 = new ArrayList<>();
        Iter23.add(0); Iter23.add(1); Iter23.add(2); Iter23.add(3); Iter23.add(4); Iter23.add(5); Iter23.add(6);
        Iter23.add(7); Iter23.add(8); Iter23.add(9); Iter23.add(10); Iter23.add(11); Iter23.add(12);
        Iter23.add(13); Iter23.add(14);Iter23.add(15);
        indexLeftList.add(Iter23);

    }
    private void assignIndexRight(){
        indexRightList = new ArrayList<>();
        List<Integer> Iter1 = new ArrayList<>();
        Iter1.add(1);
        indexRightList.add(Iter1);
        List<Integer> Iter2 = new ArrayList<>();
        Iter2.add(3);
        indexRightList.add(Iter2);
        List<Integer> Iter3 = new ArrayList<>();
        Iter3.add(2); Iter3.add(3);
        indexRightList.add(Iter3);
        List<Integer> Iter4 = new ArrayList<>();
        Iter4.add(5);
        indexRightList.add(Iter4);
        List<Integer> Iter5 = new ArrayList<>();
        Iter5.add(7);
        indexRightList.add(Iter5);
        List<Integer> Iter6 = new ArrayList<>();
        Iter6.add(6); Iter6.add(7);
        indexRightList.add(Iter6);
        List<Integer> Iter7 = new ArrayList<>();
        Iter7.add(4); Iter7.add(5); Iter7.add(6); Iter7.add(7);
        indexRightList.add(Iter7);
        List<Integer> Iter8 = new ArrayList<>();
        Iter8.add(9);
        indexRightList.add(Iter8);
        List<Integer> Iter9 = new ArrayList<>();
        Iter9.add(11);
        indexRightList.add(Iter9);
        List<Integer> Iter10 = new ArrayList<>();
        Iter10.add(10); Iter10.add(11);
        indexRightList.add(Iter10);
        List<Integer> Iter11 = new ArrayList<>();
        Iter11.add(13);
        indexRightList.add(Iter11);
        List<Integer> Iter12 = new ArrayList<>();
        Iter12.add(15);
        indexRightList.add(Iter12);
        List<Integer> Iter13 = new ArrayList<>();
        Iter13.add(14); Iter13.add(15);
        indexRightList.add(Iter13);
        List<Integer> Iter14 = new ArrayList<>();
        Iter14.add(12); Iter14.add(13); Iter14.add(14); Iter14.add(15);
        indexRightList.add(Iter14);
        List<Integer> Iter15 = new ArrayList<>();
        Iter15.add(8); Iter15.add(9); Iter15.add(10); Iter15.add(11); Iter15.add(12); Iter15.add(13); Iter15.add(14); Iter15.add(15);
        indexRightList.add(Iter15);
        List<Integer> Iter16 = new ArrayList<>();
        Iter16.add(17);
        indexRightList.add(Iter16);
        List<Integer> Iter17 = new ArrayList<>();
        Iter17.add(19);
        indexRightList.add(Iter17);
        List<Integer> Iter18 = new ArrayList<>();
        Iter18.add(18); Iter18.add(19);
        indexRightList.add(Iter18);
        List<Integer> Iter19 = new ArrayList<>();
        Iter19.add(21);
        indexRightList.add(Iter19);
        List<Integer> Iter20 = new ArrayList<>();
        Iter20.add(23);
        indexRightList.add(Iter20);
        List<Integer> Iter21 = new ArrayList<>();
        Iter21.add(22); Iter21.add(23);
        indexRightList.add(Iter21);
        List<Integer> Iter22 = new ArrayList<>();
        Iter22.add(20); Iter22.add(21); Iter22.add(22); Iter22.add(23);
        indexRightList.add(Iter22);
        List<Integer> Iter23 = new ArrayList<>();
        Iter23.add(16); Iter23.add(17); Iter23.add(18); Iter23.add(19); Iter23.add(20); Iter23.add(21); Iter23.add(22); Iter23.add(23);
        indexRightList.add(Iter23);

        loopCounts = new ArrayList<>();
        loopCounts.add(2); loopCounts.add(2); loopCounts.add(4); loopCounts.add(2); loopCounts.add(2); loopCounts.add(4);
        loopCounts.add(8); loopCounts.add(2); loopCounts.add(2); loopCounts.add(4); loopCounts.add(2); loopCounts.add(2);
        loopCounts.add(4); loopCounts.add(8); loopCounts.add(16); loopCounts.add(2); loopCounts.add(2); loopCounts.add(4);
        loopCounts.add(2); loopCounts.add(2); loopCounts.add(4); loopCounts.add(8); loopCounts.add(24);
    }

}
