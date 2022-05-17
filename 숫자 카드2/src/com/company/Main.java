package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cards = new HashMap<Integer, Integer>();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++){
            int card = Integer.parseInt(st.nextToken());

            if(cards.containsKey(card))
                cards.put(card, cards.get(card) + 1);
            else
                cards.put(card,1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<M; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Object[] mapkey = cards.keySet().toArray(new Integer[0]);
        Arrays.sort(mapkey);

        for(int i=0 ; i < M ; i++) {
            int target = nums[i];
            int start = 0, end = N-1;
            int mid = (start + end)/2;
            boolean flag = true;

            if(cards.containsKey(target))
                bw.write(cards.get(target) + " ");
            else
                bw.write("0 ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
