package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        ArrayList<Integer> print_result = new ArrayList<Integer>();

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            if(str.contains("push_back")){
                st.nextToken();
                deque.Push_back(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(str.contains("push_front")) {
                st.nextToken();
                deque.Push_front(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(str.contains("pop_front")){
                print_result.add(deque.pop_front());
                continue;
            }
            if(str.contains("pop_back")) {
                print_result.add(deque.pop_back());
                continue;
            }
            if(str.contains("front")) {
                print_result.add( deque.print_front());
                continue;
            }
            if(str.contains("back")) {
                print_result.add( deque.print_back());
                continue;
            }
            if(str.contains("size")) {
                print_result.add( deque.get_size());
                continue;
            }
            if(str.contains("empty")) {
                if(deque.Is_empty())
                    print_result.add(1);
                else
                    print_result.add(0);
                continue;
            }
        }
        for(int num: print_result)
            bw.write(Integer.toString(num) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Deque {
        ArrayList<Integer> deque;
        int size;

        Deque() {
            deque = new ArrayList<Integer>();
            size = 0;
        }
        boolean Is_empty() {
            return size == 0;
        }
        void Push_front(int x) {
            deque.add(0,x);
            size++;
        }
        void Push_back(int x) {
            deque.add(x);
            size++;
        }
        int pop_front() {
            if(size==0)
                return -1;
            size--;
            return deque.remove(0);
        }
        int pop_back() {
            if(size==0)
                return -1;
            size--;
            return deque.remove(size);
        }
        int get_size() {
            return size;
        }
        int print_front() {
           if(size==0)
               return -1;
           return deque.get(0);
        }
        int print_back() {
            if(size==0)
                return -1;
            return deque.get(size-1);
        }
    }

}
