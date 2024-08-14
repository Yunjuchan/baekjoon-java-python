import java.io.*;
import java.util.*;

class Submit implements Comparable<Submit>{
    int idx;
    int s;
    int t;

    Submit (int idx, int s, int t) {
        this.idx = idx;
        this.s = s;
        this.t = t;
    }


    @Override
    public int compareTo(Submit other) {
        if (this.s != other.s) {
            return other.s - this.s;
        }
        return this.idx - other.idx;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Submit> A = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            A.add(new Submit(i, s, t));
        }
        A.sort((a, b) -> a.compareTo(b));
        Submit sub = A.get(0);
        int result = 0;
        if (sub.s != 0) {
            result = sub.t + (sub.idx-1) * 20;
        }

        System.out.println(result);
    }
}