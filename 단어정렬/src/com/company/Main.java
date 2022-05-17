package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();

        for(int i=0 ;i<N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    if(o1.compareTo(o2)>0)
                        return 1;
                    else if(o1.compareTo(o2)<0)
                        return -1;
                return 0;
            }
        });

        for(String str: list) {
            bw.write(str + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
