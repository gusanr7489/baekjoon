import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long[][] arr = new long[Q][2];
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<Q; i++) {
            long a = arr[i][0];
            long b = arr[i][1];

            long sum;
            int k = 1;
            boolean flag = false;
            while(true) {
                sum = a + a*k;
                if(sum > b) break;
                else if(sum==b) {flag = true; break;}
                k++;
            }
            if(flag) System.out.println(1);
            else System.out.println(0);
        }

        br.close();
    }
}
