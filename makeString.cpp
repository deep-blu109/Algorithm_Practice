//랜덤 문자열 생성 프로그램

#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

char getRandomChar()
{
    char c = 'a' + rand() % 26;
    return c;
}

int main()
{
    string s;

    for (int i = 0; i < 100; i++)
    {
        for (int j = 0; j < 100; j++)
        {
            s += getRandomChar();
        }
        cout << s << endl;
        s.clear();
    }
}