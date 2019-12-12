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
        System.out.println(index + " " + maxval);
        // This function basically returns the "feature" that has the maximum possibility of saving the person
        return index;

    }

    public int training_model(int PClass, int Sex, int Age, int SibSP, int Parch){
        int survival = 99;




        return survival;
    };
}
