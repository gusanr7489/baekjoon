package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> inputs = new ArrayList<Integer>();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0)
                break;
            inputs.add(N);
        }

        for(int num: inputs) {

            int doubleN = num *2;
            boolean[] isNotPrime = new boolean[doubleN+1];
            isNotPrime[1] = true;
            isNotPrime[0] = true;

            for(int i=1; i<=doubleN; i++) {
                if(!isNotPrime[i]) {
                    for(int j=i+i; j<=doubleN; j= j+i) {
                        isNotPrime[j] = true;
                    }
                }
            }

            int count = 0;
            for(int i = num + 1; i<=doubleN; i++) {
                if(!isNotPrime[i])
                    count++;
            }
            list.add(count);
        }

        for(int counts : list)
            bw.write(Integer.toString(counts) + "\n");


        bw.flush();
        bw.close();
        br.close();
    }


}