package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st= new StringTokenizer(str);

        Long[] list = new Long[N];
        Long sum = 0L;
        for(int i=0 ;i<N; i++) {
            list[i] = Long.parseLong(st.nextToken());
            sum += list[i];
        }
        Long ave = sum / N;
        int result = 0;
        int previous = 0;
        for(Long kits: list) {
            result += Math.abs(previous);
            previous -= (kits - ave);
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
