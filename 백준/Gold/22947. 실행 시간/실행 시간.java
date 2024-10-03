import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



/**
 * N이 100일 때 3개를 고르는 것은 100 * 99 * 98 / 3! => 약 16만 번 정도
 */
public class Main {

    static class Task {
        int n;
        int startTime;
        Task (int n, int startTime) {
            this.n = n;
            this.startTime = startTime;
        }
    }

    static int N, M, K;
    static int result = Integer.MAX_VALUE;
    static List<List<Integer>> order = new ArrayList<>();
    static int[] times;

    // K개를 뽑아서 0초로 만드는 방법
    static void dfs(int start, int level, int[] prev, Set<Integer> candidates) {
        if (level == K) {

            int t = process(prev.clone(), candidates);
            if (result > t) {
                result = t;
            }
            return;
        }

        for (int i=start; i<=N; i++) {
            candidates.add(i);
            dfs(i+1, level+1, prev, candidates);
            candidates.remove(i);
        }
    }

    // 위상정렬로 시간 계산
    static int process(int[] prev, Set<Integer> candidates) {
        int t = 0;
        int last = 0;
        int[] startTime = new int[N+1];
        Queue<Task> que = new LinkedList<>();
        que.offer(new Task(1, 0));
        while (!que.isEmpty()) {
            Task task = que.poll();
            last = task.n;
            if (candidates.contains(task.n)) {
                t = Math.max(t, task.startTime);
            } else {
                t = Math.max(t, task.startTime+times[task.n]);
            }

            for (int next : order.get(task.n)) {
                prev[next]--;
                if (candidates.contains(task.n)) {
                    startTime[next] = Math.max(startTime[next], task.startTime);
                } else {
                    startTime[next] = Math.max(startTime[next], task.startTime+times[task.n]);
                }
                if (prev[next] == 0) {
                    que.offer(new Task(next, startTime[next]));
                }
            }
        }
        if (candidates.contains(last)) {
            return Integer.MAX_VALUE;
        }
        return t;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        times = new int[N+1];
        int[] prev = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<=N; i++) {
            order.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            order.get(a).add(b);
            prev[b]++;
        }

        dfs(2, 0, prev, new HashSet<Integer>());
        System.out.println(result);
    }
}