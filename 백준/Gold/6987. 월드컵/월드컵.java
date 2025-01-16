import java.io.*;
import java.util.*;

public class Main {
    static boolean isPossible;
    static boolean[][] visited;
    static int[][] result;

    static void dfs(int i, int j, int level, int[][] arr) {
        if (level == 15) {
            for (int a=0; a<6; a++) {
                for (int b=0; b<3; b++) {
                   if (arr[a][b] != result[a][b]) {
                       return;
                   }
                }
            }
            isPossible = true;
            return;

        }
        if (j == 5) {
            arr[i][0]++;
            arr[j][2]++;
            dfs(i+1, i+2, level+1, arr);
            arr[i][0]--;
            arr[j][2]--;
            arr[i][1]++;
            arr[j][1]++;
            dfs(i+1, i+2, level+1, arr);
            arr[i][1]--;
            arr[j][1]--;
            arr[i][2]++;
            arr[j][0]++;
            dfs(i+1, i+2, level+1, arr);
            arr[i][2]--;
            arr[j][0]--;
        } else {
            arr[i][0]++;
            arr[j][2]++;
            dfs(i, j+1, level+1, arr);
            arr[i][0]--;
            arr[j][2]--;
            arr[i][1]++;
            arr[j][1]++;
            dfs(i, j+1, level+1, arr);
            arr[i][1]--;
            arr[j][1]--;
            arr[i][2]++;
            arr[j][0]++;
            dfs(i, j+1, level+1, arr);
            arr[i][2]--;
            arr[j][0]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t=0; t<4; t++) {
            st = new StringTokenizer(br.readLine());
            result = new int[6][3];
            int[] sum = new int[3];
            boolean flag = false;
            visited = new boolean[6][6];
            isPossible = false;

            for (int i=0; i<6; i++) {
                int s = 0;
                for (int j=0; j<3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                    sum[j] += result[i][j];
                    s += result[i][j];
                }
                if (s != 5) {
                    flag = true;
                }
            }

            if (flag) {
                sb.append(0).append(" ");
                continue;
            }

            if (sum[0] + sum[1] + sum[2] != 30) {
                sb.append(0).append(" ");
                continue;
            }

            if (sum[0] != sum[2]) {
                sb.append(0).append(" ");
                continue;
            }

            dfs(0,1, 0, new int[6][3]);

            if (isPossible) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}