import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        int cur = 0;
        int idx = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            que.offer(0);
        }
        
        while (idx < n) {
            int esc = que.poll();
            cur -= esc;
            if (cur + truck_weights[idx] <= weight) {
                que.offer(truck_weights[idx]);
                cur += truck_weights[idx];
                idx++;
            } else {
                que.offer(0);
            }
            answer += 1;
        }
        
        answer += bridge_length;
        return answer;
    }
}