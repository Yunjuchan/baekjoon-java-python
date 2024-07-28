import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] Map = new char[N][M];
        int[][][] cnt = new int[N+1][M+1][3];
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            Map[i] = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                int[] now = new int[3];
                if (Map[i][j] == 'J') {
                    now[0]++;
                } else if (Map[i][j] == 'O') {
                    now[1]++;
                } else if (Map[i][j] == 'I'){
                    now[2]++;
                }
                for (int k=0; k<3; k++) {
                    cnt[i+1][j+1][k] = cnt[i+1][j][k] + cnt[i][j+1][k] - cnt[i][j][k] + now[k];
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            int[] result = new int[3];
            for (int j = 0; j < 3; j++) {
                result[j] = cnt[ey][ex][j] - cnt[ey][sx-1][j] - cnt[sy-1][ex][j] + cnt[sy-1][sx-1][j];
            }
            for (int j=0; j<3; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}