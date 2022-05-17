package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<Integer>();
        int[] result = new int[N];

        for(int i=1; i<= N; i++)
            list.add(i);

        int count = 0;
        int pick = K-1;
        for(int i=0; i<N-1; i++) {
            result[count++] = list.get(pick);
            list.remove(pick);
            pick = (pick + K-1) % list.size();
        }
        result[count] = list.get(pick);
        // 1, 2, 3, 4, 5, 6, 7
        /*
        *  3
        * 1 2 x 4 5 6 7      1 2 4 5 6 7
        * 6               4 + 2 = 6 % 5 = 1
        * 1 2 x 4 5 x 7      1 2 4 5 7
        * 2               1 + 2 = 3 % 4 = 3
        * 1 x x 4 5 x 7      1 4 5 7
        * 7               3 + 2 = 5 % 3 = 2
        * 1 x x 4 5 x x      1 4 5
        * 5               2 + 2 = 4 % 2 = 0
        * 1 x x 4 x x x      1 4
        * */


        System.out.print("<");
        int i=0;
        for(int num: result) {
            if(i==N-1)
                System.out.print(num + ">\n");
            else
                System.out.print(num + ", ");
            i++;
        }
        br.close();
    }

}
