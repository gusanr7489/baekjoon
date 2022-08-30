
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dogam_name = new HashMap<>();
        HashMap<Integer, String> dogam_no = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            String pkmon = br.readLine();
            dogam_name.put(pkmon, i+1);
            dogam_no.put(i+1,pkmon);
        }

        for(int i=0; i<M; i++) {
            String test = br.readLine();
            if(Character.isLetter(test.charAt(0))) {
                sb.append(dogam_name.get(test)).append("\n");
            }
            else {
                sb.append(dogam_no.get(Integer.parseInt(test))).append("\n");
            }

        }
        System.out.println(sb.toString());
        br.close();
    }
}
