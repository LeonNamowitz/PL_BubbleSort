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

        benchmark(3, false);
        // test();
    }
    

    public static void benchmark(int runs, Boolean notImproved) throws Exception  {
        double sum = 0;
        String dataFile = "lib\\adressdaten.csv";   // adressdaten.csv
        String[] results = new String[runs];
        
        for (int i = 0; i < runs; i++) {
            ArrayList<String[]> unsortedArray = helper.readCSVtoList(dataFile);
            long startTime = System.nanoTime(); 
            bubbleSortNames(unsortedArray, notImproved);  
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            double seconds = (double)time / 1_000_000_000.0;
            System.out.println("Time: " + seconds + " seconds");
            sum += seconds;

            String temp = (helper.padRight("Run " + (i + 1) + ":", 10) + "|  " + seconds + " seconds"); // we don't talk about this
            results[i] = temp;
        }
        double average = (sum / runs);
        System.out.println("-------------------------");
        System.out.println("Average: " + average);
        System.out.println("Done! ");
        helper.writeBenchmarkToFile(results, average, runs, dataFile);
    }
    
    public static void test() throws Exception  {
        // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String[][] namesArray = helper.readCSVtoArray("lib\\test.csv"); // adressdaten.csv
        System.out.println("-------------------------");
        String[][] sortedArray = bubbleSortNames(namesArray, false);   

        helper.writeCSV(sortedArray, "lib\\output.csv"); 
        System.out.println("Done! ");
        // helper.print2DArray(namesArray);
    }


    //////////////////////////////////// BUBBLE SORT ////////////////////////////////////

    // ArrayList version
    private static ArrayList<String[]> bubbleSortNames(ArrayList<String[]> arrayL, Boolean notImproved) {    // time complexity: O(n^2) - worst case
        int n = arrayL.size();   
        boolean swapped;  
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {   // all elements checked after each other
            swapped = notImproved;    // 'false' - improves best case from O(n^2) to O(n)
            for (int j = 0; j < n - 1; j++) {   // single element moving through array
                if ((arrayL.get(j)[0].compareTo(arrayL.get(j + 1)[0])) > 0) {
                    // swap current with next element
                    String temp[] = arrayL.get(j);
                    arrayL.set(j, arrayL.get(j + 1));
                    arrayL.set(j + 1, temp);
                    swapped = true;
                }

                steps++;
            }    
            if (swapped == false) { // break out of loop if no swaps were made
                break;
            }
        }
        helper.printSteps(steps);
        return arrayL;
    }

    // Array only version
    private static String[][] bubbleSortNames(String[][] array, Boolean notImproved) { 
        int n = array.length;
        boolean swapped;  
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {  
            swapped = notImproved;    
            for (int j = 0; j < n - 1; j++) {  
                if ((array[j][0].compareTo(array[j + 1][0])) > 0) {
                    String temp[] = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
                if ((array[j][0].compareTo(array[j + 1][0])) == 0)   {
                    if ((array[j][1].compareTo(array[j + 1][1])) > 0) {
                        String temp[] = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                steps++;
            }    
            if (swapped == false) {
                break;
            }
        }
        helper.printSteps(steps);
        return array;
    }


    private static int[] bubbleSort(int[] array) {    // time complexity: O(n^2) - worst case
        boolean swapped;    // prevent alg from going through a sorted array
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {               // all elements checked after each other
            swapped = false;
            for (int j = 0; j < n - 1; j++) {           // single element + remaining ones moving through array
                if (array[j] > array[j + 1]) {          // 1. find the first element that is smaller than its neighbour
                    int temp = array[j];                // 2. swap it with the next element
                    array[j] = array[j + 1];            // 3. move the same element to the right until the neighbour is bigger 
                    array[j + 1] = temp;                // 4. then check if the remaining elements can be moved
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return array;
    }

    // "Bubble sort also interacts poorly with modern CPU hardware. 
    // It requires at least twice as many writes as insertion sort, twice as many cache misses, and asymptotically more branch mispredictions. 
    // Experiments by Astrachan sorting strings in Java show bubble sort to be roughly 5 times slower than insertion sort and 40% slower than selection sort"
    // Source: https://en.wikipedia.org/wiki/Bubble_sort
    // https://youtu.be/m4yVlPqeZwo?t=1400
    private static LinkedList<Integer> bubbleSortLists(LinkedList<Integer> array) {    // time complexity: O(n^2) - worst case
        boolean swapped;
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {    // all elements checked after each other
            swapped = false;
            for (int j = 0; j < n - 1; j++) {    // single element moving through array
                if (array.get(j) > array.get(j + 1)) {
                    // swap current with next element
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
            if (!swapped)
                break;
        }
        return array;
    }
}
