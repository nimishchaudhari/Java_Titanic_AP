import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Survival_parser {
    public ArrayList<Integer> generate_array_of_survival_rate(ArrayList<ArrayList<String>> ip)
    {
        ArrayList<Integer> arrayList_of_survival_rate = new ArrayList<Integer>();
        for(int i=1; i<ip.size();i++){
            List<String> line = ip.get(i);
            String surv = line.get(0);
            //System.out.println(surv);
            arrayList_of_survival_rate.add(Integer.parseInt(surv));

        }

        return arrayList_of_survival_rate;
    }
}
