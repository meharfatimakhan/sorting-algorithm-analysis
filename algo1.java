import java.util.*;

public class algoQ1 {

    void merge(int data[], int left, int middle, int right) {

        int size1 = middle - left + 1;
        int size2 = right - middle;

        int leftArr[] = new int[size1];
        int rightArr[] = new int[size2];

        for (int index = 0; index < size1; ++index) {
            leftArr[index] = data[left + index];
        }
        for (int jIndex = 0; jIndex < size2; ++jIndex) {
            rightArr[jIndex] = data[middle + 1 + jIndex];
        }

        int index = 0, jIndex = 0;

        int kIndex = left;
        while (index < size1 && jIndex < size2) {
            if (leftArr[index] <= rightArr[jIndex]) {
                data[kIndex] = leftArr[index];
                index++;
            } else {
                data[kIndex] = rightArr[jIndex];
                jIndex++;
            }
            kIndex++;
        }

        while (index < size1) {
            data[kIndex] = leftArr[index];
            index++;
            kIndex++;
        }

        while (jIndex < size2) {
            data[kIndex] = rightArr[jIndex];
            jIndex++;
            kIndex++;
        }
    }

    void mergeSort(int data[], int left, int right) {
        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(data, left, middle);
            mergeSort(data, middle + 1, right);
            merge(data, left, middle, right);
        }
    }

    void insertionSort(int data[]) {
        int size = data.length;
        for (int index = 1; index < size; ++index) {
            int key = data[index];
            int jIndex = index - 1;
            while (jIndex >= 0 && data[jIndex] > key) {
                data[jIndex + 1] = data[jIndex];
                jIndex = jIndex - 1;
            }
            data[jIndex + 1] = key;
        }
    }

    int partition(int data[], int low, int high) {
        int pivot = data[high];
        int index = (low - 1);
        for (int jIndex = low; jIndex < high; jIndex++) {

            if (data[jIndex] <= pivot) {
                index++;

                int temp = data[index];
                data[index] = data[jIndex];
                data[jIndex] = temp;
            }
        }

        int temp = data[index + 1];
        data[index + 1] = data[high];
        data[high] = temp;

        return index + 1;
    }

    void quickSort(int data[], int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            quickSort(data, low, pivot - 1);
            quickSort(data, pivot + 1, high);
        }
    }


    void swap(int data[], int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    static void printArray(int data[]) {
        int size = data.length;
        System.out.print("Sorted Array: ");
        for (int index = 0; index < size; ++index) {
            System.out.print(data[index] + " ");
        }

        System.out.println();
    }

    public void heapSort(int data[]) {
        int size = data.length;

        for (int index = size / 2 - 1; index >= 0; index--) {
            heapify(data, size, index);
        }

        for (int index = size - 1; index >= 0; index--) {
            int temp = data[0];
            data[0] = data[index];
            data[index] = temp;

            heapify(data, index, 0);
        }
    }

    void heapify(int data[], int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && data[left] > data[largest]) {
            largest = left;
        }

        if (right < size && data[right] > data[largest]) {
            largest = right;
        }

        if (largest != index) {
            int swap = data[index];
            data[index] = data[largest];
            data[largest] = swap;

            heapify(data, size, largest);
        }
    }

    void generateRandomArray(int data[], int size) {
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * 100);
        }
    }

    void copyArray(int dataA[], int dataB[], int size) {
        for (int i = 0; i < size; ++i) {
            dataB[i] = dataA[i];
        }
    }

    void sort(int data[], int start, int end) {
        mergeSort(data, start, end);
    }

    public void sort(int array[]) {
        quickSort2(array, 0, array.length - 1);
    }

    public  void quickSort2(int array[], int low, int high) {
        if (array == null || array.length == 0)
            return;

        if (low >= high)
            return;

        // Generating random numbers from 0 to the last element of the array
        Random f = new Random();
        int first = f.nextInt(high-low) + low;

        Random s = new Random();
        int second = s.nextInt(high-low) + low;

        Random t = new Random();
        int third = t.nextInt(high-low) + low;



        // Selecting the pivot
        int pivot = Math.max(Math.min(array[first], array[second]),
                Math.min(Math.max(array[first],array[second]), array[third]));

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;

            }
        }

        if (low < j)
            quickSort2(array, low, j);

        if (high > i)
            quickSort2(array, i, high);

    }


    public static void main(String args[]) {

        algoQ1 object = new algoQ1();

        int[] arraySize10 = new int[10];
        object.generateRandomArray(arraySize10, 10);

        int[] arraySize100 = new int[100];
        object.generateRandomArray(arraySize100, 100);

        int[] arraySize1000 = new int[1000];
        object.generateRandomArray(arraySize1000, 1000);

        int[] arraySize10000 = new int[10000];
        object.generateRandomArray(arraySize10000, 10000);

        int[] arraySize100000 = new int[100000];
        object.generateRandomArray(arraySize100000, 100000);

        int[] arraySize1000000 = new int[1000000];
        object.generateRandomArray(arraySize1000000, 1000000);

        //////sorted/////////////////
        int arraySize10Sorted[] = new int[arraySize10.length];
        object.copyArray(arraySize10, arraySize10Sorted, 10);
        object.sort(arraySize10Sorted, 0, arraySize10Sorted.length - 1);

        int arraySize100Sorted[] = new int[arraySize100.length];
        object.copyArray(arraySize100, arraySize100Sorted, 100);
        object.sort(arraySize100Sorted, 0, arraySize100Sorted.length - 1);

        int arraySize1000Sorted[] = new int[arraySize1000.length];
        object.copyArray(arraySize1000, arraySize1000Sorted, 1000);
        object.sort(arraySize1000Sorted, 0, arraySize1000Sorted.length - 1);

        int arraySize10000Sorted[] = new int[arraySize10000.length];
        object.copyArray(arraySize10000, arraySize10000Sorted, 10000);
        object.sort(arraySize10000Sorted, 0, arraySize10000Sorted.length - 1);

        int arraySize100000Sorted[] = new int[arraySize100000.length];
        object.copyArray(arraySize100000, arraySize100000Sorted, 100000);
        object.sort(arraySize100000Sorted, 0, arraySize100000Sorted.length - 1);

        int arraySize1000000Sorted[] = new int[arraySize1000000.length];
        object.copyArray(arraySize1000000, arraySize1000000Sorted, 1000000);
        object.sort(arraySize1000000Sorted, 0, arraySize1000000Sorted.length - 1);

////almost sorted
        int arraySize10SortedAlmost[] = new int[arraySize10.length];
        object.copyArray(arraySize10, arraySize10SortedAlmost, 10);
        object.sort(arraySize10SortedAlmost, 0, arraySize10Sorted.length - 2);

        int arraySize100SortedAlmost[] = new int[arraySize100.length];
        object.copyArray(arraySize100, arraySize100SortedAlmost, 100);
        object.sort(arraySize100SortedAlmost, 0, arraySize100Sorted.length - 11);

        int arraySize1000SortedAlmost[] = new int[arraySize1000.length];
        object.copyArray(arraySize1000, arraySize1000SortedAlmost, 1000);
        object.sort(arraySize1000SortedAlmost, 0, arraySize1000Sorted.length - 101);

        int arraySize10000SortedAlmost[] = new int[arraySize10000.length];
        object.copyArray(arraySize10000, arraySize10000SortedAlmost, 10000);
        object.sort(arraySize10000SortedAlmost, 0, arraySize10000Sorted.length - 1001);

        int arraySize100000SortedAlmost[] = new int[arraySize100000.length];
        object.copyArray(arraySize100000, arraySize100000SortedAlmost, 100000);
        object.sort(arraySize100000SortedAlmost, 0, arraySize100000Sorted.length - 10001);

        int arraySize1000000SortedAlmost[] = new int[arraySize1000000.length];
        object.copyArray(arraySize1000000, arraySize1000000SortedAlmost, 1000000);
        object.sort(arraySize1000000SortedAlmost, 0, arraySize1000000Sorted.length - 100001);

        ///reversed/////////////
        int arraySize10SortedRev[] = new int[arraySize10.length];
        object.copyArray(arraySize10, arraySize10SortedRev, 10);
        object.sort(arraySize10SortedRev, arraySize10SortedRev.length - 1, 0);

        int arraySize100SortedRev[] = new int[arraySize100.length];
        object.copyArray(arraySize100, arraySize100SortedRev, 100);
        object.sort(arraySize100SortedRev, arraySize100SortedRev.length - 1, 0);

        int arraySize1000SortedRev[] = new int[arraySize1000.length];
        object.copyArray(arraySize1000, arraySize1000SortedRev, 1000);
        object.sort(arraySize1000Sorted, arraySize1000SortedRev.length - 1, 0);

        int arraySize10000SortedRev[] = new int[arraySize10000.length];
        object.copyArray(arraySize10000, arraySize10000SortedRev, 10000);
        object.sort(arraySize10000SortedRev, arraySize10000SortedRev.length - 1, 0);

        int arraySize100000SortedRev[] = new int[arraySize100000.length];
        object.copyArray(arraySize100000, arraySize100000SortedRev, 100000);
        object.sort(arraySize100000SortedRev, arraySize100000SortedRev.length - 1, 0);

        int arraySize1000000SortedRev[] = new int[arraySize1000000.length];
        object.copyArray(arraySize1000000, arraySize1000000SortedRev, 1000000);
        object.sort(arraySize1000000SortedRev, arraySize1000000SortedRev.length - 1, 0);

        ///INSERTION SORT for SORTED
        System.out.println("INSERTION SORTED--------------------------------");
        long timeInsertionSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10Sorted);
            long endTime = System.nanoTime();

            timeInsertionSort10 = (endTime - startTime) + timeInsertionSort10;
        }
        long avgIS10 = timeInsertionSort10 / 5;
        System.out.println(avgIS10);

        long timeInsertionSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100Sorted);
            long endTime = System.nanoTime();
            timeInsertionSort100 = (endTime - startTime) + timeInsertionSort100;
        }
        long avgIS100 = timeInsertionSort100 / 5;
        System.out.println(avgIS100);

        long timeInsertionSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000Sorted);
            long endTime = System.nanoTime();
            timeInsertionSort1000 = (endTime - startTime) + timeInsertionSort1000;
        }
        long avgIS1000 = timeInsertionSort1000 / 5;
        System.out.println(avgIS1000);

        long timeInsertionSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10000Sorted);
            long endTime = System.nanoTime();
            timeInsertionSort10000 = (endTime - startTime) + timeInsertionSort10000;
        }
        long avgIS10000 = timeInsertionSort10000 / 5;
        System.out.println(avgIS10000);

        long timeInsertionSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100000Sorted);
            long endTime = System.nanoTime();
            timeInsertionSort100000 = (endTime - startTime) + timeInsertionSort100000;
        }
        long avgIS100000 = timeInsertionSort100000 / 5;
        System.out.println(avgIS10000);

        long timeInsertionSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000000Sorted);
            long endTime = System.nanoTime();
            timeInsertionSort1000000 = (endTime - startTime) + timeInsertionSort1000000;
        }
        long avgIS1000000 = timeInsertionSort1000000 / 5;
        System.out.println(avgIS1000000);

        ////mergeSort for SORTED
        System.out.println("MERGE SORTED----------------------------------");
        long timeMergeSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10Sorted, 0, arraySize10Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10 = (endTime - startTime) + timeMergeSort10;
        }
        long avgMS10 = timeMergeSort10 / 5;
        System.out.println(avgMS10);

        long timeMergeSort100 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100Sorted, 0, arraySize100Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100 = (endTime - startTime) + timeMergeSort100;
        }
        long avgMS100 = timeMergeSort100 / 5;
        System.out.println(avgMS100);

        long timeMergeSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000Sorted, 0, arraySize1000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
        }
        long avgMS1000 = timeMergeSort1000 / 5;
        System.out.println(avgMS1000);

        long timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10000Sorted, 0, arraySize10000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        long avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);

        long timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100000Sorted, 0, arraySize100000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        long avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);

        long timeMergeSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000000Sorted, 0, arraySize1000000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000000 = (endTime - startTime) + timeMergeSort1000000;
        }
        long avgMS1000000 = timeMergeSort1000000 / 5;
        System.out.println(avgMS1000000);

        ////quickSort for SORTED
        System.out.println("QUICK SORTED----------------------------------");
        long timeQuickSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10Sorted, 0, arraySize10Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10 = (endTime - startTime) + timeQuickSort10;
        }
        long avgQS10 = timeQuickSort10 / 5;
        System.out.println(avgQS10);

        long timeQuickSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize100Sorted, 0, arraySize100Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort100 = (endTime - startTime) + timeQuickSort100;
        }
        long avgQS100 = timeQuickSort100 / 5;
        System.out.println(avgQS100);

        long timeQuickSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize1000Sorted, 0, arraySize1000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort1000 = (endTime - startTime) + timeQuickSort1000;
        }
        long avgQS1000 = timeQuickSort1000 / 5;
        System.out.println(avgQS1000);

        long timeQuickSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10000Sorted, 0, arraySize10000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10000 = (endTime - startTime) + timeQuickSort10000;
        }
        long avgQS10000 = timeQuickSort10000 / 5;
        System.out.println(avgQS10000);

