import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int max = 0, N, M;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc2X2();
        calc1X4();
        calc4X1();
        calc2X3();
        calc3X2();

        System.out.println(max);

    }

    private static void calc2X2() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int sum = 0;
                sum += arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }
    }

    private static void calc1X4() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 3; j++) {
                int sum = 0;
                sum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
                max = Math.max(max, sum);
            }
        }
    }

    private static void calc4X1() {
        for (int i = 0; i < N - 3; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                sum += arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
                max = Math.max(max, sum);
            }
        }
    }

    private static void calc2X3() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 2; j++) {
                int sum = sumBlock(i, j, i + 1, j + 2);
                //orange2X3
                max = Math.max(max, sum - arr[i][j] - arr[i][j + 1]);
                max = Math.max(max, sum - arr[i][j + 1] - arr[i][j + 2]);
                max = Math.max(max, sum - arr[i + 1][j] - arr[i + 1][j + 1]);
                max = Math.max(max, sum - arr[i + 1][j + 1] - arr[i + 1][j + 2]);

                //green2X3
                max = Math.max(max, sum - arr[i][j] - arr[i + 1][j + 2]);
                max = Math.max(max, sum - arr[i + 1][j] - arr[i][j + 2]);

                //purple2X3
                max = Math.max(max, sum - arr[i][j] - arr[i][j + 2]);
                max = Math.max(max, sum - arr[i + 1][j] - arr[i + 1][j + 2]);
            }
        }
    }

    private static void calc3X2() {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 1; j++) {
                int sum = sumBlock(i, j, i + 2, j + 1);
                //orange3X2
                max = Math.max(max, sum - arr[i][j] - arr[i + 1][j]);
                max = Math.max(max, sum - arr[i][j + 1] - arr[i + 1][j + 1]);
                max = Math.max(max, sum - arr[i + 1][j] - arr[i + 2][j]);
                max = Math.max(max, sum - arr[i + 1][j + 1] - arr[i + 2][j + 1]);

                //green3X2
                max = Math.max(max, sum - arr[i][j + 1] - arr[i + 2][j]);
                max = Math.max(max, sum - arr[i][j] - arr[i + 2][j + 1]);

                //purple3X2
                max = Math.max(max, sum - arr[i][j] - arr[i + 2][j]);
                max = Math.max(max, sum - arr[i][j + 1] - arr[i + 2][j + 1]);

            }
        }
    }


    private static int sumBlock(int x, int y, int x2, int y2) {
        int sum = 0;
        for (int i = x; i <= x2; i++) {
            for (int j = y; j <= y2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
