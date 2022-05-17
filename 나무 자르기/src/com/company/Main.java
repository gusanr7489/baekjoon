package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3 , 4, 5  여기서 height = 3이라면 자를 수 있는 수 = 1 + 2 = 3
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str);
        long [] heightOfTree = new long[N+1];

        for(int i=1; i<=N; i++) {
            heightOfTree[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(heightOfTree);

        long result =0 ;


        long start = 1, end = heightOfTree[heightOfTree.length-1];
        long cutHeight = (start + end) / 2;
        while(start <= end) {

            if( isCut(heightOfTree, cutHeight, M) ){
                start = cutHeight + 1;
                result = Math.max(result, cutHeight);
            }
            else {
                end = cutHeight - 1;
            }
            cutHeight = (start + end) / 2;
        }

        bw.write(Long.toString(result));

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isCut(long[] heights, long cutHeight, long target) {
        long sum= 0;
        for(int i=1; i<=heights.length-1; i++) {
           if (heights[i] > cutHeight)
               sum += (heights[i] - cutHeight);
        }
        if(sum >= target)
            return true;
        else
            return false;
    }
}
