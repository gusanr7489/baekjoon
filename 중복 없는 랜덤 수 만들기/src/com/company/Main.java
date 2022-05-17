package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("사람 수? --> ");
        int N = Integer.parseInt(br.readLine()) / 2;
        List<Integer> random_1 = new ArrayList<Integer>();
        List<Integer> random_2 = new ArrayList<Integer>();

        while(true) {
            if( random_1.size() == N )
                break;

            int ran = (int)((Math.random() * 10000)%(N) +1);
            if( random_1.contains(ran))
                continue;

            random_1.add(ran);
        }

        int i = 0;
        while(true) {
            if( random_2.size() == N )
                break;

            int ran = (int)( (Math.random() * 10000)% (N) +1);

            if( random_2.contains(ran))
                continue;

            if( random_1.get(i) == ran)
                continue;

            boolean flag = false;
            if( i<=5) {
                for (int k = 0; k < 4; k++) {
                    if (random_1.get(k) == ran)
                        flag = true;
                }
            }
            if(flag)
                continue;

            random_2.add(ran);
            i++;
        }

        for(i = 0; i<N; i++)
            System.out.println(random_1.get(i) + " " + random_2.get(i));
        br.close();
    }
}
