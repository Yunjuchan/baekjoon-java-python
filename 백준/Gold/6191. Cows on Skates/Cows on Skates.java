import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R+1][C+1];
        for (int i=1; i<=R; i++) {
            String line = br.readLine();
            for (int j=1; j<=C; j++) {
                arr[i][j] = line.charAt(j-1);
            }
        }

        int[][][] visited = new int[R+1][C+1][2];
        visited[1][1][0] = -1;
        visited[1][1][1] = -1;

        int[] directY = new int[]{1,0,-1,0};
        int[] directX = new int[]{0,1,0,-1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{1,1});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int y = now[0];
            int x = now[1];
            for (int i=0; i<4; i++) {
                int dy = y + directY[i];
                int dx = x + directX[i];
                if (dy <= 0 || dx <= 0 || dy > R || dx > C || arr[dy][dx] == '*' || (visited[dy][dx][0] != 0 && visited[dy][dx][1] != 0)) {
                    continue;
                }

                visited[dy][dx][0] = y;
                visited[dy][dx][1] = x;
                que.offer(new int[]{dy, dx});
            }
        }


        Stack<int[]> stack = new Stack<>();
        int y = R;
        int x = C;
        while (visited[y][x][0] != -1) {
            stack.push(new int[]{y, x});
            int cy = y;
            int cx = x;
            y = visited[cy][cx][0];
            x = visited[cy][cx][1];
        }

        System.out.println(1 + " " + 1);
        while (!stack.isEmpty()) {
            int[] route = stack.pop();
            System.out.println(route[0] + " " + route[1]);
        }
    }
}