import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Helper {
    
    Boolean printDone = false;

    public String[][] readCSVtoArray(String file) throws Exception {

        // Have to go over the file twice to avoid hardcoding the array size

        BufferedReader br = new BufferedReader(new FileReader(file));
        int lineCount = 0;
        while (br.readLine() != null)   {
            lineCount++;
        } 
        // System.out.println(lineCount);
        br.close();

        int i = 0;
        String row = "";
        String[][] persons = new String[lineCount][5];
        br.close();
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        while ((row = br2.readLine()) != null)   {
            String[] rowArray = row.split(",");
            persons[i] = rowArray;
            i++;
            // System.out.println("Line " + i + " read");
        }
        br2.close();

        return persons;
    }

    public ArrayList<String[]> readCSVtoList(String file) throws Exception    {
        ArrayList<String[]> persons = new ArrayList<String[]>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String row = "";
        while ((row = br.readLine()) != null)  {
            String[] rowArray = row.split(",");
            persons.add(rowArray);
        }
        br.close();
        return persons;
    }

    public void writeCSV(ArrayList<String[]> array, String file) throws Exception  {
        FileWriter fw = new FileWriter(file);
        // fw.write('\n'); // potentially not needed
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).length; j++) {
                if (j == 4) {
                    fw.write(array.get(i)[j]);
                }
                else {
                    fw.write(array.get(i)[j] + ",");
                }
            }
            fw.write('\n');
        }
        fw.close();
    }

    public void writeCSV(String[][] array, String file) throws Exception  {
        FileWriter fw = new FileWriter(file);
        // fw.write('\n'); // potentially not needed
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

    public void writeBenchmarkToFile(String[] results, double average, int runs, String dataFile) throws Exception    {
        String benchFile = "lib\\benchmark.txt";
        // addStringToFile(" ", file);
        writeStringToFile("Benchmarked File: " + dataFile, benchFile, true);
        writeStringToFile("------------------------------", benchFile, true);
        writeStringToFile("Results after " + runs + " runs: " + '\n', benchFile, true);
        writeStringToFile(("Average: " + average + " seconds"), benchFile, true);
        writeStringToFile("------------------------------", benchFile, true);
        writeArrayToFile(results, benchFile, true);  
        writeStringToFile(" ", benchFile, true);
        writeStringToFile("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ", benchFile, true);
        writeStringToFile(" ", benchFile, true);
    }

    @Deprecated
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
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "          ");
            }
            System.out.println();
        }
    }

    public String padRight(String content, int padLength) {
        return String.format("%-" + padLength + "s", content);  
   }

    public void printSteps(int steps) {
        
        if (!printDone)  {
            String temp = ("Steps: " + steps);
            System.out.println(temp);
            System.out.println("-------------------------");
            printDone = true;
        }
    }
}
