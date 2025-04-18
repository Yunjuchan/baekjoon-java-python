import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        int answer = -1; 
        
        List<Set<Integer>> setList = new ArrayList<>();
        int x = 0;
        for (int i = 0; i <= 8; i++) {
            setList.add(new HashSet<>());
            setList.get(i).add(x);
            if (x == number) {
                return i;
            }
            x = x * 10 + N;
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j <= i / 2; j++) {
                for (int a : setList.get(j)) {
                    for (int b : setList.get(i - j)) {
                        setList.get(i).add(a + b);
                        if (a + b == number) {
                            return i;
                        }
                        
                        setList.get(i).add(a - b);
                        if (a - b == number) {
                            return i;
                        }
                        
                        setList.get(i).add(b - a);
                        if (b - a == number) {
                            return i;
                        }
                        
                        setList.get(i).add(a * b);
                        if (a * b == number) {
                            return i;
                        }
                        
                        if (a != 0) {
                            setList.get(i).add(b / a);
                            if (b / a == number) {
                                return i;
                            }
                        }
                        if (b != 0) {
                            setList.get(i).add(a / b);
                            if (a / b == number) {
                               return i;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}