import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int level, String now) {

        if (level == N) {
            list.add(now);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation(level + 1, now + "" + i + " ");
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        permutation(0, "");

        Collections.sort(list);

        for (String p : list) {
            sb.append(p).append("\n");
        }

        System.out.println(sb);
    }
}
