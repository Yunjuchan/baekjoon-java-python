import java.io.*;
import java.util.*;

public class Main {

    public static class SegmentTree {
        int[][] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            this.tree = new int[treeSize][2];
        }

        public int[] init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = new int[]{arr[start], start};
            }
            int[] left = init(arr, node * 2, start, (start + end) / 2);
            int[] right = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            return tree[node] = minPair(left, right);
        }

        public void update(int node, int start, int end, int idx, int newValue) {
            if (idx < start || end < idx) return;

            if (start == end) {
                tree[node] = new int[]{newValue, idx};
                return;
            }

            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, newValue);
            update(node * 2 + 1, mid + 1, end, idx, newValue);
            tree[node] = minPair(tree[node * 2], tree[node * 2 + 1]);
        }

        public int[] query(int node, int start, int end, int left, int right) {
            if (right < start || end < left) return new int[]{Integer.MAX_VALUE, -1};

            if (left <= start && end <= right) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            int[] lRes = query(node * 2, start, mid, left, right);
            int[] rRes = query(node * 2 + 1, mid + 1, end, left, right);
            return minPair(lRes, rRes);
        }

        private int[] minPair(int[] a, int[] b) {
            if (a[0] < b[0]) return a;
            if (a[0] > b[0]) return b;
            return a[1] < b[1] ? a : b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        SegmentTree sTree = new SegmentTree(N);
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sTree.init(arr, 1, 1, N);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                sTree.update(1, 1, N, idx, val);
            } else if (type == 2) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(sTree.query(1, 1, N, l, r)[1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}

