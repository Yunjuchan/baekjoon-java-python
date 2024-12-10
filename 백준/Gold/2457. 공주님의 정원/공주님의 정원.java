import java.io.*;
import java.util.*;

public class Main {

    public static class Flower implements Comparable<Flower> {
        int s;
        int e;

        public Flower(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Flower other) {
            if (this.s == other.s) {
                return other.e - this.e;
            }
            return this.s - other.s;
        }
    }
    public static int convertDateToNum(int m, int d) {
        int result = d;
        switch (m) {
            case 12 : result += 30;
            case 11 : result += 31;
            case 10 : result += 30;
            case 9 : result += 31;
            case 8 : result += 31;
            case 7 : result += 30;
            case 6 : result += 31;
            case 5 : result += 30;
            case 4 : result += 31;
            case 3 : result += 28;
            case 2 : result += 31;
            case 1 : break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = convertDateToNum(3, 1);
        int E = convertDateToNum(11, 30);

        Queue<Flower> que = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            int s = convertDateToNum(sm, sd);
            int e = convertDateToNum(em, ed) - 1;
            if (s < S) {
                s = S;
            }
            if (e > E) {
                e = E;
            }

            if (e < S || s > E) {
                continue;
            }

            Flower flower = new Flower(s, e);
            que.offer(flower);
        }
        int cnt = 0;
        int covered = 0;

        boolean flag = false;

        if (que.isEmpty()) {
            System.out.println(0);
            return;
        }

        Flower flower = que.poll();
        
        if (flower.s > S) {
            System.out.println(0);
            return;
        }
        covered = flower.e;
        cnt++;

        while (!que.isEmpty()) {
            if (covered >= E) {
                System.out.println(cnt);
                return;
            }

            int next = covered;
            boolean flag2 = false;
            while (!que.isEmpty()) {
                flower = que.poll();
                if (flower.s-1 > covered && !flag2) {
                    flag = true;
                    break;
                } else if (flower.s-1 > covered) {
                    que.offer(flower);
                    break;
                } else {
                    flag2 = true;
                    next = Math.max(next, flower.e);
                }
            }
            if (flag2) {
                covered = next;
                cnt++;
            }

            if (flag) {
                System.out.println(0);
                return;
            }
        }

        if (covered >= E) {
            System.out.println(cnt);
        } else {
            System.out.println(0);
        }
    }
}