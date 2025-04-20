import java.util.*;

class Solution {
    
    public static int findMax(int[] priorities) {
        int max = 0;
        for (int p : priorities) {
            max = Math.max(max, p);
        }
        return max;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int N = priorities.length;
        int idx = 0;
        int max = 0;
        for (int p : priorities) {
            max = Math.max(max, p);
        }
        
        while (true) {
            int i = idx % N;
            if (priorities[i] == max) {
                priorities[i] = 0;
                answer++;
                if (i == location) {
                    return answer;
                }
                max = findMax(priorities);
            }    
            idx++;
        }
    }
}