//        long timeQuickSort100000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize100000Sorted, 0, arraySize100000Sorted.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort100000;
//        }
//        long avgQS100000 = timeQuickSort100000 / 5;
//        System.out.println(avgQS100000);
//
//        long timeQuickSort1000000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize1000000Sorted, 0, arraySize1000000Sorted.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort1000000;
//        }
//        long avgQS1000000 = timeQuickSort1000000 / 5;
//        System.out.println(avgQS1000000);
        System.out.println("HEAP SORTED----------------------------------");
        long timeHeapSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10Sorted);
            long endTime = System.nanoTime();

            timeHeapSort10 = (endTime - startTime) + timeHeapSort10;
        }
        long avgHS10 = timeHeapSort10 / 5;
        System.out.println(avgHS10);

        long timeHeapSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100Sorted);
            long endTime = System.nanoTime();

            timeHeapSort100 = (endTime - startTime) + timeHeapSort100;
        }
        long avgHS100 = timeHeapSort100 / 5;
        System.out.println(avgHS100);

        long timeHeapSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000Sorted);
            long endTime = System.nanoTime();

            timeHeapSort1000 = (endTime - startTime) + timeHeapSort1000;
        }
        long avgHS1000 = timeHeapSort1000 / 5;
        System.out.println(avgHS1000);

        long timeHeapSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10000Sorted);
            long endTime = System.nanoTime();

            timeHeapSort10000 = (endTime - startTime) + timeHeapSort10000;
        }
        long avgHS10000 = timeHeapSort10000 / 5;
        System.out.println(avgHS10000);

        long timeHeapSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100000Sorted);
            long endTime = System.nanoTime();

            timeHeapSort100000 = (endTime - startTime) + timeHeapSort100000;
        }
        long avgHS100000 = timeHeapSort100000 / 5;
        System.out.println(avgHS100000);

        long timeHeapSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000000Sorted);
            long endTime = System.nanoTime();

            timeHeapSort1000000 = (endTime - startTime) + timeHeapSort1000000;
        }
        long avgHS1000000 = timeHeapSort1000000 / 5;
        System.out.println(avgHS1000000);

        ////quickSort2 SORTED////////////////////
        System.out.println("QUICKSORT 2 SORTED----------------------------------");
        long timeQuickSort210 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10Sorted, 0, arraySize10Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210 = (endTime - startTime) + timeQuickSort210;
        }
        long avgQS210 = timeQuickSort210 / 5;
        System.out.println(avgQS210);

        long timeQuickSort2100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100Sorted, 0, arraySize100Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100 = (endTime - startTime) + timeQuickSort2100;
        }
        long avgQS2100 = timeQuickSort2100 / 5;
        System.out.println(avgQS2100);

        long timeQuickSort21000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000Sorted, 0, arraySize1000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000 = (endTime - startTime) + timeQuickSort21000;
        }
        long avgQS21000 = timeQuickSort21000 / 5;
        System.out.println(avgQS21000);

        long timeQuickSort210000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10000Sorted, 0, arraySize10000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210000 = (endTime - startTime) + timeQuickSort210000;
        }
        long avgQS210000 = timeQuickSort210000 / 5;
        System.out.println(avgQS210000);

        long timeQuickSort2100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100000Sorted, 0, arraySize100000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100000 = (endTime - startTime) + timeQuickSort2100000;
        }
        long avgQS2100000 = timeQuickSort2100000 / 5;
        System.out.println(avgQS2100000);

        long timeQuickSort21000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000000Sorted, 0, arraySize1000000Sorted.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000000 = (endTime - startTime) + timeQuickSort21000000;
        }
        long avgQS21000000 = timeQuickSort21000000 / 5;
        System.out.println(avgQS21000000);
        System.out.println("----------------------------------------------------");
