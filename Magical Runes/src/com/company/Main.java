package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
* A 일 경우 B로 바꿈,
* 맨 왼쪽 B에서 A로 바꿈
* B -> A로 바꿨으니 다음 파트로 넘어감
* 반복
* ABBAA   0 1 1 0 0  = 2^3 + 2^2 = 12
* BBBAA   1 1 1 0 0  = 2^
* AAABA   0 0 0 1 0
* BAABA   1 0 0 1 0
* */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String rune = sc.nextLine();
        StringTokenizer st = new StringTokenizer(rune);
        rune = st.nextToken();
        int D = Integer.parseInt(st.nextToken());

        int len = rune.length();
        int bit = 0;
        for(int i=len-1; i>=0; i--) {
            if(rune.charAt(i)=='B') {
                bit = bit << 1;
                bit = bit | 1;
            }
            else
                bit = bit << 1;
        }
        bit += D;

        rune = Integer.toBinaryString(bit);
        StringBuilder ans= new StringBuilder();

        for(int i=rune.length()-1; i>=0; i--) {
            if( rune.charAt(i) == '0')
                ans.append("A");
            else
                ans.append("B");
        }
        for(int i=0; i< len - rune.length(); i++)
            ans.append("A");
        System.out.println(ans);
    }
}
