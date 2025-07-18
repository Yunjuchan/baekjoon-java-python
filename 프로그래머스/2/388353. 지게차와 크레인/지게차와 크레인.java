import java.util.*;
class Solution {
    
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, -1, 0, 1};
    
    public int solution(String[] storage, String[] requests) {
        
        int n = storage.length;
        int m = storage[0].length();
        int answer = n * m;
        char[][] containers = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                containers[i][j] = storage[i].charAt(j);
            }
        }
        
        for (String r : requests) {
            char c = r.charAt(0);
            int cnt = 0;
            List<int[]> arr = new ArrayList<>();
            
            if (r.length() == 1) {
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < m; x++) {
                        boolean pick = false;
                        if (containers[y][x] != c) {
                            continue;
                        }
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= m || containers[ny][nx] == ' ') {
                                pick = true;
                                break;
                            }
                        }
                        if (pick) {
                            arr.add(new int[] {y, x});
                            cnt++;
                        }
                    }
                }
            } else {
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < m; x++) {
                        if (containers[y][x] != c) {
                            continue;
                        }
                        
                        containers[y][x] = '-';
                        arr.add(new int[] {y, x});
                        cnt++;
                    }
                }
            }
            
            answer -= cnt;
            
            // 창고 상황 변경
            
            if (r.length() == 1) {
                Queue<int[]> que = new LinkedList<>();
                for (int[] x : arr) {
                    containers[x[0]][x[1]] = ' ';
                    que.offer(new int[] {x[0], x[1]});
                }
                
                while (!que.isEmpty()) {
                    int[] cur = que.poll();
                    int y = cur[0];
                    int x = cur[1];
                    containers[y][x] = ' ';

                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= m || containers[ny][nx] != '-') {
                            continue;
                        }
                        que.offer(new int[] {ny, nx});
                    }
                }
                
            } else {
                Queue<int[]> que = new LinkedList<>();

                for (int[] can : arr) {
                    int y = can[0];
                    int x = can[1];
                    if (containers[y][x] != '-') {
                        continue;
                    }
                    boolean outSide = false;
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= m || containers[ny][nx] == ' ') {
                            outSide = true;
                            break;
                        }
                    }

                    if (outSide) {
                        que.offer(new int[] {y, x});
                    }
                }

                while (!que.isEmpty()) {
                    int[] cur = que.poll();
                    int y = cur[0];
                    int x = cur[1];
                    containers[y][x] = ' ';

                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        if (ny < 0 || nx < 0 || ny >= n || nx >= m || containers[ny][nx] != '-') {
                            continue;
                        }
                        que.offer(new int[] {ny, nx});
                    }
                }
            }
        }
        
        return answer;
    }
}