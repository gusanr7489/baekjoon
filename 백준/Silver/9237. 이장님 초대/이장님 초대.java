import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int grow = 0;

        for(int i=N-1; i>=0; i--) {

            if(grow < arr[i]) grow += arr[i] - grow;

            grow--;

        }
        System.out.println(grow + N + 2);
        br.close();
    }
}
