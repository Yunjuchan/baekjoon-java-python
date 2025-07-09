import java.util.*;

class Solution {
    
    public static class Node {
        int d;
        int cnt;
        int y;
        int x;
        
        public Node(int d, int cnt, int y, int x) {
            this.d = d;
            this.cnt = cnt;
            this.y = y;
            this.x = x;
        }
    }
    
    public int[] solution(String[] grid) {
        int N = grid.length;
        int M = grid[0].length();
        boolean[][][] visited = new boolean[N][M][4];
        
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        List<Integer> arr = new ArrayList<>();
        int[] answer = {};
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int d = 0; d < 4; d++) {
                    
                    if (visited[y][x][d]) {
                        continue;
                    }
                    
                    Queue<Node> que = new LinkedList<>();
                    Node start = new Node(d, 0, y, x);
                    que.offer(new Node(d, 0, y, x));

                    while (!que.isEmpty()) {
                        Node cur = que.poll();
                        
                        int ny = (cur.y + dy[cur.d] + N) % N;
                        int nx = (cur.x + dx[cur.d] + M) % M;
                        
                        
                        if (grid[ny].charAt(nx) == 'L') {
                            cur.d = (cur.d + 1) % 4;
                        } else if (grid[ny].charAt(nx) == 'R') {
                            cur.d = (cur.d + 3) % 4;
                        }
                        
                        if (start.d == cur.d && start.y == ny && start.x == nx) {
                            arr.add(cur.cnt + 1);
                            break;
                        }
                        
                        visited[ny][nx][cur.d] = true;
                        que.offer(new Node(cur.d, cur.cnt + 1, ny, nx));
                    }
                }        
            }
        }
        
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        Arrays.sort(answer);
    
        
        return answer;
    }
}