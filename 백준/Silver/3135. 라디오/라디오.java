
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int range = Math.abs(A-B);

        for(int i=0; i<N; i++) {
            int tryClick = Math.abs(B-arr[i])+1;
            if( tryClick < range) range = tryClick;
        }

        System.out.println(range);
        br.close();
    }
}
