package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<N; i++)
            list.add(Integer.parseInt(st.nextToken()));

        int result = Collections.max(list) * Collections.min(list);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
