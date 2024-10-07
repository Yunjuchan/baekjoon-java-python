import java.io.*;
import java.util.*;

public class Main {
    static int[] directY = {-1,-1,0,1,1,1,0,-1};
    static int[] directX = {0,1,1,1,0,-1,-1,-1};

    static class Fire {
        int r;  // 세로
        int c;  // 가로
        int m;  // 질량
        int s;  // 속력
        int d;  // 방향

        Fire (int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Fire> que = new LinkedList<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            que.offer(new Fire(r, c, m, s, d));
        }
        for (int i=0; i<K; i++) {
            Map<Integer, List<Fire>> next = new HashMap<>();
            while (!que.isEmpty()) {
                Fire f = que.poll();
                int nR = (N*1000 + f.r + f.s * directY[f.d]) % N;
                int nC = (N*1000 + f.c + f.s * directX[f.d]) % N;
                int key = nR * N + nC;
                if (next.containsKey(key)) {
                    List<Fire> replace = next.get(key);
                    replace.add(new Fire(nR, nC, f.m, f.s, f.d));
                    next.replace(key, replace);
                } else {
                    List<Fire> put = new ArrayList<>();
                    put.add(new Fire(nR, nC, f.m, f.s, f.d));
                    next.put(key, put);
                }
            }
            for (int nextKey : next.keySet()) {
                List<Fire> fList = next.get(nextKey);
                if (fList.size() != 1) {
                    int flag = 0;
                    Fire first = fList.get(0);
                    int mSum = first.m;
                    int sSum = first.s;
                    for (int j=1; j<fList.size(); j++) {
                        Fire compare = fList.get(j);
                        if (first.d % 2 != compare.d % 2) {
                            flag = 1;
                        }
                        mSum += compare.m;
                        sSum += compare.s;
                    }
                    if (mSum / 5 != 0) {
                        for (int k=0; k<4; k++) {
                            que.offer(new Fire(first.r, first.c, mSum / 5, sSum / fList.size(), 2*k+flag));
                        }
                    }
                } else {
                    Fire f = next.get(nextKey).get(0);
                    que.offer(new Fire(f.r, f.c, f.m, f.s, f.d));
                }
            }

        }
        long result = 0;
        for (Fire f : que) {
            result += f.m;
        }
        System.out.println(result);
    }
}