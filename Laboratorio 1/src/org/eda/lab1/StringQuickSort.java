package org.eda.lab1;

public class StringQuickSort {

    private String[] array;
    private int length;
    private static StringQuickSort miStringQuickSort=null;

    private StringQuickSort()
    {

    }

    public static StringQuickSort getStringQuickSort()
    {
        if(miStringQuickSort==null)
        {
            miStringQuickSort=new StringQuickSort();
        }
        return miStringQuickSort;
    }

    public String [] sort(String[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        this.array = array;
        this.length = array.length;
        quickSort(0, length - 1);
        return this.array;
    }

    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (this.array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    void exchangeNames(int i, int j) {
        String temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }
}