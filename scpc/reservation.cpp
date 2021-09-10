/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int Answer;
vector<int> S;

int main(int argc, char **argv)
{
    int T, test_case, n, m, l, oddMax1, oddMax2, evenMax1, evenMax2, twoOdd;
    vector<int> tempVec;
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

        Answer = 0;
        /////////////////////////////////////////////////////////////////////////////////////////////
        oddMax1 = 0;
        oddMax2 = 0;
        evenMax1 = 0;
        evenMax2 = 0;
        cin >> n >> m;

        for (int i = 0; i < n; i++)
        {
            cin >> l;
            tempVec.resize(l);
            for (int j = 0; j < l; j++)
            {
                cin >> tempVec[j];
            }

            sort(tempVec.begin(), tempVec.end());

            if (l % 2 == 1)
            {
                twoOdd++;
                S.push_back(tempVec[0] * 2 + tempVec[1] * 2 + tempVec[2] + tempVec[3]);

                if (oddMax1 == 0)
                {
                    oddMax1 = tempVec[1] + tempVec[2] + tempVec[3];
                }
                else if (oddMax2 == 0)
                {
                    oddMax2 = tempVec[1] + tempVec[2] + tempVec[3];
                    if (oddMax1 < oddMax2)
                    {
                        int temp = oddMax1;
                        oddMax1 = oddMax2;
                        oddMax2 = temp;
                    }
                }
                else if (oddMax1 < tempVec[1] + tempVec[2] + tempVec[3])
                {
                    oddMax1 = tempVec[1] + tempVec[2] + tempVec[3];
                }
                else if (oddMax2 < tempVec[1] + tempVec[2] + tempVec[3])
                {
                    oddMax2 = tempVec[1] + tempVec[2] + tempVec[3];
                }
            }
            else
            {
                S.push_back(tempVec[0] + tempVec[1] + tempVec[2] + tempVec[3]);

                if (evenMax1 == 0)
                {
                    evenMax1 = tempVec[2] + tempVec[3];
                }
                else if (evenMax2 == 0)
                {
                    evenMax2 = tempVec[2] + tempVec[3];
                    if (evenMax1 < evenMax2)
                    {
                        int temp = evenMax1;
                        evenMax1 = evenMax2;
                        evenMax2 = temp;
                    }
                }
                else if (evenMax1 < tempVec[2] + tempVec[3])
                {
                    evenMax1 = tempVec[2] + tempVec[3];
                }
                else if (evenMax2 < tempVec[2] + tempVec[3])
                {
                    evenMax2 = tempVec[2] + tempVec[3];
                }
            }

            tempVec.clear();
        }
        sort(S.rbegin(), S.rend());

        for (int i = 0; i < n; i++)
        {
            Answer += S[i];
        }

        if (oddMax1 + oddMax2 > evenMax1 + evenMax2)
        {
            Answer -= oddMax1;
            Answer -= oddMax2;
        }
        else
        {
            Answer -= evenMax1;
            Answer -= evenMax2;
        }
        S.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////

        // Print the answer to standard output(screen).
        cout << "Case #" << test_case + 1 << endl;
        cout << Answer << endl;
    }

    return 0; //Your program should return 0 on normal termination.
}