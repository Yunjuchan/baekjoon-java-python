import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] angle = new int[N];
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            angle[i] = Integer.parseInt(st.nextToken());
            que.offer(angle[i]);
            set.add(angle[i]);
        }

        while (!que.isEmpty()) {
            int a = que.poll();
            for (int i=0; i<N; i++) {
                for (int j=-1; j<=1; j+=2) {
                    int next = Math.abs(a + j * angle[i]) % 360;
                    if (set.contains(next)) {
                        continue;
                    }
                    que.offer(next);
                    set.add(next);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) {
            int Q = Integer.parseInt(st.nextToken());
            if (set.contains(Q)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}