import java.io.*;
import java.util.*;

class Hole {
    int y;
    int x;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hole hole = (Hole) o;
        return y == hole.y && x == hole.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    public Hole (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        List<Hole> holes = new ArrayList<>();
        Set<Hole> S = new HashSet<>();
        int[] directY = {1,0,1,-1};
        int[] directX = {1,1,0,1};

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Hole hole = new Hole(y, x);
            holes.add(hole);
            S.add(hole);
        }
        long[][] A = new long[N+1][M+1];
        A[1][1] = 1;
        for (int j=1; j<=M; j++) {
            for (int i=1; i<=N; i++) {
                Hole h = new Hole(i, j);
                if (S.contains(h)) {
                    continue;
                }
                for (int k=0; k<3; k++) {
                    int ny = directY[k+j%2] + h.y;
                    int nx = directX[k+j%2] + h.x;
                    if (ny < 1 || nx < 1 || ny > N || nx > M) {
                        continue;
                    }
                    A[ny][nx] += A[i][j];
                    A[ny][nx] %= 1000000007;
                }
            }
        }
        System.out.println(A[N][M]);
    }
}