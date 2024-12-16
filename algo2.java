public class algoQ2 {
    static void printArray(int data[]) {
        int size = data.length;
        System.out.print("Sorted Array: ");
        for (int index = 0; index < size; ++index) {
            System.out.print(data[index] + " ");
        }

        System.out.println();
    }

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

    void generateRandomArray(int data[], int size) {
        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * 100);
        }
    }

//    void modifiedMergeSort(int data[], int left, int right) {
//        if (left < right) {
//
//            int middle = (left + right) / 2;
//
//            mergeSort(data, left, middle);
//            mergeSort(data, middle + 1, right);
//            insertionSort(data);
//        }
//
//    }

    void modifiedMergeSort(int data[],int left, int right,int k){
        if(left<right) {
            if (right - left <= k)
                insertionSort(data, left, right);
            else {
                int middle = (left + right) / 2;
                mergeSort(data, left, middle);
                mergeSort(data, middle, right);
                merge(data, left, middle, right);
            }
        }
    }

    void insertionSort(int data[],int left,int right) {
        int size = right+1;
        for (int index = left; index < size; index++) {
            int key = data[index];
            int jIndex = index - 1;
            while ((jIndex >= 0) && (data[jIndex] > key)) {
                data[jIndex + 1] = data[jIndex];
                jIndex = jIndex - 1;
            }
            data[jIndex + 1] = key;
        }
    }


    public static void main(String[] args) {
        algoQ2 object = new algoQ2();

        int[] arraySize1000 = new int[1000];
        object.generateRandomArray(arraySize1000, 1000);

        int[] arraySize10000 = new int[10000];
        object.generateRandomArray(arraySize10000, 10000);

        int[] arraySize50000 = new int[50000];
        object.generateRandomArray(arraySize50000, 50000);

        int[] arraySize100000 = new int[100000];
        object.generateRandomArray(arraySize100000, 100000);

        System.out.println("-----MERGE SORT---------");

        long timeMergeSort1000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize1000, 0, arraySize1000.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
        }
        long avgMS1000 = timeMergeSort1000 / 5;
        System.out.println(avgMS1000);
        //  printArray(arraySize1000);

        long timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize10000, 0, arraySize10000.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        long avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);

        long timeMergeSort50000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize50000, 0, arraySize50000.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort50000 = (endTime - startTime) + timeMergeSort50000;
        }
        long avgMS50000 = timeMergeSort50000 / 5;
        System.out.println(avgMS50000);

        long timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.mergeSort(arraySize100000, 0, arraySize100000.length - 1);
            long endTime = System.nanoTime();

            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        long avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);

        System.out.println("-----MODIFIED MERGE SORT---------");

        object.generateRandomArray(arraySize1000, 1000);
        object.generateRandomArray(arraySize10000, 10000);
        object.generateRandomArray(arraySize50000, 50000);
        object.generateRandomArray(arraySize100000, 100000);

//        int k=2;
//        timeMergeSort1000 = 0;
//        long avgMMS1000=0;
//        while (avgMS1000>avgMMS1000) {
//            for (int i = 0; i < 5; i++) {
//                long startTime = System.nanoTime();
//                object.modifiedMergeSort(arraySize1000, 1, arraySize1000.length - 1, k);
//                long endTime = System.nanoTime();
//
//                timeMergeSort1000 = (endTime - startTime) + timeMergeSort1000;
//            }
//            avgMMS1000 = timeMergeSort1000 / 5;
//            System.out.println(avgMMS1000);
//            k++;
//        }
//
//        System.out.print(k);

        int k=22;
        timeMergeSort10000 = 0;
        long avgMMS10000=0;

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.modifiedMergeSort(arraySize10000, 1, arraySize10000.length - 1, k);
            long endTime = System.nanoTime();

            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        avgMMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMMS10000);

//
//        System.out.print(k);

        k=22;
        timeMergeSort10000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.modifiedMergeSort(arraySize10000, 1, arraySize10000.length - 1,k);
            long endTime = System.nanoTime();

            timeMergeSort10000 = (endTime - startTime) + timeMergeSort10000;
        }
        avgMS10000 = timeMergeSort10000 / 5;
        System.out.println(avgMS10000);
        //printArray(arraySize10000);

        k=22;
        timeMergeSort50000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.modifiedMergeSort(arraySize50000, 1, arraySize50000.length - 1,k);
            long endTime = System.nanoTime();

            timeMergeSort50000 = (endTime - startTime) + timeMergeSort50000;
        }
        avgMS50000 = timeMergeSort50000 / 5;
        System.out.println(avgMS50000);
        //printArray(arraySize50000);

        k=22;
        timeMergeSort100000 = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            object.modifiedMergeSort(arraySize100000, 1, arraySize100000.length - 1,k);
            long endTime = System.nanoTime();

            timeMergeSort100000 = (endTime - startTime) + timeMergeSort100000;
        }
        avgMS100000 = timeMergeSort100000 / 5;
        System.out.println(avgMS100000);
        //printArray(arraySize100000);




    }

}