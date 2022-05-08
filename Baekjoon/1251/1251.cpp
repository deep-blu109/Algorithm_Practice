#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool cmp(pair<string, int> a, pair<string, int> b){
    return a.first < b.first;
}

int main(){
    char arr[51];
    string str;
    vector<pair<string, int>> alphabat;
    vector<int> result;
    vector<int> order;
    scanf("%s", &arr);
    str = arr;
    reverse(str.begin(), str.end());

    for(int i = 0; i < str.size(); i++){
        alphabat.push_back({str.substr(i), i});
    }

    sort(alphabat.begin(), alphabat.end(), cmp);

    bool TF = true;
    for(int i = 0; i < 2; i++){
        if(alphabat[i].second == 0){
            TF = false;
        }
        result.push_back(alphabat[i].second);
    }

    if(TF){
        result.push_back(0);
    }
    else{
        result.push_back(alphabat[2].second);
    }

    order = result;

    sort(order.begin(), order.end());
    

    for(int now : result){
        if(now == order[0]){
            printf("%s", str.substr(now, order[1]-now).c_str());
        }
        else if(now == order[1]){
            printf("%s", str.substr(now, order[2]-now).c_str());
        }
        else{
            printf("%s", str.substr(now).c_str());
        }

    }
}
