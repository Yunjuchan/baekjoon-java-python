import java.io.*;
import java.util.*;

public class Main {
    static int [][] P;
    static int [][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        P = new int[N][3];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                P[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int INF = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        // 맨 처음 어디에서 시작했는지 체크하기
        for (int i=0; i<3; i++) {
            DP = new int[N][3];
            DP[0][i] = P[0][i];
            DP[0][(i+1)%3] = INF;
            DP[0][(i+2)%3] = INF;
            for (int j=1; j<N; j++) {
                for (int k=0; k<3; k++) {
                    if (j == N-1 && k == i) {
                        DP[j][k] = INF;
                        continue;
                    }
                    if (Math.min(DP[j-1][(k+1)%3], DP[j-1][(k+2)%3]) == INF) {
                        DP[j][k] = INF;
                    } else {
                        DP[j][k] = Math.min(DP[j-1][(k+1)%3], DP[j-1][(k+2)%3]) + P[j][k];
                    }
                }
            }
            for (int t=0; t<3; t++) {
                result = Math.min(result, DP[N-1][t]);
            }
        }
        System.out.println(result);
    }
}