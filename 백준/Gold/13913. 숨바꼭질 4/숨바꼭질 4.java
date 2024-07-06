import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] path = new int[100001];
        for (int i=0; i<=100000; i++) {
            path[i] = -1;
        }

        que.offer(N);
        while (!que.isEmpty()) {
            int now = que.poll();
            if (now-1 >= 0 && path[now-1] == -1) {
                path[now-1] = now;
                que.offer(now-1);
            }
            if (now+1 <= 100000 && path[now+1] == -1) {
                path[now+1] = now;
                que.offer(now+1);
            }

            if (now != 0 && 2*now <= 100000 && path[2*now] == -1) {
                path[2*now] = now;
                que.offer(2*now);
            }
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        while (K != N) {
            stack.push(path[K]);
            K = path[K];
        }

        System.out.println((stack.size()-1));
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}