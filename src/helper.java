import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Helper {
    
    public String[][] readCSV(String file, int rows) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        int i = 0;
        String row = "";
        String[][] persons = new String[rows][5];

        while ((row = br.readLine()) != null)   {
            String[] rowArray = row.split(",");
            persons[i] = rowArray;

            i++;
        }
        br.close();
        // print2DArray(persons);
        return persons;
    }

    public void write2dArrayToFile(String[][] array, String file) throws Exception  {
        FileWriter fw = new FileWriter(file);

        fw.write('\n'); // potential not needed
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 4) {
                    fw.write(array[i][j]);
                }
                else {
                    fw.write(array[i][j] + ",");
                }
            }
            fw.write('\n');
        }
        fw.close();
    }

    public void writeArrayToFile(String[] array, String file, Boolean append) throws Exception  {
        FileWriter fw = new FileWriter(file, append);

        fw.write('\n');
        for (String str : array) {
            fw.write(str + '\n');
        }
        fw.close();
    }

    public void writeStringToFile(String content, String file, Boolean append) throws Exception  {
        FileWriter fw = new FileWriter(file, append); // true flag to append instead of overwrite file
        fw.append(content + '\n');
        fw.close();
    }

    public void writeBenchmarkToFile(String[] results, double average, int runs) throws Exception    {
        String file = "lib\\benchmark.txt";
        // addStringToFile(" ", file);
        writeStringToFile("Benchmark Results after " + runs + " runs: " + '\n', file, false);
        writeStringToFile(("Average: " + average + " seconds"), file, true);
        writeStringToFile("------------------------------", file, true);
        writeArrayToFile(results, file, true);
    }


    public int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public void print2DArray(String[][] array) {
        // System.out.print(array[0][0]);
        // System.out.print(array[4][4]);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "          ");
            }
            System.out.println();
        }
    }
    
}
