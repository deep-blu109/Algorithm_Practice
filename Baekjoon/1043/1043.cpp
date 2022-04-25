#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;

int main(){
    int people, party_num, truth_num, ans;
    scanf("%d %d\n%d", &people, &party_num, &truth_num);

    vector<vector<int>> party_vec(party_num);
    vector<vector<int>> people_vec(people+1);
    vector<bool> party_visited(party_num, false);
    vector<bool> know_truth(people+1, false);
    queue<int> q;
    ans = party_num;


    for(int i = 0; i < truth_num; i++){
        int tmp;
        scanf("%d", &tmp);
        know_truth[tmp] = true;
    }

    for(int i = 0; i < party_num; i++){
        int now_num;
        bool TF = false;
        scanf("%d", &now_num);

        for(int j = 0; j < now_num; j++){
            int tmp;
            scanf("%d", &tmp);
            
            people_vec[tmp].push_back(i);
            party_vec[i].push_back(tmp);

            if(know_truth[tmp]){
                TF = true;
            }
        }

        if(TF){
            q.push(i);
            party_visited[i] = true;
            ans--;
        }
    }


    while(!q.empty()){
        int now = q.front();
        q.pop();

        bool TF = false;
        for(int person : party_vec[now]){
            //know_truth[p] = true;

            for(int party : people_vec[person]){
                if(!party_visited[party]){
                    q.push(party);
                    party_visited[party] = true;
                    ans--;
                }
            }
        }
    }

    printf("%d", ans);
}