
import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder debug = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            debug.append(i).append("\n");
            boolean[][] place = new boolean[n][m];
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                place[y][x] = true;
            }

            boolean[][] visited = new boolean[n][m];
            int count=0;
            for(int u=0; u<n; u++) {
                for(int v=0; v<m; v++) {

                    if(place[u][v] && !visited[u][v]) {
                        count++;
                        debug.append("case").append("\n");
                        Queue<Node> que = new LinkedList<>();
                        que.add(new Node(v,u));

                        while(!que.isEmpty()) {
                            Node node = que.peek();
                            que.poll();
                            if(!place[node.y][node.x] || visited[node.y][node.x]) continue;
                            visited[node.y][node.x] = true;
                            debug.append("x: ").append(node.x).append(" y: ").append(node.y).append("\n");

                            if(node.x+1 < m && place[node.y][node.x+1]) que.add(new Node(node.x+1,node.y));
                            if(node.x-1 >= 0 && place[node.y][node.x-1]) que.add(new Node(node.x-1, node.y));
                            if(node.y+1 < n && place[node.y+1][node.x]) que.add(new Node(node.x, node.y+1));
                            if(node.y-1 >= 0 && place[node.y-1][node.x]) que.add(new Node(node.x, node.y-1));

                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
        //System.out.println(debug.toString());
        br.close();
    }
}
