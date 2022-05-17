package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 0;
        int i = 666;
        while( count < N) {
            if(Integer.toString(i).contains("666"))
                count++;
            if(count == N)
                break;
            i++;
        }

        System.out.println(i);
    }
}
