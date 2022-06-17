#include <iostream>
#include <string.h>
using namespace std;
int main() {
    int N=0;
    cin >> N;

    int size[N][2];
    for(int i=0; i<N; i++) {
        cin>> size[i][0] >>  size[i][1];
    }

    int *ans = new int[N];
    for(int i=0; i<N; i++) {
    
        int level = 1;

        for(int j=0; j<N; j++) {
            if(i==j)
                continue;

            if(size[i][0] < size[j][0] && size[i][1] < size[j][1])
                level ++;
        }
        ans[i] = level;
    }
    for(int i=0; i<N; i++)
        cout<< ans[i] << " ";

    delete[] ans;
    return 0;
}