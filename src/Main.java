import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Main { 

    private static LinkedList<Integer> unsortedArray = new LinkedList<Integer>(Arrays.asList(3, 17, 4, 10, 9, 8, 7, 21, 29, 12));
    static Helper helper = new Helper();
    
    public static void main(String[] args) throws Exception {
 
        // long startTime = System.nanoTime();
        // bubbleSortLists(unsortedArray);
        // long endTime = System.nanoTime();
        // long time = endTime - startTime;
        // double seconds = (double)time / 1_000_000_000.0;
        // System.out.println("Time: " + seconds + " seconds");

        benchmark(3);
        // test();
    }
    

    public static void benchmark(int runs) throws Exception  {
        double sum = 0;
        String file = "lib\\adressdaten.csv";
        String[] results = new String[runs];
        
        for (int i = 0; i < runs; i++) {
            String namesArray[][] = helper.readCSV(file);
            long startTime = System.nanoTime(); 
            int steps = (int) bubbleSortNames(namesArray, false).get(1);   // very much not typesafe !!!
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            double seconds = (double)time / 1_000_000_000.0;
            System.out.println("Time: " + seconds + " seconds");
            sum += seconds;

            String temp = (helper.padRight("Run " + (i + 1) + ":", 10) + "|  " + seconds + " seconds" + "  |  " + "Steps: " + steps); // we don't talk about this
            results[i] = temp;
        }
        double average = (sum / runs);
        System.out.println("-------------------------");
        // System.out.println("Average: " + average);
        System.out.println("Done! ");
        helper.writeBenchmarkToFile(results, average, runs, file);
    }
    
    public static void test() throws Exception  {
        // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String[][] namesArray = helper.readCSV("lib\\test.csv"); // adressdaten.csv
        System.out.println("-------------------------------------------");
        String[][] sortedArray = (String[][]) bubbleSortNames(namesArray, false).get(0);   // very much not typesafe !!!

        helper.writeCSV(sortedArray, "lib\\output.csv"); 
        System.out.println("Done! ");
        // helper.print2DArray(namesArray);
    }


    //////////////////////////////////// BUBBLE SORT ////////////////////////////////////


    private static ArrayList<Object> bubbleSortNames(String[][] array, Boolean notImproved) {    // time complexity: O(n^2) - worst case
        int n = array.length;
        boolean swapped;  
        int steps = 0; 
        ArrayList<Object> arrayPlusSteps = new ArrayList<Object>(); // funky workaround to return 2 different things
        for (int i = 0; i < n - 1; i++) {   // all elements checked after each other
            swapped = notImproved;    // 'false' - improves best case from O(n^2) to O(n)
            for (int j = 0; j < n - 1; j++) {   // single element moving through array
                if ((array[j][0].compareTo(array[j + 1][0])) > 0) {
                    // swap current with next element
                    String temp[] = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                steps++;
            }    
            if (swapped == false) { // break out of loop if no swaps were made
                break;
            }
        }
        arrayPlusSteps.add(array);  // don't do this at home
        arrayPlusSteps.add(steps);  // really don't
        // System.out.println(helper.padRight(("Predicted steps: "), 20) + (n * n));
        // System.out.println(helper.padRight(("Steps: "), 20) + "0" + (steps + 1));
        return arrayPlusSteps;
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
