import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] cats = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);

        int s = 0;
        int e = N - 1;
        while (s < e) {
            if (cats[s] + cats[e] <= K) {
                answer++;
                s++;
                e--;
            } else {
                e--;
            }
        }

        System.out.println(answer);
    }
}