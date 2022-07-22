import java.util.*;
import java.io.*;

public class Main {

    public static class Data{
        int x;
        int y;

        Data(int X, int Y){
            x = X;
            y = Y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] img = new int[N][N];
        int[][] abnimg = new int[N][N];
        String str;

        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                char color = str.charAt(j);
                int code;
                if(color == 'R') code = 1;
                else if(color == 'G') code = 2;
                else code = 3;

                img[i][j] = code;
                if(code == 1 || code == 2) abnimg[i][j] = 1;
                else abnimg[i][j] = 2;
            }

        }

        Stack<Data> stack = new Stack<>();
        boolean[][] visited = new boolean[N][N];

        stack.add(new Data(0,0));
        int normal = 0;

        for(int i=0; i<N; i++) {

            for(int j=0; j<N; j++) {
                boolean flag = false;
                int area = img[i][j];

                stack.add(new Data(j, i));

                while(!stack.isEmpty()) {
                    Data curr = stack.peek();
                    stack.pop();
                    int x = curr.x;
                    int y = curr.y;

                    if(img[y][x] != area) continue;
                    if(visited[y][x]) continue;
                    visited[y][x] = true;
                    flag = true;

                    if(x+1 < N) stack.add(new Data(x+1, y));
                    if(y+1 < N) stack.add(new Data(x, y+1));
                    if(x-1 >= 0) stack.add(new Data(x-1, y));
                    if(y-1 >= 0) stack.add(new Data(x, y-1));

                }
                if(flag)
                    normal++;
            }
        }

        stack = new Stack<>();
        visited = new boolean[N][N];

        stack.add(new Data(0,0));
        int abnormal = 0;

        for(int i=0; i<N; i++) {

            for(int j=0; j<N; j++) {
                boolean flag = false;
                int area = abnimg[i][j];

                stack.add(new Data(j, i));

                while(!stack.isEmpty()) {
                    Data curr = stack.peek();
                    stack.pop();
                    int x = curr.x;
                    int y = curr.y;

                    if(abnimg[y][x] != area) continue;
                    if(visited[y][x]) continue;
                    visited[y][x] = true;
                    flag = true;

                    if(x+1 < N) stack.add(new Data(x+1, y));
                    if(y+1 < N) stack.add(new Data(x, y+1));
                    if(x-1 >= 0) stack.add(new Data(x-1, y));
                    if(y-1 >= 0) stack.add(new Data(x, y-1));

                }
                if(flag)
                    abnormal++;
            }
        }

        System.out.println(normal +" " + abnormal);

        br.close();
    }

}
