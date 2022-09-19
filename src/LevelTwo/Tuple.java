package LevelTwo;

import java.util.*;
import java.util.stream.Collectors;


// Lv 2. 튜플
public class Tuple {
    private static int[] solution(String s){
        s = s.substring(2, s.length() - 2);

        String[] elems = s.split("},\\{");
        List<String> elemArray = Arrays.asList(elems);
        elemArray.sort(Comparator.comparingInt(String::length));

        LinkedHashSet<Integer> numberSet = new LinkedHashSet<>();
        int[] answer = new int[elemArray.size()];

        for (String elem : elemArray) {
            String[] numbers = elem.split(",");
            List<String> numberArray = Arrays.asList(numbers);
            numberSet.addAll(numberArray.stream().map(Integer::parseInt).collect(Collectors.toList()));
        }

        int i  = 0;
        for (Integer num : numberSet){
            answer[i++] = num;
        }

        return answer;
    }
    public static void main(String[] args) {
        String input = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] result = solution(input);
        for (int elem : result)
            System.out.print(elem + " ");
    }
}
