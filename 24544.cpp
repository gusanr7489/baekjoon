#include <iostream> 
using namespace std;

int main() {

    int N;
    cin >> N;
    
    long long int *content = new long long int[N];
    long long int total = 0;
    for(int i=0; i<N; i++) {
        cin >> content[i];
        total += content[i];
    }
    long long int subTotal=0;
    for(int i=0; i<N; i++) {
        int num;
        cin >> num;
        if(num==0)
            subTotal += content[i];
    }
    cout << total << endl;
    cout << subTotal << endl;

    return 0;
}