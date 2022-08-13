import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] line = new String[N];
        int max = 0;
        int[] arr = new int[10];

        for(int i=0; i<N; i++) line[i] = br.readLine();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M ;j++) {
                char compare = line[i].charAt(j);
                for(int k=j+1 ; k<M; k++) {
                    if(compare == line[i].charAt(k)) {
                        int len = k-j;
                        if(i+len<N && compare==line[i+len].charAt(j) && compare==line[i+len].charAt(k))
                            max = Math.max(max, (len+1) * (len+1));
                    }
                }
            }
        }
        if(max==0) System.out.println(1);
        else System.out.println(max);
        br.close();
    }
}
