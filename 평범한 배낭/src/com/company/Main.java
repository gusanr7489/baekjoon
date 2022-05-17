package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static class Item {
        int weight;
        int value;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Item> list = new ArrayList<Item>();

        for(int i=0; i<N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            Item item = new Item();
            item.weight = Integer.parseInt(st.nextToken());
            item.value = Integer.parseInt(st.nextToken());
            list.add(item);
        }

        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        int[][] bag = new int[N+1][K+1];

        for(int i=0; i<=K; i++) {
            bag[0][i] = 0;
        }


        for(int i=1; i<=N; i++) {
            bag[i][0] = 0;

            for(int j=1; j<=K; j++) {

                Item o1 = list.get(i-1);

                if(o1.weight <= j) {

                    if(o1.value + bag[i-1][j-o1.weight] > bag[i-1][j])
                        bag[i][j] = o1.value + bag[i-1][j-o1.weight];
                    else
                        bag[i][j] = bag[i-1][j];
                }
                else {
                    bag[i][j] = bag[i-1][j];
                }
            }
        }
        bw.write(Integer.toString(bag[N][K]));


        bw.flush();
        br.close();
        bw.close();
    }
}
