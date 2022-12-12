public class SelectionSort implements SortingAlgorithm{

    @Override
    public long sort(int[] array) {
        int n = array.length;
        long steps = 0;
        for (int i = 0; i < n - 1; i++) {   // moves the boundary of the unsorted subarray
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {   // find the smallest element in the unsorted subarray
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                steps++;
            }   // swap the smallest element with the first element
            int temp = array[minIndex]; // save current/min  value
            array[minIndex] = array[i]; // set current to first
            array[i] = temp;            // set first to current/min
        }
        // String temp = df.format(new BigDecimal(steps));
        // System.out.println("Steps: " + temp);
        return steps;
    }
}
