package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);
        int sum = 0;
        int max = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    sum = list.get(i) + list.get(j) + list.get(k);
                    if( sum > M)
                        break;
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}
