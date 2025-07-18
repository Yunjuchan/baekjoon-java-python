import java.util.*;

class Solution {
    
    public static class Robot {
        int rIdx;
        int y;
        int x;
        int goal;
        int gIdx;
        
        public Robot(int rIdx, int y, int x, int goal, int gIdx) {
            this.rIdx = rIdx;
            this.y = y;
            this.x = x;
            this.goal = goal;   // 현재 가야하는 목표
            this.gIdx = gIdx;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int[][] visited = new int[101][101];
        
        Queue<Robot> que = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            int p = routes[i][0] - 1;
            int y = points[p][0];
            int x = points[p][1];
            
            que.offer(new Robot(i, y, x, p, 0));
        }
        int t = 0;
        while (!que.isEmpty()) {
            visited = new int[101][101];
            List<Robot> status = new ArrayList<>();
            
            while (!que.isEmpty()) {
                Robot cur = que.poll();
                int p = cur.goal;
                
                if (points[p][0] > cur.y) {
                    cur.y++;
                } else if (points[p][0] < cur.y) {
                    cur.y--;
                } else {
                    if (points[p][1] > cur.x) {
                        cur.x++;
                    } else if (points[p][1] < cur.x) {
                        cur.x--;
                    }
                }
                
                visited[cur.y][cur.x]++;
                
                if (visited[cur.y][cur.x] == 2) {
                    answer++;
                }

                if (cur.y == points[p][0] && cur.x == points[p][1]) {
                    cur.gIdx++;
                    if (cur.gIdx == routes[cur.rIdx].length) {
                        continue;
                    } else {
                        cur.goal = routes[cur.rIdx][cur.gIdx] - 1;
                    }
                }
                status.add(cur);
            }
            
            for (Robot r : status) {
                que.offer(r);
            }
            t++;
        }
        
        return answer;
    }
}