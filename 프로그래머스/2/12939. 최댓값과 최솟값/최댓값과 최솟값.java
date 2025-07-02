import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] stringNumbers = s.split(" ");
        
        int N = stringNumbers.length;
        int[] numbers = new int[N];
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        Arrays.sort(numbers);
        
        answer = numbers[0] + " " + numbers[N - 1];
        return answer;
    }
}