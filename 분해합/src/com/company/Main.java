package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(str);

        int split;
        boolean flag = false;
        for(int i=1; i<=N; i++) {

            split = i;
            String tmp = Integer.toString(i);
            String[] splt = tmp.split("");
            for(String st: splt) {
                split += Integer.parseInt(st);
            }

            if( split == N) {
                System.out.println(i);
                flag = true;
                break;
            }

        }
        if(!flag) {
            System.out.println("0");
        }

        br.close();
    }
}
