import javafx.geometry.HPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DTree {
    ArrayList<Integer> temp_AL = new ArrayList<Integer>();

    public HashMap<Integer, Integer> identify_feature_weightages(ArrayList<Integer> survival_rate_col, ArrayList<Integer> feature_col)
    {
        HashMap<Integer,Integer> feat_surv_hashmap = new HashMap();

        int i = 0;
        for(Integer integer: feature_col)
        {
            //System.out.println(integer);
            //int i = feature_col.indexOf(integer);

            //System.out.println(survival_rate_col.get(i));
            if(survival_rate_col.get(i) == 1){      // IF the passenger survived
                //System.out.println(integer +":"+survival_rate_col.get(i));
                // Take the feature
                // Add it to the Hashmap if it doesn't exists
                // If it exists, just do +1 to the value.
                //System.out.println("The Key is: " +integer);
                if(feat_surv_hashmap.containsKey(integer)){
                  //  System.out.println(" This key exists");
                    // has this key, doesn't need to be added
                    int val = feat_surv_hashmap.get(integer);       // Getting value
                    val++;                                          // Incrementing it
                    feat_surv_hashmap.replace(integer,val);         // Setting the value
                }
                else{
                    feat_surv_hashmap.put(integer,1); // Initializing value with 1 instead of doing +1
                    //System.out.println("Creating this entry on hashmap" + integer);
                }

            }
            i++;
        }


        return feat_surv_hashmap;

    }

    public int Getting_feature_data_with_max_value(HashMap<Integer,Integer> hm){
        int index = Collections.max(hm.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        int maxval = Collections.max(hm.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue();
        //System.out.println(index + " " + maxval);
        // This function basically returns the "feature" that has the maximum possibility of saving the person
        return index;

    }

    ArrayList<Integer> model = new ArrayList<>();
    public void training_model(ArrayList<Integer> features){

        model = features;
        // This function basically saves the "feature" that lets the person survive

    };
    public int predict(int PClass, int Sex, int Age, int SibSP, int Parch){
        ArrayList<Integer> features= wrap_to_ArrayList( PClass, Sex, Age,SibSP, Parch);
        int i=0;
        int survived = 0;
        // This function is supposed to predict if a person dies or lives
        // Input is the data we input as the test data
        // 0 = Dead 1 = Lived
        for (Integer feature: features
             ) {
            if(model.get(i) == feature){
                survived++;
            }
            else {
                survived--;
            }
            // Give points to the traits, if the passenger survived;
            i++;
        }
        //System.out.println("score =" + survived);
        if(survived<=0){
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public int predict(ArrayList<String> input_AL){
        int survived,a;
        /*if(input_AL.get(2).equals("male"))
        {
            a = 0;
        }
        else{
            a=1;
        }

         */
        survived = predict(
                Integer.parseInt(input_AL.get(0)),
                Integer.parseInt(input_AL.get(1)),
                Integer.parseInt(input_AL.get(2)),
                Integer.parseInt(input_AL.get(3)),
                Integer.parseInt(input_AL.get(4))
        );

        return survived;
    }
    public ArrayList<Integer> wrap_to_ArrayList (int PClass, int Sex, int Age, int SibSP, int Parch){
        // The idea is to wrap the whole data in an arraylist to predict the survived thing more efficiently
        ArrayList<Integer> features_wrapped = new ArrayList<Integer>();
        features_wrapped.add(PClass);
        features_wrapped.add(Sex);
        features_wrapped.add(Age);
        features_wrapped.add(SibSP);
        features_wrapped.add(Parch);

        return features_wrapped;
    }
    

    public ArrayList<Integer> predict__by_dataset(ArrayList<ArrayList<Integer>> ip){
        ArrayList<Integer> results = new ArrayList<Integer>();
        int x=0;

        for(int loop=0;loop<=ip.size();loop++){


        }

        ArrayList<Integer> input_AL = ip.get(0);

        for(x=0;x<input_AL.size();x++){
            ArrayList<Integer> set = new ArrayList<Integer>();
            for(int y=0;y<ip.size();y++){
                ArrayList<Integer> feat = ip.get(y);
                set.add(feat.get(x));
            }

            results.add(predict(
                    set.get(0),
                    set.get(1),
                    set.get(2),
                    set.get(3),
                    set.get(4)
            ));
            //System.out.println(set);
        }


       /* for (ArrayList<Integer> input_AL: ip
        ) {

            results.add(predict(
                    input_AL.get(0),
                    input_AL.get(1),
                    input_AL.get(2),
                    input_AL.get(3),
                    input_AL.get(4)
            ));
            System.out.println(input_AL);
            //System.out.println(input_AL.get(0));
            System.out.println(x);
            x++;


        }

        */

        return results;


    }

/*
    public ArrayList<Integer> predict_as_AL(ArrayList<ArrayList<Integer>> features_to_be_predicted){
        ArrayList<Integer> output_AL = new ArrayList<Integer>();
        int length = features_to_be_predicted.size(); // for the outer
        for(int x=0;x<length;x++) { // outer loop of number of feature entries
            for (int i = 0; i < features_to_be_predicted.get(0).size(); i++) { // inner loop of 5 features
                int a = features_to_be_predicted.get(i).get(x);
                output_AL.add(a);
            }
        }

        return output_AL;
    }
    public ArrayList<Integer> predictions(ArrayList<ArrayList<Integer>> features_to_be_predicted){
        int a,b,c,d,e;

    }

    public float accuracy(){
        return (float) 0.1;
    }

 */

public float accuracy(ArrayList<Integer> predictions, ArrayList<Integer> real_values){
    float x=0;
    float size = predictions.size();

    for(int i=0; i<predictions.size();i++){
        if(predictions.get(i) == real_values.get(i)){
            x++;
            //System.out.println(x);
        }
    }
    System.out.println(x+" : "+size);
    return x/size*100f;
}
}
