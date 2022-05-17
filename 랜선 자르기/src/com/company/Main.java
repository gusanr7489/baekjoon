package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

/*
*  2 5
* 10
* 20
*  = 5
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long[] lengths = new long[K+1];

        for(int i=1; i<=K; i++) {
            lengths[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lengths);

        long start = 1, end = lengths[lengths.length-1];
        long mid = (start + end) / 2;
        long result = 0;

        while(start<=end) {

            if(PossibleCut(lengths, mid, N)) {
                start = mid +1;
                result = Math.max(result, mid);
            }
            else {
                end = mid -1;
            }
            mid = (start + end) /2;
        }

        bw.write(Long.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean PossibleCut(long[] lens, long cutLen, long target) {
        long count = 0;

        for(int i=1 ; i<=lens.length-1; i++) {
            count += ( lens[i] / cutLen );
        }
        if( count >= target )
            return true;
        else
            return false;
    }
}
