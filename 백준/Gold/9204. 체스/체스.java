import java.io.*;
import java.util.*;

public class Main {
    static class Grid {
        char x;
        int y;
        List<Grid> path;

        public Grid(char x, int y, List<Grid> path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public static void bfs(char x1, int y1, char x2, int y2) {
        if ((x1+y1) % 2 != (x2+y2) % 2) {
            System.out.println("Impossible");
            return;
        }

        if (x1 == x2 && y1 == y2) {
            System.out.println("0 " + x1 + " " + y1);
            return;
        }

        Queue<Grid> que = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];
        List<Grid> initialPath = new ArrayList<>();
        initialPath.add(new Grid(x1, y1, null));
        que.add(new Grid(x1, y1, initialPath));
        visited[x1-'A'][y1-1] = true;

        while (!que.isEmpty()) {
            Grid current = que.poll();
            char cx = current.x;
            int cy = current.y;

            if (current.path.size() > 5) continue;

            for (int dx=-1; dx<=1; dx+=2) {
                for (int dy=-1; dy<=1; dy+=2) {
                    for (int step=1; step<=8; step++) {
                        char nx = (char) (cx + dx * step);
                        int ny = cy + dy * step;

                        if (nx<'A' || nx>'H' || ny<1 || ny>8 || visited[nx-'A'][ny-1]) {
                            break;
                        }

                        List<Grid> newPath = new ArrayList<>(current.path);
                        newPath.add(new Grid(nx, ny, null));

                        if (nx == x2 && ny == y2) {
                            System.out.print(newPath.size() - 1 + " ");
                            for (Grid g : newPath) {
                                System.out.print(g.x + " " + g.y + " ");
                            }
                            System.out.println();
                            return;
                        }

                        que.add(new Grid(nx, ny, newPath));
                        visited[nx-'A'][ny-1] = true;
                    }
                }
            }
        }

        System.out.println("Impossible");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char x1 = st.nextToken().charAt(0);
            int y1 = Integer.parseInt(st.nextToken());
            char x2 = st.nextToken().charAt(0);
            int y2 = Integer.parseInt(st.nextToken());

            bfs(x1, y1, x2, y2);
        }
    }
}