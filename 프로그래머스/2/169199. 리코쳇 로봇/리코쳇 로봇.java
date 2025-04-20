import java.util.*;

class Solution {
    
    static int N, M;
    static int[] dy = new int[] {1,0,-1,0};
    static int[] dx = new int[] {0,-1,0,1};
    static boolean[][] visited;
    
    public static int bfs(String[] board, int y, int x) {
        visited[y][x] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0, y, x});
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur[1];
                int nx = cur[2];
                
                while (true) {
                    ny += dy[i];
                    nx += dx[i];
                    
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || board[ny].charAt(nx) == 'D') {
                        ny -= dy[i];
                        nx -= dx[i];
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            if (board[ny].charAt(nx) == 'G') {
                                return cur[0] + 1;
                            }
                            que.offer(new int[] {cur[0] + 1, ny, nx});
                        }
                        break;
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        
        int answer = -1;
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    return bfs(board, i, j);
                }
            }
        }
        
        
        
        return answer;
        
    }
}