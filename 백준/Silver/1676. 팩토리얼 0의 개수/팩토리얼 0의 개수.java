/*
* 0의 개수를 찾으려면 10의 개수가 몇개인지 알면 된다.
* 따라서 5와 2의 개수를 알면 10의 개수를 알 수 있고,
* 0<=N<=500은 항상 2의 개수 >= 5의 개수를 만족하므로 ( 2 4 8 16 ... , 5 10 15 ...)
* 5의 개수는 10의 개수와 동일하다.
* */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count_five=0;
        while(N!=0) {

            int tmp = N;
            while(tmp%5 == 0) {
                count_five++;
                tmp = tmp/5;
            }

            N--;
        }

        System.out.println(count_five);
        br.close();
    }

}
