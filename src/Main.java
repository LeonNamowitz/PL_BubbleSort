import java.util.ArrayList;
import java.util.Arrays;


public class Main { 

    private static int[] unsortedArray = new int[]{3, 17, 4, 10, 9, 8, 7, 21, 29, 12};
    
    public static void main(String[] args) throws Exception {

        aufgabe1(false); // change to true to print the steps
        // aufgabe2();
        
        // adressBenchmark(10, true, true, true, true);
        // test();
    }
    
    private static void aufgabe1(Boolean print)      {
        System.out.println("************************************************************************");
        System.out.println("Unsorted Array: " + '\n' + Arrays.toString(unsortedArray));
        int[] sortedArray = bubbleSort(unsortedArray, print);
        System.out.println('\n' + "Sorted Array: " + '\n' + Arrays.toString(sortedArray) + '\n');
        System.out.println("************************************************************************");
    }

    private static void aufgabe2()  throws Exception {
        // ArrayList<String[]> namesArray = Helper.readCSVtoList("lib\\adressdaten.csv"); // adressdaten.csv
        String[][] namesArray = Helper.readCSVtoArray("lib\\adressdaten.csv"); // adressdaten.csv
        System.out.println("-------------------------");
        String[][] sortedArray = bubbleSortNames(namesArray, false);   
        Helper.writeCSV(sortedArray, "lib\\output.csv"); 
        System.out.println("Done! ");
        // Helper.print2DArray(namesArray);
    }


    private static void adressBenchmark(int runs, Boolean bubbleImpr, Boolean bubble, Boolean insertion, Boolean selection) throws Exception  {
        String dataFile = "lib\\adressdaten.csv";   // adressdaten.csv
        String[] results = new String[runs];
        if (bubble)    {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            double sum = 0;
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
            System.out.println("-------------------------");
            System.out.println("Bubble Sort Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile, "lib\\BubbleBenchmark.txt");
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }
        if (bubbleImpr)    {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            double sum = 0;
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
            System.out.println("-------------------------");
            System.out.println("Improved Bubble Sort Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile, "lib\\BubbleImprovedBenchmark.txt");
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }
        if (insertion)  {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            double sum = 0;
            for (int i = 0; i < runs; i++) {
                ArrayList<String[]> unsortedArray = Helper.readCSVtoList(dataFile);
                long startTime = System.nanoTime(); 
                sortedList = insertionSort(unsortedArray);  
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
            System.out.println("-------------------------");
            System.out.println("Insertion Sort Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile, "lib\\InsertionBenchmark.txt");
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }
        if (selection)  {
            ArrayList<String[]> sortedList = new ArrayList<String[]>();
            double sum = 0;
            for (int i = 0; i < runs; i++) {
                ArrayList<String[]> unsortedArray = Helper.readCSVtoList(dataFile);
                long startTime = System.nanoTime(); 
                sortedList = selectionSort(unsortedArray);  
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
            System.out.println("-------------------------");
            System.out.println("Selection Done! " + '\n');
            Helper.writeBenchmarkToFile(results, average, runs, dataFile, "lib\\SelectionBenchmark.txt");
            Helper.writeCSV(sortedList, "lib\\output.csv"); 
        }
        
    }
    
    private static void test() throws Exception  {
        // System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ArrayList<String[]> namesArray = Helper.readCSVtoList("lib\\adressdaten.csv"); // adressdaten.csv
        System.out.println("-------------------------");
        // ArrayList<String[]> sortedArray = selectionSort(namesArray);   
        long startTime = System.nanoTime(); 
        ArrayList<String[]> sortedArray = insertionSort(namesArray);   
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        double seconds = (double)time / 1_000_000_000.0;
        System.out.println("Time: " + seconds + " seconds");
        Helper.writeCSV(sortedArray, "lib\\output.csv"); 
        System.out.println("Done! ");
        // Helper.print2DArray(namesArray);
    }


    //////////////////////////////////// BUBBLE SORT ////////////////////////////////////

    // improved ArrayList version
    private static ArrayList<String[]> bubbleSortNamesImprv(ArrayList<String[]> arrayList) {    
        int n = arrayList.size();
        boolean swapped;  
        int steps = 0; 
        for (int i = 0; i < n - 1; i++) {   
            swapped = false;    // 'false' - improves best case from O(n^2) to O(n)
            for (int j = 0; j < n - i - 1; j++) {   
                if ((arrayList.get(j)[0].compareTo(arrayList.get(j + 1)[0])) > 0) {
                    String temp[] = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                    swapped = true;
                }
                steps++;
            }  
            if (swapped == false) { // break out of loop if no swaps were made
                break;
            }
        }
        // Helper.printSteps(steps);
        return arrayList;
    }

    // basic ArrayList version
    private static ArrayList<String[]> bubbleSortNames(ArrayList<String[]> arrayList) {   
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

    // improved Array version
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

    public static ArrayList<String[]> insertionSort (ArrayList<String[]> arrayList) {
        int n = arrayList.size();
        int steps = 0;
        for (int i = 1; i < n; i++) {
            String current[] = arrayList.get(i);
            int j = i - 1;
            while (j >= 0 && (arrayList.get(j)[0].compareTo(current[0]) > 0)) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
                steps++;
            }
            arrayList.set(j + 1, current);
        }
        // Helper.printSteps(steps);
        return arrayList;
    }

    public static ArrayList<String[]> selectionSort(ArrayList<String[]> arrayList) {
        int n = arrayList.size();
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {               // moves the boundary of the unsorted subarray
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {           // find the smallest element in the unsorted subarray
                if ((arrayList.get(j)[0].compareTo(arrayList.get(minIndex)[0])) < 0) {
                minIndex = j;
                }
                steps++;
            }                                           // swap the smallest element with the first element
            String temp[] = arrayList.get(minIndex);    // save current/min  value
            arrayList.set(minIndex, arrayList.get(i));  // set current to first
            arrayList.set(i, temp);                     // set first to current/min
        }
        // Helper.printSteps(steps);
        return arrayList;
    }

    private static int[] bubbleSort(int[] array, Boolean print) {      // time complexity: O(n^2) - worst case
        boolean swapped;                                // prevent alg from going through a sorted array
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {               // all elements checked after each other
            if (print)
                System.out.println('\n' + "------------------" + "Bubble Phase " + (i + 1) + "------------------" + '\n');
            swapped = false;
            for (int j = 0; j < n - 1; j++) {           // single element + remaining ones moving through array
                if (print)
                    System.out.println("Array: " + Arrays.toString(array) + "        j = " + j);
                if (array[j] > array[j + 1]) {          // 1. find the first element that is smaller than its neighbour
                    int temp = array[j];                // 2. swap it with the next element
                    array[j] = array[j + 1];            // 3. move the same element to the right until the neighbour is bigger 
                    array[j + 1] = temp;                // 4. then check if the remaining elements can be moved
                    swapped = true;
                    if (print)
                        System.out.println('\n' + "Swapped " + array[j + 1] + " with " + array[j] + '\n');
                }
            }
            if (!swapped)
                break;
        }
        return array;
    }
}
