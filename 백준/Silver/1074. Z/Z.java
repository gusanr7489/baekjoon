
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        while(N!=0) {
            int key = (int)Math.pow(2,N-1);
            if(r>=key && c>=key) {
                ans += key * key * 3;
                r -= key;
                c -= key;
            } else if(r<=key && c>=key) {
                ans += key * key;
                c -= key;
            } else if(r>=key && c<=key) {
                ans += key * key * 2;
                r -= key;
            }
            //System.out.println(r +" " + c + " ans: " + ans);
            N--;
        }
        System.out.println(ans);

        br.close();
    }
}
