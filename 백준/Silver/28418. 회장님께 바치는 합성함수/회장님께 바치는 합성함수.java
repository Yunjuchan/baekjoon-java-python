import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] p = new int[3];
        int[] q = new int[3];
        int[] ans = new int[3];
        int a, b, c, d, e, root;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        p[2] = a * d * d;
        p[1] = 2 * a * d * e + b * d;
        p[0] = a * e * e + b * e + c;

        q[2] = d * a;
        q[1] = d * b;
        q[0] = c * d + e;

        for (int i = 2; i >= 0; i--) {
            ans[i] = p[i] - q[i];
        }

        root = (ans[1] * ans[1]) - (4 * ans[2] * ans[0]);

        if (ans[2] == 0) {
            if (ans[1] != 0) {
                System.out.println("Remember my character");
            } else if (p[2] == q[2] && p[1] == q[1] && p[0] == q[0]) {
                System.out.println("Nice");
            } else {
                System.out.println("Head on");
            }
        } else if (root > 0) {
            System.out.println("Go ahead");
        } else if (root == 0) {
            System.out.println("Remember my character");
        } else {
            System.out.println("Head on");
        }
    }
}