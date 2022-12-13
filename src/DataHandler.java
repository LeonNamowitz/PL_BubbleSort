import java.util.ArrayList;
import java.util.Arrays;

public class DataHandler {
    
    private SortingAlgorithm alg;
    private Benchmark.InputOrder inputOrder;
    private int sample;
    private long steps;
    private double average;
    // private double seconds;
    private String name;
    private final ArrayList<Double> times = new ArrayList<>();

    public DataHandler(String name) {
        this.name = name;
    }


    public void addData(SortingAlgorithm alg, Benchmark.InputOrder inputOrder, int sample, long steps, double seconds) {
        times.add(seconds);
        this.alg = alg;
        this.inputOrder = inputOrder;
        this.sample = sample;
        this.steps = steps;
        // this.seconds = seconds;
        setAverage();
    }


    public void setAverage() {
        double sum = 0;
        for (double t : times) {
            sum = sum + t;
        }
        average = sum / times.size();
    }


    public SortingAlgorithm getAlgorithm() {
        return this.alg;
    }


    public Benchmark.InputOrder getInputOrder() {
        return this.inputOrder;
    }


    public int getSampleSize() {
        return this.sample;
    }


    // public double getTime() {
    //     return this.seconds;
    // }


    public long getSteps() {
        return this.steps;
    }


    public double getAverage() {
        return average;
    }


}
