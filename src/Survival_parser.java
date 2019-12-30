import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Survival_parser {
    public ArrayList<Integer> generate_array_of_survival_rate(ArrayList<ArrayList<String>> ip)
    {
        ip.remove(0);
        //ip.remove(ip.size());
        //System.out.println(ip.get(0));
        ArrayList<Integer> arrayList_of_survival_rate = new ArrayList<Integer>();
        for(int i=0; i<ip.size();i++){
            ArrayList<String> line = ip.get(i);
            String surv = line.get(0);
            //  System.out.println("ici "+i+ ip.get(i) +"  " + surv);
            arrayList_of_survival_rate.add(Integer.parseInt(surv));

        }
        //arrayList_of_survival_rate.remove(0);

        return arrayList_of_survival_rate;
    }
    public ArrayList<Integer> testset_survival(){
        CSVReader csvr = new CSVReader();
        ArrayList<ArrayList<String>> testset_surv = csvr.read_CSV("/Users/nimishchaudhari/IdeaProjects/AP_DA/src/gender_submission.csv",false);
        ArrayList<String> survived = testset_surv.get(1);
        ArrayList<Integer> One_or_zero = new ArrayList<Integer>();
        for (String s: survived
             ) {
            One_or_zero.add(Integer.parseInt(s));

        }
        return One_or_zero;
    }

}
