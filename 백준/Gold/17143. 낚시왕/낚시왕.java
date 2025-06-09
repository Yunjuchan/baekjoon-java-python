import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] {0, -1, 1, 0, 0};
    static int[] dx = new int[] {0, 0, 0, 1, -1};
    static Queue<Shark> que;

    public static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        que = new LinkedList<>();
        Shark[][] status = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (d <= 2) {
                s = s % (2 * R - 2);
            } else {
                s = s % (2 * C - 2);
            }
            status[r][c] = new Shark(r, c, s, d, z);
        }

        for (int c = 1; c <= C; c++) {

            for (int r = 1; r <= R; r++) {
                if (status[r][c] != null) {
                    result += status[r][c].z;
                    status[r][c] = null;
                    break;
                }
            }

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (status[i][j] == null) {
                        continue;
                    }
                    que.offer(status[i][j]);
                }
            }

            status = new Shark[R + 1][C + 1];

            while (!que.isEmpty()) {
                Shark cur = que.poll();
                cur.r += cur.s * dy[cur.d];
                cur.c += cur.s * dx[cur.d];
                if (cur.r > R) {
                    int diff = (cur.r - R);
                    if (diff < R - 1) {
                        cur.r = R - diff;
                        cur.d = 1;
                    } else {
                        cur.r = 1 + (diff - R + 1);
                    }
                } else if (cur.r < 1) {
                    int diff = (1 - cur.r);
                    if (diff < R - 1) {
                        cur.r = 1 + diff;
                        cur.d = 2;
                    } else {
                        cur.r = R - (diff - R + 1);
                    }
                } else if (cur.c > C) {
                    int diff = (cur.c - C);
                    if (diff < C - 1) {
                        cur.c = C - diff;
                        cur.d = 4;
                    } else {
                        cur.c = 1 + (diff - C + 1);
                    }
                } else if (cur.c < 1) {
                    int diff = (1 - cur.c);
                    if (diff < C - 1) {
                        cur.c = 1 + diff;
                        cur.d = 3;
                    } else {
                        cur.c = C - (diff - C + 1);
                    }
                }

                if (status[cur.r][cur.c] == null || status[cur.r][cur.c].z < cur.z) {
                    status[cur.r][cur.c] = cur;
                }
            }
        }

        System.out.println(result);
    }
}