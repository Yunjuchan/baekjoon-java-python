import java.util.*;
import java.io.*;

class Solution {
    public static int N, result;
    public static List<Integer> time;
    public static List<int[]> people, exit;

    public static void dfs(int level, boolean[] visited) {
        if (level == people.size()) {
            int tmp = downTime(visited);
            result = Math.min(result, tmp);
            return;
        }

        dfs(level+1, visited);
        visited[level] = true;
        dfs(level+1, visited);
        visited[level] = false;


    }

    public static int downTime(boolean[] visited) {
        Queue<Integer> A = new PriorityQueue<>();
        Queue<Integer> B = new PriorityQueue<>();
        for (int i=0; i<people.size(); i++) {
            int[] p = people.get(i);
            if (visited[i]) {
                int[] e = exit.get(0);
                A.offer(Math.abs(p[0] - e[0]) + Math.abs(p[1] - e[1])+1);
            } else {
                int[] e = exit.get(1);
                B.offer(Math.abs(p[0] - e[0]) + Math.abs(p[1] - e[1])+1);
            }
        }
        // System.out.println("A: " + calc(A, time.get(0)) + " B: " + calc(B, time.get(1)));
        return Math.max(calc(A, time.get(0)), calc(B, time.get(1)));
    }

    public static int calc(Queue<Integer> que, int t) {
        int result = 0;
        Queue<Integer> stair = new LinkedList<>();
        while (!que.isEmpty()) {
            int next = que.poll();
            if (stair.size() < 3) {
                stair.offer(next+t);
                result = next+t;
            } else {
                if (stair.peek() > next) {
                    stair.offer(stair.peek()+t);
                    result = stair.peek()+t;
                    stair.poll();
                } else {
                    stair.offer(next+t);
                    result = next+t;
                    stair.poll();
                }
            }
        }
        return result;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[][] arr;

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            time = new ArrayList<>();
            exit = new ArrayList<>();
            people = new ArrayList<>();
            result = Integer.MAX_VALUE;

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x > 1) {
                        exit.add(new int[]{i, j});
                        time.add(x);
                    } else if (x == 1) {
                        people.add(new int[]{i, j});
                    }
                }
            }
            dfs(0, new boolean[people.size()]);
            System.out.println("#" + tc + " " + result);
        }
    }
}