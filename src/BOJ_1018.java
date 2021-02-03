import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처 : https://st-lab.tistory.com/101?category=855026
 */
public class BOJ_1018 {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for(int i = 0; i < N_row; i++) {
            for(int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for(int i = x; i < end_x; i++) {
            for(int j = y; j < end_y; j++) {

                if(arr[i][j] != TF) {
                    count++;
                }

                TF = !TF;
            }
            TF = !TF;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}
