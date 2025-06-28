import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int reinforce = 0;
        int[] items = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = -Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items);
        for (int i = 0; i < N; i++) {
            if (items[i] == 0) {
                break;
            }
            reinforce = Math.max(reinforce, i - items[i]);
        }

        reinforce = Math.min(reinforce, N);
        System.out.println(reinforce);
    }
}
