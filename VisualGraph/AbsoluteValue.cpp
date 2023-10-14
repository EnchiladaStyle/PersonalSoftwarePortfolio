
#include "AbsoluteValue.h"




    double AbsoluteValue::a = 1;
    double AbsoluteValue::b = 1;
    double AbsoluteValue::h = 1;
    double AbsoluteValue::k = 1;

    void AbsoluteValue::getInput()
    {
        system("clear");
        cout << "Absolute Value Equation: y = a * |x - h| + k" << endl;
        cout << "Input a value for (a). example 1.5: ";
        cin >> AbsoluteValue::a;
        cout << "Input a value for (h). example -10: ";
        cin >> AbsoluteValue::h;
        cout << "Input a value for (k). example -10: ";
        cin >> AbsoluteValue::k;
        cout << "your equation is y = " << AbsoluteValue::a << " * |x - " << AbsoluteValue::h << "| + " << AbsoluteValue::k;
        AbsoluteValue::h = AbsoluteValue::h * 10;
        AbsoluteValue::k = AbsoluteValue::k * 10;
    }

    void AbsoluteValue::equation()
    {

        for (int i = 0; i < 400; i++)
        {
            AbsoluteValue::yValuespos[i] = -(AbsoluteValue::a * abs(AbsoluteValue::rangepos[i] - AbsoluteValue::h)) - AbsoluteValue::k + 400;
            AbsoluteValue::yValuesneg[i] = -(AbsoluteValue::a * abs(AbsoluteValue::rangeneg[i] - AbsoluteValue::h)) - AbsoluteValue::k + 400;
        }
    }
