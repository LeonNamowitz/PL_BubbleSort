import java.util.ArrayList;
import java.util.Arrays;

public class DataHandler {
    
    private String name;
    private String order;
    private final ArrayList<Double> times = new ArrayList<>();

    public DataHandler(String name) {
        this.name = name;
    }


    public void addTime(double time) {
        times.add(time);
    }


    public double getAverage() {
        long sum = 0;
        for (double t : times) {
            sum += t;
        }
        return sum / times.size();
    }

    public void setOrder(String order) {
        this.order = order;
    }

}
