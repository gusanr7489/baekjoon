#include <iostream>
using namespace std;

int N, M;
int result[200000];
int school[200000];
int remain[200000];
int main() {

    cin >> N;
    cin >> M;
    for(int i=0; i<M; i++) {
        cin >> school[i];
    }

    int count = 0;
    int ave = N / M ;
    if(ave==0)
        ave = N;
    
    for(int i=0; i<M; i++){
        
        if(school[i] >= ave) {
            result[i] = ave;
            remain[i] = school[i] - ave;
            count += ave;    
        }
        else {
            result[i] = school[i];
            remain[i] = -1;
            count += school[i];
        }
    }
    
    int k = 0;
    for(int i=0; i< N - count; i++) {
        k = k % M;
        if( remain[k] == -1) {
            i--;
            k++;
            continue;
        }
        result[k]++;
        k++;
    }
    
    cout<< "count: " << count << " ave: " << ave <<endl;

    for(int i=0 ;i<M; i++) {
        cout << result[i] << endl;
    }

}