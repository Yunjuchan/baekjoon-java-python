import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] lock = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if (lock[i] == 'A') {
                continue;
            } else if (K > 'Z' - lock[i]) {
                K -= 'Z' - lock[i] + 1;
                lock[i] = 'A';
            }
        }
        lock[N - 1] = (char) ((lock[N - 1] - 'A' + K) % 26 + 'A');
        for (int i = 0; i < N; i++) {
            System.out.print(lock[i]);
        }
        System.out.println();
    }
}