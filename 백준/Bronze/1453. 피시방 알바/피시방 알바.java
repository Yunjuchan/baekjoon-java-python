import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] used = new boolean[101];
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (used[a]) {
                answer++;
            } else {
                used[a] = true;
            }
        }

        System.out.println(answer);
    }
}