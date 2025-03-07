import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int now;
        int d;

        public Node(int now, int d) {
            this.now = now;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            return this.d - other.d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");
            st = new StringTokenizer(br.readLine());
            int result = Integer.MAX_VALUE;

            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] friends = new int[P][2];

            List<List<int[]>> road = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                road.add(new ArrayList<>());
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    friends[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int prev = Integer.parseInt(st.nextToken());
                for (int j = 1; j < L; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    road.get(prev).add(new int[]{now, d});
                    road.get(now).add(new int[]{prev, d});
                    prev = now;
                }
            }

            int[] arr = new int[N + 1];

            for (int i = 0; i < P; i++) {
                int[] dist = new int[N + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dist[friends[i][0]] = 0;
                PriorityQueue<Node> que = new PriorityQueue<>();
                que.offer(new Node(friends[i][0], 0));

                while (!que.isEmpty()) {
                    Node node = que.poll();
                    if (dist[node.now] < node.d) {
                        continue;
                    }

                    for (int[] next : road.get(node.now)) {
                        if (dist[next[0]] <= node.d + next[1]) {
                            continue;
                        }
                        dist[next[0]] = node.d + next[1];
                        que.offer(new Node(next[0], dist[next[0]]));
                    }
                }

                for (int j = 0; j <= N; j++) {
                    if (dist[j] == Integer.MAX_VALUE) {
                        arr[j] = Integer.MAX_VALUE;
                    }
                    if (arr[j] != Integer.MAX_VALUE) {
                        arr[j] = Math.max(arr[j], dist[j] * friends[i][1]);
                    }
                }
            }

            for (int i = 0; i <= N; i++) {
//                System.out.print(arr[i] + " ");
                result = Math.min(result, arr[i]);
            }

            if (result == Integer.MAX_VALUE) {
                result = -1;
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}