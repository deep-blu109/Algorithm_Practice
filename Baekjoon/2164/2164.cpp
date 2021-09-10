#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int num, front;
    scanf("%d", &num);

    vector<int> vec(num);
    vector<int> vec2;
    for (int i = 0; i < num; i++)
    {
        vec[i] = num - i;
    }

    int i = 0;
    while (true)
    {
        if (vec.size() == 1 && vec2.empty())
        {
            break;
        }
        else if (vec.empty())
        {
            reverse(vec2.begin(), vec2.end());
            vec = vec2;
            vec2.clear();
        }
        else
        {
            if (i++ % 2 == 1)
            {
                int temp = vec.back();
                vec2.push_back(temp);
                vec.pop_back();
            }
            else
            {
                vec.pop_back();
            }
        }
    }

    printf("%d", vec[0]);
}