package LevelTwo;

import java.util.ArrayList;

//Lv 2. 영어 끝말잇기
public class Kkeunmaritgi {
    static ArrayList<String> spokenList = new ArrayList<>();
    private static int[] solution(int n, String[] words){
        int[] answer = { 0, 0 };
        spokenList.add(words[0]);
        for (int i = 1; i < words.length; i++){
            if (spokenList.contains(words[i])){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            else if (words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            spokenList.add(words[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        int members = 3;
        String[] words_arr = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        int[] sol = solution(members, words_arr);
        for(int elem : sol)
            System.out.print(elem + " ");
    }
}
