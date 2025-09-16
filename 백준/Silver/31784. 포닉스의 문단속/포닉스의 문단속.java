import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] lock = br.readLine().toCharArray();
        
        for (int i = 0; i < N - 1; i++) {
            if (lock[i] == 'A') {
                continue;
            }

            int dist = 'Z' - lock[i] + 1;
            if (K >= dist) {
                K -= dist;
                lock[i] = 'A';
                if (K == 0) {
                    break;
                }
            }
        }
        
        K %= 26;
        if (K != 0) {
            int last = lock[N - 1] - 'A';
            lock[N - 1] = (char) ((last + K) % 26 + 'A');
        }
        
        System.out.println(new String(lock));
    }
}