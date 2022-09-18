package LevelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    private static int solution(int cacheSize, String[] cities){
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for (String city : cities){
            city = city.toLowerCase();
            if(!cache.contains(city)){
                if (cacheSize == 0) {
                    answer += 5;
                    continue;
                }
                if (cache.size() < cacheSize)
                    cache.add(city);
                else{
                    cache.remove();
                    cache.add(city);
                }
                answer += 5;
            }
            else {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = { "Jeju", "Pangyo", "NewYork", "newyork" };
        System.out.println(solution(cacheSize, cities));
    }
}
