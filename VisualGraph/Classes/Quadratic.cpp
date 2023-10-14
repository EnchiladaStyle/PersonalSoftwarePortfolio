#include "Quadratic.h"


    double Quadratic::a = 1;
    double Quadratic::h = 0;
    double Quadratic::k = 0;

    void Quadratic::getInput()
    {
        system("clear");
        cout << "Quadratic Equation: y = a(x - h)^2 + k" << endl;
        cout << "Input a value for (a) as a decimal. Example .04: ";
        cin >> Quadratic::a;
        cout << "Input a value for (h). Example 10: ";
        cin >> Quadratic::h;
        cout << "Input a value for (k). Example -20: ";
        cin >> Quadratic::k;
        cout << "your equation is y = " << Quadratic::a << "(x - " << Quadratic::h << ")^2 + " << Quadratic::k << endl;
        Quadratic::a = Quadratic::a / 10;
        Quadratic::h = Quadratic::h * 10;
        Quadratic::k = Quadratic::k * 10;
    }
    void Quadratic::equation()
    {

        for (int i = 0; i < 400; i++)
        {

            Quadratic::yValuespos[i] = -(Quadratic::a * (Quadratic::rangepos[i] - Quadratic::h) * (Quadratic::rangepos[i] - Quadratic::h)) - Quadratic::k + 400;
            Quadratic::yValuesneg[i] = -(Quadratic::a * (Quadratic::rangeneg[i] - Quadratic::h) * (Quadratic::rangeneg[i] - Quadratic::h)) - Quadratic::k + 400;
        }
    }

