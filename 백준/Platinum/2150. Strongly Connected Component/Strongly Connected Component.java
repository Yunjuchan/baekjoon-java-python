import java.io.*;
import java.util.*;

public class Main {
    static int V, E, id;
    static boolean[] visited, finished, isSCC, onStack;
    static int[] ids, lowLink;
    static Stack<Integer> stack;
    static List<List<Integer>> sccList;
    static List<List<Integer>> edges;

    public static void tarjan(int now) {
        ids[now] = lowLink[now] = id++;
        stack.push(now);
        onStack[now] = true;
        for (int next : edges.get(now)) {
            if (ids[next] == 0) {
                tarjan(next);
                lowLink[now] = Math.min(lowLink[now], lowLink[next]);
            } else if (onStack[next]) {
                lowLink[now] = Math.min(lowLink[now], ids[next]);
            }
        }

        if (ids[now] == lowLink[now]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = stack.pop();
                onStack[top] = false;
                scc.add(top);
                if (top == now) {
                    break;
                }
            }

            scc.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
            scc.add(-1);
            sccList.add(scc);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        id = 1;
        stack = new Stack<>();
        visited = new boolean[V + 1];
        finished = new boolean[V + 1];
        isSCC = new boolean[V + 1];
        onStack = new boolean[V + 1];
        lowLink = new int[V + 1];
        ids = new int[V + 1];
        sccList = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
        }

        for (int i = 0; i <= V; i++) {
            edges.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
        }

        for (int i = 1; i <= V; i++) {
            if (ids[i] == 0) {
                tarjan(i);
            }
        }

        sccList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(0), o2.get(0));
            }
        });


        sb.append(sccList.size()).append("\n");
        for (List<Integer> scc : sccList) {
            for (int node : scc) sb.append(node).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}