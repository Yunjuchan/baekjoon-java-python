import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Driver {

        int distance;
        int y;
        int x;

        public Driver(int distance, int y, int x) {
            this.distance = distance;
            this.y = y;
            this.x = x;
        }
    }

    static class Passenger {
        int sy;
        int sx;
        int ey;
        int ex;

        public Passenger(int sy, int sx, int ey, int ex) {
            this.sy = sy;
            this.sx = sx;
            this.ey = ey;
            this.ex = ex;
        }
    }

    static int[] directY = {-1, 0, 0, 1};
    static int[] directX = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        Driver driver = new Driver(0, y, x);

        Map<Integer, Passenger> P = new TreeMap<>();

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken())-1;
            int sx = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            P.put(i+2, new Passenger(sy, sx, ey, ex));
        }

        while (!P.isEmpty()) {
            boolean flag = false;
            int[][] m2 = new int[N][N];
            int[][] m3 = new int[N][N];

            for (int i = 0; i < N; i++) {
                m2[i] = map[i].clone();
                m3[i] = map[i].clone();
            }

            Queue<Driver> que = new LinkedList<>();
            que.add(new Driver(0, driver.y, driver.x));
            m2[driver.y][driver.x] = 1;
//            System.out.println("남은 승객 수: " + P.size());
            boolean pass = false;
            for (int key : P.keySet()) {
                Passenger p = P.get(key);
                m2[p.sy][p.sx] = key;
                if (driver.y == p.sy && driver.x == p.sx) {
                    pass = true;
                    P.remove(key);
                    m3[p.ey][p.ex] = 2;
                    flag = true;
                    break;
                }
            }

            int dist = Integer.MAX_VALUE;
            int key = -1;
            int ny = -1;
            int nx = -1;
            while (!pass && !que.isEmpty()) {
                Driver d = que.poll();
                for (int i=0; i<4; i++) {
                    int dy = d.y + directY[i];
                    int dx = d.x + directX[i];
                    if (fuel - d.distance <= 0 || dy < 0 || dx < 0 || dy >= N || dx >= N || m2[dy][dx] == 1) {
                        continue;
                    } else if (m2[dy][dx] == 0) {
                        m2[dy][dx] = 1;
                        que.add(new Driver(d.distance+1, dy, dx));
                    } else {
                        if (dist > d.distance+1) {
                            dist = d.distance+1;
                            key = m2[dy][dx];
                            ny = dy;
                            nx = dx;
                        } else if (dist == d.distance+1) {
                            if (ny > dy) {
                                key = m2[dy][dx];
                                ny = dy;
                                nx = dx;
                            } else if (ny == dy && nx > dx) {
                                key = m2[dy][dx];
                                ny = dy;
                                nx = dx;
                            } else {
                            }
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (ny != -1) {
                flag = true;
                fuel -= dist;
                driver.y = ny;
                driver.x = nx;
                Passenger p = P.get(key);
                P.remove(key);
                m3[p.ey][p.ex] = 2;
            }

            if (!flag) {
                fuel = -1;
                break;
            } else {
                flag = false;
            }

            que = new LinkedList<>();
            que.add(new Driver(0, driver.y, driver.x));
            m3[driver.y][driver.x] = 1;

            while (!que.isEmpty()) {
                Driver d = que.poll();
                for (int i=0; i<4; i++) {
                    int dy = d.y + directY[i];
                    int dx = d.x + directX[i];
                    if (fuel - d.distance <= 0 || dy < 0 || dx < 0 || dy >= N || dx >= N || m3[dy][dx] == 1) {
                        continue;
                    } else if (m3[dy][dx] == 0) {
                        m3[dy][dx] = 1;
                        que.add(new Driver(d.distance+1, dy, dx));
                    } else {
                        flag = true;
                        fuel += d.distance+1;
                        driver.y = dy;
                        driver.x = dx;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                fuel = -1;
                break;
            }
        }
        System.out.println(fuel);
    }
}