////MergeSort Random Data
        System.out.println("MERGE RANDOM----------------------------------");
        timeMergeSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10, 0, arraySize10.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10 = (endTime - startTime) + timeMergeSort10;
        }
        avgMS10 = timeMergeSort10 / 5;
        System.out.println(avgMS10);

        timeMergeSort100 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100, 0, arraySize100.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100 = (endTime - startTime) + timeMergeSort100;
        }
        avgMS100 = timeMergeSort100 / 5;
        System.out.println(avgMS100);

        timeMergeSort1000 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000, 0, arraySize1000.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
        }
        avgMS1000 = timeMergeSort1000 / 5;
        System.out.println(avgMS1000);

        timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10000, 0, arraySize10000.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);

        timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100000, 0, arraySize100000.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);

        timeMergeSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000000, 0, arraySize1000000.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort1000000 = (endTime - startTime) + timeMergeSort1000000;
        }
        avgMS1000000 = timeMergeSort1000000 / 5;
        System.out.println(avgMS1000000);

        System.out.println("INSERTION RANDOM----------------------------------");

        object.generateRandomArray(arraySize10, 10);
        object.generateRandomArray(arraySize100, 100);
        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize100000, 100000);
        object.generateRandomArray(arraySize1000000, 1000000);

        timeInsertionSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10);
            long endTime = System.nanoTime();

            timeInsertionSort10 = (endTime - startTime) + timeInsertionSort10;
        }
        avgIS10 = timeInsertionSort10 / 5;
        System.out.println(avgIS10);

        timeInsertionSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100);
            long endTime = System.nanoTime();

            timeInsertionSort100 = (endTime - startTime) + timeInsertionSort100;
        }
        avgIS100 = timeInsertionSort100 / 5;
        System.out.println(avgIS100);

        timeInsertionSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000);
            long endTime = System.nanoTime();

            timeInsertionSort1000 = (endTime - startTime) + timeInsertionSort1000;
        }
        avgIS1000 = timeInsertionSort1000 / 5;
        System.out.println(avgIS1000);

        timeInsertionSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10000);
            long endTime = System.nanoTime();

            timeInsertionSort10000 = (endTime - startTime) + timeInsertionSort10000;
        }
        avgIS10000 = timeInsertionSort10000 / 5;
        System.out.println(avgIS10000);

        timeInsertionSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100000);
            long endTime = System.nanoTime();

            timeInsertionSort100000 = (endTime - startTime) + timeInsertionSort100000;
        }
        avgIS100000 = timeInsertionSort100000 / 5;
        System.out.println(avgIS100000);

        timeInsertionSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000000);
            long endTime = System.nanoTime();

            timeInsertionSort1000000 = (endTime - startTime) + timeInsertionSort1000000;
        }
        avgIS1000000 = timeInsertionSort1000000 / 5;
        System.out.println(avgIS1000000);

        System.out.println("HEAP RANDOM----------------------------------");
        object.generateRandomArray(arraySize10, 10);
        object.generateRandomArray(arraySize100, 100);
        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize100000, 100000);
        object.generateRandomArray(arraySize1000000, 1000000);

        timeHeapSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10);
            long endTime = System.nanoTime();

            timeHeapSort10 = (endTime - startTime) + timeHeapSort10;
        }
        avgHS10 = timeHeapSort10 / 5;
        System.out.println(avgHS10);

        timeHeapSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100);
            long endTime = System.nanoTime();

            timeHeapSort100 = (endTime - startTime) + timeHeapSort100;
        }
        avgHS100 = timeHeapSort100 / 5;
        System.out.println(avgHS100);

        timeHeapSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000);
            long endTime = System.nanoTime();

            timeHeapSort1000 = (endTime - startTime) + timeHeapSort1000;
        }
        avgHS1000 = timeHeapSort1000 / 5;
        System.out.println(avgHS1000);

        timeHeapSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10000);
            long endTime = System.nanoTime();

            timeHeapSort10000 = (endTime - startTime) + timeHeapSort10000;
        }
        avgHS10000 = timeHeapSort10000 / 5;
        System.out.println(avgHS10000);

        timeHeapSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100000);
            long endTime = System.nanoTime();

            timeHeapSort100000 = (endTime - startTime) + timeHeapSort100000;
        }
        avgHS100000 = timeHeapSort100000 / 5;
        System.out.println(avgHS100000);

        timeHeapSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000000);
            long endTime = System.nanoTime();

            timeHeapSort1000000 = (endTime - startTime) + timeHeapSort1000000;
        }
        avgHS1000000 = timeHeapSort1000000 / 5;
        System.out.println(avgHS1000000);

        System.out.println("QUICKSORT RANDOM----------------------------------");
        object.generateRandomArray(arraySize10, 10);
        object.generateRandomArray(arraySize100, 100);
        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize100000, 100000);
        object.generateRandomArray(arraySize1000000, 1000000);

        timeQuickSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10, 0, arraySize10.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10 = (endTime - startTime) + timeQuickSort10;
        }
        avgQS10 = timeQuickSort10 / 5;
        System.out.println(avgQS10);

        timeQuickSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize100, 0, arraySize100.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort100 = (endTime - startTime) + timeQuickSort100;
        }
        avgQS100 = timeQuickSort100 / 5;
        System.out.println(avgQS100);

        timeQuickSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize1000, 0, arraySize1000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort1000 = (endTime - startTime) + timeQuickSort1000;
        }
        avgQS1000 = timeQuickSort1000 / 5;
        System.out.println(avgQS1000);

        timeQuickSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10000, 0, arraySize10000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10000 = (endTime - startTime) + timeQuickSort10000;
        }
        avgQS10000 = timeQuickSort10000 / 5;
        System.out.println(avgQS10000);

