import java.util.*;
import java.io.*;

public class Main {

    static class Data implements Comparable<Data>{
        int x;
        int y;

        Data(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Data o) {
            if(this.y != o.y)
                return this.y - o.y ;
            else
                return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Data> data = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            data.add(new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(data);

        StringBuilder sb = new StringBuilder();
        for(Data d: data) {
            sb.append(d.x).append(" ").append(d.y).append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}
