package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] matrix = new int[N+1];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            matrix[i] = Integer.parseInt(st.nextToken());
            matrix[i+1] = Integer.parseInt(st.nextToken());
        }

        long[][] table = new long[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            table[i][i] = 0;

        int i, j, k;
        long tmp = 0;

        for(int r=2; r<=N; r++) {

            for(i = 1; i<= N-r+1; i++) {

                j = i + r - 1;
                table[i][j] = Long.MAX_VALUE;

                for(k=i; k<= j-1; k++) {

                    tmp = table[i][k] + table[k+1][j] + (long) matrix[i - 1] * matrix[k] * matrix[j];
                    if( tmp < table[i][j] ){

                        table[i][j] = tmp;
                        dp[i][j] = k;
                    }

                }
            }

        }
        bw.write(Long.toString(table[1][N]));

        bw.flush();
        br.close();
        bw.close();
    }
}
