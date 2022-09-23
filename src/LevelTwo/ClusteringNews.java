package LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//Lv 2. 뉴스 클러스터링
public class ClusteringNews {
    private static List<String> union(ArrayList<String> text1, ArrayList<String> text2){
        List<String> arr1 = new ArrayList<>(text1.subList(0, text1.size()));
        List<String> arr2 = new ArrayList<>(text1.subList(0, text1.size()));

        for(String elem : text2){
            if(!arr1.contains(elem))
                arr2.add(elem);
            else
                arr1.remove(elem);
        }
        return arr2;
    }
    private static List<String> intersection(ArrayList<String> text1, ArrayList<String> text2){
        List<String> arr = new ArrayList<>();
        for(String elem : text2){
            if (text1.contains(elem)){
                text1.remove(elem);
                arr.add(elem);
            }
        }
        return arr;
    }
    private static ArrayList<String> formalize(String str){
        ArrayList<String> textSet = new ArrayList<>();
        //String text = str.replaceAll("[^A-Za-z]", "").toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String split = String.valueOf(str.charAt(i)) + str.charAt(i+1);
            if (Pattern.matches("[A-Za-z]{2}", split))
                textSet.add(split.toUpperCase());
        }
        return textSet;
    }
    private static int solution(String str1, String str2){
        ArrayList<String> textSet1 = formalize(str1);
        ArrayList<String> textSet2 = formalize(str2);

        if (textSet1.isEmpty() && textSet2.isEmpty()) return 65536;

        List<String> textSet_u = union(textSet1, textSet2);
        List<String> textSet_i = intersection(textSet1, textSet2);

        float answer = (float)textSet_i.size() / (float)textSet_u.size() * 65536;
        return (int) answer;
    }
    public static void main(String[] args) {
        String param1 = "handshake", param2 = "shake hands";
        System.out.println(solution(param1, param2));
    }
}
