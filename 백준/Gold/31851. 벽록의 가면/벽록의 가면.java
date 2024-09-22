import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Hole {
        int x;
        int y;

        public Hole(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Hole> A;
    static int N;
    static int result;

    static void dfs(int start, int depth, Stack<Hole> picks) {
        if (depth == 4) {
            // 선택된 4개의 점을 정렬
            List<Hole> selected = new ArrayList<>(picks);
            sortPoints(selected);

            // 볼록한 사각형인지 확인
            if (isConvex(selected)) {
                result++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            picks.push(A.get(i));
            dfs(i + 1, depth + 1, picks);
            picks.pop();
        }
    }

    static boolean isConvex(List<Hole> picks) {
        Hole a = picks.get(0);
        Hole b = picks.get(1);
        Hole c = picks.get(2);
        Hole d = picks.get(3);

        long cp1 = crossProduct(a, b, c); // AB x AC
        long cp2 = crossProduct(b, c, d); // BC x BD
        long cp3 = crossProduct(c, d, a); // CD x CA
        long cp4 = crossProduct(d, a, b); // DA x DB

        // 모든 외적 값이 같은 부호(양수 혹은 음수)여야 볼록한 사각형
        return (cp1 > 0 && cp2 > 0 && cp3 > 0 && cp4 > 0) ||
                (cp1 < 0 && cp2 < 0 && cp3 < 0 && cp4 < 0);
    }

    // 외적 계산
    static long crossProduct(Hole a, Hole b, Hole c) {
        long x1 = b.x - a.x;
        long y1 = b.y - a.y;
        long x2 = c.x - a.x;
        long y2 = c.y - a.y;
        return x1 * y2 - y1 * x2;
    }

    // 점 정렬 함수
    static void sortPoints(List<Hole> points) {
        final double[] center = {0, 0}; // 중심점

        // 중심점 계산
        for (Hole h : points) {
            center[0] += h.x;
            center[1] += h.y;
        }
        center[0] /= points.size();
        center[1] /= points.size();

        // 각도를 기준으로 정렬
        points.sort((h1, h2) -> {
            double angle1 = Math.atan2(h1.y - center[1], h1.x - center[0]);
            double angle2 = Math.atan2(h2.y - center[1], h2.x - center[0]);
            return Double.compare(angle1, angle2);
        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A.add(new Hole(x, y));
        }

        dfs(0, 0, new Stack<>());
        System.out.println(result);
    }
}