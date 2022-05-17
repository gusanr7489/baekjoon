package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String X = br.readLine();
        String Y = br.readLine();

        int[][] nums = new int[Y.length()+1][X.length()+1];
        int[][] arrow = new int[Y.length()+1][X.length()+1];

        for(int i=0; i<=X.length(); i++)
            nums[0][i] = 0;

        for(int i=0; i<=Y.length(); i++)
            nums[i][0] = 0;

        for(int i=1; i<=Y.length(); i++) {

            for(int j=1; j<=X.length(); j++) {

                if ( X.charAt(j - 1) == Y.charAt(i - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                    arrow[i][j] = 1;   // diagonal
                }
                else if( nums[i-1][j] >= nums[i][j-1]){

                    nums[i][j] = nums[i-1][j];
                    arrow[i][j] = -1;  // left
                }
                else{
                    nums[i][j] = nums[i][j-1];
                    arrow[i][j] = -2;  // up
                }
            }
        }

        bw.write(Integer.toString(nums[Y.length()][X.length()]));

        bw.flush();
        bw.close();
        br.close();
    }
}
