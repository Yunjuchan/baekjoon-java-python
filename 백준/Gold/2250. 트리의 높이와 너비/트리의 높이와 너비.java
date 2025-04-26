import java.io.*;
import java.util.*;

public class Main {
    static int[] parents, positions, depths;
    static int p = 1;
    static int maxDepth = 1;
    static int[][] children;

    public static void checkDepth(int depth, int now) {
        maxDepth = Math.max(maxDepth, depth);
        for (int i = 0; i < 2; i++) {
            if (children[now][i] == -1) {
                continue;
            }

            depths[children[now][i]] = depth + 1;
            checkDepth(depth + 1, children[now][i]);
        }
    }

    public static void inorder(int now) {
        int l = children[now][0];
        int r = children[now][1];
        if (l != -1) {
            inorder(l);
        }
        positions[now] = p++;

        if (r != -1) {
            inorder(r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        positions = new int[N + 1];
        depths = new int[N + 1];
        children = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l != -1) {
                parents[l] = p;
            }

            if (r != -1) {
                parents[r] = p;
            }

            children[p][0] = l;
            children[p][1] = r;
        }

        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0) {
                depths[i] = 1;
                checkDepth(1, i);
                inorder(i);
            }
        }

        int[][] width = new int[maxDepth + 1][2];

        for (int i = 1; i <= maxDepth; i++) {
            width[i][0] = 100000;
        }

        for (int i = 1; i <= N; i++) {
            width[depths[i]][0] = Math.min(width[depths[i]][0], positions[i]);
            width[depths[i]][1] = Math.max(width[depths[i]][1], positions[i]);
        }

        int maxWidth = 0;
        int level = 0;

        for (int i = 1; i <= maxDepth; i++) {
            if (maxWidth < width[i][1] - width[i][0] + 1) {
                maxWidth = width[i][1] - width[i][0] + 1;
                level = i;
            }
        }

        System.out.println(level + " " + maxWidth);
    }
}
