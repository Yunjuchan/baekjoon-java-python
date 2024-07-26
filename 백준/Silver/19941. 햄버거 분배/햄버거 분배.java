import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] line = br.readLine().toCharArray();
        boolean[] visited = new boolean[N];
        int result = 0;
        for (int i=0; i<N; i++) {
            if (line[i] == 'P') {
                for (int j=i-K; j<=i+K; j++) {
                    if (j < 0 || j >= N || visited[j]) {
                        continue;
                    }
                    if (line[j] == 'H') {
                        visited[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}