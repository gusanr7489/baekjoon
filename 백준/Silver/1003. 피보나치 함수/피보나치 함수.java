import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++ ) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for(int k=0; k<N; k++) {
            int[][] dp = new int[arr[k]+1][2];

            if(arr[k] == 0) {
                sb.append("1 0").append("\n");
                continue;
            }
            else if(arr[k] == 1) {
                sb.append("0 1").append("\n");
                continue;
            }

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for(int i=2; i<=arr[k];i++) {
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }

            sb.append(dp[arr[k]][0]).append(" ").append(dp[arr[k]][1]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
