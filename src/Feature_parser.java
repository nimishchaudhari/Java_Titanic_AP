import java.util.ArrayList;
import java.util.List;

public class Feature_parser {
    public ArrayList<Integer> generate_array_of_feature(ArrayList<ArrayList<String>> ip,int index,boolean is_it_gender)
    {
        ArrayList<Integer> arrayList_of_feature = new ArrayList<Integer>();
        for(int i=1; i<ip.size();i++){
            int gender_to_number;
            List<String> line = ip.get(i);
            String feat = line.get(index);
            if(is_it_gender) {

                // here we convert all gender values from str to int
                if (feat.equals("male")) {
                    gender_to_number = 0;
                } else {
                    gender_to_number = 1;
                }
                arrayList_of_feature.add(gender_to_number);
            }
            else{
                    //System.out.println( feat);
                Float rounded_number = Float.parseFloat(feat);
                    arrayList_of_feature.add(Math.round(rounded_number));

            }

            }

        return arrayList_of_feature;
    }
    //private String fix_null_values(String val){
    //    return "99";
    //}
}
