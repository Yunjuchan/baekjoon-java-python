import java.util.*;

class Solution {
    
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, -1, 0, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] arr = new int[101][101];
        int N = rectangle.length;
        
        for (int k = 0; k < N; k++) {
            int sx = rectangle[k][0] * 2;
            int sy = rectangle[k][1] * 2;
            int ex = rectangle[k][2] * 2;
            int ey = rectangle[k][3] * 2;
            for (int i = sy; i <= ey; i++) {
                for (int j = sx; j <= ex; j++) {
                    arr[i][j] = 1;
                }   
            }
        }
        
        for (int k = 0; k < N; k++) {
            int sx = rectangle[k][0] * 2;
            int sy = rectangle[k][1] * 2;
            int ex = rectangle[k][2] * 2;
            int ey = rectangle[k][3] * 2;
            for (int i = sy + 1; i < ey; i++) {
                for (int j = sx + 1; j < ex; j++) {
                    arr[i][j] = 0;
                }   
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[] {0, 0, characterY * 2, characterX * 2, -1});
        arr[characterY * 2][characterX * 2] = 0;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur[2] + dy[i];
                int nx = cur[3] + dx[i];
                
                if (ny < 0 || nx < 0 || ny > 100 || nx > 100 || arr[ny][nx] == 0) {
                    continue;
                }
                
                if (ny == itemY * 2 && nx == itemX * 2) {
                    return cur[0] + (cur[1] + 1) / 2;
                }
                
                if (cur[4] == i) {
                    que.offer(new int[] {cur[0], cur[1] + 1, ny, nx , i});
                    arr[ny][nx] = 0;
                } else {
                    que.offer(new int[] {cur[0] + cur[1] / 2, 1, ny, nx, i});
                    arr[ny][nx] = 0;
                }
            }
        }
        
        return 0;
    }
}