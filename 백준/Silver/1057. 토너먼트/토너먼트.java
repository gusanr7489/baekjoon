

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int round = 0;

        while(kim != 0 && lim !=0) {
            kim = (int)Math.ceil((double) kim/2);
            lim = (int) Math.ceil((double) lim/2);

            round++;
            if(kim == lim) break;
            //System.out.println(kim + " " + lim);
        }

        System.out.println(round);

        br.close();
    }
}
