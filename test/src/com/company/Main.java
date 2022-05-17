package com.company;

import java.io.*;
import java.util.*;
/*
    N번째의 영화 제목에 들어가는 수 출력
    1. 브루트포스니까 모든 수를 구해야 하나
    2. 1~5 까지 앞의 수 바뀜 , 6부터 뒷자리수 바뀜
    3. 다시 7~15까지 앞의 수 바뀜, 16부터 뒷자리 수 바뀜
    4. 17~26까지 앞의 수, 26부터 뒷자리 수 바뀌고
    5. 26, 36, ~ 56까지 2번 반복
    6. 66부터는 뒤의 두자리 수까지 바뀜
    7. 76 ~ 106까진 다시 2번 반복
    8. 166, 266, 366
    9. 666, 1666, 2666 ~ 일경우 뒷자리 3자리까지 바뀜
* */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(str + "??!");
        br.close();
    }
}
