import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int[] cnt = new int[10001];
        for (int c : citations) {
            for (int i = c; i >= 0; i--) {
                cnt[i] += 1;
            }
        }
        
        for (int i = 0; i <= 10000; i++) {
            if (cnt[i] >= i) {
                answer = i;
            }
        }
        
        return answer;
    }
}