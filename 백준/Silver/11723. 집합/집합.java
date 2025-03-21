import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        boolean[] set;
        StringBuilder sb;

        public Node() {
            set = new boolean[21];
            sb = new StringBuilder();
        }

        public void add(int x) {
            set[x] = true;
        }

        public void remove(int x) {
            set[x] = false;
        }

        public void check(int x) {
            if (set[x]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        public void toggle(int x) {
            set[x] = !set[x];
        }

        public void all() {
            Arrays.fill(set, true);
        }

        public void empty() {
            Arrays.fill(set, false);
        }

        public String toString() {
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Node node = new Node();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if (query.equals("add")) {
                node.add(Integer.parseInt(st.nextToken()));
            } else if (query.equals("remove")) {
                node.remove(Integer.parseInt(st.nextToken()));
            } else if (query.equals("check")) {
                node.check(Integer.parseInt(st.nextToken()));
            } else if (query.equals("toggle")) {
                node.toggle(Integer.parseInt(st.nextToken()));
            } else if (query.equals("all")) {
                node.all();
            }  else {
                node.empty();
            }
        }
        System.out.println(node);
    }
}