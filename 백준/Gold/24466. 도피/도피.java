import java.io.*;
import java.util.*;

class Edge {
    int next;
    int p;

    Edge (int next, int p) {
        this.next = next;
        this.p = p;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Edge>> adj = new ArrayList<>();
        for (int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(e, p);
            adj.get(s).add(edge);
        }
        long[] byeongjun = new long[N];
        byeongjun[0] = 1;
        for (int i=0; i<9; i++) {
            long[] tomorrow = new long[N];
            for (int j=0; j<N; j++) {
                if (byeongjun[j] != 0) {
                    for (Edge edge : adj.get(j)) {
                        tomorrow[edge.next] += byeongjun[j] * edge.p;
                    }
                }
            }
            byeongjun = tomorrow.clone();
        }
        List<Integer> idx = new ArrayList<>();
        long maxP = 0;
        for (int i=0; i<N; i++) {
            if (byeongjun[i] > maxP) {
                idx.clear();
                idx.add(i);
                maxP = byeongjun[i];
            } else if (byeongjun[i] == maxP) {
                idx.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<idx.size(); i++) {
            sb.append(idx.get(i)).append(" ");
        }
        sb.append("\n");

        int n = 18 - String.valueOf(maxP).length();
        if (n < 0) {
            sb.append("1.000000000000000000");
        } else {
            sb.append("0.");
            for (int i=0; i<n; i++) {
                sb.append("0");
            }
            sb.append(maxP);
        }
        System.out.println(sb.toString());
    }
}