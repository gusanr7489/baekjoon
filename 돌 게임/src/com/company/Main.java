package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N %2 == 1)
            bw.write("SK");
        else
            bw.write("CY");
        bw.flush();
        bw.close();
        br.close();
    }
}
