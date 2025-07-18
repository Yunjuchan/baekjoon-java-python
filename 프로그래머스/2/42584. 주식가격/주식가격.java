import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty()) {
                if (stack.peek()[1] > prices[i]) {
                    int[] prev = stack.pop();
                    answer[prev[0]] = i - prev[0];
                } else {
                    break;
                }
            }
            
            stack.push(new int[] {i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] res = stack.pop();
            answer[res[0]] = n - 1 - res[0];
        }
        
        return answer;
    }
}