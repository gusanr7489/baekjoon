package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        for(int i =0; i<N; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);
        for(int n: list)
            bw.write(Integer.toString(n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
