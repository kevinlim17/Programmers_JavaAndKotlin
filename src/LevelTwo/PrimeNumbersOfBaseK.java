package LevelTwo;

//Lv 2. k 진수에서 소수 개수 구하기
public class PrimeNumbersOfBaseK {
    private static boolean isPrime(long num){
        for (long i = 2; i <= (long) Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    private static String convertBase(long base10, int k){
        StringBuilder baseK = new StringBuilder();
        while(base10 != 0){
            baseK.append(base10 % k);
            base10 /= k;
        }
        return baseK.reverse().toString();
    }
    private static int solution(int n, int k){
        int count = 0;
        String n_baseK = convertBase(n, k);
        String[] numbers = n_baseK.split("0");
        for (String elem : numbers){
            if (elem.isEmpty())
                continue;
            long number = Long.parseLong(elem);
            if(number >= 2 && isPrime(number))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int result1 = solution(437674, 3);
        int result2 = solution(110011, 10);
        System.out.println(result1 + " " + result2);
    }
}
