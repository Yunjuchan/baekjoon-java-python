import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] cnt = new int[n+1];
        for (int i=1; i<=n; i++) {
            cnt[i]++;
        }
        
        for (int l : lost) {
            cnt[l]--;
        }
        
        for (int r : reserve) {
            cnt[r]++;
        }
        for (int i=1; i<=n; i++) {
            if (cnt[i] == 2) {
                for (int j=-1; j<2; j+=2) {
                    int adj = i+j;
                    if (adj <= 0 || adj > n) {
                        continue;
                    }
                    if (cnt[adj] == 0) {
                        cnt[adj] += 1;
                        cnt[i] -= 1;
                        break;
                    }
                }
            }
        }
        
        for (int i=1; i<=n; i++) {
            if (cnt[i] == 0) {
                answer--;
            }
        }
        
        return answer;
    }
}