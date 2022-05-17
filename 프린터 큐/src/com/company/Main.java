package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        int[] ans = new int[test_case];
        for(int i=0; i<test_case; i++) {
            Queue<Integer> que = new LinkedList<Integer>();

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            str = br.readLine();
            st = new StringTokenizer(str);
            ArrayList<Integer> doc = new ArrayList<Integer>();

            int max =0 , max_index = 0;
            for(int j=0; j<N; j++) {
                doc.add( Integer.parseInt(st.nextToken()) );
                if( doc.get(j) > max) {
                    max = doc.get(j);
                    max_index = j;
                }
                que.offer(doc.get(j));
            }

            doc.sort(Collections.reverseOrder());

            int count = 0;
            if(max_index == M) {
                ans[i] = 1;
                continue;
            }
            while(true) {
                if(que.isEmpty())
                    break;
                int tmp = que.poll();
                if( tmp != doc.get(count) )
                    que.add(tmp);
                else if(tmp == doc.get(count)) {
                    count++;
                    //System.out.println(count);

                    N--;
                    if(0 == M)
                        break;
                }

                if(M != 0)
                    M--;
                else
                    M = N-1;
            }
            ans[i] = count;

        }
        for(int num: ans)
            bw.write(Integer.toString(num) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
