import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Main { 

    private static LinkedList<Integer> unsortedArray = new LinkedList<Integer>(Arrays.asList(3, 17, 4, 10, 9, 8, 7, 21, 29, 12));
    
    public static void main(String[] args) throws Exception {
 
        // long startTime = System.nanoTime();
        // bubbleSortLists(unsortedArray);
        // long endTime = System.nanoTime();
        // long time = endTime - startTime;
        // double seconds = (double)time / 1_000_000_000.0;
        // System.out.println("Time: " + seconds + " seconds");

        // benchmark(10, false);
        benchmark(1, false);
        // test();
    }
    

    public static void benchmark(int runs, Boolean improved) throws Exception  {
        double sum = 0;
        String dataFile = "lib\\adressdaten.csv";   // adressdaten.csv
        String[] results = new String[runs];
        if (!improved)    {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            for (int i = 0; i < runs; i++) {
                ArrayList<String[]> unsortedArray = Helper.readCSVtoList(dataFile);
                long startTime = System.nanoTime(); 
                sortedList = bubbleSortNames(unsortedArray);  
                long endTime = System.nanoTime();
                long time = endTime - startTime;
                double seconds = (double)time / 1_000_000_000.0;
                System.out.println("Time: " + seconds + " seconds");
                sum += seconds;
                
                String temp = (Helper.padRight("Run " + (i + 1) + ":", 10) + "|  " + seconds + " seconds"); // we don't talk about this
                results[i] = temp;
            }
            double average = (sum / runs);
            System.out.println("-------------------------");
            System.out.println("Average: " + average);
            System.out.println("Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile);
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }
        if (improved)    {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            for (int i = 0; i < runs; i++) {
                ArrayList<String[]> unsortedArray = Helper.readCSVtoList(dataFile);
                long startTime = System.nanoTime(); 
                sortedList = bubbleSortNamesImprv(unsortedArray);  
                long endTime = System.nanoTime();
                long time = endTime - startTime;
                double seconds = (double)time / 1_000_000_000.0;
                System.out.println("Time: " + seconds + " seconds");
                sum += seconds;
                
                String temp = (Helper.padRight("Run " + (i + 1) + ":", 10) + "|  " + seconds + " seconds"); // we don't talk about this
                results[i] = temp;
            }
            double average = (sum / runs);
            System.out.println("-------------------------");
            System.out.println("Average: " + average);
            System.out.println("Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile);
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }

    }
    
    public static void test() throws Exception  {
        // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String[][] namesArray = Helper.readCSVtoArray("lib\\test.csv"); // adressdaten.csv
        System.out.println("-------------------------");
        String[][] sortedArray = bubbleSortNames(namesArray, false);   
        
        Helper.writeCSV(sortedArray, "lib\\output.csv"); 
        System.out.println("Done! ");
        // helper.print2DArray(namesArray);
    }


    //////////////////////////////////// BUBBLE SORT ////////////////////////////////////

    // ArrayList version
    private static ArrayList<String[]> bubbleSortNamesImprv(ArrayList<String[]> arrayL) {    // time complexity: O(n^2) - worst case
        int n = arrayL.size();
        boolean swapped;  
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {   // all elements checked after each other
            swapped = false;    // 'false' - improves best case from O(n^2) to O(n)
            for (int j = 0; j < n - i - 1; j++) {   // single element moving through array
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
        // Helper.printSteps(steps);
        return arrayL;
    }

    private static ArrayList<String[]> bubbleSortNames(ArrayList<String[]> arrayList) {    // time complexity: O(n^2) - worst case
        int n = arrayList.size();   
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {   
            for (int j = 0; j < n - 1; j++) {   
                if ((arrayList.get(j)[0].compareTo(arrayList.get(j + 1)[0])) > 0) {
                    // swap current with next element
                    String temp[] = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
                steps++;
            }
        }
        // Helper.printSteps(steps);
        return arrayList;
    }

    // Array only version
    @Deprecated
    private static String[][] bubbleSortNames(String[][] array, Boolean notImproved) { 
        int n = array.length;
        boolean swapped;  
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {  
            swapped = notImproved;    
            for (int j = 0; j < n - i - 1; j++) {  // improvement
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
        // Helper.printSteps(steps);
        return array;
    }


    private static int[] bubbleSort(int[] array) {    // time complexity: O(n^2) - worst case
        boolean swapped;    // prevent alg from going through a sorted array
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {               // all elements checked after each other
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {           // single element + remaining ones moving through array
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
            for (int j = 0; j < n - i - 1; j++) {    // single element moving through array
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
