import java.util.*;

class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int N = name.length();
        int move = N - 1;
        int[] count = new int[N];
        int s = -1;
        int e = 0;
        for (int i = 0; i < N; i++) {
            count[i] = name.charAt(i) - 'A';
            
            if (count[i] > 13) {
                count[i] = 26 - count[i];
            }
            answer += count[i];
        }
        
        for (int i = 0; i < N; i++) {
            int next = i + 1;
            while (next < N && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + N - next + Math.min(i, N - next));
        }
        
        return answer + move;
    }
}