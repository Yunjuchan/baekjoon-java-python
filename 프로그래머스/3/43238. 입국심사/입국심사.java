import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long s = 0;
        long e = 0;
        for (int t : times) {
            e = Math.max(e, t);
        }
        
        e *= n;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = 0;
            
            for (int t : times) {
                cnt += mid / (long) t;
            }
            
            if (cnt >= n) {
                answer = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return answer;
    }
}