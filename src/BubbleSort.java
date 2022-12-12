public class BubbleSort implements SortingAlgorithm{

    @Override
    public long sort(int[] array) {
        int size = array.length;
        long steps = 0;
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                steps++;
            }
        }
        return steps;
        // String temp = df.format(new BigDecimal(steps));
        // System.out.println("Steps: " + temp);
    }
 

}
