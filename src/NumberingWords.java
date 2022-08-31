import java.util.HashMap;

//Lv1. 숫자 문자열과 영단어
public class NumberingWords {
    static HashMap<String, Integer> table = new HashMap<>();
    private static Integer tokenizeWord(String substr, int startPos){
        int token_len = startPos + 1;
        while(table.getOrDefault(substr.substring(startPos, token_len), -1) == -1){
            token_len += 1;
        }
        return token_len;
    }
    private static int solution(String s){
        StringBuilder answer = new StringBuilder();
        String[] words = { "zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine" };
        for (int i = 0; i < 10; i++)
            table.put(words[i], i);
        for (int i = 0; i < s.length();){
            if(Character.isDigit(s.charAt(i))) {
                answer.append(s.charAt(i));
                i++;
            } else{
                int wordSize = tokenizeWord(s, i);
                answer.append(table.get(s.substring(i,wordSize)));
                i += (wordSize - i);
            }
        }
        return Integer.parseInt(answer.toString());
    }
    public static void main(String[] args) {
        String s = "seven8ninenine";
        System.out.println(solution(s));
    }
}
