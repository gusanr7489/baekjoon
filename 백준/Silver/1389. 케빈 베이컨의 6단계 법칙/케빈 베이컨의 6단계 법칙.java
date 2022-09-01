
import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int count;
        int a;
        int b;

        Node() {
            count = 0;
            a = 0;
            b = 0;
        }
        Node(int count, int a, int b) {
            this.count = count;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int conn = Integer.parseInt(st.nextToken());

        boolean[][] friends = new boolean[N+1][N+1];
        for(int i=0; i<conn; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = true;
            friends[b][a] = true;
        }

        int[] counts = new int[N];
        for(int i=1; i<=N; i++) {
            Queue<Node> que = new LinkedList<>();
            boolean[] visited = new boolean[N+1];
            visited[i] = true;

            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                if(friends[i][j]) {
                    que.add(new Node(1,i,j));
                }
            }
            //System.out.println("Debug "+ i +": " + counts[i-1]);

            while(!que.isEmpty()) {
                Node isFriend = que.poll();

                if(visited[isFriend.b]) continue;
                visited[isFriend.b] = true;
                counts[i-1] += isFriend.count;
                //System.out.println( isFriend.count +" " + isFriend.a +" " + isFriend.b);

                for(int k=1; k<=N;k++) {
                    if(!visited[k] && friends[isFriend.b][k]) {
                        que.add(new Node(isFriend.count+1, isFriend.b, k));
                    }
                }
            }
            //System.out.println("Debug "+ i+": " + counts[i-1]);
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i<N; i++) {
            if(min > counts[i]) {
                min = counts[i];
                ans = i;
            }
        }

        System.out.println(ans+1);
        br.close();
    }
}
