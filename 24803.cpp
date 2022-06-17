#include <iostream>
#include <string.h>
using namespace std;

int main() {
    int G, S, C;
    cin >> G >> S >> C;
    int buyPower = G * 3 + S *2 + C*1;
    string ans;
    if(buyPower>=8)
        ans = "Province";
    else if(buyPower>=5)
        ans = "Duchy";
    else if(buyPower>=2)
        ans = "Estate";
    
    if(buyPower>=6)
        ans += " or Gold";
    else if(buyPower>=3)
        ans += " or Silver";
    else if(buyPower==2)
        ans += " or Copper";
    else 
        ans = "Copper";

    cout << ans << endl;
    return 0;
}