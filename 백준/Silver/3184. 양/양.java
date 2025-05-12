import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dy = new int[] {1, 0, -1, 0};
        int[] dx = new int[] {0, -1, 0, 1};
        char[][] yard = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                yard[i][j] = line.charAt(j);
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (yard[i][j] != '#') {
                    int[] count = new int[2];

                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[] {i, j});

                    if (yard[i][j] == 'o') {
                        count[0]++;
                    } else if (yard[i][j] == 'v') {
                        count[1]++;
                    }
                    yard[i][j] = '#';

                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        int y = cur[0];
                        int x = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];
                            if (ny < 0 || nx < 0 || ny >= R || nx >= C || yard[ny][nx] == '#') {
                                continue;
                            }
                            que.offer(new int[] {ny, nx});

                            if (yard[ny][nx] == 'o') {
                                count[0]++;
                            } else if (yard[ny][nx] == 'v') {
                                count[1]++;
                            }

                            yard[ny][nx] = '#';
                        }
                    }

                    if (count[0] > count[1]) {
                        result[0] += count[0];
                    } else {
                        result[1] += count[1];
                    }
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}