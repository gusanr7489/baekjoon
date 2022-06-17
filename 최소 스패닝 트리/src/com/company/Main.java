package com.company;

import java.util.*;
import java.io.*;
/*
*
8 10
1 2 4
1 8 6
8 2 5
2 3 9
2 5 2
8 7 14
8 6 10
7 6 3
6 5 8
5 4 15
* */

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<int[]> weights = new ArrayList<>();

        for(int i=1; i<=E; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            weights.add(new int[] {start, end, weight});
        }

        weights.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        List<int[]> mst = new ArrayList<int[]>();
        int size = 0;
        int ans = 0;

        while(!weights.isEmpty()) {
            int[] arr = weights.get(0);
            weights.remove(0);
            mst.add(arr);
            size++;

            if(containCycle(mst, V) == 1) {
                mst.remove(--size);
                continue;
            } else
                ans += mst.get(size-1)[2];
        }

        System.out.println(ans);

        br.close();
    }

    static int findRoot(int[] parent, int i) {
        if(parent[i] == -1)
            return i;
        return findRoot(parent, parent[i]);
    }

    static void doUnion(int[] parent, int x, int y) {
        int xRoot = findRoot(parent, x);
        int yRoot = findRoot(parent, y);
        if(xRoot != yRoot)
            parent[xRoot] = y;
    }

    static int containCycle(List<int[]> tree, int V) {
        int [] parent = new int[V+1];

        for(int i=1; i<=V; i++)
            parent[i] = -1;

        for(int i=0; i< tree.size(); i++) {
            int x = findRoot(parent, tree.get(i)[0]);
            int y = findRoot(parent, tree.get(i)[1]);

            if(x==y)
                return 1;

            doUnion(parent, x, y);
        }
        return 0;
    }
}
