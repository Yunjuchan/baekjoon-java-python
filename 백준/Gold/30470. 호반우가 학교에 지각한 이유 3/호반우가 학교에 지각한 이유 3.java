import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {

    public static class Wood {
        int l;
        int n;

        public Wood (int l, int n) {
            this.l = l;
            this.n = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Max = 0;
        long Sum = 0;
        Stack<Wood> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                stack.add(new Wood(b, 1));
                Sum += b;
                Max = b;
            } else {
                int cnt = 0;
                int std = Math.max(Max-b, 0);
                while (!stack.isEmpty()) {
                    Wood now = stack.pop();
                    if (now.l < std) {
                        stack.add(now);
                        break;
                    }

                    Sum -= (long) now.l * now.n;
                    cnt += now.n;
                }
                stack.add(new Wood(std, cnt));
                Sum += (long) std * cnt;
                Max = std;
            }
        }

        System.out.println(Sum);
    }
}