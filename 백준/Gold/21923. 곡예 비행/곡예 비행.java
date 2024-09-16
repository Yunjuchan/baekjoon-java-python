import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] scores = new int[N][M];
        long[][] up = new long[N][M];
        long[][] down = new long[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int x = Integer.parseInt(st.nextToken());
                scores[i][j] = x;
            }
        }
        up[N-1][0] = scores[N-1][0];
        down[N-1][M-1] = scores[N-1][M-1];

        for (int j=1; j<M; j++) {
            up[N-1][j] = up[N-1][j-1] + scores[N-1][j];
        }

        for (int j=M-2; j>=0; j--) {
            down[N-1][j] = down[N-1][j+1] + scores[N-1][j];
        }

        for (int i=N-2; i>=0; i--) {
            up[i][0] = up[i+1][0] + scores[i][0];
            down[i][M-1] = down[i+1][M-1] + scores[i][M-1];
        }


        for (int i=N-2; i>=0; i--) {
            for (int j=1; j<M; j++) {
                up[i][j] = Math.max(up[i+1][j], up[i][j-1]) + scores[i][j];
            }
        }

        for (int i=N-2; i>=0; i--) {
            for (int j=M-2; j>=0; j--) {
                down[i][j] = Math.max(down[i+1][j], down[i][j+1]) + scores[i][j];
            }
        }
        
        long result = Long.MIN_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                result = Math.max(result, up[i][j]+down[i][j]);
            }
        }
        System.out.println(result);
    }
}