//        timeQuickSort100000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize100000, 0, arraySize100000.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort100000;
//        }
//        avgQS100000 = timeQuickSort100000 / 5;
//        System.out.println(avgQS100000);
//
//       timeQuickSort1000000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize1000000, 0, arraySize1000000.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort1000000;
//        }
//        avgQS1000000 = timeQuickSort1000000 / 5;
//        System.out.println(avgQS1000000);
        System.out.println("QUICKSORT2 RANDOM----------------------------------");
        object.generateRandomArray(arraySize10, 10);
        object.generateRandomArray(arraySize100, 100);
        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize100000, 100000);
        object.generateRandomArray(arraySize1000000, 1000000);
        timeQuickSort210 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10, 0, arraySize10.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210 = (endTime - startTime) + timeQuickSort210;
        }
        avgQS210 = timeQuickSort210 / 5;
        System.out.println(avgQS210);

        timeQuickSort2100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100, 0, arraySize100.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100 = (endTime - startTime) + timeQuickSort2100;
        }
        avgQS2100 = timeQuickSort2100 / 5;
        System.out.println(avgQS2100);

        timeQuickSort21000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000, 0, arraySize1000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000 = (endTime - startTime) + timeQuickSort21000;
        }
        avgQS21000 = timeQuickSort21000 / 5;
        System.out.println(avgQS21000);

        timeQuickSort210000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10000, 0, arraySize10000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210000 = (endTime - startTime) + timeQuickSort210000;
        }
        avgQS210000 = timeQuickSort210000 / 5;
        System.out.println(avgQS210000);

        timeQuickSort2100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100000, 0, arraySize100000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100000 = (endTime - startTime) + timeQuickSort2100000;
        }
        avgQS2100000 = timeQuickSort2100000 / 5;
        System.out.println(avgQS2100000);

        timeQuickSort21000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000000, 0, arraySize1000000.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000000 = (endTime - startTime) + timeQuickSort21000000;
        }
        avgQS21000000 = timeQuickSort21000000 / 5;
        System.out.println(avgQS21000000);
        System.out.println("----------------------------------------------------");
