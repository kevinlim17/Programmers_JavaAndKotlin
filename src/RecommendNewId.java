//Lv 1. 신규 아이디 추천
public class RecommendNewId {
    private static String solution(String new_id){
        //Step 1
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());
        //Step 2
        answer = new StringBuilder(answer.toString().replaceAll("[^0-9a-z._-]", ""));
        //Step 3
        answer = new StringBuilder(answer.toString().replaceAll("[.]{2,}", "."));
        //Step 4
        if(answer.toString().startsWith("."))
            answer = new StringBuilder(answer.substring(1));
        if(answer.toString().endsWith("."))
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        /*
            answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));
         */
        //Step 5
        if(answer.toString().equals(""))
            answer = new StringBuilder("a");
        //Step 6
        if(answer.length() > 15){
            answer = new StringBuilder(answer.substring(0, 15));
            if(answer.toString().endsWith("."))
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
            /*
                answer = new StringBuilder(answer.toString().replaceAll("[.]$", "")); //$ 앞의 regex가 String을 끝맺는지 확인.
             */
        }
        //Step 7
        while(answer.length() < 3){
            answer.append(answer.charAt(answer.length() - 1));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(id));
    }
}
