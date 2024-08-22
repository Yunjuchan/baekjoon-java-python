import java.io.*;
import java.util.*;

public class Main {

    static class Expression {
        long a, b, c, d;

        public Expression(long a, long b, long c, long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;

            normalize();
        }

        // 두 Expression의 덧셈
        public Expression add(Expression other) {
            long newA = this.a * other.a;
            long newB = this.b * other.a + other.b * this.a;
            long newC = this.c * other.a + other.c * this.a;
            long newD = this.d;

            return simplify(new Expression(newA, newB, newC, newD));
        }

        // 두 Expression의 뺄셈
        public Expression subtract(Expression other) {
            long newA = this.a * other.a;
            long newB = this.b * other.a - other.b * this.a;
            long newC = this.c * other.a - other.c * this.a;
            long newD = this.d;

            return simplify(new Expression(newA, newB, newC, newD));
        }

        // 두 Expression의 곱셈
        public Expression multiply(Expression other) {
            long newA = this.a * other.a;
            long newB = this.b * other.b + this.c * other.c * this.d;
            long newC = this.b * other.c + this.c * other.b;
            long newD = this.d;

            return simplify(new Expression(newA, newB, newC, newD));
        }

        // 두 Expression의 나눗셈
        public Expression divide(Expression other) {
            long newA = this.a * (other.b * other.b - other.c * other.c * other.d);
            long newB = other.a * (this.b * other.b - this.c * other.c * this.d);  // 수정된 부분
            long newC = other.a * (this.c * other.b - this.b * other.c);           // 수정된 부분
            long newD = this.d;

            return simplify(new Expression(newA, newB, newC, newD));
        }

        // 기약 분수로 단순화
        private Expression simplify(Expression exp) {
            long gcd1 = gcd(exp.a, exp.b);
            long gcd2 = gcd(gcd1, exp.c);

            exp.a /= gcd2;
            exp.b /= gcd2;
            exp.c /= gcd2;

            // 분모가 음수일 경우 부호를 모두 반대로 바꿔준다
            exp.normalize();

            return exp;
        }

        // GCD 계산
        private long gcd(long x, long y) {
            return y == 0 ? x : gcd(y, x % y);
        }

        // a가 음수일 경우 모든 값을 반대로 바꿔주는 메서드
        private void normalize() {
            if (this.a < 0) {
                this.a = -this.a;
                this.b = -this.b;
                this.c = -this.c;
            }
        }

        @Override
        public String toString() {
            if (c == 0) {
                return a + " " + b + " " + c + " " + 0;
            }
            return a + " " + b + " " + c + " " + d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Long.parseLong(st.nextToken());
        long b1 = Long.parseLong(st.nextToken());
        long c1 = Long.parseLong(st.nextToken());
        long d1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long a2 = Long.parseLong(st.nextToken());
        long b2 = Long.parseLong(st.nextToken());
        long c2 = Long.parseLong(st.nextToken());
        long d2 = Long.parseLong(st.nextToken());

        Expression A = new Expression(a1, b1, c1, d1);
        Expression B = new Expression(a2, b2, c2, d2);

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
        System.out.println(A.divide(B));
    }
}