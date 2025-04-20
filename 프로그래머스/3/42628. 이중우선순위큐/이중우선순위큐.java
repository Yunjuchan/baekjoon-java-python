import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (String operation : operations) {
            st = new StringTokenizer(operation);
            char query = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            
            if (query == 'I') {
                maxHeap.offer(-x);
                minHeap.offer(x);
            } else {
                if (x == -1) {
                    if (minHeap.isEmpty()) {
                        continue;
                    }
                    int pop = minHeap.poll();
                    maxHeap.remove(-pop);
                } else {
                    if (maxHeap.isEmpty()) {
                        continue;
                    }
                    int pop = maxHeap.poll();
                    minHeap.remove(-pop);
                }
            }
        }
        
        if (maxHeap.isEmpty()) {
            answer = new int[] {0, 0};
        } else {
            answer[0] = -maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        return answer;
    }
}