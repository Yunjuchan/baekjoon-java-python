import java.io.*;
import java.util.*;

public class Main {

    /**
     * t: 요청 시점
     * p: 우선 순위
     * b: 실행 시간
     * nowT: 현재 시간
     * 실행 된다면 현재 시간이 this.t만큼 증가
     *
     * 우선 순위 부여 방식:
     * 1. 실행 시간이 nowT 이전에 있어야 함
     * 2. 조정된 p(this.p + nowT - this.t)가 높아야 하고
     * 3. 진행 시간 b가 짧아야함
     * 4. b도 같다면 n이 작은 순으로
     *
     */

    static long nowT = Integer.MAX_VALUE;
    static class Process implements Comparable<Process>{
        int n;
        int t;
        int p;
        int b;

        public Process (int n, int t, int p, int b) {
            this.n = n;
            this.t = t;
            this.p = p;
            this.b = b;
        }

        @Override
        public int compareTo(Process o) {
            // 조정된 p가 같을 때
            if (this.p - this.t == o.p - o.t) {
                // 실행 시간이 같을 때
                if (this.b == o.b) {
                    // 3. n이 작은 순
                    return this.n - o.n;
                }
                // 2. 실행 시간이 낮은순
                return this.b - o.b;
            }
            // 1. 조정된 p가 높은순
            return o.p - o.t - this.p + this.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Process> que = new PriorityQueue<>();
        int idx = 0;

        List<Process> list = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (nowT > t) {
                nowT = t;
            }
            int p = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Process process = new Process(i, t, p, b);

            list.add(process);
            if (t == nowT) {
                que.offer(process);
                idx = i;
            }
        }

        while (!que.isEmpty()) {
            Process process = que.poll();
//            System.out.println("nowT: " + nowT);
//            System.out.println("n: " + process.n + " t: " + process.t + " p: " + process.p + " b: " + process.b);

            nowT += process.b;
            sb.append(process.n).append(" ");

            if (idx == N) {
                continue;
            }
            if (que.isEmpty() && nowT < list.get(idx).t) {
                nowT = list.get(idx).t;
            }
            for (int i=idx; i<N; i++) {
                Process nextP = list.get(idx);
                if (nextP.t > nowT) {
                    break;
                }
                que.offer(nextP);
                idx = i+1;
            }
        }
        System.out.println(sb.toString());
    }
}