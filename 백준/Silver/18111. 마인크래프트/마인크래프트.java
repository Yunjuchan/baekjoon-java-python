import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int Max = 0;
        int Min = 257;
        int[][] G = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] > Max) {
                    Max = G[i][j];
                }
                if (G[i][j] < Min) {
                    Min = G[i][j];
                }
            }
        }

        int resultT = Integer.MAX_VALUE;
        int resultH = -1;

        for (int i=Min; i<=Max; i++) {
            int block = B;
            int t = 0;
            int[][] tmpG = new int[N][M];

            for (int j=0; j<N; j++) {
                tmpG[j] = G[j].clone();
            }

            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    int tmp = tmpG[j][k] - i;
                    if (tmp > 0) {
                        t += 2 * tmp;
                        block += tmp;
                    } else if (tmp < 0) {
                        t -= tmp;
                        block += tmp;
                    }
                }
            }

            if (block >= 0) {
                if (resultT >= t) {
                    resultT = t;
                    resultH = i;
                }
            }
        }
        System.out.println(resultT + " " + resultH);
    }
}