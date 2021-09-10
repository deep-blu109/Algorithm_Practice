/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

string Answer;
vector<vector<int>> graph(501);

bool findCycle(int num)
{
    graph[0][num] = 3;

    int temp;
    for (int i = 0; i < graph[num].size(); i++)
    {
        temp = graph[num][i];

        if (graph[0][temp] == 0 || graph[0][temp] == 2)
        {
            if (findCycle(temp))
            {
                return true;
            }
        }
        else if (graph[0][temp] >= 2)
        {
            return true;
        }
    }

    if (graph[0][num] == 3)
    {
        graph[0][num] = 1;
    }
    else if (graph[0][num] == 2)
    {
        graph[0][num] == 0;
    }

    return false;
}

int main(int argc, char **argv)
{
    int T, test_case, N, M, K;
    vector<int> condition;
    /*
	The freopen function below opens input.txt file in read only mode, and afterward,
	the program will read from input.txt file instead of standard(keyboard) input.
	To test your program, you may save input data in input.txt file,
	and use freopen function to read from the file when using cin function.
	You may remove the comment symbols(//) in the below statement and use it.
	Use #include<cstdio> or #include <stdio.h> to use the function in your program.
	But before submission, you must remove the freopen function or rewrite comment symbols(//).
	*/

    // freopen("input.txt", "r", stdin);

    cin >> T;
    for (test_case = 0; test_case < T; test_case++)
    {

        Answer.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////
        cin >> N >> M >> K;
        graph.resize(N + 1);

        condition.resize(N + 1);
        graph[0] = condition;

        int temp1, temp2;
        for (int i = 0; i < M; i++)
        {
            cin >> temp1 >> temp2;
            graph[temp1].push_back(temp2);
        }
        for (int i = 0; i < K; i++)
        {
            cin >> temp1 >> temp2;

            graph[temp1].push_back(temp2);
            if (!findCycle(temp1))
            {
                Answer += '0';
                graph[0].clear();
                graph[0].resize(N + 1, 0);
                continue;
            }
            else
            {
                Answer += '1';
                graph[temp1].pop_back();
                graph[temp2].push_back(temp1);
            }

            graph[0].clear();
            graph[0].resize(N + 1, 0);
        }

        graph.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////

        // Print the answer to standard output(screen).
        cout << "Case #" << test_case + 1 << endl;
        cout << Answer << endl;
    }

    return 0; //Your program should return 0 on normal termination.
}