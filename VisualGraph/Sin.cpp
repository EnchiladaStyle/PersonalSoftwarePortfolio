
#include "Sin.h"

float Sin::a;
float Sin::b;
float Sin::d;
float Sin::c;

void Sin::getInput()
{
    system("clear");
    cout << "Sin Equation: y = a * Sin(b(x - d)) + c" << endl;
    cout << "Input a value for (a). Example 10: ";
    cin >> Sin::a;
    cout << "Input a value for (b) as a decimal. Example .2: ";
    cin >> Sin::b;
    cout << "Input a value for (d). Example 0: ";
    cin >> Sin::d;
    cout << "Input a value for (c). Example 0: ";
    cin >> Sin::c;
    cout << "your equation is y = " << Sin::a << "Sin(" << Sin::b << "(x - " << Sin::d << ")) + " << Sin::c << endl;
    Sin::b = Sin::b / 10;
    Sin::d = Sin::d * 10;
    Sin::c = Sin::c * 10;
    Sin::a = Sin::a * 10;
}

// y = a*sin(b(x-d)) + c
void Sin::equation()
{

    for (int i = 0; i < 400; i++)
    {
        Sin::yValuespos[i] = round(-(Sin::a * sin(Sin::b * (Sin::rangepos[i] + Sin::d))) - Sin::c + 400);
        Sin::yValuesneg[i] = round(-(Sin::a * sin(Sin::b * (rangeneg[i] + Sin::d))) - Sin::c + 400);
    }
}