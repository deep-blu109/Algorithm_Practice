#include <stdio.h>
#include <unordered_map>
#include <unordered_set>
#include <string>
using namespace std;

int main(){
    int n, m;
    unordered_map<int, string> pocketmon_num;
    unordered_map<string, int> pocketmon_name;
    unordered_set<char> num = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    scanf("%d %d", &n, &m);

    char tmp[21];
    int idx = 1;
    string s;
    for(int i = 0; i < n; i++){
        scanf(" %s", &tmp);
        s = tmp;
        pocketmon_num[idx] = s;
        pocketmon_name[s] = idx;
        idx++;
    }

    for(int i = 0; i < m; i++){
        scanf(" %s", &tmp);
        s = tmp;

        if(num.find(s[0]) != num.end()){
            int now = atoi(s.c_str());
            printf("%s\n", pocketmon_num[now].c_str());
        }
        else{
            printf("%d\n", pocketmon_name[s]);
        }
    }
}
