
#include "Tan.h"

    float Tan::b = 1;
    float Tan::a = 1;
    float Tan::c = 1;
    float Tan::d = 1;

    void Tan::getInput()
    {

        system("clear");
        cout << "Tangent Equation: y = a * Tan(b * x + c)) + d" << endl;
        cout << "Input a value for (a). Example 10: ";
        cin >> Tan::a;
        cout << "Input a value for (b) as a decimal. Example .2: ";
        cin >> Tan::b;
        cout << "Input a value for (d). Example 0: ";
        cin >> Tan::d;
        cout << "Input a value for (c). Example 0: ";
        cin >> Tan::c;
        cout << "your equation is y = " << Tan::a << "Sin(" << Tan::b << "(x - " << Tan::d << ")) + " << Tan::c << endl;
        Tan::b = Tan::b / 10;
        Tan::d = Tan::d * 10;
        Tan::c = Tan::c * 10;
        Tan::a = Tan::a * 10;
    }

    void Tan::equation()
    {
        for (int i = 0; i < 400; i++)
        {
            Tan::yValuespos[i] = round(-(Tan::a * tan(Tan::b * Tan::rangepos[i] + Tan::c)) - Tan::d + 400);
            Tan::yValuesneg[i] = round(-(Tan::a * tan(Tan::b * Tan::rangeneg[i] + Tan::c)) - Tan::d + 400);
        }
    }