////MergeSort Data
        object.generateRandomArray(arraySize10, 10);
        object.generateRandomArray(arraySize100, 100);
        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize100000, 100000);
        object.generateRandomArray(arraySize1000000, 1000000);
        System.out.println("MERGE ALMOST SORT-----------------------------");

        timeMergeSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10SortedAlmost, 0, arraySize10SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10 = (endTime - startTime) + timeMergeSort10;
        }
        avgMS10 = timeMergeSort10 / 5;
        System.out.println(avgMS10);

        timeMergeSort100 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100SortedAlmost, 0, arraySize100SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100 = (endTime - startTime) + timeMergeSort100;
        }
        avgMS100 = timeMergeSort100 / 5;
        System.out.println(avgMS100);

        timeMergeSort1000 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000SortedAlmost, 0, arraySize1000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
        }
        avgMS1000 = timeMergeSort1000 / 5;
        System.out.println(avgMS1000);

        timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10000SortedAlmost, 0, arraySize10000SortedAlmost.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);

        timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100000SortedAlmost, 0, arraySize100000SortedAlmost.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);

        timeMergeSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000000SortedAlmost, 0, arraySize1000000SortedAlmost.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort1000000 = (endTime - startTime) + timeMergeSort1000000;
        }
        avgMS1000000 = timeMergeSort1000000 / 5;
        System.out.println(avgMS1000000);

        System.out.println("INSERTION ALMOST SORT-----------------------------");

        object.copyArray(arraySize10, arraySize10SortedAlmost, 10);
        object.sort(arraySize10SortedAlmost, 0, arraySize10Sorted.length - 2);

        object.copyArray(arraySize100, arraySize100SortedAlmost, 100);
        object.sort(arraySize100SortedAlmost, 0, arraySize100Sorted.length - 11);

        object.copyArray(arraySize1000, arraySize1000SortedAlmost, 1000);
        object.sort(arraySize1000SortedAlmost, 0, arraySize1000Sorted.length - 101);

        object.copyArray(arraySize10000, arraySize10000SortedAlmost, 10000);
        object.sort(arraySize10000SortedAlmost, 0, arraySize10000Sorted.length - 1001);

        object.copyArray(arraySize100000, arraySize100000SortedAlmost, 100000);
        object.sort(arraySize100000SortedAlmost, 0, arraySize100000Sorted.length - 10001);

        object.copyArray(arraySize1000000, arraySize1000000SortedAlmost, 1000000);
        object.sort(arraySize1000000SortedAlmost, 0, arraySize1000000Sorted.length - 100001);

        timeInsertionSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort10 = (endTime - startTime) + timeInsertionSort10;
        }
        avgIS10 = timeInsertionSort10 / 5;
        System.out.println(avgIS10);

        timeInsertionSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort100 = (endTime - startTime) + timeInsertionSort100;
        }
        avgIS100 = timeInsertionSort100 / 5;
        System.out.println(avgIS100);

        timeInsertionSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort1000 = (endTime - startTime) + timeInsertionSort1000;
        }
        avgIS1000 = timeInsertionSort1000 / 5;
        System.out.println(avgIS1000);

        timeInsertionSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10000SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort10000 = (endTime - startTime) + timeInsertionSort10000;
        }
        avgIS10000 = timeInsertionSort10000 / 5;
        System.out.println(avgIS10000);

        timeInsertionSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100000SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort100000 = (endTime - startTime) + timeInsertionSort100000;
        }
        avgIS100000 = timeInsertionSort100000 / 5;
        System.out.println(avgIS100000);

        timeInsertionSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000000SortedAlmost);
            long endTime = System.nanoTime();

            timeInsertionSort1000000 = (endTime - startTime) + timeInsertionSort1000000;
        }
        avgIS1000000 = timeInsertionSort1000000 / 5;
        System.out.println(avgIS1000000);

        System.out.println("HEAP ALMOST SORT-----------------------------");
        object.copyArray(arraySize10, arraySize10SortedAlmost, 10);
        object.sort(arraySize10SortedAlmost, 0, arraySize10Sorted.length - 2);

        object.copyArray(arraySize100, arraySize100SortedAlmost, 100);
        object.sort(arraySize100SortedAlmost, 0, arraySize100Sorted.length - 11);

        object.copyArray(arraySize1000, arraySize1000SortedAlmost, 1000);
        object.sort(arraySize1000SortedAlmost, 0, arraySize1000Sorted.length - 101);

        object.copyArray(arraySize10000, arraySize10000SortedAlmost, 10000);
        object.sort(arraySize10000SortedAlmost, 0, arraySize10000Sorted.length - 1001);

        object.copyArray(arraySize100000, arraySize100000SortedAlmost, 100000);
        object.sort(arraySize100000SortedAlmost, 0, arraySize100000Sorted.length - 10001);

        object.copyArray(arraySize1000000, arraySize1000000SortedAlmost, 1000000);
        object.sort(arraySize1000000SortedAlmost, 0, arraySize1000000Sorted.length - 100001);

        timeHeapSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort10 = (endTime - startTime) + timeHeapSort10;
        }
        avgHS10 = timeHeapSort10 / 5;
        System.out.println(avgHS10);

        timeHeapSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort100 = (endTime - startTime) + timeHeapSort100;
        }
        avgHS100 = timeHeapSort100 / 5;
        System.out.println(avgHS100);

        timeHeapSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort1000 = (endTime - startTime) + timeHeapSort1000;
        }
        avgHS1000 = timeHeapSort1000 / 5;
        System.out.println(avgHS1000);

        timeHeapSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10000SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort10000 = (endTime - startTime) + timeHeapSort10000;
        }
        avgHS10000 = timeHeapSort10000 / 5;
        System.out.println(avgHS10000);

        timeHeapSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100000SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort100000 = (endTime - startTime) + timeHeapSort100000;
        }
        avgHS100000 = timeHeapSort100000 / 5;
        System.out.println(avgHS100000);

        timeHeapSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000000SortedAlmost);
            long endTime = System.nanoTime();

            timeHeapSort1000000 = (endTime - startTime) + timeHeapSort1000000;
        }
        avgHS1000000 = timeHeapSort1000000 / 5;
        System.out.println(avgHS1000000);

        System.out.println("QUICKSORT ALMOST SORT-----------------------------");
        object.copyArray(arraySize10, arraySize10SortedAlmost, 10);
        object.sort(arraySize10SortedAlmost, 0, arraySize10Sorted.length - 2);

        object.copyArray(arraySize100, arraySize100SortedAlmost, 100);
        object.sort(arraySize100SortedAlmost, 0, arraySize100Sorted.length - 11);

        object.copyArray(arraySize1000, arraySize1000SortedAlmost, 1000);
        object.sort(arraySize1000SortedAlmost, 0, arraySize1000Sorted.length - 101);

        object.copyArray(arraySize10000, arraySize10000SortedAlmost, 10000);
        object.sort(arraySize10000SortedAlmost, 0, arraySize10000Sorted.length - 1001);

        object.copyArray(arraySize100000, arraySize100000SortedAlmost, 100000);
        object.sort(arraySize100000SortedAlmost, 0, arraySize100000Sorted.length - 10001);

        object.copyArray(arraySize1000000, arraySize1000000SortedAlmost, 1000000);
        object.sort(arraySize1000000SortedAlmost, 0, arraySize1000000Sorted.length - 100001);

        timeQuickSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10SortedAlmost, 0, arraySize10SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10 = (endTime - startTime) + timeQuickSort10;
        }
        avgQS10 = timeQuickSort10 / 5;
        System.out.println(avgQS10);

        timeQuickSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize100SortedAlmost, 0, arraySize100SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort100 = (endTime - startTime) + timeQuickSort100;
        }
        avgQS100 = timeQuickSort100 / 5;
        System.out.println(avgQS100);

        timeQuickSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize1000SortedAlmost, 0, arraySize1000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort1000 = (endTime - startTime) + timeQuickSort1000;
        }
        avgQS1000 = timeQuickSort1000 / 5;
        System.out.println(avgQS1000);

        timeQuickSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10000SortedAlmost, 0, arraySize10000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10000 = (endTime - startTime) + timeQuickSort10000;
        }
        avgQS10000 = timeQuickSort10000 / 5;
        System.out.println(avgQS10000);

