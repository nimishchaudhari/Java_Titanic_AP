

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    //String csvFile = "/train.csv";
    String line = "";
    String cvsSplitBy = ",";
    BufferedReader br = null;

    //ArrayList<String> data_to_writte = new ArrayList<String>();
    ArrayList<ArrayList<String>> data_read = new ArrayList<ArrayList<String>>();


    public ArrayList<ArrayList<String>> read_CSV(String filename) {

        try {
            /*
            We take the CSV, try to extract only the features we need,
            Use an ArrayList in which you store a List of type String
            Each List<String> will have one line of the CSV in it
            Then we parse that Line as needed
             */
            //PrintStream out = new PrintStream(new FileOutputStream("trainmod.csv"));
            //System.setOut(out);


            br = new BufferedReader(new FileReader(filename));
            //System.out.println("Survived PClass Sex Age SibSP ParCh Cabin");
            int i = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);

                if (data[6].isEmpty()) {
                    //System.out.println("empty detected");
                    // Skip if the age row is empty
                }
                else{
                    ArrayList<String> x = new ArrayList<String>(); // This ArrayList<String> contains all elements in 1 line
                    x.add(data[1]); // Survived?
                    x.add(data[2]); // PClass
                    x.add(data[5]); // Sex  M/F
                    x.add(data[6]); // Age
                    x.add(data[7]); //SibSP
                    x.add(data[8]); // ParCh

                    // Added all elements in x
                    data_read.add(x); // Adding ArrayList<String> into main ArrayList
                    //System.out.println("this"+x.get(3)+".");
                    //System.out.println(data_read.get(i));
                    i++;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return data_read;

    }
    }
