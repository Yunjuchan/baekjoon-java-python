import java.util.*;

class Solution {
    
    static int[] dy, dx;
    public int[] solution(int m, int n, int s, int[][] time_map) {
        int moveDistance = Integer.MAX_VALUE;
        int sumOfTalkTime = Integer.MAX_VALUE;
        
        dy = new int[] {1,0,-1,0};
        dx = new int[] {0,1,0,-1};
        
        long[][] dist = new long[m][n];
        long[][] time = new long[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<long[]> que = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[2] == o2[2]) {
                    return Long.compare(o1[3], o2[3]);
                }
                return Long.compare(o1[2], o2[2]);
            }
        });
      
        que.offer(new long[]{0, 0, 0, 0});
        dist[0][0] = 0;
        time[0][0] = 0;
        
        while (!que.isEmpty()) {
            
            long[] cur = que.poll();
            int y = (int) cur[0];
            int x = (int) cur[1];
            
            if (dist[y][x] < cur[2]) {
                dist[y][x] = cur[2];
                time[y][x] = cur[3];
            } else if (dist[y][x] == cur[2] && time[y][x] < cur[3]) {
                continue;
            }
            
            if (y == m - 1 && x == n - 1) {
                if (cur[2] < moveDistance) {
                    moveDistance = (int) cur[2];
                    sumOfTalkTime = (int) cur[3];    
                } else if ((int) cur[2] == moveDistance && (int) cur[3] < sumOfTalkTime) {
                    sumOfTalkTime = (int) cur[3];
                }
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n || time_map[ny][nx] == -1 || cur[3] + time_map[ny][nx] > s || cur[3] + time_map[ny][nx] >= time[ny][nx]) {
                    continue;
                }
                if (dist[ny][nx] > cur[2] + 1) {
                    dist[ny][nx] = cur[2] + 1;
                    time[ny][nx] = (long) (cur[3] + time_map[ny][nx]);
                } else if (dist[ny][nx] == cur[2] + 1 && time[ny][nx] > cur[3] + time_map[ny][nx]) {
                    time[ny][nx] = (long) (cur[3] + time_map[ny][nx]);
                }
                que.offer(new long[]{ny, nx, cur[2] + 1, (long) (cur[3] + time_map[ny][nx])});
            }
        }
        
        int[] answer = new int[2];
        answer[0] = moveDistance;
        answer[1] = sumOfTalkTime;
      
        return answer;
    }
}