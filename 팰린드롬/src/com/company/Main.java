package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<String>();

        while(true) {
            String str = br.readLine();
            if( str.equals("0"))
                break;
            list.add(str);
        }

        for(String str: list) {

            Stack<Integer> stack = new Stack<Integer>();
            boolean flag = true;

            if(str.length()%2 == 1) {
                for(int i=0; i<str.length()/2; i++) {
                    int tmp = Integer.parseInt(Character.toString(str.charAt(i)));
                    stack.add( tmp);
                }

                for(int i=str.length()/2+1; i<str.length(); i++) {

                    int tmp = stack.pop();
                    if( tmp != Integer.parseInt(Character.toString(str.charAt(i)))) {
                        flag = false;
                        break;
                    }
                }
            }
            else {
                for(int i=0; i<str.length()/2; i++) {
                    int tmp = Integer.parseInt(Character.toString(str.charAt(i)));
                    stack.add( tmp);
                }

                for(int i=str.length()/2; i<str.length(); i++) {

                    int tmp = stack.pop();
                    if( tmp != Integer.parseInt(Character.toString(str.charAt(i)))) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag)
                bw.write("yes"+"\n");
            else
                bw.write("no"+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
