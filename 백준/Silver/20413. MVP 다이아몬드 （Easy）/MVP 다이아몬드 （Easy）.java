import java.io.*;
import java.util.*;
public class Main {

    static long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int b = 0;
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        String level = br.readLine();
        int[] arr = new int[N];
        int first = level.charAt(0);
        if (first == 'B') {
            arr[0] = s - 1;
        } else if (first == 'S') {
            arr[0] = g - 1;
        } else if (first == 'G') {
            arr[0] = p - 1;
        } else if (first == 'P') {
            arr[0] = d - 1;
        } else {
            arr[0] = d;
        }

        for (int i = 1; i < N; i++) {
            char c = level.charAt(i);
            if (c == 'B') {
                arr[i] = (s - 1) - arr[i - 1];
            } else if (c == 'S') {
                arr[i] = (g - 1) - arr[i - 1];
            } else if (c == 'G') {
                arr[i] = (p - 1) - arr[i - 1];
            } else if (c == 'P') {
                arr[i] = (d - 1) - arr[i - 1];
            } else {
                arr[i] = d;
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += arr[i];
        }

        System.out.println(answer);

    }
}