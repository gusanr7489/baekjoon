import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Integer.parseInt(st.nextToken());
            double y1 = Integer.parseInt(st.nextToken());
            double r1 = Integer.parseInt(st.nextToken());
            double x2 = Integer.parseInt(st.nextToken());
            double y2 = Integer.parseInt(st.nextToken());
            double r2 = Integer.parseInt(st.nextToken());

            double eucline = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
            // 0개 일 때
            if(eucline > r1 + r2) sb.append("0").append("\n");
            else if(eucline==0 && r1==0 && r2==0) sb.append("1").append("\n");
            else if(eucline==0 && r1==r2) sb.append("-1").append("\n");
            else if (eucline==0) sb.append("0").append("\n");
            else if(r1>r2 && eucline+r2 < r1) sb.append("0").append("\n");
            else if(r2>r1 && eucline+r1 < r2) sb.append("0").append("\n");
            else if(eucline==r1+r2) sb.append("1").append("\n");
            else if(r1>r2 && eucline+r2==r1) sb.append("1").append("\n");
            else if(r1<r2 && eucline+r1==r2) sb.append("1").append("\n");
            else sb.append("2").append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
