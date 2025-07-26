import java.io.*;
import java.util.*;
public class Main {

    static Node home, site;
    static List<List<Node>> arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static String answer = "";


    public static String apply(int type) {
        if (type == 0) {
            return "Assassin";
        } else if (type == 1) {
            return "Healer";
        } else if (type == 2) {
            return "Mage";
        } else {
            return "Tanker";
        }
    }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static int distance(Node s, Node e) {
        return Math.abs(s.y - e.y) + Math.abs(s.x - e.x);
    }

    public static void dfs(int type, int level, Node[] path) {
        if (level == 4) {
            int dist = 0;
            for (int i = 0; i < 4; i++) {
                dist += distance(path[i], path[i + 1]);
            }
            if (min > dist) {
                min = dist;
                answer = apply(type);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            path[level] = arr.get(type).get(i);
            dfs(type, level + 1, path);
            path[level] = null;
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        home = new Node(-1, -1);
        site = new Node(-1, -1);
        visited = new boolean[3];

        arr = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            arr.add(new ArrayList<>());
        }

        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < N; x++) {
                if (str.charAt(x) == 'H') {
                    home = new Node(y, x);
                } else if (str.charAt(x) == 'J') {
                    arr.get(0).add(new Node(y, x));
                } else if (str.charAt(x) == 'C') {
                    arr.get(1).add(new Node(y, x));
                } else if (str.charAt(x) == 'B') {
                    arr.get(2).add(new Node(y, x));
                } else if (str.charAt(x) == 'W') {
                    arr.get(3).add(new Node(y, x));
                } else if (str.charAt(x) == '#') {
                    site = new Node(y, x);
                }
            }
        }
        Node[] path = new Node[5];
        path[0] = home;
        path[4] = site;
        for (int i = 0; i < 4; i++) {
            dfs(i, 1, path);
        }

        System.out.println(answer);
    }
}