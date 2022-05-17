package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<M; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        for(int i=0 ; i < M ; i++) {
            int target = nums[i];
            int start = 0, end = N-1;
            int mid = (start + end)/2;
            boolean flag = true;
            while(start <= end) {
                if( cards[mid] == target) {
                   bw.write("1 ");
                   flag = false;
                   break;
                }
                else if(cards[mid] > target) {
                    end = mid - 1;
                }
                else start = mid + 1;

                mid = (start + end) /2;
            }

            if(flag)
                bw.write("0 ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
