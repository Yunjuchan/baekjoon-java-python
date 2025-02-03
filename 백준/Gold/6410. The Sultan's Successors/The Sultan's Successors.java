import java.io.*;
import java.util.*;

public class Main {
    static int result;
    static int[] visited;
    static int[][] arr;

    public static int calc() {
        int value = 0;
        for (int i = 0; i < 8; i++) {
            value += arr[i][visited[i]];
        }
        return value;
    }

    public static void dfs(int level) {
        if (level == 8) {
            result = Math.max(result, calc());
            return;
        }

        boolean[] cant = new boolean[8];
        for (int i = 0; i < level; i++) {
            cant[visited[i]] = true;
            int left = visited[i] - (level - i);
            int right = visited[i] + (level - i);
            if (left >= 0) {
                cant[left] = true;
            }
            if (right < 8) {
                cant[right] = true;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (cant[i]) {
                continue;
            }
            visited[level] = i;
            dfs(level + 1);
            visited[level] = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            result = 0;
            visited = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
            arr = new int[8][8];

            for (int i = 0; i < 8; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0);
            System.out.printf("%5d\n", result);
        }
    }
}