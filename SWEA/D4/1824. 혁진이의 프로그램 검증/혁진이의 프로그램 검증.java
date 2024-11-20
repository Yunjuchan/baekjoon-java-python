import java.util.*;
import java.io.*;

class Solution {
    static int memory;
    static int[] directY = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] directX = {0, 1, 0, -1};

    public static class Position {
        int r, c, v, d;

        public Position(int r, int c, int v, int d) {
            this.r = r;
            this.c = c;
            this.v = v;
            this.d = d;
        }
    }

    public static int calc(char c) {
        if (c == '<') {
            return 3;
        } else if (c == '>') {
            return 1;
        } else if (c == '^') {
            return 2;
        } else if (c == 'v') {
            return 0;
        } else if (c == '_') {
            if (memory == 0) {
                return 1;
            } else {
                return 3;
            }
        } else if (c == '|') {
            if (memory == 0) {
                return 0;
            } else {
                return 2;
            }
        } else if (c == '?') {
            return 5;
        } else if (c == '.') {
            return 6;
        } else if (c == '@') {
            return -1;
        } else if (c == '+') {
            memory++;
            memory %= 16;
        } else if (c == '-') {
            memory--;
            memory = (memory + 16) % 16;
        } else {
            memory = (int) c - (int) '0';
        }
        return 6;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            boolean flag = false;
            memory = 0;

            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 배열 저장
            boolean isAt = false;
            char[][] arr = new char[R][C];
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    arr[i][j] = line.charAt(j);
                    if (arr[i][j] == '@') {
                        isAt = true;
                    }
                }
            }
            if (!isAt) {
                System.out.println("#" + tc + " NO");
                continue;
            }

            Queue<Position> que = new LinkedList<>();
            boolean[][][][] visited = new boolean[R][C][16][4];
            que.offer(new Position(0,0,0,1));
            visited[0][0][0][1] = true;

            while (!que.isEmpty()) {
                Position p = que.poll();
                memory = p.v;
                int next = calc(arr[p.r][p.c]);

                if (next == -1) {
                    flag = true;
                    break;
                }

                if (next >= 0 && next <= 3) {
                    int nextR = (p.r + directY[next] + R) % R;
                    int nextC = (p.c + directX[next] + C) % C;
                    if (visited[nextR][nextC][memory][next]) {
                        continue;
                    }
                    visited[nextR][nextC][memory][next] = true;
                    que.offer(new Position(nextR, nextC, memory, next));

                } else if (next == 5) {
                    for (int i=0; i<4; i++) {
                        int nextR = (p.r + directY[i] + R) % R;
                        int nextC = (p.c + directX[i] + C) % C;
                        if (visited[nextR][nextC][memory][i]) {
                            continue;
                        }
                        visited[nextR][nextC][memory][i] = true;
                        que.offer(new Position(nextR, nextC, memory, i));
                    }
                } else if (next == 6) {
                    int nextR = (p.r + directY[p.d] + R) % R;
                    int nextC = (p.c + directX[p.d] + C) % C;
                    if (visited[nextR][nextC][memory][p.d]) {
                        continue;
                    }
                    visited[nextR][nextC][memory][p.d] = true;
                    que.offer(new Position(nextR, nextC, memory, p.d));
                }
            }

            if (flag) {
                System.out.println("#" + tc + " YES");
            } else {
                System.out.println("#" + tc + " NO");
            }
        }
    }
}