package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str);
        int[] find = new int[M];
        for(int i=0; i<M; i++)
            find[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        for(int i=0; i<M; i++) {
            int start = 0, end = N - 1;
            int mid = (start + end) / 2;
            int target = find[i];
            boolean flag = true;

            while (start <= end) {
                if (nums[mid] == target) {
                    flag = false;
                    bw.write("1\n");
                    break;
                }
                else if(nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;

                mid = (start + end) /2;
            }

            if(flag)
                bw.write("0\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
