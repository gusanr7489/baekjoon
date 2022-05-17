import java.util.*
/*
    N번째의 영화 제목에 들어가는 수 출력
    1. 브루트포스니까 모든 수를 구해야 하나
    2. i번재 수가 6일 때 총 7번만큼은 더
* */
public class Main {
    int NAME = 666;
    int STR = 0;
    public Main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result= 666;
        for(int i=0; i<N; i++) {
            String str = Integer.toString(i);
            if(Integer.toString(i).contains('6')) {
                result = i * 1000 + STR;
                STR++;
            }
            else
                result = i * 1000 + NAME;

        }
        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
