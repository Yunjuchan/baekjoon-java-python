import java.io.*;
import java.util.*;

public class Main {
    static int[] directY = new int[]{1,0,-1,0};
    static int[] directX = new int[]{0,1,0,-1};
    static List<List<Integer>> adj;
    static int D = (int)(Math.pow(10, 9) + 7);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] DP = new long[N+1][8];
        adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
            DP[i][0] = 1;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        for (int i=1; i<8; i++) {
            for (int j=1; j<=N; j++) {
                for (int next : adj.get(j)) {
                    DP[j][i] += DP[next][i-1];
                }
                DP[j][i] %= D;
            }
        }
        long result = 0;
        for (int i=1; i<=N; i++) {
            result += DP[i][7];
        }
        System.out.println((result % D));
    }
}