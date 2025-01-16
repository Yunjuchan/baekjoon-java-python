import java.util.*;
import java.io.*;

class Solution {
    static int[] dy = {0,-1,1,0,0}; // 상 하 좌 우
    static int[] dx = {0,0,0,-1,1}; // 상 하 좌 우

    static class Creature {
        int y;
        int x;
        int n;
        int d;
        public Creature (int y, int x, int n, int d) {
            this.y = y;
            this.x = x;
            this.n = n;
            this.d = d;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][][] arr = new int[N][N][4];
            Queue<Creature> que = new LinkedList<>();

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                que.offer(new Creature(y, x, n, d));
            }

            for (int i=0; i<M; i++) {
                Map<Integer, Map<Integer, List<int[]>>> map = new HashMap<>();

                // 미생물 이동
                while (!que.isEmpty()) {
                    Creature now = que.poll();
                    int ny = now.y += dy[now.d];
                    int nx = now.x += dx[now.d];
                    map.putIfAbsent(ny, new HashMap<>());
                    map.get(ny).putIfAbsent(nx, new ArrayList<>());
                    if (ny == 0 || nx == 0 || ny == N-1 || nx == N-1) {
                        now.n /= 2;
                        now.d += (now.d % 2) * 2 - 1;
                    }
                    map.get(ny).get(nx).add(new int[]{now.n, now.d});
                }

                // 미생물 군집 형성
                for (int y : map.keySet()) {
                    for (int x : map.get(y).keySet()) {
                        int sum = 0;
                        int max = 0;
                        int nd = 0;
                        for (int[] creature : map.get(y).get(x)) {
                            sum += creature[0];
                            if (max < creature[0]) {
                                max = creature[0];
                                nd = creature[1];
                            }
                        }
                        que.offer(new Creature(y, x, sum, nd));
                    }
                }
            }
            int result = 0;
            while (!que.isEmpty()) {
                result += que.poll().n;
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}