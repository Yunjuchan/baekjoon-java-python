import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Node {
        Map<String, Node> childs;

        public Node(TreeMap<String, Node> childs) {
            this.childs = childs;
        }

        public Node() {
            this.childs = new TreeMap<>();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Node root = new Node();

        for (int i=0; i<N; i++) {
            Node now = root;
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j=0; j<K; j++) {
                String next = st.nextToken();
                if (!now.childs.containsKey(next)) {
                    now.childs.put(next, new Node());
                }
                // 현재 위치를 아래로 한 칸 내림
                now = now.childs.get(next);
            }
        }
        dfs(0, root);

    }

    public static void dfs(int depth, Node now) {
        for (String key : now.childs.keySet()) {
            System.out.println("--".repeat(depth) + key);
            dfs(depth+1, now.childs.get(key));
        }
    }
}