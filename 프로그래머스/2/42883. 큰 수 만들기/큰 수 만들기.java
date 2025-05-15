import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int N = number.length();
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            int x = number.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() < x) {
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        
        while (k-- > 0) {
            stack.pop();
        }

        for (int n : stack) {
            answer += n;
        }
        
        return answer;
    }
}