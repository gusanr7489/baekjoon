package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] line = new String[N];
        for(int i=0; i<N; i++)
            line[i] = br.readLine();

        int min = 10000000;

        char prev, next;
        prev = 'W';
        next = 'B';

        for(int r=0; r<= N-8; r++) {
            for(int k=0; k<=M-8; k++) {

                int count = 0, count_2 = 0;
                int comp=0;

                for (int i = r; i < r+8; i++) {
                    //boolean flag = true;
                    for (int j = k; j < k+8; j++) {

                        boolean a = (line[i].charAt(j) != prev);
                        boolean b = (line[i].charAt(j) != next);
                        if (a)
                            count++;
                        if (b)
                            count_2++;
                        //flag = !flag;
                        char tmp = prev;
                        prev = next;
                        next = tmp;
                    }
                    char tmp = prev;
                    prev = next;
                    next = tmp;
                }
                comp = Math.min(count_2, count);
                min = Math.min(min, comp);
            }
        }
        System.out.println( min);

        br.close();
    }
}
