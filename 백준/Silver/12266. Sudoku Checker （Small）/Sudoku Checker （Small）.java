import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] sdoku = new int[N*N][N*N];
            boolean flag = false;
            // 값 저장 및 행체크
            for (int i=0; i<N*N; i++) {
                st = new StringTokenizer(br.readLine());

                int sumR = 0;
                Set<Integer> setR = new HashSet<>();
                for (int j=0; j<N*N; j++) {
                    sdoku[i][j] = Integer.parseInt(st.nextToken());
                    if (sdoku[i][j] < 1 && sdoku[i][j] > N*N) {
                        flag = true;
                    }
                    setR.add(sdoku[i][j]);
                    sumR += sdoku[i][j];
                }
                if (setR.size() != 9 || sumR != N*N*(N*N+1)/2) {
                    flag = true;
                }
            }

            if (flag) {
//                System.out.println("행 틀림");
                sb.append("Case #").append(t).append(": No\n");
                continue;
            }

            // 열체크
            for (int i=0; i<N*N; i++) {
                int sumC = 0;
                Set<Integer> setC = new HashSet<>();
                for (int j=0; j<N*N; j++) {
                    setC.add(sdoku[i][j]);
                    sumC += sdoku[j][i];
                }
                if (setC.size() != 9 || sumC != N*N*(N*N+1)/2) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
//                System.out.println("열 틀림");
                sb.append("Case #").append(t).append(": No\n");
                continue;
            }


            // 서브시스템 체크
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    int sumSub = 0;
                    Set<Integer> setSub = new HashSet<>();
                    for (int ii=0; ii<N; ii++) {
                        for (int jj=0; jj<N; jj++) {
                            setSub.add(sdoku[3*i+ii][3*j+jj]);
                            sumSub += sdoku[3*i+ii][3*j+jj];
                        }
                    }
                    if (setSub.size() != 9 || sumSub != N*N*(N*N+1)/2) {

                        System.out.println(i + " " + j);
                        System.out.println(setSub.size() + " " + sumSub);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (flag) {
//                System.out.println("서브시스템 틀림");
                sb.append("Case #").append(t).append(": No\n");
                continue;
            }

            sb.append("Case #").append(t).append(": Yes\n");
        }
        System.out.println(sb.toString());
    }
}