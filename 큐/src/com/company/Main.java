package com.company;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int k=0;

        Queue queue = new Queue();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            if(str.contains("push")) {
                st.nextToken();
                queue.push(Integer.parseInt(st.nextToken()));
            } else if(str.contains("pop")) {
                arr[k++] = queue.pop();
            } else if(str.contains("size")) {
                arr[k++] = queue.front - queue.back;
            } else if(str.contains("empty")) {
                if(queue.is_empty())
                    arr[k++] = 1;
                else
                    arr[k++] = 0;
            } else if(str.contains("front")) {
                arr[k++] = queue.front();
            } else if(str.contains("back")) {
                arr[k++] = queue.back();
            }

        }
        for(int i=0; i<k; i++) {
            bw.write(Integer.toString(arr[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Queue {
        int[] queue;
        int front;
        int back;

        Queue() {
            queue = new int[100001];
            front = 0;
            back = 0;
        }
        boolean is_empty() {
            return front == back;
        }
        void push(int x) {
            queue[front++] = x;
        }
        int pop() {
            if(is_empty())
                return -1;
            return queue[back++];
        }
        int front() {
            if(is_empty())
                return -1;
            return queue[back];
        }
        int back() {
            if(is_empty())
                return -1;
            return queue[front-1];
        }

    }
}

