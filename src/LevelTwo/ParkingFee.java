package LevelTwo;

import java.util.*;

//Lv. 2 주차 요금 계산
public class ParkingFee {
    static LinkedHashMap<String, Integer> ParkingRecord = new LinkedHashMap<>(); //Car number - Parking_Time
    static LinkedHashMap<String, Integer> ParkingPeriodRecord = new LinkedHashMap<>(); //Car number - Cumulative_Time
    static LinkedHashMap<String, Integer> ParkingFeeRecord = new LinkedHashMap<>(); // Car number - Fee

    private static int[] solution(int[] fees, String[] records){
        /*
         * fees[0] : 기본 시간(분)
         * fees[1] : 기본 요금(원)
         * fees[2] : 단위 시간(분)
         * fees[3] : 단위 요금(원)
         */
        for (String record : records){
            String[] split_record = record.split(" ");

            List<String> time_record = Arrays.asList(split_record[0].split(":"));
            Integer time = Integer.parseInt(time_record.get(0)) * 60 + Integer.parseInt(time_record.get(1));

            if (split_record[2].equals("OUT")){
                Integer cumulative_time = ParkingPeriodRecord.getOrDefault(split_record[1], 0) + time - ParkingRecord.get(split_record[1]);
                ParkingPeriodRecord.put(split_record[1], cumulative_time);
                ParkingRecord.put(split_record[1], 0);
            }
            else{
                ParkingRecord.put(split_record[1], time);
            }
        }

        for (String carNum : ParkingRecord.keySet()){
            if (ParkingRecord.get(carNum) != 0 || ParkingPeriodRecord.getOrDefault(carNum, -1) == -1) {
                int time = 60 * 23 + 59;
                Integer cumulative_time = ParkingPeriodRecord.getOrDefault(carNum, 0) + time - ParkingRecord.get(carNum);
                ParkingPeriodRecord.put(carNum, cumulative_time);
            }
        }

        List<String> carNumbers = Arrays.asList(ParkingPeriodRecord.keySet().toArray(new String[0]));
        carNumbers.sort(Comparator.naturalOrder());

        for (String key : carNumbers){
            Integer period = ParkingPeriodRecord.get(key);
            int fee = fees[1];
            if (period <= fees[0])
                ParkingFeeRecord.put(key, fee);
            else{
                double added  = (double) (period - fees[0]) / (double) fees[2];
                fee += (int) Math.ceil(added) * fees[3];
                ParkingFeeRecord.put(key, fee);
            }
        }

        return ParkingFeeRecord.values().stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] fee = { 1, 461, 1, 10 };
        String[] record = { "00:00 1234 IN" };
        for (int elem : solution(fee, record)) {
            System.out.print(elem + " ");
        }
    }
}
