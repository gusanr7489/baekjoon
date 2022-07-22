import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine())-1;

        boolean[] visited = new boolean[N];
        Queue<Integer> que = new LinkedList<>();
        que.add(S);
        int count = 0;

        while(!que.isEmpty()) {
            int currStone = que.peek();
            que.poll();
            if(visited[currStone]) continue;

            visited[currStone] = true;
            count++;

            int left = currStone - arr[currStone];
            int right = currStone + arr[currStone];

            if(left>=0) que.add(left);
            if(right<N) que.add(right);
        }

        System.out.println(count);

        br.close();
    }
}
