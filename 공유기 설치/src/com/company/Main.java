package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*  결국 답 보고 푼 문제
*  16시간 고민 끝에 답을 봤지만 기분이 더 안좋아졌다.
*  생각의 전환 한번만 하면 되는데 이걸 못해서 못 풀었다.
* */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] lengths = new long[N+1];
        for(int i=1 ; i<=N; i++) {
            lengths[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lengths);

        long result = 0;


        long start = 1, end = lengths[lengths.length-1] - lengths[1];
        long mid = 0;

        while(start <= end) {
            mid = (start+end) /2;

            if(PossibleLen(lengths, mid, C)) {
                start = mid + 1;
                result = Math.max(result, mid);
            }
            else
                end = mid - 1;
        }

        bw.write(Long.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean PossibleLen (long[] len, long cutLen, long num) {

        long count = 1;
        long value = len[1];

        for(int i=1; i<= len.length-1; i++) {
            if(value + cutLen <= len[i]) {
                count ++;
                value = len[i];
            }
        }

        if(count >= num)
            return true;

        return false;
    }

}