//        timeQuickSort100000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize100000SortedAlmost, 0, arraySize100000SortedAlmost.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort100000;
//        }
//        avgQS100000 = timeQuickSort100000 / 5;
//        System.out.println(avgQS100000);
//
//       timeQuickSort1000000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize1000000SortedAlmost, 0, arraySize1000000SortedAlmost.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort1000000;
//        }
//        avgQS1000000 = timeQuickSort1000000 / 5;
//        System.out.println(avgQS1000000);
        System.out.println("QUICKSORT2 ALMOST SORT-----------------------------");
        object.copyArray(arraySize10, arraySize10SortedAlmost, 10);
        object.sort(arraySize10SortedAlmost, 0, arraySize10Sorted.length - 2);

        object.copyArray(arraySize100, arraySize100SortedAlmost, 100);
        object.sort(arraySize100SortedAlmost, 0, arraySize100Sorted.length - 11);

        object.copyArray(arraySize1000, arraySize1000SortedAlmost, 1000);
        object.sort(arraySize1000SortedAlmost, 0, arraySize1000Sorted.length - 101);

        object.copyArray(arraySize10000, arraySize10000SortedAlmost, 10000);
        object.sort(arraySize10000SortedAlmost, 0, arraySize10000Sorted.length - 1001);

        object.copyArray(arraySize100000, arraySize100000SortedAlmost, 100000);
        object.sort(arraySize100000SortedAlmost, 0, arraySize100000Sorted.length - 10001);

        object.copyArray(arraySize1000000, arraySize1000000SortedAlmost, 1000000);
        object.sort(arraySize1000000SortedAlmost, 0, arraySize1000000Sorted.length - 100001);

        timeQuickSort210 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10SortedAlmost, 0, arraySize10SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210 = (endTime - startTime) + timeQuickSort210;
        }
        avgQS210 = timeQuickSort210 / 5;
        System.out.println(avgQS210);

        timeQuickSort2100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100SortedAlmost, 0, arraySize100SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100 = (endTime - startTime) + timeQuickSort2100;
        }
        avgQS2100 = timeQuickSort2100 / 5;
        System.out.println(avgQS2100);

        timeQuickSort21000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000SortedAlmost, 0, arraySize1000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000 = (endTime - startTime) + timeQuickSort21000;
        }
        avgQS21000 = timeQuickSort21000 / 5;
        System.out.println(avgQS21000);

        timeQuickSort210000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10000SortedAlmost, 0, arraySize10000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210000 = (endTime - startTime) + timeQuickSort210000;
        }
        avgQS210000 = timeQuickSort210000 / 5;
        System.out.println(avgQS210000);

        timeQuickSort2100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100000SortedAlmost, 0, arraySize100000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100000 = (endTime - startTime) + timeQuickSort2100000;
        }
        avgQS2100000 = timeQuickSort2100000 / 5;
        System.out.println(avgQS2100000);

        timeQuickSort21000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000000SortedAlmost, 0, arraySize1000000SortedAlmost.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000000 = (endTime - startTime) + timeQuickSort21000000;
        }
        avgQS21000000 = timeQuickSort21000000 / 5;
        System.out.println(avgQS21000000);
        System.out.println("----------------------------------------------------");

        System.out.println("MERGE SORT REVERSE--------------------------------------------------------------------------");
        timeMergeSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10SortedRev, 0, arraySize10SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10 = (endTime - startTime) + timeMergeSort10;
        }
        avgMS10 = timeMergeSort10 / 5;
        System.out.println(avgMS10);

        timeMergeSort100 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100SortedRev, 0, arraySize100SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100 = (endTime - startTime) + timeMergeSort100;
        }
        avgMS100 = timeMergeSort100 / 5;
        System.out.println(avgMS100);

        timeMergeSort1000 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000SortedRev, 0, arraySize1000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
        }
        avgMS1000 = timeMergeSort1000 / 5;
        System.out.println(avgMS1000);

        timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10000SortedRev, 0, arraySize10000SortedRev.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);

        timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100000SortedRev, 0, arraySize100000SortedRev.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);

        timeMergeSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000000SortedRev, 0, arraySize1000000SortedRev.length - 1);
            long endTime = System.nanoTime();
            timeMergeSort1000000 = (endTime - startTime) + timeMergeSort1000000;
        }
        avgMS1000000 = timeMergeSort1000000 / 5;
        System.out.println(avgMS1000000);
        System.out.println("INSERTION SORT REVERSE--------------------------------------------------------------------------");
        object.copyArray(arraySize10, arraySize10SortedRev, 10);
        object.sort(arraySize10SortedRev, arraySize10SortedRev.length - 1, 0);

        object.copyArray(arraySize100, arraySize100SortedRev, 100);
        object.sort(arraySize100SortedRev, arraySize100SortedRev.length - 1, 0);

        object.copyArray(arraySize1000, arraySize1000SortedRev, 1000);
        object.sort(arraySize1000Sorted, arraySize1000SortedRev.length - 1, 0);

        object.copyArray(arraySize10000, arraySize10000SortedRev, 10000);
        object.sort(arraySize10000SortedRev, arraySize10000SortedRev.length - 1, 0);

        object.copyArray(arraySize100000, arraySize100000SortedRev, 100000);
        object.sort(arraySize100000SortedRev, arraySize100000SortedRev.length - 1, 0);

        object.copyArray(arraySize1000000, arraySize1000000SortedRev, 1000000);
        object.sort(arraySize1000000SortedRev, arraySize1000000SortedRev.length - 1, 0);


        timeInsertionSort10 = 0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort10 = (endTime - startTime) + timeInsertionSort10;
        }
        avgIS10 = timeInsertionSort10 / 5;
        System.out.println(avgIS10);

        timeInsertionSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort100 = (endTime - startTime) + timeInsertionSort100;
        }
        avgIS100 = timeInsertionSort100 / 5;
        System.out.println(avgIS100);

        timeInsertionSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort1000 = (endTime - startTime) + timeInsertionSort1000;
        }
        avgIS1000 = timeInsertionSort1000 / 5;
        System.out.println(avgIS1000);

        timeInsertionSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize10000SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort10000 = (endTime - startTime) + timeInsertionSort10000;
        }
        avgIS10000 = timeInsertionSort10000 / 5;
        System.out.println(avgIS10000);

        timeInsertionSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize100000SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort100000 = (endTime - startTime) + timeInsertionSort100000;
        }
        avgIS100000 = timeInsertionSort100000 / 5;
        System.out.println(avgIS100000);

        timeInsertionSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.insertionSort(arraySize1000000SortedRev);
            long endTime = System.nanoTime();

            timeInsertionSort1000000 = (endTime - startTime) + timeInsertionSort1000000;
        }
        avgIS1000000 = timeInsertionSort1000000 / 5;
        System.out.println(avgIS1000000);

        System.out.println("HEAP SORT REVERSE--------------------------------------------------------------------------");
        object.copyArray(arraySize10, arraySize10SortedRev, 10);
        object.sort(arraySize10SortedRev, arraySize10SortedRev.length - 1, 0);

        object.copyArray(arraySize100, arraySize100SortedRev, 100);
        object.sort(arraySize100SortedRev, arraySize100SortedRev.length - 1, 0);

        object.copyArray(arraySize1000, arraySize1000SortedRev, 1000);
        object.sort(arraySize1000Sorted, arraySize1000SortedRev.length - 1, 0);

        object.copyArray(arraySize10000, arraySize10000SortedRev, 10000);
        object.sort(arraySize10000SortedRev, arraySize10000SortedRev.length - 1, 0);

        object.copyArray(arraySize100000, arraySize100000SortedRev, 100000);
        object.sort(arraySize100000SortedRev, arraySize100000SortedRev.length - 1, 0);

        object.copyArray(arraySize1000000, arraySize1000000SortedRev, 1000000);
        object.sort(arraySize1000000SortedRev, arraySize1000000SortedRev.length - 1, 0);
        timeHeapSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort10 = (endTime - startTime) + timeHeapSort10;
        }
        avgHS10 = timeHeapSort10 / 5;
        System.out.println(avgHS10);

        timeHeapSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort100 = (endTime - startTime) + timeHeapSort100;
        }
        avgHS100 = timeHeapSort100 / 5;
        System.out.println(avgHS100);

        timeHeapSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort1000 = (endTime - startTime) + timeHeapSort1000;
        }
        avgHS1000 = timeHeapSort1000 / 5;
        System.out.println(avgHS1000);

        timeHeapSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize10000SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort10000 = (endTime - startTime) + timeHeapSort10000;
        }
        avgHS10000 = timeHeapSort10000 / 5;
        System.out.println(avgHS10000);

        timeHeapSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize100000SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort100000 = (endTime - startTime) + timeHeapSort100000;
        }
        avgHS100000 = timeHeapSort100000 / 5;
        System.out.println(avgHS100000);

        timeHeapSort1000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.heapSort(arraySize1000000SortedRev);
            long endTime = System.nanoTime();

            timeHeapSort1000000 = (endTime - startTime) + timeHeapSort1000000;
        }
        avgHS1000000 = timeHeapSort1000000 / 5;
        System.out.println(avgHS1000000);


        System.out.println("QUICKSORT SORT REVERSE--------------------------------------------------------------------------");
        object.copyArray(arraySize10, arraySize10SortedRev, 10);
        object.sort(arraySize10SortedRev, arraySize10SortedRev.length - 1, 0);

        object.copyArray(arraySize100, arraySize100SortedRev, 100);
        object.sort(arraySize100SortedRev, arraySize100SortedRev.length - 1, 0);

        object.copyArray(arraySize1000, arraySize1000SortedRev, 1000);
        object.sort(arraySize1000Sorted, arraySize1000SortedRev.length - 1, 0);

        object.copyArray(arraySize10000, arraySize10000SortedRev, 10000);
        object.sort(arraySize10000SortedRev, arraySize10000SortedRev.length - 1, 0);

        object.copyArray(arraySize100000, arraySize100000SortedRev, 100000);
        object.sort(arraySize100000SortedRev, arraySize100000SortedRev.length - 1, 0);

        object.copyArray(arraySize1000000, arraySize1000000SortedRev, 1000000);
        object.sort(arraySize1000000SortedRev, arraySize1000000SortedRev.length - 1, 0);

        timeQuickSort10 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10SortedRev, 0, arraySize10SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10 = (endTime - startTime) + timeQuickSort10;
        }
        avgQS10 = timeQuickSort10 / 5;
        System.out.println(avgQS10);

        timeQuickSort100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize100SortedRev, 0, arraySize100SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort100 = (endTime - startTime) + timeQuickSort100;
        }
        avgQS100 = timeQuickSort100 / 5;
        System.out.println(avgQS100);

        timeQuickSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize1000SortedRev, 0, arraySize1000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort1000 = (endTime - startTime) + timeQuickSort1000;
        }
        avgQS1000 = timeQuickSort1000 / 5;
        System.out.println(avgQS1000);

        timeQuickSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort(arraySize10000SortedRev, 0, arraySize10000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort10000 = (endTime - startTime) + timeQuickSort10000;
        }
        avgQS10000 = timeQuickSort10000 / 5;
        System.out.println(avgQS10000);

