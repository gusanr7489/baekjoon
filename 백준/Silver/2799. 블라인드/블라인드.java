import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(s.nextToken());
        int row = Integer.parseInt(s.nextToken());
        
        int[][] state = new int[col][row];
        String st = br.readLine();
        
        for(int i=0; i<col; i++) {
            String line = "";
            while(!(line = br.readLine()).equals(st)) {
                line = line.substring(1, line.length()-1);
                String[] windows = line.split("#");
                for(int j=0; j<row; j++) 
                    if(windows[j].contains("****")) 
                       state[i][j]++;
            } 
        }
        
        int[] type = new int[5];
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                if(state[i][j]==0)
                    type[0]++;
                else if(state[i][j]==1)
                    type[1]++;
                else if(state[i][j]==2) 
                    type[2]++;
                else if(state[i][j]==3)
                    type[3]++;
                else if(state[i][j]==4)
                    type[4]++;
            }
        }
  
       System.out.print(type[0] + " " +type[1] + " " +type[2] + " " +type[3] + " " +type[4]);
            
    }
}