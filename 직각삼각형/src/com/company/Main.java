package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<String>();

        while(true) {
            String str = br.readLine();
            if(str.equals("0 0 0"))
                break;

            list.add(str);
        }

        for(String str : list) {
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int hyp = Integer.parseInt(st.nextToken());

            if(a>b && a>hyp){
                int tmp = hyp;
                hyp = a;
                a = tmp;
            } else if(b>a && b>hyp) {
                int tmp = hyp;
                hyp = b;
                b = tmp;
            }

            if( Math.pow(a,2) + Math.pow(b,2) == Math.pow(hyp,2) )
                bw.write("right\n");
            else
                bw.write("wrong\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
