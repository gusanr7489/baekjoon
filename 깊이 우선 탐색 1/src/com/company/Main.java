package com.company;

import java.io.*;
import java.util.*;

/*
* 1 -> 2 -> 3 -> 4
*
* */
public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list[] = new ArrayList[N+1];
        for(int i=0; i<=N;i++)
            list[i] = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        for(int i=1; i<=N; i++)
            Collections.sort(list[i]);
        int[] ans = new int[N+1];
        DFS(list, R, visited, ans);

        for(int i=1; i<=N; i++)
            bw.write(Integer.toString(ans[i]) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static void DFS(ArrayList<Integer>[] nodes, int vertex, boolean[] visited, int[] ans ) {

        if(visited[vertex])
            return;
        visited[vertex] = true;
        ans[vertex] = ++count;
        for(int i=0; i< nodes[vertex].size(); i++) {
            if( !visited[nodes[vertex].get(i)] )
                DFS(nodes, nodes[vertex].get(i), visited, ans);
        }
    }
}
