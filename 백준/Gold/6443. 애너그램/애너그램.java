import java.io.*;
import java.util.*;

public class Main {

    public static int L;
    public static boolean[] visited;
    public static String[] arr;
    public static StringBuilder sb;

    public static void dfs(int level, String now) {
        if (level == L) {
            sb.append(now).append("\n");
            return;
        }
        char lastUsed = '\0';  // 직전에 사용한 문자 저장
        for (int i = 0; i < L; i++) {
            if (visited[i] || arr[i].charAt(0) == lastUsed) {
                continue;
            }
            visited[i] = true;
            dfs(level + 1, now + arr[i]);
            visited[i] = false;
            lastUsed = arr[i].charAt(0);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            L = word.length();
            visited = new boolean[L];
            arr = new String[L];
            int[] tmp = new int[26];
            for (int j=0; j<L; j++) {
                tmp[word.charAt(j)-97]++;
            }

            int idx = 0;
            for (int j=0; j<26; j++) {

                while (tmp[j] > 0) {
                    arr[idx] = String.valueOf((char) (97+j));
                    tmp[j]--;
                    idx++;
                }
            }
            dfs(0, "");
        }
        System.out.println(sb.toString());
    }
}