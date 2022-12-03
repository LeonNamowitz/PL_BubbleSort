import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Main { 

    private static LinkedList<Integer> unsortedArray = new LinkedList<Integer>(Arrays.asList(3, 17, 4, 10, 9, 8, 7, 21, 29, 12));
    
    
    public static void main(String[] args) throws Exception {
        // int[] arr = createArray(120);
        // System.out.println(Arrays.toString(arr));
        // System.out.println("Sorted Array: ");
        // bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));
        
        readCSV();
        // test();

    }
    

    public static void readCSV() throws Exception{
        String file = "lib\\test.csv";
        BufferedReader br = new BufferedReader(new FileReader(file));
        int i = 0;
        String line = "";
        String[][] persons = new String[10][5];

        while ((line = br.readLine()) != null)   {
            String[] row = line.split(",");
            persons[i] = row;

            i++;
        }
        br.close();
        print2DArray(persons);
    }


    public static void test(){
        String s1 = "ALeon";
        String s2 = "BSimon";
        System.out.println(s1.compareTo(s2));

        if (s1.compareTo(s2) > 0)
            System.out.println("Leon > Simon");

    }

    private static String[][] bubbleSortNames(String[][] array) {    // time complexity: O(n^2) - worst case
        int n = array.length; // hopefully 10 ?
        for (int i = 0; i < n - 1; i++)    // all elements checked after each other
            for (int j = 0; j < n - 1; j++)    // single element moving through array
                if ((array[j][0].compareTo(array[j + 1][0])) < 0) {
                    // swap current with next element
                    String temp = array[j][0];
                    array[j][0] = array[j + 1][0];
                    array[j + 1][0] = temp;
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

    public static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void print2DArray(String[][] array) {
        System.out.print(array[0][0] + '\n');
        System.out.print(array[4][4] + '\n');
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + '\n');
            }
            System.out.println();
        }
    }
}
