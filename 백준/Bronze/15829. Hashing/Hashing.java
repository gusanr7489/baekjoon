import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger hash = new BigInteger("0") ;
        BigInteger r = new BigInteger("1");
        BigInteger M = new BigInteger("1234567891");

        for(int i=0; i<N; i++) {
            int ascii = str.charAt(i) - 'a' + 1;
            BigInteger num = new BigInteger(Integer.toString(ascii));

            hash = hash.add( num.multiply(r).mod(M) );

            r = r.multiply(new BigInteger("31")).mod(M);
        }

        System.out.println(hash.mod(M));

        br.close();
    }
}
