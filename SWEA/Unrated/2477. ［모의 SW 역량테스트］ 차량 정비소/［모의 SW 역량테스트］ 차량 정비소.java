import java.util.*;
import java.io.*;

class Solution {

    public static class Reception implements Comparable<Reception> {
        int n;
        int t;

        public Reception (int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo (Reception o) {
            if (this.t == o.t) {
                return this.n - o.n;
            }
            return this.t - o.t;

        }
    }

    public static class Repair implements Comparable<Repair> {
        int n;
        int receptN;
        int t;

        public Repair (int n, int receptN, int t) {
            this.n = n;
            this.receptN = receptN;
            this.t = t;
        }

        @Override
        public int compareTo (Repair o) {
            if (this.t == o.t) {
                return this.receptN - o.receptN;
            }
            return this.t - o.t;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = 0;

            int[] arr1 = new int[N+1];
            int[] wait1 = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr2 = new int[M+1];
            int[] wait2 = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int[] arrive = new int[K+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=K; i++) {
                arrive[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Reception> receptQue = new PriorityQueue<>();
            Queue<Repair> repairQue = new PriorityQueue<>();

            // 도착 인원 처리하기
            for (int j=1; j<=K; j++) {
                receptQue.offer(new Reception(j, arrive[j]));
            }

            // 접수 대기 인원 처리하기
            while (!receptQue.isEmpty()) {
                Reception reception = receptQue.peek();
                int idx = -1;
                int idx2 = -1;
                int minT = Integer.MAX_VALUE;
                for (int ai=1; ai<=N; ai++) {
                    if (idx2 == -1 && reception.t >= wait1[ai]) {
                        idx2 = ai;
                    }

                    if (minT > wait1[ai]) {
                        minT = wait1[ai];
                        idx = ai;
                    }
                }

                receptQue.poll();
                if (idx2 != -1) {
                    wait1[idx2] = reception.t + arr1[idx2];
                    repairQue.offer(new Repair(reception.n, idx2, wait1[idx2]));
                } else {
                    wait1[idx] = minT + arr1[idx];
                    repairQue.offer(new Repair(reception.n, idx, wait1[idx]));
                }


            }

            // 정비 처리하기
            while (!repairQue.isEmpty()) {
                Repair repair = repairQue.peek();

                int idx = -1;
                int idx2 = -1;
                int minT = Integer.MAX_VALUE;
                for (int bj=1; bj<=M; bj++) {
                    if (idx2 == -1 && repair.t >= wait2[bj]) {
                        idx2 = bj;
                    }

                    if (minT > wait2[bj]) {
                        minT = wait2[bj];
                        idx = bj;
                    }
                }

                repairQue.poll();
                if (idx2 != -1) {
                    if (repair.receptN == A && idx2 == B) {
                        result += repair.n;
                    }
                    wait2[idx2] = repair.t + arr2[idx2];
                } else {
                    if (repair.receptN == A && idx == B) {
                        result += repair.n;
                    }
                    wait2[idx] = minT + arr2[idx];
                }
            }

            if (result == 0) {
                result = -1;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}