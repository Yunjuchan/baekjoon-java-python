import java.io.*;
import java.util.*;

public class Main {

    // Jump 클래스를 static으로 변경하여 main 메서드 내에서 쉽게 접근할 수 있도록 합니다.
    public static class Jump implements Comparable<Jump> {

        int idx;
        int diff;

        public Jump (int idx, int diff) {
            this.idx = idx;
            this.diff = diff;
        }

        @Override
        public int compareTo(Jump o) {
            if (this.diff == o.diff) {
                return this.idx - o.idx;
            }
            return o.diff - this.diff;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();
        set.add(0);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int year = Integer.parseInt(br.readLine());
            int a = year / 12 + 1;
            set.add(a);
            max = Math.max(max, a);
        }

        List<Integer> years = new ArrayList<>(set);
        boolean[] isJump = new boolean[set.size()];
        int[] diff = new int[set.size()];

        PriorityQueue<Jump> que = new PriorityQueue<>();


        for (int i=1; i<set.size(); i++) {
            diff[i] = years.get(i) - years.get(i-1);
//            System.out.print(diff[i] + " ");
            que.offer(new Jump(i, diff[i]));
        }

        int cnt = 0;
        while (K-1 > cnt && !que.isEmpty()) {
            Jump jump = que.poll();
            isJump[jump.idx] = true;
            cnt++;
        }
        int result = max * 12;

        for (int i=1; i<isJump.length; i++) {
            if (isJump[i]) {
                result -= (diff[i] - 1) * 12;
            }
        }
        System.out.println(result);
    }
}