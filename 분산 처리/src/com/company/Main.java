package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            double[] pattern = new double[5];
            for(int j=1; j<=4; j++){
                pattern[j] = Math.pow(a,j) % 10;
            }
            b = b % 4;
            if(b==0)
                b = 4;

            result[i] = (int) pattern[b];
            if(result[i]==0)
                result[i]=10;
        }

        for(int i=0; i<N; i++)
            bw.write( Integer.toString(result[i]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
