import java.io.*;
import java.util.*;

public class Main {
    static int N, diff = Integer.MAX_VALUE;
    static int[] gom = new int[3];
    static int[][] color;

    public static void dfs(int start, int level, int[][] now) {
        if (level > 1) {
            int tmp = 0;

            for (int i=0; i<3; i++) {
                int c = 0;
                for (int j=0; j<level; j++) {
                    c += now[j][i];
                }
                tmp += Math.abs(gom[i] - c / level);
            }
            diff = Math.min(diff, tmp);
        }

        if (level == 7) {
            return;
        }
        for (int i=start; i<N; i++) {
            now[level] = color[i].clone();
            dfs(i+1, level+1, now);
            now[level] = new int[3];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        color = new int[N][3];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<3; i++) {
            gom[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, new int[7][3]);
        System.out.println(diff);

    }
}