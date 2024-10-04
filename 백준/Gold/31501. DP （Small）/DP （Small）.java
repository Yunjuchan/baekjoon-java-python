import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] level = new int[N+1];
        int[] dpForward = new int[N+1];
        int[] dpBackward = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        // 순방향 DP
        for (int i = 1; i <= N; i++) {
            dpForward[i] = 1;
            for (int j = 1; j < i; j++) {
                if (level[j] < level[i]) {
                    dpForward[i] = Math.max(dpForward[i], dpForward[j] + 1);
                }
            }
        }

        // 역방향 DP
        for (int i = N; i >= 1; i--) {
            dpBackward[i] = 1;
            for (int j = N; j > i; j--) {
                if (level[j] > level[i]) {
                    dpBackward[i] = Math.max(dpBackward[i], dpBackward[j] + 1);
                }
            }
        }
        
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(dpForward[query] + dpBackward[query] - 1);
        }
    }
}