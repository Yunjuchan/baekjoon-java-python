import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        Queue<int[]> que = new LinkedList<>();
        PriorityQueue<int[]> que2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });


        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            que.offer(new int[]{p, t});
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            que2.offer(new int[]{p, t, c});
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i<W) {
            int cost = 0;
            int[] nowP = que.poll();
            while (true) {
                nowP[1]--;
                cost++;
                i++;
                sb.append(nowP[0]).append("\n");
                if (!que2.isEmpty() && que2.peek()[2] == i) {
                    que.offer(que2.poll());
                }

                if (i >= W) break;
                if (cost == T && nowP[1] != 0) {
//                    System.out.println("i: " + i);
//                    System.out.println("customer: " + nowP[0]);
                    que.offer(nowP);
                    break;
                } else if (nowP[1] == 0) {
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}