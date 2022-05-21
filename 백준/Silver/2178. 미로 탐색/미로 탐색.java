
import java.io.*;
import java.util.*;

public class Main {
    static int count = 1;
    static int[] rotate_col = {-1, 1, 0, 0};
    static int[] rotate_row = {0, 0 , -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] maze = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = (Integer.parseInt(String.valueOf(str.charAt(j))) == 1);
            }
        }

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        visited[0][0] = true;
        boolean flag = false;

        while (true) {

            if(flag || que.isEmpty())
                break;

            int qsize = que.size();

            for(int k=0; k<qsize; k++) {
                int hash = que.poll();

                int row = hash / 100;
                int col = hash % 100;

                for (int i = 0; i < 4; i++) {
                    int rt_row = row + rotate_row[i];
                    int rt_col = col + rotate_col[i];

                    if (rt_row == N - 1 && rt_col == M - 1) {
                        flag = true;
                        break;
                    }

                    if (rt_row < 0 || rt_col < 0)
                        continue;

                    if (rt_row == N || rt_col == M)
                        continue;

                    if (maze[rt_row][rt_col] && !visited[rt_row][rt_col]) {
                        que.add(rt_row * 100 + rt_col);
                        visited[rt_row][rt_col] = true;
                    }
                }
       
            }
            count++;
        }

        bw.write(Integer.toString(count) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}


