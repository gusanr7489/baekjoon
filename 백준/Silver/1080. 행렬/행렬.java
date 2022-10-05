
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] matrixA = new int[N*M+1];
        int[] matrixB = new int[N*M+1];
        Boolean[] visited = new Boolean[N*M+1];
        int idx = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                matrixA[idx++] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        idx = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                matrixB[idx] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[idx] = matrixB[idx] != matrixA[idx++];
            }
        }

        int count = 0;
        for(int k=0; k<N*M; k++) {
            if(visited[k] && k+2*M + 2 < N*M) {
                int find;
                // System.out.println(k);

                for(int i=0; i<9; i++) {
                    if(i>=6) {
                        find = k + M*2 + i%3;
                    }
                    else if(i>=3) {
                        find = k+M + i%3;
                    }
                    else {
                        find = k + i;
                    }

                    matrixA[find] = (matrixA[find] == 0) ? 1:0;
                    visited[find] = !visited[find];
                }
                count++;
            }
        }
        idx = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                //System.out.print(matrixA[idx++]);
                if(visited[idx++]) {
                    System.out.println("-1");
                    return;
                }
            }
            // System.out.println();
        }
        System.out.println(count);

        br.close();
    }
}
/*
*
001  1
100  2
100  3  1
000  4  1
011  5  1
010  6
100  7
100  8
010  9  1
010  10
010  11  1
110  12
101  13
101  14  1
000  15
110  16  1
000  17
110  18
*
001  1
100  2
011  3
000  4
100  5
010  6
011  7
100  8
101  9
101  10
010  11
001  12
010  13
010  14
111  15
110  16
111  17
001  18
* */