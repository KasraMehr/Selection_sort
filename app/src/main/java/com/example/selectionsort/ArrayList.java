package com.example.selectionsort;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ArrayList {
    private int size;
    private List<Integer> array;

    public ArrayList(int size, List<Integer> array)
    {
        this.size = size;
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> getArray() {
        return array;
    }

    private List<Integer> stepSelectionSort(List<Integer> array, int size, int step)
    {
        int smallest = array.get(step);
        int smallestIndex = step;
        for(int i=step+1; i<size; i++){
            if(array.get(i) < smallest){
                smallest = array.get(i);
                smallestIndex = i;
            }
        }
        int temp = array.get(step);
        array.set(step, smallest);
        array.set(smallestIndex, temp);
        return array;
    }

    public List<List<Integer>> SelectionSort(List<Integer> array, int size)
    {
        List<List<Integer>> arrays = Collections.singletonList(array);
        List<Integer> sortedList = array;
        Collections.sort(sortedList);
        int step = 0;
        while(array != sortedList){
            array = stepSelectionSort(array, size, step);
            step += 1;
            arrays.add(array);
        }
        return arrays;
    }

//    public List<Integer> createRandomNumbers(int size)
//    {
//        Random rand = new Random();
//        List<Integer> array = Collections.singletonList(String.valueOf(rand.nextInt(1000)));
//        for(int i = 1; i <= size+1; i++){
//            assert false;
//            array.add(String.valueOf(rand.nextInt(1000)));
//        }
//        return array;
//    }

}
