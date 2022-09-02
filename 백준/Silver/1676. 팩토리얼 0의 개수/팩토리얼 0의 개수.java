
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count_five=0;
        while(N!=0) {

            int tmp = N;
            while(tmp%5 == 0) {
                count_five++;
                tmp = tmp/5;
            }

            N--;
        }

        System.out.println(count_five);
        br.close();
    }

}
