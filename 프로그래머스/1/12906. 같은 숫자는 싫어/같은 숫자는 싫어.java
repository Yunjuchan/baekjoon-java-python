import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int[] answer = {};
        int prev = -1;
        List<Integer> A = new ArrayList<>();
        for (int x : arr) {
            if (prev != x) {
                A.add(x);
            }
            prev = x;
        }
        int[] tmp = new int[A.size()];
        for (int i=0; i<A.size(); i++) {
            tmp[i] = A.get(i);
        }
        answer = tmp.clone();
        
        return answer;
    }
}