import java.io.*;
import java.util.*;

public class Main {

    static int N, move = 0;
    static boolean isEnd = false;

    static int[][] children;
    static int end = 0;

    public static void inOrder(int now) {
        int l = children[now][0];
        int r = children[now][1];
        if (l != -1) {
            inOrder(l);
        }
        end = now;

        if (r != -1) {
            inOrder(r);
        }
    }

    public static void similarInOrder(int now) {

        int l = children[now][0];
        int r = children[now][1];
        if (l != -1) {
            move++;
            similarInOrder(l);
            move++;
        }

        if (r != -1) {
            move++;
            similarInOrder(r);
            if (!isEnd) {
                move++;
            }
        }

        if (now == end) {
            isEnd = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        children = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            children[a][0] =  b;
            children[a][1] =  c;
        }

        inOrder(1);
        similarInOrder(1);
        System.out.println(move);
    }
}
