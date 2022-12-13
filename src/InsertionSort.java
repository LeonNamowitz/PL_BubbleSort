public class InsertionSort implements SortingAlgorithm{

    @Override
    public long sort(int[] array) {
        long steps = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
                steps++;
            }
            array[j + 1] = current;
        }
        // String temp = df.format(new BigDecimal(steps));
        // System.out.println("Steps: " + temp);
        return steps;
    }

}
