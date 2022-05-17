package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = 1000000;
        if( Math.abs(x-w) < min)
            min = Math.abs(x-w);

        if( x < min )
            min = x;

        if( Math.abs(y-h) < min)
            min = Math.abs(y-h);

        if( y < min)
            min = y;

        System.out.println( Integer.toString(min));
        br.close();
    }
}
