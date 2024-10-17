import java.util.*;
class Solution {
    
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int s : scoville) {
            que.offer(s);
        }
        
        while (que.size() > 1) {
            int x = que.poll();
            if (x >= K) {
                return answer;
            }
            int y = que.poll();
            int mix = x + 2 * y;
            que.add(mix);
            answer++;
        }
        
        if (que.poll() >= K) {
            return answer;
        }
        
        return -1;
    }
}