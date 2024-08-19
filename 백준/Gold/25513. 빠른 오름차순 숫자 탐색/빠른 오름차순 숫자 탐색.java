import java.io.*;
import java.util.*;

class CheckPoint {
    int y;
    int x;
    int cnt;
    CheckPoint(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }

}
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] A = new int[5][5];
        int[] directY = {1,0,-1,0};
        int[] directX = {0,1,0,-1};
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<List<CheckPoint>> B = new ArrayList<>();
        for (int i=0; i<7; i++) {
            B.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        B.get(0).add(new CheckPoint(y, x, 0));
        for (int i=0; i<6; i++) {
            for (CheckPoint cp : B.get(i)) {
                Queue<CheckPoint> que = new LinkedList<>();
                que.add(cp);
                boolean[][] visited = new boolean[5][5];
                visited[cp.y][cp.x] = true;
                while (!que.isEmpty()) {
                    CheckPoint now = que.poll();
                    for (int j=0; j<4; j++) {
                        int dy = now.y + directY[j];
                        int dx = now.x + directX[j];
                        if (dy<0 || dx<0 || dy>=5 || dx>=5 || visited[dy][dx] || A[dy][dx] == -1) {
                            continue;
                        }
                        visited[dy][dx] = true;
                        if (A[dy][dx] == i+1) {
                            B.get(i+1).add(new CheckPoint(dy, dx, now.cnt+1));
                        } else {
                            que.add(new CheckPoint(dy, dx, now.cnt+1));
                        }
                    }
                }
            }
        }
        if (B.get(6).isEmpty()) {
            System.out.println(-1);
        } else {
            int result = Integer.MAX_VALUE;
            for (CheckPoint cp : B.get(6)) {
                result = Math.min(result, cp.cnt);
            }
            System.out.println(result);
        }

    }
}