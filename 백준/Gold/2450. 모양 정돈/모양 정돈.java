import java.io.*;
import java.util.*;

public class Main {

    static int N, result = Integer.MAX_VALUE;
    static int[] arr, cnt;

    public static int calcCnt(int[] order) {
        int[][] status = new int[3][3];
        int[] original = new int[4];
        int tmp = 0;
        int res = 0;

        for (int i = 1; i <= 3; i++) {
            original[i] = cnt[order[i - 1]] + original[i - 1];
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == order[0]) {
                if (i >= original[2]) {
                    status[0][2]++;
                } else if (i >= original[1]){
                    status[0][1]++;
                }
            } else if (arr[i] == order[1]) {
                if (i >= original[2]) {
                    status[1][2]++;
                } else if (i < original[1]) {
                    status[1][0]++;
                }
            } else {
                if (i < original[1]) {
                    status[2][0]++;
                } else if (i < original[2]) {
                    status[2][1]++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int min = Math.min(status[i][j], status[j][i]);
                tmp += min;
                res += status[i][j] + status[j][i] - 2 * min;
                status[i][j] = status[j][i] = 0;
            }
        }

        return tmp + res / 3 * 2;
    }

    public static void dfs(int level, boolean[] visited, int[] order) {
        if (level == 3) {
            result = Math.min(result, calcCnt(order));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order[level] = i;
            dfs(level + 1, visited, order);
            order[level] = 0;
            visited[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        dfs(0, new boolean[4], new int[3]);
        System.out.println(result);
    }
}