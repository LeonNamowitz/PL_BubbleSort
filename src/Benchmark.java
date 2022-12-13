import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Benchmark {

    private static DecimalFormat df = new DecimalFormat("");

    private static final Boolean DEBUG = false;
    private static final int WARM_UPS = 1;
    private static final int REPEATS = 4;
    private static final int LIMIT = 1_000_000;

    static final SortingAlgorithm[] ALGORITHMS = {
            new BubbleSort(),
            new BubbleSortImproved(),
            new SelectionSort(),
            new InsertionSort(),
            // new JavaArraysSort(),
    };

    public static void main(String[] args) {
        new Benchmark().run();
    }

    private void run() {
        for (int i = 0; i < WARM_UPS; i++) {
            DataHandler dh = new DataHandler("WarmUp");
            if (DEBUG) {
                System.out.printf("%n===== Warm up %d of %d =====%n", i, WARM_UPS);
            }
            for (SortingAlgorithm algorithm : ALGORITHMS) {
                test(algorithm, true, LIMIT/2, dh, dh, dh);
            }
        }
        
        for (SortingAlgorithm algorithm : ALGORITHMS) {
            for (int sample = 1000; sample < LIMIT; sample *= 2) {
                DataHandler dh1 = new DataHandler(algorithm.getName());
                DataHandler dh2 = new DataHandler(algorithm.getName());
                DataHandler dh3 = new DataHandler(algorithm.getName());
                for (int i = 0; i < REPEATS ; i++) {
                    if (DEBUG) {
                        System.out.printf("%n===== Iteration %d =====%n", i);
                    }
                  test(algorithm, false, sample, dh1, dh2, dh3);
                }
                if (REPEATS != 0) {
                    try {
                        Helper.writeBench(dh1);
                        Helper.writeBench(dh2);
                        Helper.writeBench(dh3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void test (SortingAlgorithm algorithm, boolean warmUp, int sample, DataHandler dh1, DataHandler dh2, DataHandler dh3) {
        double time;
        time = test(algorithm, InputOrder.RANDOM, Helper.createRandomArray(sample), warmUp, dh1);
        time = test(algorithm, InputOrder.ASCENDING, Helper.createAscendingArray(sample), warmUp, dh2);
        time = test(algorithm, InputOrder.DESCENDING, Helper.createDescendingArray(sample), warmUp, dh3);
    }

    private double test(SortingAlgorithm algorithm, InputOrder inputOrder, int[] array, boolean warmUp, DataHandler dh) {
        if (DEBUG)
            System.out.printf("%n--- %s (order: %s) ---%n", algorithm.getName(), inputOrder);
        double time = runAndMeasure(algorithm, array, inputOrder, warmUp, dh);
        return time;
    }


    private double runAndMeasure(SortingAlgorithm alg, int[] array, InputOrder inputOrder, Boolean warmUp, DataHandler dh) {
        double start = System.nanoTime();
        long steps = alg.sort(array);
        double end = System.nanoTime();
        double duration = end - start;
        double seconds = duration / 1000000000;
        dh.addData(alg, inputOrder, array.length, steps, seconds);
        if (DEBUG) {
            String stepsF = df.format(new BigDecimal(steps));
            System.out.printf("%s took %s steps and %f seconds%n", alg.getName(), stepsF, seconds);
        }
        if (warmUp) {
            return duration;
        }
        // try {
        //     Helper.writeBench(alg, inputOrder, array.length, steps, seconds);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return duration;
    }

    private void writeBench() {
        
    }

    enum InputOrder {
        RANDOM(false),
        ASCENDING(true),
        DESCENDING(true);
    
        private final boolean sorted;
    
        InputOrder(boolean sorted) {
          this.sorted = sorted;
        }
    
        boolean isSorted() {
          return sorted;
        }
    }
}
