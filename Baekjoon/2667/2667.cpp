#include <stdio.h>
#include <vector>
#include <queue>
#include <set>
using namespace std;

multiset<int> ans;

int n;
vector<vector<char>> map;
int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};

bool outOfRange(int r, int c){
    if(r < 0 || c < 0 || r >= n || c >= n){
        return true;
    }
    return false;
}


void bfs(int row, int column){
    queue<pair<int, int>> bfs_q;
    int cnt = 1;

    bfs_q.push({row, column});

    while(!bfs_q.empty()){
        int r = bfs_q.front().first;
        int c = bfs_q.front().second;
        bfs_q.pop();

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(!outOfRange(nr, nc) && map[nr][nc] == '1'){
                map[nr][nc] = '2';
                cnt++;
                bfs_q.push({nr, nc});
            }
        }
    }

    ans.insert(cnt);
}


int main(){
    scanf("%d", &n);

    for(int i = 0; i < n; i++){
        vector<char> vec(n);
        for(int j = 0; j < n; j++){
            scanf(" %c", &vec[j]);
        }
        map.push_back(vec);
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
           if(map[i][j] == '1'){
               map[i][j] = '2';
               bfs(i, j);
           }
        }
    }

    printf("%d\n", ans.size());

    for(auto i : ans){
        printf("%d\n", i);
    }
}