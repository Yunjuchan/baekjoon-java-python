import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        List<Integer> A = new ArrayList<>();
        Deque<Integer> P = new ArrayDeque<>();
        for (int p : progresses) {
            P.offer(p);
        }
        Deque<Integer> S = new ArrayDeque<>();
        for (int s : speeds) {
            S.offer(s);
        }
        while (!P.isEmpty()) {
            int cnt = 1;
            int p = P.poll();
            int s = S.poll();
            int res = 100 - p;
            int day = (res / s) + (res % s == 0 ? 0 : 1);
            // System.out.println("p: " + p + " s: " + s + " res: " + res);
            // System.out.println("배포까지 걸리는 시간: " + day);
            while (!P.isEmpty()) {
                int plusP = P.poll();
                int plusS = S.poll();
                if (plusP + plusS * day >= 100) {
                    cnt++;
                } else {
                    P.offerFirst(plusP);
                    S.offerFirst(plusS);
                    break;
                }
            }
            A.add(cnt);
        }
        
        int[] answer = new int[A.size()];
        for (int i=0; i<A.size(); i++) {
            answer[i] = A.get(i);
        }
        return answer;
    }
}