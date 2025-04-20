import java.util.*;

class Solution {
    
    static int N, M;
    static int[] dy = new int[] {1,0,-1,0};
    static int[] dx = new int[] {0,1,0,-1};
    static int[][] intMap;
    
    public static int bfs(int y, int x) {
        int day = intMap[y][x];
        intMap[y][x] = 0;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {y, x});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || intMap[ny][nx] == 0) {
                    continue;
                }
                que.offer(new int[] {ny, nx});
                day += intMap[ny][nx];
                intMap[ny][nx] = 0;
            }
        }
        return day;
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        N = maps.length;
        M = maps[0].length();
        intMap = new int[N][M];
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X') {
                    continue;
                }
                intMap[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (intMap[i][j] != 0) {
                    arr.add(bfs(i, j));
                }
            }
        }
        Collections.sort(arr);
        
        if (arr.isEmpty()) {
            answer = new int[] {-1};
        } else {
            answer = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
               answer[i] = arr.get(i);
            }
        }
        return answer;
    }
}