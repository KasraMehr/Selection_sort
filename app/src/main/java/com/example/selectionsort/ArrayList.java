package com.example.selectionsort;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ArrayList {
    private int size;
    private List<String> array;

    public ArrayList(int size, List<String> array)
    {
        this.size = size;
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArray(List<String> array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public List<String> getArray() {
        return array;
    }

    private List<String> stepSelectionSort(List<String> array, int size, int step)
    {
        int smallest = Integer.parseInt(array.get(step));
        int smallestIndex = step;
        for(int i=step+1; i<size; i++){
            if(Integer.parseInt(array.get(i)) < smallest){
                smallest = Integer.parseInt(array.get(i));
                smallestIndex = i;
            }
        }
        int temp = Integer.parseInt(array.get(step));
        array.set(step, String.valueOf(smallest));
        array.set(smallestIndex, String.valueOf(temp));
        return array;
    }

    public List<List<String>> SelectionSort(List<String> array, int size)
    {
        List<List<String>> arrays = Collections.singletonList(array);
        int step = 0;
        while(arrays.get(step) != stepSelectionSort(array, size, step)){
            stepSelectionSort(array, size, step);
            step += 1;
            arrays.add(array);
        }
        return arrays;
    }

    public List<String> createRandomNumbers(int size)
    {
        Random rand = new Random();
        if(size < 1){
            return Collections.singletonList("Error");
        }
        List<String> array = Collections.singletonList(String.valueOf(rand.nextInt(1000)));
        for(int i = 1; i <= size+1; i++){
            assert false;
            array.add(String.valueOf(rand.nextInt(1000)));
        }
        return array;
    }

}
