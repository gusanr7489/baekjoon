
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] mem = new int[N];
        int[] v = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int ans =1;
        for(int i=0; i<N; i++) {
            mem[i] = 1;
            for(int j=0; j<i; j++) {
                if(v[i]>v[j]) {
                    mem[i] = Math.max(mem[i], mem[j]+1);

                    if(mem[i]>ans) ans = mem[i];
                }
            }
        }
        System.out.println(ans);

        br.close();
    }
}
