import java.io.*;
import java.util.*;

public class Main {

    static class xy{
        int x;
        int y;

        xy(int X, int Y) {
            x = X;
            y = Y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while( !(str=br.readLine()).equals("0 0") ){
            //System.out.println("Debug");

            StringTokenizer st = new StringTokenizer(str);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[h][w];

            for(int i=0; i<h; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);

                for(int j=0; j<w; j++) {
                    int isIsland = Integer.parseInt(st.nextToken());
                    map[i][j] = (1 == isIsland);
                }
            }

            Queue<xy> que = new LinkedList<>();
            boolean[][] visited = new boolean[h][w];
            int tot_Island = 0;

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(visited[i][j]) continue;

                    visited[i][j] = true;

                    if(map[i][j]) {
                        //System.out.println(tot_Island + " " + i + " " + j);
                        tot_Island++;

                        if(i+1 != h) que.add(new xy(i+1, j));

                        if(j+1 != w) que.add(new xy(i, j+1));

                        if(i+1 != h && j != 0) que.add(new xy(i+1, j-1));

                        if(i+1 != h && j+1 != w) que.add(new xy(i+1, j+1));

                        while(!que.isEmpty()) {
                            xy piece = que.peek();
                            que.poll();
                            //System.out.println(tot_Island+" " + piece.x +" " + piece.y);
                            if(visited[piece.x][piece.y]) continue;
                            visited[piece.x][piece.y] = true;

                            if(map[piece.x][piece.y]) {
                                if(piece.x != 0) que.add(new xy(piece.x-1, piece.y));

                                if(piece.x+1 != h) que.add(new xy(piece.x+1, piece.y));

                                if(piece.y+1 != w) que.add(new xy(piece.x, piece.y+1));

                                if(piece.y != 0) que.add(new xy(piece.x, piece.y-1));

                                if(piece.x+1 != h && piece.y+1 != w) que.add(new xy(piece.x+1, piece.y+1));

                                if(piece.x+1 != h && piece.y != 0) que.add(new xy(piece.x+1, piece.y-1));

                                if(piece.x != 0 && piece.y+1 != w) que.add(new xy(piece.x-1, piece.y+1));

                                if(piece.x != 0 && piece.y != 0) que.add(new xy(piece.x-1, piece.y-1));
                            }
                        }

                    }
                }
            }

            sb.append(tot_Island).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
