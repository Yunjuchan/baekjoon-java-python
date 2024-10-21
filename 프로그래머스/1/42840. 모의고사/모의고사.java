import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int[] c = new int[3];
        int[] answer = {};
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == st1[i % st1.length] ) {
                c[0]++;
            }
            if (answers[i] == st2[i % st2.length] ) {
                c[1]++;
            }
            if (answers[i] == st3[i % st3.length] ) {
                c[2]++;
            }
        }
        
        for (int i=0; i<3; i++) {
            if (c[i] > max) {
                max = c[i];
                list = new ArrayList<>();
                list.add(i+1);
            } else if (c[i] == max) {
                list.add(i+1);
            }
        }
        
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
     return result;
    }
}