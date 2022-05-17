package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int count = 0;

        int[] dp = new int[X+1];

        if(X>3) {
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            int tmp;
            for(int i=4; i<=X; i++) {
                if(i%3==0) {
                    tmp = Math.min(dp[i/3], dp[i-1]);
                    if(i%2==0)
                        tmp = Math.min(tmp, dp[i/2]);
                    dp[i] = tmp + 1;
                }
                else if(i%2==0)
                    if(dp[i-1] < dp[i/2])
                        dp[i] = dp[i-1] +1;
                    else
                        dp[i] = dp[i/2] +1;
                else
                    dp[i] = dp[i-1] + 1;
                //System.out.println("i: "+ i + " dp: "+ dp[i]);
            }

            System.out.println(Integer.toString(dp[X]));
        }
        else if(X==1)
            System.out.println("0");
        else
            System.out.println("1");

        br.close();
    }
}
