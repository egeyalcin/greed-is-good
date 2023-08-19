package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int greedy = greedy(new int[]{2,5,5,5,5});
        System.out.println(greedy);
    }
    public static int greedy(int[] dice){
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        List<Integer> listThree = new ArrayList<>();
        List<Integer> listFour = new ArrayList<>();
        List<Integer> listFive = new ArrayList<>();
        List<Integer> listSix = new ArrayList<>();

        for(int diceNum : dice) {
            addToLists(diceNum, listOne, listTwo, listThree, listFour, listFive, listSix);
        }
        int one = calculateTheTotalPoints(listOne);
        int two = calculateTheTotalPoints(listTwo);
        int three = calculateTheTotalPoints(listThree);
        int four = calculateTheTotalPoints(listFour);
        int five = calculateTheTotalPoints(listFive);
        int six = calculateTheTotalPoints(listSix);

        return one + two + three + four + five + six;
    }

    static void addToLists(int diceNum,List<Integer> listOne, List<Integer> listTwo, List<Integer> listThree, List<Integer> listFour, List<Integer> listFive, List<Integer> listSix) {
        switch(diceNum) {
            case 1:
                listOne.add(diceNum);
                break;
            case 2:
                listTwo.add(diceNum);
                break;
            case 3:
                listThree.add(diceNum);
                break;
            case 4:
                listFour.add(diceNum);
                break;
            case 5:
                listFive.add(diceNum);
                break;
            case 6:
                listSix.add(diceNum);
                break;
        }
    }

    static int calculateTheTotalPoints(List<Integer> list) {
        int sum = 0;
        if(list.size() == 3) {
            int i = list.get(0);
            switch(i) {
                case 1:
                    sum+= 1000;
                    break;
                case 2:
                    sum+= 200;
                    break;
                case 3:
                    sum+= 300;
                    break;
                case 4:
                    sum+= 400;
                    break;
                case 5:
                    sum+= 500;
                    break;
                case 6:
                    sum+= 600;
                    break;
            }
            return sum;
        } else if (list.size() > 3) {
            int i = list.get(0);
            switch(i) {
                case 1:
                    sum+= 1000;
                    removeAddedObjects(list);
                    for(int j = 0; j < list.size();j++) {
                        sum+= 100;
                    }
                    break;
                case 2:
                    sum+= 200;
                    break;
                case 3:
                    sum+= 300;
                    break;
                case 4:
                    sum+= 400;
                    break;
                case 5:
                    sum+= 500;
                    removeAddedObjects(list);
                    for(int j = 0; j < list.size();j++) {
                        sum+= 50;
                    }
                    break;
                case 6:
                    sum+= 600;
                    break;
            }
            return sum;
        } else {
            if(list.size() > 0) {
                int i = list.get(0);
                switch(i) {
                    case 1:
                        sum+= 100 * list.size();
                        break;
                    case 5:
                        sum+= 50 * list.size();
                        break;
                }
                return sum;
            }
            return sum;
        }
    }

    static List<Integer> removeAddedObjects(List<Integer> list) {
        for(int j = 0; j < 3;j++) {
            list.remove(list.get(0));
        }
        return list;
    }
}
