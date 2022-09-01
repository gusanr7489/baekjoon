
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int conn = Integer.parseInt(st.nextToken());

        int[][] floid = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) floid[i][j] = 0;
                else floid[i][j] = 101;
            }
        }

        for(int i=0; i<conn; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            floid[a][b] = 1;
            floid[b][a] = 1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++) {
                    floid[i][j] = Math.min(floid[i][j], floid[i][k]+floid[k][j]);
                }
            }
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=1; j<=N; j++) {
                sum += floid[i][j];
            }
            if(min > sum) {
                min = sum;
                ans = i;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
