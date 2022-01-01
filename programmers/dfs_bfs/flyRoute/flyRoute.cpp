#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> answer;

void dfs(vector<vector<string>> &tickets, int count, vector<string> &ans, string start)
{
    if (count == tickets.size())
    {
        if (answer.empty())
        {
            answer = ans;
        }
        else
        {
            for (int i = 0; i < count; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (answer[i][j] < ans[i][j])
                    {
                        return;
                    }
                    else if (answer[i][j] > ans[i][j])
                    {
                        answer = ans;
                        return;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
        return;
    }

    for (int i = 0; i < tickets.size(); i++)
    {
        if (tickets[i][0] == start)
        {
            tickets[i][0] = "";
            ans.push_back(tickets[i][1]);
            dfs(tickets, count + 1, ans, tickets[i][1]);
            tickets[i][0] = start;
            ans.pop_back();
        }
    }
}

vector<string> solution(vector<vector<string>> tickets)
{
    vector<string> ans;
    ans.push_back("ICN");
    dfs(tickets, 0, ans, "ICN");
    return answer;
}

int main()
{
    vector<vector<string>> tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}, {"SFO", "IAD"}};
    vector<string> answer = solution(tickets);
    int size = answer.size();
    for (int i = 0; i < size; i++)
    {
        cout << answer[i] << " ";
    }
}