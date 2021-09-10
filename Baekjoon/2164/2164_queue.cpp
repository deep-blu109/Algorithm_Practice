#include <stdio.h>
#include <queue>
using namespace std;

int main()
{
    int N, temp;
    queue<int> card;
    scanf("%d", &N);

    for (int i = 1; i <= N; i++)
    {
        card.push(i);
    }

    int i = 0;
    while (card.front() != card.back())
    {
        if (i % 2 == 0)
        {
            card.pop();
        }
        else
        {
            temp = card.front();
            card.pop();
            card.push(temp);
        }

        i++;
    }

    printf("%d", card.front());
}