import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Lv 1. 2021 Dev-Matching : 로또의 최고 순위와 최저 순위
public class LottoRanking {
    private static int[] solution(int[] lottos, int[] win_nums){
        int[] answer = { 7, 7 };
        List<Integer> lotto = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> win_num = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        for(int selected : lottos){
            if (win_num.contains(selected)){
                answer[0]--;
                answer[1]--;
            }
            else if (selected == 0){
                answer[0]--;
            }
        }
        if (answer[0] == 7) answer[0] = 6;
        if (answer[1] == 7) answer[1] = 6;
        return answer;
    }
    public static void main(String[] args) {
        int[] lottos = { 44, 1, 0, 0, 31, 25 };
        int[] win_nums = { 31, 10, 45, 1, 6, 19 };
        int[] sol = solution(lottos, win_nums);
        for(int elem : sol)
            System.out.print(elem + " ");
    }
}
