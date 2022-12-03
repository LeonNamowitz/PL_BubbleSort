import java.util.Arrays;
import java.util.LinkedList;


public class Main { 

    private static LinkedList<Integer> unsortedArray = new LinkedList<Integer>(Arrays.asList(3, 17, 4, 10, 9, 8, 7, 21, 29, 12));
    static Helper helper = new Helper();
    
    public static void main(String[] args) throws Exception {
        // int[] arr = createArray(120);
        // System.out.println(Arrays.toString(arr));
        // System.out.println("Sorted Array: ");
        long startTime = System.nanoTime();
        bubbleSortLists(unsortedArray);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        double seconds = (double)time / 1_000_000_000.0;
        System.out.println("Time: " + seconds + " seconds");

        // benchmark(3);
        // System.out.print

    }
    

    public static void benchmark(int runs) throws Exception  {
        double sum = 0;
        String[] results = new String[runs];
        for (int i = 0; i < runs; i++) {
            String namesArray[][] = helper.readCSV("lib\\adressdaten.csv", 10_000);
            long startTime = System.nanoTime(); 
            bubbleSortNames(namesArray);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            double seconds = (double)time / 1_000_000_000.0;
            System.out.println("Time: " + seconds + " seconds");
            sum += seconds;
            results[i] = "Run " + (i + 1) + ":  |  " + seconds + " seconds";    // @ToDo: format runs with same spacing
        }
        double average = (sum / runs);
        System.out.println("-------------------------");
        System.out.println("Average: " + average);

        helper.writeBenchmarkToFile(results, average, runs);
    }

    public static void test() throws Exception  {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String namesArray[][] = helper.readCSV("lib\\test.csv", 10);
        System.out.println("-------------------------------------------");
        bubbleSortNames(namesArray);
        helper.print2DArray(namesArray);
    }

    private static String[][] bubbleSortNames(String[][] array) {    // time complexity: O(n^2) - worst case
        int n = array.length; 
        for (int i = 0; i < n - 1; i++)    // all elements checked after each other
            for (int j = 0; j < n - 1; j++)    // single element moving through array
                if ((array[j][0].compareTo(array[j + 1][0])) > 0) {
                    // swap current with next element
                    String temp[] = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        return array;
    }


    private static int[] bubbleSort(int[] array) {    // time complexity: O(n^2) - worst case
        int n = array.length;
        for (int i = 0; i < n - 1; i++)    // all elements checked after each other
            for (int j = 0; j < n - 1; j++)    // single element moving through array
                if (array[j] > array[j + 1]) {
                    // swap current with next element
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        return array;
    }

    private static LinkedList<Integer> bubbleSortLists(LinkedList<Integer> array) {    // time complexity: O(n^2) - worst case
        int n = array.size();
        for (int i = 0; i < n - 1; i++)    // all elements checked after each other
            for (int j = 0; j < n - 1; j++)    // single element moving through array
                if (array.get(j) > array.get(j + 1)) {
                    // swap current with next element
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
        return array;
    }

 
}
