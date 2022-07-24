import java.util.*;
import java.io.*;

/*
*   반례 :
3 4 11
29 51 54 44
22 44 32 62
25 38 16 2
*
2 2 35
20 10
190 40
*
* */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][N];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max) max = arr[i][j];
                if(arr[i][j] < min) min = arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        // 모든 땅이 고름
        if(max == min) {
            System.out.println("0 "+ max);
            return;
        }

        // 브루트포스
        int[] result = new int[257];
        int[] inventories = new int[257];

        for(int k=0; k<=256; k++) {
            inventories[k] = B;

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {

                    if(k>arr[i][j]) { result[k] += k-arr[i][j]; inventories[k]-= k-arr[i][j];}
                    else if(k<arr[i][j]) { result[k]+= (arr[i][j]-k)*2; inventories[k]+= arr[i][j]-k; }

                }
            }
            //System.out.println("k: " + k + " Debug: " + result[k]);
            //System.out.println("Inventory: " + inventories[k]);
        }

        int max_index=0, min_time = Integer.MAX_VALUE;
        for(int i=0; i<=256; i++) {

            if(inventories[i] < 0) continue;

            if(min_time >= result[i]) {
                min_time = result[i];
                max_index = i;
            }
        }

        System.out.println(min_time +" " + max_index);


        br.close();
    }
}
