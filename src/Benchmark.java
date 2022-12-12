import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class Benchmark {

    private static DecimalFormat df = new DecimalFormat("");

    private static final int WARM_UPS = 0;
    private static final int ITERATIONS = 1;
    private static final int LIMIT = 20_000;

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
            System.out.printf("%n===== Warm up %d of %d =====%n", i, WARM_UPS);
            for (SortingAlgorithm algorithm : ALGORITHMS) {
                test(algorithm, true);
            }
        }

        for (int i = 0; i < ITERATIONS ; i++) {
            System.out.printf("%n===== Iteration %d =====%n", i);
            for (SortingAlgorithm algorithm : ALGORITHMS) {
              test(algorithm, false);
            }
        }
    }

    private void test (SortingAlgorithm algorithm, boolean warmUp) {
        test(algorithm, InputOrder.RANDOM, Helper.createRandomArray(LIMIT), warmUp);
        test(algorithm, InputOrder.ASCENDING, Helper.createAscendingArray(LIMIT), warmUp);
        test(algorithm, InputOrder.DESCENDING, Helper.createDescendingArray(LIMIT), warmUp);
    }

    private void test(SortingAlgorithm algorithm, InputOrder inputOrder, int[] array, boolean warmUp) {
        System.out.printf("%n--- %s (order: %s) ---%n", algorithm.getName(), inputOrder);
        double time = runAndMeasure(algorithm, array);
    }


    private double runAndMeasure(SortingAlgorithm alg, int[] array) {
        double start = System.nanoTime();
        long steps = alg.sort(array);
        double end = System.nanoTime();
        double duration = end - start;
        double seconds = duration / 1000000000;
        String stepsF = df.format(new BigDecimal(steps));
        System.out.printf("%s took %s steps and %f seconds%n", alg.getName(), stepsF, seconds);
        try {
            Helper.writeBench(alg, steps, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return duration;
    }

    private void writeBench() {
        
    }

    private enum InputOrder {
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
