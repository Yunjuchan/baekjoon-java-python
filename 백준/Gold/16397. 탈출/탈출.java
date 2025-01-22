import java.io.*;
import java.util.*;

public class Main {

    public static class Number {
        int n;
        int cnt;

        public Number(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_000];
        visited[N] = true;
        Queue<Number> que = new LinkedList<>();
        que.offer(new Number(N, 0));
        while (!que.isEmpty()) {
            Number number = que.poll();
            if (number.n == G) {
                System.out.println(number.cnt);
                return;
            }
            if (number.cnt == T) {
                continue;
            }
            int a = number.n + 1;
            int b = number.n * 2;
            if (a < 100_000 && !visited[a]) {
                que.offer(new Number(a, number.cnt+1));
                visited[a] = true;
            }

            if (b > 0 && b < 100_000) {
                String strB = String.valueOf(b);
                b -= (int) Math.pow(10, strB.length()-1);
                if (!visited[b]) {
                    que.offer(new Number(b, number.cnt+1));
                    visited[b] = true;
                }
            }
        }
        System.out.println("ANG");
    }
}