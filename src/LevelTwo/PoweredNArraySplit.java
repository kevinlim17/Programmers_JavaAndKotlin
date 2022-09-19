package LevelTwo;

import java.util.ArrayList;

// Lv 2. n^2 배열 자르기
public class PoweredNArraySplit {
    public static int[] solution(int n, long left, long right){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(long i = left; i <= right; i++){
            long low = i / (long) n;
            long col = i % (long) n;
            if (col <= low)
                arrayList.add(Integer.parseInt(String.valueOf(low+1)));
            else
                arrayList.add(Integer.parseInt(String.valueOf(col+1)));
        }
        int[] answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public static void main(String[] args) {
        int[] sol = solution(4, 7, 14);
        for (int elem : sol)
            System.out.print(elem + " ");
    }
}
