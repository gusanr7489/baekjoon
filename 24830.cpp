#include <iostream>
using namespace std;

int main() {

    int N;
    cin >> N;

    long long int *ans = new long long int[N+1];
    ans[0] = 1;
    for(int i=1; i<=N; i++) {
        int A,B;
        char opr;
        cin >> A >> opr >> B;
        if(opr=='+') {
            long long int C = A + B;
            ans[i] = C - ans[i-1];
        }
        else if(opr=='-') {
            long long int C = A - B;
            ans[i] = ans[i-1] * C;
        }
        else if(opr=='*') {
            long long int C = A*B;
            ans[i] = C * C;
        }
        else if(opr == '/') {
            if(A%2==0)
                ans[i] = A/2;
            else {
                A ++;
                ans[i] = A/2;
            } 

        }
    }

    for(int i=1; i<=N; i++) {
        cout<<ans[i]<<endl;
    }
    delete[] ans;
    return 0;
}