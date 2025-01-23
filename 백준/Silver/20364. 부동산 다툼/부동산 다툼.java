import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N+1];
            for (int q=0; q<Q; q++) {
                boolean possible = true;
                int x = Integer.parseInt(br.readLine());
                int n = x;
                while (x > 0) {
                    if (visited[x]) {
                        possible = false;
                        n = x;
                    }
                    x /= 2;
                }
                if (possible) {
                    visited[n] = true;
                    System.out.println(0);
                } else {
                    System.out.println(n);
                }
            }
        }
    }