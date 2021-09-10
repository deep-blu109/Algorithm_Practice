/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

string Answer;

int main(int argc, char **argv)
{
    int T, test_case, N, t;
    string s;
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
        cin >> N >> t >> s;
        vector<int> A(N + 1, 0);
        vector<int> B(N + 1);

        for (int i = 1; i <= N; i++)
        {
            B[i] = s[i - 1] - '0';
        }

        int temp = 0;
        for (int i = 1; i <= N; i++)
        {
            if (B[i] == 0)
            {
                continue;
            }

            if (i > t)
            {
                if (A[i - t] == 1)
                {
                    continue;
                }
                else
                {
                    temp = i - t;
                }
            }

            if (i <= N - t && i + t <= N)
            {
                if (i + 2 * t <= N)
                {
                    if (B[i + 2 * t] == 1)
                    {
                        temp = i + t;
                    }
                }
                else
                {
                    temp = i + t;
                }
            }

            A[temp] = 1;
            temp = 0;
        }

        for (int i = 1; i <= N; i++)
        {
            Answer += A[i] + '0';
        }
        A.clear();
        B.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////

        // Print the answer to standard output(screen).
        cout << "Case #" << test_case + 1 << endl;
        cout << Answer << endl;
    }

    return 0; //Your program should return 0 on normal termination.
}