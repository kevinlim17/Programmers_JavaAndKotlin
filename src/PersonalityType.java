import java.util.LinkedHashMap;

 //Lv1. 성격 유형 검사하기
public class PersonalityType {
    static LinkedHashMap<Character, Integer> surveyDataSet = new LinkedHashMap<>();

    private static void setScore(String q, int score){
        char key;
        if(score <= 0){
            key = q.charAt(0);
            score = Math.abs(score);
        }
        else {
            key = q.charAt(1);
        }
        surveyDataSet.put(key, surveyDataSet.get(key) + score);
    }

    private static String solution(String[] survey, int[] choice){
        String types = "RTCFJMAN";
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < types.length(); i += 2){
            surveyDataSet.put(types.charAt(i), 0);
            surveyDataSet.put(types.charAt(i+1), 0);
        }
        for (int i = 0; i < survey.length ; i++) {
            String question = survey[i];
            int selection = choice[i];
            setScore(question, selection-4);
        }
        for (int i = 0; i < types.length(); i += 2){
            if(surveyDataSet.get(types.charAt(i)) < surveyDataSet.get(types.charAt(i+1))){
                answer.append(types.charAt(i + 1));
            }
            else{
                answer.append(types.charAt(i));
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        String[] strings = {"AN", "CF", "MJ", "RT", "NA"};
        int[] integers = {5, 3, 2, 7, 5};
        System.out.println(solution(strings, integers));
    }
}
