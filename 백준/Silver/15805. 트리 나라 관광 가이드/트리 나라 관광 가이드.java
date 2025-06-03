import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] route = new int[N];
        int K = 0;
        int prev = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int city = Integer.parseInt(st.nextToken());
            K = Math.max(K, city);
            route[i] = city;
        }
        int[] parents = new int[K + 1];
        boolean[] visited = new boolean[K + 1];


        for (int i = 0; i < N; i++) {
            if (!visited[route[i]]) {
                visited[route[i]] = true;
                parents[route[i]] = prev;
            }
            prev = route[i];
        }

        sb.append(K + 1).append("\n");
        for (int i = 0; i <= K; i++) {
            sb.append(parents[i]).append(" ");
        }
        System.out.println(sb);
    }
}