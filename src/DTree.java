import java.util.ArrayList;
import java.util.HashMap;

public class DTree {
    HashMap<Integer,Integer> feat_surv_hashmap = new HashMap();
    ArrayList<Integer> temp_AL = new ArrayList<Integer>();
    public HashMap<Integer,Integer> distributor(ArrayList<Integer> survival_rate_col, ArrayList<Integer> feature_col){
        for(int i=0;i<feature_col.size();i++){
                if(feat_surv_hashmap.containsKey(feature_col.get(i))){
                    //SKIP
                }
                else{
                    //temp_AL.add(feature_col.get(i));
                    feat_surv_hashmap.put(feature_col.get(i),0);
                    System.out.println(feat_surv_hashmap);
                }
        }               // This code is supposed to create hashmap entries for unique elements in the feature columns

        for(int i=0;i<feature_col.size();i++){  //HAVE TO WORK ON THIS CODE, DOESN't WORK YET, ** NOW SHOULD WORK
            if(survival_rate_col.get(i)==1)
            {
                int val = feat_surv_hashmap.get(feature_col.get(i));
                val++;
                feat_surv_hashmap.replace(feature_col.get(i),val);
                System.out.println(feat_surv_hashmap.values());
            }
        } // This loop is supposed to count the number of times an entry got a survivor as yes




        return feat_surv_hashmap;

    }
}
