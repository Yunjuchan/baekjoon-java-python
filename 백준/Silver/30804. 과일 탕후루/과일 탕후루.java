import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] fruits = new int[N];
        int[] used = new int[10];
        int fruitsCount = 0;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        while (true) {
            if (fruitsCount <= 2) {
                if (e == N) {
                    answer = Math.max(answer, e - s);
                    break;
                } else {
                    used[fruits[e]]++;
                    if (used[fruits[e]] == 1) {
                        fruitsCount++;
                    }
                    e++;
                }
            } else {
                answer = Math.max(answer, e - s - 1);
                used[fruits[s]]--;
                if (used[fruits[s]] == 0) {
                    fruitsCount--;
                }
                s++;
            }
        }
        System.out.println(answer);
    }
}