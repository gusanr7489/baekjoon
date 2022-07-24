import java.util.*;
import java.io.*;

public class Main {

    static class Data{
        int x;
        int y;
        int n;
        String str;

        Data(int x, int y, int n, String str) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.str = str;
        }
    }

    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[5][5];
        StringTokenizer st;
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited;
        Stack<Data> stack = new Stack<>();
        int count = 0;

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {

                stack.add(new Data(j, i, 0, ""));

                while(!stack.isEmpty()) {
                    Data cur = stack.peek();
                    stack.pop();

                    if(cur.n == 6) { result.add(cur.str); continue; }

                    String concat = cur.str + Integer.toString(arr[cur.y][cur.x]);
                    //System.out.println(concat);
                    if(cur.x!=0) stack.add(new Data(cur.x-1, cur.y, cur.n+1, concat));
                    if(cur.y!=0) stack.add(new Data(cur.x, cur.y-1, cur.n+1, concat));
                    if(cur.x!=4) stack.add(new Data(cur.x+1, cur.y, cur.n+1, concat));
                    if(cur.y!=4) stack.add(new Data(cur.x, cur.y+1, cur.n+1, concat));

                    count++;
                }
            }
        }

        System.out.println(result.size());

        br.close();
    }

}
