import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Deque<Character> que = new ArrayDeque<>();
        boolean[] isPrime = new boolean[50000001];
        isPrime[1] = true;
        for (int i=2; i<Math.sqrt(50000001); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j=2; i*j<=50000000; j++) {
                isPrime[i*j] = true;
            }
        }
        int[] cnt = new int[2];
        boolean direct = true;
        for (int i=1; i<=N; i++) {
            if (isPrime[i]) {
                if (direct) {
                    que.offerLast('B');
                }
                else {
                    que.offerFirst('B');
                }
                cnt[0]++;
            } else {
                if (direct) {
                    if (!que.isEmpty()) {
                        if (que.getLast() == 'B') {
                            que.pollLast();
                            que.offerLast('S');
                            cnt[0]--;
                            cnt[1]++;
                        }
                        else {
                            que.offerLast('S');
                        }
                    }
                    que.offerLast('S');
                    cnt[1]++;
                }
                else {
                    if (!que.isEmpty()) {
                        if (que.getFirst() == 'B') {
                            que.pollFirst();
                            que.offerFirst('S');
                            cnt[0]--;
                            cnt[1]++;
                        }
                        else {
                            que.offerFirst('S');
                        }
                    }
                    que.offerFirst('S');
                    cnt[1]++;
                }
                direct = !direct;
            }
        }
        System.out.println(cnt[0] + " " + cnt[1]);
        
    }
}