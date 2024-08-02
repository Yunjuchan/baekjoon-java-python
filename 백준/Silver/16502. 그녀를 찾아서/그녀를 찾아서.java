import java.io.*;
import java.util.*;

class Route {
    int next;
    double p;

    public Route (int next, double p) {
        this.next = next;
        this.p = p;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<List<Route>> adj = new ArrayList<>();
        double[] cur = new double[4];
        for (int i=0; i<4; i++) {
            adj.add(new ArrayList<>());
            cur[i] = 25.00;
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0)-65;
            int b = st.nextToken().charAt(0)-65;
            double p = Double.parseDouble(st.nextToken());
            adj.get(a).add(new Route(b, p));
        }

        for (int i=0; i<N; i++) {
            double[] tmp = new double[4];
            for (int j=0; j<4; j++) {
                for (Route r : adj.get(j)) {
                    tmp[r.next] += cur[j] * r.p;
                }
            }
            cur = tmp.clone();
        }
        for (double x : cur) {
            System.out.printf("%.2f\n", x);
        }
    }
}