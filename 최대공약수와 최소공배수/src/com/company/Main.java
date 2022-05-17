package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // greatest common factor
        int gcf = GCF(N,M);
        // Least common multiple
        int lcm = LCM(gcf,N,M);

        System.out.println(gcf);
        System.out.println(lcm);
        br.close();
    }

    static int GCF(int n, int m) {

        int gcf = 1;
        List<Integer> nlist = new ArrayList<Integer>();
        int tmp = n;
        for(int i=n-1; i>1; i--) {
            if(tmp%i == 0) {
                nlist.add(tmp/i);
                tmp = i;
            }
        }
        nlist.add(tmp);

        List<Integer> mlist = new ArrayList<Integer>();
        tmp = m;
        for(int i=m-1; i>1; i--) {
            if(tmp%i==0) {
                mlist.add(tmp/i);
                tmp = i;
            }
        }
        mlist.add(tmp);

        for(int num: nlist) {
            if(mlist.size() == 0)
                break;
            if(mlist.contains(num)) {
                gcf *= num;
                mlist.remove( mlist.indexOf(num));
            }
        }

        return gcf;
    }
    static int LCM(int gcf, int n, int m) {
        int lcm = gcf * n/gcf * m/gcf;
        return lcm;
    }
}
