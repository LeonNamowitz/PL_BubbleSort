import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Helper {
    
    public String[][] readCSV(String file, int rows) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        int i = 0;
        String line = "";
        String[][] persons = new String[rows][5];

        while ((line = br.readLine()) != null)   {
            String[] row = line.split(",");
            persons[i] = row;

            i++;
        }
        br.close();
        // print2DArray(persons);
        return persons;
    }

    public void writeFile(String[][] array) throws Exception  {
        FileWriter fw = new FileWriter("lib\\output.csv");

        fw.write("TESTSSSSSSSSSSS" + '\n');
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
