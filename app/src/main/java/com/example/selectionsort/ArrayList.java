package com.example.selectionsort;

import java.util.Collections;
import java.util.List;

public class ArrayList {
    private int size;
    private List<String> array;

    public ArrayList(int size, List<String> array){
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

    public List<String> stepSelectionSort(List<String> array, int size, int step){
        int smallest = Integer.parseInt(array.get(step));
        int smallestIndex = step;
        for(int i=step+1; i<size; i++){
            if(Integer.parseInt(array.get(i)) < smallest){
                smallest = Integer.parseInt(array.get(i));
                smallestIndex = i;
            }
        }
        int temp = Integer.parseInt(array.get(0));
        array.set(0, String.valueOf(smallest));
        array.set(smallestIndex, String.valueOf(temp));
        return array;
    }

    public List<List<String>> SelectionSort(List<String> array, int size){
        List<List<String>> arrays = Collections.singletonList(array);
        int step = 0;
        while(arrays.get(step) != stepSelectionSort(array, size, step)){
            array = stepSelectionSort(array, size, step);
            step += 1;
            arrays.add(array);
        }
        return arrays;
    }

}
