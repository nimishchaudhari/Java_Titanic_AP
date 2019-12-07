import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DAO {
    /*
    Define the different business classes represented in the following class diagram and
    add method to the DAO class to create the training dataset.
    This method must verify that there is no row with null values.
     */

    public static void main(String[] args) {
        CSVReader CSVR = new CSVReader();
        DTree algo = new DTree();
        ArrayList<ArrayList<String>> training_data = CSVR.read_CSV("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/train.csv");

        Survival_parser survival_parser = new Survival_parser();
        Feature_parser feature_parser = new Feature_parser();
        ArrayList<Integer> feature_arraylist = new ArrayList<Integer>();
        ArrayList<Integer> survival_arraylist = new ArrayList<Integer>();
        survival_arraylist = survival_parser.generate_array_of_survival_rate(training_data);
        // PClass 1, Sex 2, Age 3, SibSP 4, ParCh 5
        ArrayList<Integer> PClass = new ArrayList<Integer>();
        PClass = feature_parser.generate_array_of_feature(training_data,1,false);
        ArrayList<Integer> Sex = new ArrayList<Integer>();
        Sex = feature_parser.generate_array_of_feature(training_data,2,true);
        ArrayList<Integer> Age = new ArrayList<Integer>();
        Age = feature_parser.generate_array_of_feature(training_data,3,false);
        ArrayList<Integer> SibSP = new ArrayList<Integer>();
        SibSP = feature_parser.generate_array_of_feature(training_data,4,false);
        ArrayList<Integer> ParCh = new ArrayList<Integer>();
        ParCh = feature_parser.generate_array_of_feature(training_data,5,false);
        // The above code has got each column of the dataset as an ArrayList, now we do the Tree

        System.out.println(survival_arraylist.size()+"\n"+Age.size()); // All the arraylists are of the same size,
        // now I can compare them with the survival arrayList and see the value being 0 or 1
        HashMap Survival_based_on_sex = algo.distributor(survival_arraylist,Sex);

        System.out.println(Arrays.asList(Survival_based_on_sex));


        /*
        Survival_based_on_sex.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        example.entrySet().forEach(entry->{
    System.out.println(entry.getKey() + " " + entry.getValue());
         });

         */
    }



}
