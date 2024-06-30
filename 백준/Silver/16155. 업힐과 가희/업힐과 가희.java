import java.io.*;
import java.util.*;

public class Main {
    static class Position {
        long x;
        long h;

        public Position(long x, long h) {
            this.x = x;
            this.h = h;
        }
    }

    static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        } else {
            return gcd(B, A % B);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Position> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        long X0 = Long.parseLong(st.nextToken());
        long H0 = Long.parseLong(st.nextToken());
        A.add(new Position(X0, H0));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A.add(new Position(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        long S = Long.parseLong(st.nextToken());
        long E = Long.parseLong(st.nextToken());

        long[] h1 = interpolateHeight(A, S);
        long[] h2 = interpolateHeight(A, E);

        long deltaHeight = Math.abs(h2[0] * h1[1] - h1[0] * h2[1]);
        long deltaDistance = Math.abs((E - S) * h1[1] * h2[1]);

        if (deltaHeight == 0) {
            System.out.println(0);
        } else if (deltaHeight % deltaDistance == 0) {
            System.out.println(deltaHeight / deltaDistance);
        } else {
            long g = gcd(deltaHeight, deltaDistance);
            System.out.println((deltaHeight / g) + "/" + (deltaDistance / g));
        }
    }

    private static long[] interpolateHeight(List<Position> A, long pos) {
        for (int i = 0; i < A.size() - 1; i++) {
            long x1 = A.get(i).x;
            long h1 = A.get(i).h;
            long x2 = A.get(i + 1).x;
            long h2 = A.get(i + 1).h;

            if (pos == x1) {
                return new long[]{h1, 1};
            } else if (pos == x2) {
                return new long[]{h2, 1};
            } else if (pos > x1 && pos < x2) {
                long numerator = (h2 - h1) * (pos - x1) + h1 * (x2 - x1);
                long denominator = x2 - x1;
                long g = gcd(Math.abs(numerator), denominator);
                return new long[]{numerator / g, denominator / g};
            }
        }
        return new long[]{0, 1}; // Should not reach here, pos should be within range
    }
}