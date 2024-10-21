
import java.util.*;

class Solution {
    
    public static Set<Integer> S = new HashSet<>();
    public static boolean[] isNotPrime, visited;
    
    public static void dfs(int level, String numbers, String now) {
        if (!now.equals("")) {
            int number = Integer.parseInt(now);
            if (!isNotPrime[number]) {
                S.add(number);
            }
        }
        if (level == numbers.length()) {
            return;
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            String n = String.valueOf(numbers.charAt(i));
            dfs(level+1, numbers, now+n);
            visited[i] = false;
        }
    }
    
    public int solution(String numbers) {
        
        isNotPrime = new boolean[10000000];
        visited = new boolean[numbers.length()];
        isNotPrime[0] = isNotPrime[1] = true;
        int maxNumber = (int) (Math.sqrt(10000000));
        
        for (int i=2; i<maxNumber; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j=2; i*j<10000000; j++) {
                isNotPrime[i*j] = true;
            }
        }
        dfs(0, numbers, "");
        int answer = S.size();
        return answer;
    }
}