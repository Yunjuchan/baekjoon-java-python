import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        int max = m;
        for (int i = 0; i < 24; i++) {
            if (!que.isEmpty()) {
                int[] top = que.peek();
                 if (i >= top[0]) {
                     max -= top[1] * m;
                     que.poll();
                 }
            }
            int over = players[i] - max;
            if (over >= 0) {
                int cnt = (over + m) / m;
                max += cnt * m;
                answer += cnt;
                que.offer(new int[] {i + k, cnt});
            }
            
        }
        return answer;
    }
}