package LevelTwo;

//Lv 2. 이진 변환 반복하기
public class BinaryTransformation {
    private static int countZero(String s){
        int counts = 0, startIndex = 0;
        while (s.indexOf('0', startIndex) >= 0){
            counts++;
            startIndex = s.indexOf('0', startIndex) + 1;
        }
        return counts;
    }
    private static String Trans(int dem){
        StringBuilder num = new StringBuilder();
        while (dem != 0){
            num.append(dem%2);
            dem /= 2;
        }
        return num.reverse().toString();
    }
    private static int[] solution(String s){
        int[] answer = { 0, 0 };
        while(!s.equals("1")){
            answer[1] += countZero(s);
            s = s.replaceAll("0", "");
            s = Trans(s.length());
            answer[0]++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "110010101001";
        int[] sol = solution(s);
        for(int elem : sol)
            System.out.print(elem + " ");
    }
}
