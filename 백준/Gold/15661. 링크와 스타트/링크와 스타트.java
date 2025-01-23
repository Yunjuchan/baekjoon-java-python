import java.io.*;
import java.util.*;

public class Main {
    static int N, result = Integer.MAX_VALUE, sum = 0;
    static int[][] arr;
    static boolean[] visited;
    public static void dfs(int start) {
        int teamA = 0;
        int teamB = 0;
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamB += arr[i][j] + arr[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(teamA - teamB));

        if (teamA >= teamB) {
            return;
        }

        for (int i=start; i<N; i++) {
            visited[i] = true;
            dfs(i+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
            }
        }
        dfs(0);
        System.out.println(result);
    }
}