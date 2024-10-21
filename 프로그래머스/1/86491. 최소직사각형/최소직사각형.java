import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxR = 0;
        int maxC = 0;
        
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int tmp = size[1];
                size[1] = size[0];
                size[0] = tmp;
            }
            
            if (maxR < size[0]) {
                maxR = size[0];
            }
                
            if (maxC < size[1]) {
                maxC = size[1];
            }
        }
        
        int answer = maxR * maxC;
            
        return answer;
    }
}