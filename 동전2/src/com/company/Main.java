package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        for(int i=0 ;i<N; i++) {
            arr[i+1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dp = new int[K+1];

        for(int i=1; i<=K; i++) {
            dp[i] = 100001;
        }
        dp[0] = 0;
        for(int i=1; i<=N; i++) {
            for(int j=arr[i]; j<=K; j++) {
                if(dp[j] > dp[j-arr[i]] + 1)
                    dp[j] = dp[j-arr[i]] + 1;
                else
                    dp[j] = dp[j];
            }
        }
        if(dp[K] == 100001)
            bw.write("-1" + "\n");
        else
            bw.write(Integer.toString(dp[K]));
        bw.flush();
        br.close();
        bw.close();
    }
}
