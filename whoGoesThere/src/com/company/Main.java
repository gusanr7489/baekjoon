package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] schools = new int[M];

        for(int i= 0; i<M ; i++) {
            schools[i] = Integer.parseInt(br.readLine());
        }
        int[] result = new int[M];

        int count = 0;
        while(count <= 100) {

            for(int i=0; i<M; i++){
                if(count == N)
                    break;
                if( result[i] == schools[i] )
                    continue;
                result[i]++;
                count++;
            }
        }

        for(int n: result)
            bw.write(Integer.toString(n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
