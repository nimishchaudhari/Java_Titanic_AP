

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    //String csvFile = "/train.csv";

    String cvsSplitBy = ",";

    //ArrayList<String> data_to_writte = new ArrayList<String>();
    ArrayList<Integer> passenger_ids_from_dataset = new ArrayList<>();
    ArrayList<Integer> passenger_ids_from_testset = new ArrayList<>();
    ArrayList<Integer> passenger_ids_from_results_set = new ArrayList<>();

    public ArrayList<ArrayList<String>> read_CSV(String filename, boolean test_case) {
        String line = "";
        ArrayList<ArrayList<String>> data_read = new ArrayList<ArrayList<String>>();
        BufferedReader br = null;
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
            int skipper=0;
            int skipper2=0;
            while ((line = br.readLine()) != null) {


                // use comma as separator
                String[] data = line.split(cvsSplitBy);

                //System.out.println(data[0]);
                if (!test_case && data[6].isEmpty()) {
                    //System.out.println("empty detected");
                    // Skip if the age row is empty
                }
                else if(test_case && data[5].isEmpty() )
                {
                    //System.out.println("spotted");
                    // If any age is missing in the test dataset
                }
                else {
                    ArrayList<String> x = new ArrayList<String>(); // This ArrayList<String> contains all elements in 1 line
                    if (test_case) {

                        //System.out.println(line);

                       if(skipper==0)
                       {

                       }
                       else{
                           //System.out.println(data[0]);

                           passenger_ids_from_testset.add(Integer.parseInt(data[0]));
                       }



                        x.add(data[1]); // PClass
                        x.add(data[4]); // Sex  M/F
                        x.add(data[5]); // Age
                        x.add(data[6]); //SibSP
                        x.add(data[7]); // ParCh

                        // Added all elements in x
                        data_read.add(x); // Adding ArrayList<String> into main ArrayList
                    } else {



                        if(skipper2==0)
                        {

                        }
                        else{
                            //System.out.println(Integer.parseInt(data[0]));

                            passenger_ids_from_dataset.add(Integer.parseInt(data[0]));
                        }
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
                    }
                    i++;


                }

                skipper++;
                skipper2++;
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
        //System.out.println(data_read);
        return data_read;

    }

    public ArrayList<Integer> read_real_survival(String filename) throws IOException {
        ArrayList<ArrayList<String>> data_read = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> return_arraylist = new ArrayList<>();
        String line = "";
        BufferedReader br2 = null;
        try {
            br2 = new BufferedReader(new FileReader(filename));
            int i = 0;
            //System.out.println((passenger_ids_from_testset));

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                //System.out.println(i);
                if (i == 0) {
                     //To skip the first row which has string values
                } else {


                    //System.out.println("TEST");
                    // use comma as separator

                    if (passenger_ids_from_testset.contains(Integer.parseInt(data[0]))) {
                        return_arraylist.add(Integer.parseInt(data[1]));
                        // This means if the passenger ID is recorded, then it is considered.
                        // Since passenger IDs are aligned in ascending order, it doesn't need to be verified at every iteration.
                    }



                }
                i++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    return return_arraylist;
    }
}