//        timeQuickSort100000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize100000SortedRev, 0, arraySize100000SortedRev.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort100000;
//        }
//        avgQS100000 = timeQuickSort100000 / 5;
//        System.out.println(avgQS100000);
//
//       timeQuickSort1000000 = 0;
//        for (int i = 0; i < 5; i++) {
//            long startTime = System.nanoTime();
//            object.quickSort(arraySize1000000SortedRev, 0, arraySize1000000SortedRev.length - 1);
//            long endTime = System.nanoTime();
//
//            timeQuickSort100000 = (endTime - startTime) + timeQuickSort1000000;
//        }
//        avgQS1000000 = timeQuickSort1000000 / 5;
//        System.out.println(avgQS1000000);

        System.out.println("QUICKSORT2 SORT REVERSE--------------------------------------------------------------------------");
        object.copyArray(arraySize10, arraySize10SortedRev, 10);
        object.sort(arraySize10SortedRev, arraySize10SortedRev.length - 1, 0);

        object.copyArray(arraySize100, arraySize100SortedRev, 100);
        object.sort(arraySize100SortedRev, arraySize100SortedRev.length - 1, 0);

        object.copyArray(arraySize1000, arraySize1000SortedRev, 1000);
        object.sort(arraySize1000Sorted, arraySize1000SortedRev.length - 1, 0);

        object.copyArray(arraySize10000, arraySize10000SortedRev, 10000);
        object.sort(arraySize10000SortedRev, arraySize10000SortedRev.length - 1, 0);

        object.copyArray(arraySize100000, arraySize100000SortedRev, 100000);
        object.sort(arraySize100000SortedRev, arraySize100000SortedRev.length - 1, 0);

        object.copyArray(arraySize1000000, arraySize1000000SortedRev, 1000000);
        object.sort(arraySize1000000SortedRev, arraySize1000000SortedRev.length - 1, 0);

        timeQuickSort210 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10SortedRev, 0, arraySize10SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210 = (endTime - startTime) + timeQuickSort210;
        }
        avgQS210 = timeQuickSort210 / 5;
        System.out.println(avgQS210);

        timeQuickSort2100 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100SortedRev, 0, arraySize100SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100 = (endTime - startTime) + timeQuickSort2100;
        }
        avgQS2100 = timeQuickSort2100 / 5;
        System.out.println(avgQS2100);

        timeQuickSort21000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000SortedRev, 0, arraySize1000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000 = (endTime - startTime) + timeQuickSort21000;
        }
        avgQS21000 = timeQuickSort21000 / 5;
        System.out.println(avgQS21000);

        timeQuickSort210000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize10000SortedRev, 0, arraySize10000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort210000 = (endTime - startTime) + timeQuickSort210000;
        }
        avgQS210000 = timeQuickSort210000 / 5;
        System.out.println(avgQS210000);

        timeQuickSort2100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize100000SortedRev, 0, arraySize100000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort2100000 = (endTime - startTime) + timeQuickSort2100000;
        }
        avgQS2100000 = timeQuickSort2100000 / 5;
        System.out.println(avgQS2100000);

        timeQuickSort21000000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.quickSort2(arraySize1000000SortedRev, 0, arraySize1000000SortedRev.length - 1);
            long endTime = System.nanoTime();

            timeQuickSort21000000 = (endTime - startTime) + timeQuickSort21000000;
        }
        avgQS21000000 = timeQuickSort21000000 / 5;
        System.out.println(avgQS21000000);
    }

}

