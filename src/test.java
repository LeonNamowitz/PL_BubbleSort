// create Main method
public class test {
    public static void main(String[] args) {
        int[] arr = createArray(22_000);
        // printArray(arr);
        double time = sortAndTime(arr);
        // printArray(arr);
        System.out.println("Time taken to sort: " + time + "s");

        int[] arr2 = createArray(22_000);
        double time2 = sortAndTime(arr2);
        System.out.println("Time taken to sort: " + time2 + "s");

    }

    // method that creates array with random integers between 1 and 1000
    public static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    // method that prints array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // timer that measures time of sorting
    public static double sortAndTime(int[] array) {
        long startTime = System.nanoTime();
        bubbleSort(array);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        double seconds = (double)time / 1_000_000_000.0;
        return seconds;
    }


    // create bubble sort alrogithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("BubbleSort done !");
    }
}