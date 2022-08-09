
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==b) {sb.append(1).append("\n"); continue;}

            int[][] dp = new int[a+1][b+1];
            for(int j=1; j<=a; j++) {
                for(int k=1; k<=b; k++) {
                    if(j==k) dp[j][k] = 1;
                    else if(j==1) dp[j][k] = k;
                    else dp[j][k] = dp[j][k-1] + dp[j-1][k-1];
                }
            }

            sb.append(dp[a][b]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
