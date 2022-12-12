public class BubbleSortImproved implements SortingAlgorithm {

    @Override
    public long sort(int[] array) {
        int size = array.length;
        long steps = 0;
        for (int i = 0; i < (size - 1); i++) {
            boolean swapped = false;                    // improvement 1
            for (int j = 0; j < (size - i - 1); j++) {  // improvement 2  
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                steps++;
            }
            if (!swapped)
            break;
        }
        // String temp = df.format(new BigDecimal(steps));
        // System.out.println("Steps: " + temp);
        return steps;
    }
    
}
