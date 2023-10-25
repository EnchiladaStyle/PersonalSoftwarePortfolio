#include "Linear.h"

double Linear::m = 1;
double Linear::b = 0;
double Linear::f = 0;



void Linear::getInput()
{
    system("clear");
    cout << "Linear Equation: y = mx + b" << endl;
    cout << "Input a value for m as (a) decimal: ";
    cin >> Linear::m;
    cout << "Input a value for (b): ";
    cin >> Linear::b;
    cout << "your equation is y = " << Linear::m << "x + " << Linear::b << endl;
    Linear::b = Linear::b * 10;
}

void Linear::equation()
{

    for (int i = 0; i < 400; i++)
    {
        Linear::yValuespos[i] = -(Linear::m * (Linear::rangepos[i]) + Linear::b) + 400;
        Linear::yValuesneg[i] = -(Linear::m * (Linear::rangeneg[i]) + Linear::b) + 400;
    }
}
