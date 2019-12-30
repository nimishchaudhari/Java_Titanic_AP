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
                Float rounded_number = Float.parseFloat(feat);
                arrayList_of_feature.add(Math.round(rounded_number));

            }

            }
        //System.out.println(arrayList_of_feature);
        return arrayList_of_feature;
    }

    public ArrayList<ArrayList<Integer>> features_ready_to_use(ArrayList<ArrayList<String>> ipal){
        ipal.remove(0);
        ArrayList<ArrayList<Integer>> opal = new ArrayList<ArrayList<Integer>>();
        opal.add(generate_array_of_feature(ipal,1,false));
        opal.add(generate_array_of_feature(ipal,2,true));
        opal.add(generate_array_of_feature(ipal,3,false));
        opal.add(generate_array_of_feature(ipal,4,false));
        opal.add(generate_array_of_feature(ipal,5,false));


        return opal;
    }

    /*
    ArrayList<Integer> PClass = new ArrayList<Integer>();
        PClass = feature_parser.generate_array_of_feature(training_data,1,false);
        ArrayList<Integer> Sex = new ArrayList<Integer>();
        Sex = feature_parser.generate_array_of_feature(training_data,2,true);

        ArrayList<Integer> Age = new ArrayList<Integer>();
        Age = feature_parser.generate_array_of_feature(training_data,3,false);
        ArrayList<Integer> SibSP = new ArrayList<Integer>();
        ArrayList<Integer> ParCh = new ArrayList<Integer>();
        ParCh = feature_parser.generate_array_of_feature(training_data,5,false);
     */
}
