import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Main { 

    private static LinkedList<Integer> unsortedArray = new LinkedList<Integer>(Arrays.asList(3, 17, 4, 10, 9, 8, 7, 21, 29, 12));
    static Helper helper = new Helper();
    
    public static void main(String[] args) throws Exception {
        // int[] arr = createArray(120);
        // System.out.println(Arrays.toString(arr));
        // System.out.println("Sorted Array: ");
        // bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String namesArray[][] = helper.readCSV();
        System.out.println("-------------------------------------------");
        bubbleSortNames(namesArray);
        helper.print2DArray(namesArray);

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
