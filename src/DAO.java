import java.awt.event.ItemEvent;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        CSVReader CSVR = new CSVReader();
        CSVReader CSVR2 = new CSVReader();
        DTree algo = new DTree();
        ArrayList<ArrayList<String>> training_data = CSVR.read_CSV("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/train.csv",false);
        ArrayList<ArrayList<String>> test_data = CSVR2.read_CSV("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/test.csv",true);

        //System.out.println(training_data);
        Survival_parser survival_parser = new Survival_parser();
        Feature_parser feature_parser = new Feature_parser();
        //System.out.println(training_data.get(0));

        ArrayList<Integer> survival_arraylist = survival_parser.generate_array_of_survival_rate(training_data); // Parses an arraylist of survival.

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

        // now I can compare them with the survival arrayList and see the value being 0 or 1
        HashMap Survival_based_on_PClass = algo.identify_feature_weightages(PClass,Sex);
        HashMap Survival_based_on_sex = algo.identify_feature_weightages(survival_arraylist,Sex);
        HashMap Survival_based_on_age = algo.identify_feature_weightages(Age,Sex);
        HashMap Survival_based_on_SibSP = algo.identify_feature_weightages(SibSP,Sex);
        HashMap Survival_based_on_ParCh = algo.identify_feature_weightages(ParCh,Sex);
        // The above code will generate hashmaps of all features' scores



        // The next function basically gets the "feature" with max score in the hashmap

        ArrayList<Integer> features_AL = new ArrayList<>();
        features_AL.add(algo.Getting_feature_data_with_max_value(Survival_based_on_PClass));
        features_AL.add(algo.Getting_feature_data_with_max_value(Survival_based_on_sex));
        features_AL.add(algo.Getting_feature_data_with_max_value(Survival_based_on_age));
        features_AL.add(algo.Getting_feature_data_with_max_value(Survival_based_on_SibSP));
        features_AL.add(algo.Getting_feature_data_with_max_value(Survival_based_on_ParCh));
        // Adding this in a new ArrayList for training the model.

        // To train the model:
        algo.training_model(features_AL);

        // Now the model (which is just an ArrayList<Int> knows which feature should be at what value to facilitate
        // The survival of the person

        // For prediction; the input needed is an arraylist of the features in the following order:
        // Or I can just grab the 5 things, put them in predict function and get predictions in an ArrayList of Integers
        // PClass, sex, Age, SibSP, ParCH

        //Trying the predict function: 0 = Dead 1 = Survive


        //System.out.println(algo.predict(3,0,22,1,0));
        //System.out.println(algo.predict(2,1,14,1,0));
        //ArrayList<Integer> survival_testcase = survival_parser.generate_array_of_survival_rate(test_data); // Parses an arraylist of survival.
        //System.out.println(survival_arraylist.size());
        //System.out.println(test_data);

        //STUFF ABOVE THIS WORKS FINE





        // PClass 1, Sex 2, Age 3, SibSP 4, ParCh 5

        //System.out.println(test_data.get(1));
        ArrayList<Integer> PClass1 = feature_parser.generate_array_of_feature(test_data,0,false);
        ArrayList<Integer> Sex1 = feature_parser.generate_array_of_feature(test_data,1,true);
        ArrayList<Integer> Age1 = feature_parser.generate_array_of_feature(test_data,2,false);
        ArrayList<Integer> SibSP1 = feature_parser.generate_array_of_feature(test_data,3,false);
        ArrayList<Integer> ParCh1 = feature_parser.generate_array_of_feature(test_data,4,false);

        ArrayList<ArrayList<Integer>> test_features_to_be_predicted = new ArrayList<ArrayList<Integer>>();
        test_features_to_be_predicted.add(PClass1);
        test_features_to_be_predicted.add(Sex1);
        test_features_to_be_predicted.add(Age1);
        test_features_to_be_predicted.add(SibSP1);
        test_features_to_be_predicted.add(ParCh1);

        ArrayList<Integer> predicted_values = algo.predict__by_dataset(test_features_to_be_predicted);

        Survival_parser sp_for_test_data = new Survival_parser();
        ArrayList<Integer> real_values = CSVR2.read_real_survival("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/gender_submission.csv");

        //System.out.println(predicted_values);
        //System.out.println(real_values);
        System.out.println(algo.accuracy(predicted_values,real_values));





        //ArrayList<ArrayList<String>> test_results_real = CSVR.read_CSV("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/gender_submission.csv");

    }



}
